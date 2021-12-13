package org.example.domain;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;

@XmlRootElement
public class Sentence {


    private ArrayList<Word> words = new ArrayList<>();

    public Sentence() {
    }

    public void add(Word word) {
        this.words.add(word);
    }

    public ArrayList<Word> getWord() {
        return words;
    }

    public void setWord(ArrayList<Word> words) {
        this.words = words;
    }

}
