package org.example.domain;


import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;

@XmlRootElement
public class Text {


    private ArrayList<Sentence> sentences = new ArrayList<>();

    public Text() {
    }

    public void add(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public ArrayList<Sentence> getSentence() {
        return sentences;
    }

    public void setSentence(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }
}
