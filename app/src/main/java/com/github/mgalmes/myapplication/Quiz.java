package com.github.mgalmes.myapplication;

import com.github.mgalmes.myapplication.model.Question;

import java.util.Arrays;
import java.util.List;

public class Quiz {
    private List<Question> questionList;
    private Question currentQuestion;

    public Quiz(Question[] questionList) {
        this.questionList = Arrays.asList(questionList);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
