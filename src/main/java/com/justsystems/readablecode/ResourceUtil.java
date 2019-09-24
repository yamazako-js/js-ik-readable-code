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

/**
 * 外部リソースを扱う処理を記載するUtilityクラス
 */
public class ResourceUtil {

    /**
     * ファイルに記載された情報を1行1要素としてListで返却する。
     *
     * @return ファイルから読み込んだ文字列のリスト。読み込めない場合は空のリストを返却する
     */
    public static List<String> readWordsInfo(String filePath) {
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
}
