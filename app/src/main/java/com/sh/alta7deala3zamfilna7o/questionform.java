package com.sh.alta7deala3zamfilna7o;

public class questionform {

    private  String question;
    private  String correctresponse;
    private  String leson;
    private  String false1;
    private  String false2;
    private  String false3;
    private int agerequired;


    public questionform(String question, String correctresponse, String leson, String false1, String false2, String false3, int agerequired) {
        this.question = question;
        this.correctresponse = correctresponse;
        this.leson = leson;
        this.false1 = false1;
        this.false2 = false2;
        this.false3 = false3;
        this.agerequired = agerequired;

    }
public questionform(){}
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectresponse() {
        return correctresponse;
    }

    public void setCorrectresponse(String correctresponse) {
        this.correctresponse = correctresponse;
    }

    public String getLeson() {
        return leson;
    }

    public void setLeson(String leson) {
        this.leson = leson;
    }

    public String getFalse1() {
        return false1;
    }

    public void setFalse1(String false1) {
        this.false1 = false1;
    }

    public String getFalse2() {
        return false2;
    }

    public void setFalse2(String false2) {
        this.false2 = false2;
    }

    public String getFalse3() {
        return false3;
    }

    public void setFalse3(String false3) {
        this.false3 = false3;
    }

    public int getAgerequired() {
        return agerequired;
    }

    public void setAgerequired(int agerequired) {
        this.agerequired = agerequired;
    }


}
