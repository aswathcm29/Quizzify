package com.example.demo;


public class Options {
    public int option_id;
    public String option_var;
    public int question_id;

    public Options(Integer _id,String _optionVar,Integer _question_id){
        this.option_id = _id;
        this.option_var = _optionVar;
        this.question_id = _question_id;
    }


    public void setOptionId(Integer _Option_id){
        this.option_id = _Option_id;
    }
    public Integer getId(){
        return this.option_id;
    }
    public void setOption_var(String _OptionVar){
        this.option_var = _OptionVar;
    }
    public  String getOption_var(){
        return this.option_var;
    }
    public void setQuestion_id(Integer _question_id){
        this.question_id = _question_id;
    }
    public Integer getQuestion_id(){
        return this.question_id;
    }
}