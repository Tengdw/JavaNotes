package com.tengdw.lambda.session7;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 实现Spliterator来统计字数
 * 实现Spliterator接口定义并行流如何拆分它要遍历的数据。
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/24 10:43
 */
public class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // 处理当前字符
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            //返回null表示要解析的String已经足够小，可以顺序处理
            return null;
        }
        //将试探拆分位置设定为要解析的String的中间
        for (int splitPos = currentSize / 2 + currentChar;
             splitPos < string.length(); splitPos++) {
            //让拆分位置前进直到下一个空格
            if (Character.isWhitespace(string.charAt(splitPos))) {
                //创建一个新WordCounterSpliterator来解析String从开始到拆分位置的部分
                Spliterator<Character> spliterator =
                        new WordCounterSpliterator(string.substring(currentChar, splitPos));
                //将这个WordCounterSpliterator的起始位置设为拆分位置
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
