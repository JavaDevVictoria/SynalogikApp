package org.victoriaholland;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestWordLength {
    File synalogikExample = new File("src/main/resources/test.txt");
    File blankFile = new File("src/main/resources/BlankTextFile.txt");

    @Test
    public void testExample() {
        final WordLength wordLength = new WordLength();
        wordLength.readDataFile(String.valueOf(synalogikExample));

        assertEquals(9, wordLength.getWordCount());
        assertEquals(41, wordLength.getCharacterCount());
        assertEquals(4.556, wordLength.getAverageWordLength(), 0.001);

        List<Integer> expectedMostCommonWordLengths = Arrays.asList(4, 5);
        List<Integer> resultMostCommonWordLengths = wordLength.getMostFrequentWordLengths();
        assertEquals(expectedMostCommonWordLengths, resultMostCommonWordLengths);

        String expectedNumberOfWordsOfEachLength = "Number of words of length 1 is 1\n" +
                "Number of words of length 2 is 1\n" +
                "Number of words of length 3 is 1\n" +
                "Number of words of length 4 is 2\n" +
                "Number of words of length 5 is 2\n" +
                "Number of words of length 7 is 1\n" +
                "Number of words of length 10 is 1\n" +
                "The most frequently occurring word length is 2, for word lengths of 4 & 5";
        String resultNumberOfWordsOfEachLength = wordLength.getNumberOfWordsOfEachLength();
        assertEquals(expectedNumberOfWordsOfEachLength, resultNumberOfWordsOfEachLength);
    }

    @Test
    public void testBlankTextFile() {
        final WordLength wordLength = new WordLength();
        wordLength.readDataFile(String.valueOf(blankFile));

        assertEquals(0, wordLength.getWordCount());
        assertEquals(0, wordLength.getCharacterCount());
        assertEquals(0.0, wordLength.getAverageWordLength(), 0.001);

        String expectedNumberOfWordsOfEachLength = "The file is empty.";
        String resultNumberOfWordsOfEachLength = wordLength.getNumberOfWordsOfEachLength();
        assertEquals(expectedNumberOfWordsOfEachLength, resultNumberOfWordsOfEachLength);
    }
}
