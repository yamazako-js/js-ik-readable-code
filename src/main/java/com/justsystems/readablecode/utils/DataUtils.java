package com.justsystems.readablecode.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataUtils {

    /**
     * ハッシュ生成アルゴリズム
     */
    enum HashAlgorithm {
        SHA_512("SHA-512");

        String str;

        HashAlgorithm(String str) {
            this.str = str;
        }
    }

    /**
     * 引数で渡した文字列のSHA-512ハッシュ値を生成する
     *
     * @param str ハッシュ値の
     * @return 引数の文字列から生成したハッシュ値
     */
    public static String createHash_SHA512(String str) {
        return createHash(str, HashAlgorithm.SHA_512);
    }

    /**
     * 引数で渡した文字列、アルゴリズムでハッシュ値を生成する
     *
     * @param source    ソース文字列
     * @param algorithm ハッシュ生成アルゴリズム<br/>
     *                  SameParameterValue の Warning が出るが、拡張性のために @SuppressWarnings を付与
     * @return 生成したハッシュ値
     */
    // 可用性のために @SuppressWarnings を付与して対応
    private static String createHash(
            String source,
            @SuppressWarnings("SameParameterValue") HashAlgorithm algorithm) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm.str);
            md.update(source.getBytes());
            byte[] hash = md.digest();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.printf("Exception: %s, Source string: %s", e.getMessage(), source);
        }
        return sb.toString();
    }
}
