package com.tengdw.lambda.session11.v1;

import com.tengdw.lambda.session11.ExchangeService;
import com.tengdw.lambda.session11.ExchangeService.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 最佳价格查询器
 */
public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   new Shop("BuyItAll")/*,
                                                   new Shop("ShopEasy")*/);

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    //采用顺序查询所有商店的方式
    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    //使用并行操作
    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .collect(Collectors.toList());
    }
    //使用 CompletableFuture 自定义线程池
    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is "
                        + shop.getPrice(product), executor))
                .collect(Collectors.toList());

        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

    public List<String> findPricesInUSD(String product) {
        List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            // Start of Listing 10.20.
            // Only the type of futurePriceInUSD has been changed to
            // CompletableFuture so that it is compatible with the
            // CompletableFuture::join operation below.
            CompletableFuture<Double> futurePriceInUSD = 
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                    CompletableFuture.supplyAsync(
                        () ->  ExchangeService.getRate(Money.EUR, Money.USD)),
                    (price, rate) -> price * rate
                );
            priceFutures.add(futurePriceInUSD);
        }
        // Drawback: The shop is not accessible anymore outside the loop,
        // so the getName() call below has been commented out.
        List<String> prices = priceFutures
                .stream()
                .map(CompletableFuture::join)
                .map(price -> /*shop.getName() +*/ " price is " + price)
                .collect(Collectors.toList());
        return prices;
    }

    public List<String> findPricesInUSDJava7(String product) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            final Future<Double> futureRate = executor.submit(new Callable<Double>() { 
                public Double call() {
                    return ExchangeService.getRate(Money.EUR, Money.USD);
                }
            });
            Future<Double> futurePriceInUSD = executor.submit(new Callable<Double>() { 
                public Double call() {
                    try {
                        double priceInEUR = shop.getPrice(product);
                        return priceInEUR * futureRate.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
            });
            priceFutures.add(futurePriceInUSD);
        }
        List<String> prices = new ArrayList<>();
        for (Future<Double> priceFuture : priceFutures) {
            try {
                prices.add(/*shop.getName() +*/ " price is " + priceFuture.get());
            }
            catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }

    public List<String> findPricesInUSD2(String product) {
        List<CompletableFuture<String>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            // Here, an extra operation has been added so that the shop name
            // is retrieved within the loop. As a result, we now deal with
            // CompletableFuture<String> instances.
            CompletableFuture<String> futurePriceInUSD = 
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                    CompletableFuture.supplyAsync(
                        () -> ExchangeService.getRate(Money.EUR, Money.USD)),
                    (price, rate) -> price * rate
                ).thenApply(price -> shop.getName() + " price is " + price);
            priceFutures.add(futurePriceInUSD);
        }
        List<String> prices = priceFutures
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

    //合并两个独立的CompletableFuture对象
    public List<String> findPricesInUSD3(String product) {
        // Here, the for loop has been replaced by a mapping function...
        Stream<CompletableFuture<String>> priceFuturesStream = shops
            .stream()
            .map(shop -> CompletableFuture
                .supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                    CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)),
                    (price, rate) -> price * rate)
                .thenApply(price -> shop.getName() + " price is " + price));
        // However, we should gather the CompletableFutures into a List so that the asynchronous
        // operations are triggered before being "joined."
        List<CompletableFuture<String>> priceFutures = priceFuturesStream.collect(Collectors.toList());
        List<String> prices = priceFutures
            .stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());
        return prices;
    }

}
