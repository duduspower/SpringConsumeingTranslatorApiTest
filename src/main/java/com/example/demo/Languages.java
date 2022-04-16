package com.example.demo;

import java.util.ArrayList;

public class Languages {

    private ArrayList<Language> languages;

    public Languages() {
    }

    public Languages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString(){
        return "List of languages : " + this.languages.toString();
    }


}
