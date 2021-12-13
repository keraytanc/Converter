package org.example.logic;

import org.example.domain.Sentence;
import org.example.domain.Text;
import org.example.domain.Word;

import java.io.File;
import java.text.Collator;
import java.util.Arrays;
import java.util.Scanner;

public class TextReader {

    public Text readAndSerializeData() {

        Text textObject = new Text();

        //loop reading file sentence by sentence
        try {
            Scanner scanner = new Scanner(System.in);

            scanner.useDelimiter("[.]+[ ][.]*");


            while (scanner.hasNext()) {
                String sentence = scanner.next();

                /*
                regular expression including non-english letters taken from:
                https://stackoverflow.com/questions/11332772/java-string-split-on-all-non-alphanumeric-except-apostrophes
                and edited by me to include: @, $, %, &, + as these signs are often used in written language
                 */
                //String[] words = sentence.split("[^\\p{L}0-9'@$%&-.]+");
                String[] words = sentence.split("[[^\\p{L}0-9'@$%&-.+]||[*,()]]+");

                //sorting words array(case insensitive)
                Arrays.sort(words, Collator.getInstance());

                Sentence sentenceObject = new Sentence();

                for (String word: words) {

                    Word wordObject = new Word();
                    wordObject.setWord(word.trim());

                    sentenceObject.add(wordObject);
                }

                textObject.add(sentenceObject);
            }
            scanner.close();

            return textObject;
        } catch (Exception e) {

            return new Text();
        }
    }
}
