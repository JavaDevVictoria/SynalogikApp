package org.victoriaholland;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLength {
    private int wordCount = 0;
    private int characterCount = 0;
    private final HashMap<Integer, Integer> wordLengthCount = new HashMap<>();
    /**
     * Reads the input file and processes the data
     */
    public void readDataFile(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

            // Reads data from the file using the BufferedReader.
            // Reads a line at a time.
            String line;
            while ((line = reader.readLine()) != null) {
                // Processes each line to count words.
                String[] words = line.split("\\s+"); // Split the line into words, by spaces.
                wordCount += words.length;

                // Counts only word characters (alphanumeric, underscores, ampersands, slashes, at-symbols).
                for (char c : line.toCharArray()) {
                    if (Character.isLetterOrDigit(c) || c == '_' || c == '&' || c == '/' || c == '\'' || c == '@') {
                        characterCount++;
                    }
                }

                // Update word length count, excluding words that consist solely of full stops.
                for (String word : words) {
                    // Remove trailing full stops from the word.
                    String wordWithoutTrailingPeriod = word.replaceAll("\\.$", "");
                    int length = wordWithoutTrailingPeriod.length();
                    wordLengthCount.put(length, wordLengthCount.getOrDefault(length, 0) + 1);
                }
            }

            reader.close();
            fileInputStream.close();

            createReport();
        } catch (IOException e) {
            System.out.println("Failed to read from source file.");
            System.out.println(e.getMessage());
        }
    }

    private void createReport() {
        System.out.println("Word count = " + getWordCount());
        System.out.println("Average word length = " + getAverageWordLength());

        System.out.println(getNumberOfWordsOfEachLength());
    }

    /**
     * @return the number of words of each length, and most frequently
     * occurring word length
     */
    public String getNumberOfWordsOfEachLength() {
        StringBuilder result = new StringBuilder();
        // Appends the number of words of each length to the result.
        // Length is key, number of words is value.
        wordLengthCount.forEach((key, value) ->
                result.append("Number of words of length ")
                        .append(key)
                        .append(" is ")
                        .append(value)
                        .append("\n")
        );

        // Initialises variables to track the maximum value.
        int maxValue = Integer.MIN_VALUE;

        // Iterates through the HashMap entries and find the maximum value.
        for (Map.Entry<Integer, Integer> entry : wordLengthCount.entrySet()) {
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }

        if (maxValue > 0) {
            List<Integer> mostFrequentLengths = getMostFrequentWordLengths();
            result.append("The most frequently occurring word length is ");
            result.append(maxValue);
            result.append(", for word lengths of ");

            if (mostFrequentLengths.size() == 1) {
                result.append(mostFrequentLengths.get(0));
            } else if (mostFrequentLengths.size() > 1) {
                result.append(mostFrequentLengths.get(0));
                for (int i = 1; i < mostFrequentLengths.size(); i++) {
                    result.append(" & ").append(mostFrequentLengths.get(i));
                }
            }
        }
        else {
            result.append("The file is empty.");
        }

        return result.toString();
    }


    /**
     * @return the total number of words counted
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * @return the total number of characters counted
     */public int getCharacterCount() {
        return characterCount;
    }

    /**
     * @return the average length of the words
     */
    public double getAverageWordLength() {
        double average;
        if (getWordCount() == 0) {
            average = 0;
        }
        else {
            average = (double) getCharacterCount() / (double) getWordCount();
            average = (double)Math.round(average * 1000d) / 1000d; // Rounds the average to 3 decimal places
        }
        return average;
    }

    /**
     * @return List containing the most frequent word lengths
     */
    public List<Integer> getMostFrequentWordLengths() {
        int maxCount = 0;
        List<Integer> mostFrequentLengths = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : wordLengthCount.entrySet()) {
            int length = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                mostFrequentLengths.clear(); // Clears previous results
                mostFrequentLengths.add(length);
                maxCount = count;
            } else if (count == maxCount) {
                mostFrequentLengths.add(length);
            }
        }

        return mostFrequentLengths;
    }
}

