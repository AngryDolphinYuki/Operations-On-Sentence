import java.util.Scanner;

public class Word {
    String sentence;
    String clearedSentence = "";
    String sentenceWithoutPunctuations = "";
    String[] differentWords;

    public Word(){
        Files file = new Files();
        sentence = file.readTheSentenceTxt();
        clearSpaces(sentence);
        countWords(clearedSentence);
        countPunctuations(clearedSentence);
        countDifferentWords(clearedSentence);
        findTheMostUsedWord(clearedSentence);
    }

    public void clearSpaces(String a) {
        char[] letters = a.trim().toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (!(letters[i] == ' ' && letters[i+1] == ' ')){
                clearedSentence += letters[i];
            }
        }
        System.out.println("The sentence cleared from extra spaces successfully.");
        System.out.println(clearedSentence);
    }

    public void countWords(String a) {
        String[] words = a.split(" ");
        System.out.println("Word Count: " + words.length);
    }

    public void countPunctuations(String a) {
        char[] letters = a.toCharArray();
        int count = 0;
        for (int i = 0; i < letters.length; i++) {
            if (!((letters[i] >= 'a' && letters[i] <= 'z') || (letters[i] >= 'A' && letters[i] <= 'Z') || (letters[i] >= '0' && letters[i] <= '9') || letters[i] == ' ')){
                count++;
            }
            else sentenceWithoutPunctuations += letters[i];
        }
        System.out.println("Punctuation Marks Count: " + count);
    }

    public void countDifferentWords(String a) {
        String[] words = sentenceWithoutPunctuations.split(" ");
        differentWords = new String[words.length];
        int count = 0;
        boolean different;
        for (int i = 0; i < words.length; i++) {
            different = true;
            for (int j = 0; j < i; j++) {
                if (words[i].toLowerCase().equals(words[j].toLowerCase())){
                    different = false;
                    break;
                }
            }
            if (different) {
                differentWords[count] = words[i].toLowerCase();
                count++;
            }
        }
        System.out.println("Different Words Count: " + count);
    }

    public void findTheMostUsedWord(String a) {
        String[] words = sentenceWithoutPunctuations.split(" ");
        int[] usageCounts = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[j].toLowerCase().equals(words[i])) count++;
            }
            usageCounts[i] = count;
        }
        int max = 0;
        for (int i = 0; i < usageCounts.length; i++) {
            if (usageCounts[i] > usageCounts[max]) max = i;
        }
        System.out.println("The Most Used Word: " + words[max]);
        System.out.println("Usage Count: " + usageCounts[max]);
    }
}
