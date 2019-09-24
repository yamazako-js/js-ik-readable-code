package com.justsystems.readablecode;



public class Main {

    private void printHeading() {
        ResourceUtil.readWordsInfo("data/dictionary-data.tsv").forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printHeading();
    }
}
