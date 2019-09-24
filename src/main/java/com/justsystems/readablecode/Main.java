package com.justsystems.readablecode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * 単語情報を記載したファイルから全ての単語情報を読み込む。
     * ファイルには単語の情報が1行に一つ記載されている。
     *
     * @return ファイルから読み込んだ単語のリスト。読み込めない場合は空のリストを返却する
     */
    private List<String> readWordsInfo() {
        String filePath = "data/word.tsv";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(filePath, StandardCharsets.UTF_8))) {
            return reader.lines().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println(MessageFormat.format("ファイルが存在しません: {0}", filePath));
        } catch (IOException e) {
            System.out.println(MessageFormat.format("ファイルが読み込めませんでした: {0}", filePath));
        }
        return Collections.emptyList();
    }

    private void printHeading() {
        readWordsInfo().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printHeading();
    }
}
