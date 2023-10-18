INTRODUCTION

This application is a Java API to read the contents of a plain text file and enable the display of the total number of words, the average word length, the most frequently occurring word length, and a list of the number of words of each length.

Average word length is calculated by dividing the total number of characters by the total number of words in the file.

INPUT

Hello world & good morning. The date is 18/05/2016

OUTPUT

Word count = 9
Average word length = 4.556
Number of words of length 1 is 1
Number of words of length 2 is 1
Number of words of length 3 is 1
Number of words of length 4 is 2
Number of words of length 5 is 2
Number of words of length 7 is 1
Number of words of length 10 is 1
The most frequently occurring word length is 2, for word lengths of 4 & 5

ASSUMPTIONS ON WORD DEFINITIONS

& is counted as a word. A word containing a hyphen is counted as all one word. I made the assumption that full stops aren't included in the total character count. This is because the character count being 41 is the only way to get the average word length to be 4.556, as per the specification. (Total haracter count / word count = average word length, eg 41 / 9 = 4.556). I made this assumption because the ampersand character is still counted as a word of length 1 in the sample output provided in the specification.

Punctuation marks aren't included in the total character count. However, when counting the length of individual words, eg hello@google.com (which counts as one word), the @ symbol and the dot before "com" is still counted, so it counts as 16 characters.

INSTALLATION INSTRUCTIONS

To install, download the file:
   SynalogikApp\out\artifacts\SynalogikApp_jar\SynalogikApp.jar

Execute using the command:
java -jar <installation-dir>/SynalogikApp.jar <path-to-text-file>
eg java -jar SynalogikApp.jar C:\Users\victo\OneDrive\Documents\Synalogik\SynalogikApp\src\main\resources\test.txt

Alternatively, you can run the project via Maven. Clone the git repository and then run "mvn clean install" in the project root directory where the pom.xml file is located. Then run mvn exec:java -Dexec.mainClass=org.victoriaholland.ReadFile -Dexec.args="C:\Users\victo\OneDrive\Documents\Synalogik\SynalogikApp\src\main\resources\test.txt"  [You will need to edit the filepath in Dexec.args to match the path to your local copy of test.txt].


RUNNING TESTS

Navigate to the project root directory where the pom.xml file is located. Run "mvn test" in the command prompt. 

Two separate tests will run - the first one tests the output for the test.txt file containing "Hello world & good morning. The date is 18/05/2016" The second test will run against an empty file, checking that no exceptions are thrown, and that the text "The file is empty." is printed. 
