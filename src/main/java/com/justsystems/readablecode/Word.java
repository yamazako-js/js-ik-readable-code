package com.justsystems.readablecode;

/**
 * 辞書の1単語を表すクラス
 */
class Word {
    /**
     * ID <br/>
     * value に対して一意に定まる
     */
    private String id;
    /**
     * 単語の文字列
     */
    private String value;

    String getId() {
        return id;
    }

    String getValue() {
        return value;
    }

    Word(String value) {
        this.id = DataUtils.createHash_SHA512(value);
        this.value = value;
    }
}
