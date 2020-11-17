package com.github.mgalmes.myapplication.model;

public class Question {
    private String text;
    private Answer option1;
    private Answer option2;

    public Question(String text, Answer option1, Answer option2) {
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer getOption1() {
        return option1;
    }

    public void setOption1(Answer option1) {
        this.option1 = option1;
    }

    public Answer getOption2() {
        return option2;
    }

    public void setOption2(Answer option2) {
        this.option2 = option2;
    }
}
