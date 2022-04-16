package com.example.demo;

public class Detection {

    private String language;
    private int confidence;
    private boolean isReliable;

    public Detection() {
    }

    public Detection(String language, int confidence, boolean isReliable) {
        this.language = language;
        this.confidence = confidence;
        this.isReliable = isReliable;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public boolean isReliable() {
        return isReliable;
    }

    public void setReliable(boolean reliable) {
        isReliable = reliable;
    }

    @Override
    public String toString(){
        return "Detection : " +
                "\n" + this.language +
                "\n" + String.valueOf(this.confidence) +
                "\n" + String.valueOf(this.isReliable);
    }
}
