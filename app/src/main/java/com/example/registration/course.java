package com.example.registration;

public class course {
    private String cName;
    private int cHours;
    private int cFees;

    public course(String cName, int cHours, int cFees) {
        this.cName = cName;
        this.cHours = cHours;
        this.cFees = cFees;
    }

    public String getcName() {
        return cName;
    }

    public int getcHours() {
        return cHours;
    }

    public double getcFees() {
        return cFees;
    }
}
