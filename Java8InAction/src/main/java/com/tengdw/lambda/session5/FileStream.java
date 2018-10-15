package com.tengdw.lambda.session5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/15 14:56
 */
public class FileStream {
    public static void main(String[] args) {
        // 一个文件中有多少各不相同的词
        try (Stream<String> lines = Files.lines(Paths.get("D:\\IdeaProjects\\JavaNotes\\Java8InAction\\src\\main\\resources\\lambda\\chap5\\data.txt"), Charset.defaultCharset())) {
            long count = lines.flatMap(l -> Arrays.stream(l.split(" ")))
                    .distinct()
                    .count();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
