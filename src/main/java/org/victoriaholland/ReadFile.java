package org.victoriaholland;

public class ReadFile {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java ReadFile <filename>");
            System.exit(0);
        }

        WordLength wordLength = new WordLength();

        wordLength.readDataFile(args[0]);
    }
}