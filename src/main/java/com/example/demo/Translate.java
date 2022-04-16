package com.example.demo;

public class Translate {
    private String translatedText;

    public Translate() {
    }

    public Translate(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    @Override
    public String toString(){
        return "Translated Text : " + this.translatedText;
    }

}
