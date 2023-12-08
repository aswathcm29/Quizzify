package com.example.demo;

public class Question {
    public int id;
    public String quiz;
    public int parent_id;

    public Question(int _id, String _quiz, int _parent_id) {
        this.id = _id;
        this.quiz = _quiz;
        this.parent_id = _parent_id;
    }
    public void setId(int _id) {
        this.id = _id;
    }

    public int getId() {
        return this.id;
    }

    public void setQuiz(Integer _Quiz) {
        this.id = _Quiz;
    }

    public String getQuiz() {
        return this.quiz;
    }

    public void setParent_id(int _ParentId) {
        this.id = _ParentId;
    }

    public Integer getParent_id() {
        return this.parent_id;
    }
}
