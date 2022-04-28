package ru.plesser.hellogeekbrains;

import java.io.Serializable;

public class Data implements Serializable {
    private String display;
    private String displayHistory;

    private float numberOne;
    private float numberTwo;

    private String operator;

    public Data() {
        this.display = "0";
        this.display = "0";

        numberOne = 0;
        numberTwo = 0;
        operator = "";
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDisplayHistory() {
        return displayHistory;
    }

    public void setDisplayHistory(String displayHistory) {
        this.displayHistory = displayHistory;
    }

    public float getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(float numberOne) {
        this.numberOne = numberOne;
    }

    public float getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(float numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
