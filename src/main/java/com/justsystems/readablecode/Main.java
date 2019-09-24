package com.justsystems.readablecode;



public class Main {

    /**
     * 辞書情報を読み込み、標準出力に表示する。
     * ファイルは`data`ディレクトリに配置されている想定となっている。
     *
     * @param fileName 読み込む辞書ファイル名
     */
    private void printHeading(String fileName) {
        String filePath = String.join("/", "data", fileName);
        ResourceUtil.readWordsInfo(filePath).forEach(wordStr -> {
            Word word = new Word(wordStr);
            System.out.println(word.getId() + ": " + word.getValue());
        });
    }



    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("プログラムの実行には、引数に辞書ファイル名を一つだけ指定する必要があります。");
            System.exit(1);
        }
        Main main = new Main();
        main.printHeading(args[0]);
    }
}
