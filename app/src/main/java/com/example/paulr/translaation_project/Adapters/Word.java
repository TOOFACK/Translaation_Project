package com.example.paulr.translaation_project.Adapters;

import android.text.Editable;

public class Word {
    private Editable word;

    public Word(Editable word) {
        this.word = word;
    }

    public Editable getWord() {
        return word;
    }

    public void setWord(Editable word) {
        this.word = word;
    }
}
