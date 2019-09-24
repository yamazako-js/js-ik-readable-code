package com.justsystems.readablecode.data;

import com.justsystems.readablecode.utils.DataUtils;

/**
 * 辞書の1単語を表すクラス
 */
public class Word {
    /**
     * ID <br/>
     * value に対して一意に定まる
     */
    private String id;
    /**
     * 単語の文字列
     */
    private String value;

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Word(String value) {
        this.id = DataUtils.createHash_SHA512(value);
        this.value = value;
    }
}
