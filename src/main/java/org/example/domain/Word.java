package org.example.domain;


import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlValue;


public class Word {

    @XmlValue
    private String word;

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    @XmlTransient
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
