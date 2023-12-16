package com.wang.learnjava;

public class Card2 {

    private double salary;


    /**
     * the "hearts" cart suit
     */
    public static final int HEARTS = 1;

    /**
     * Raise the slary of an employee,
     * @Param byPercent mean the percentange
     * @Return the ammount of raise
     */
    public double raiseSalary2(double byPersent) {
        double raise = this.salary * byPersent / 100;
        this.salary += raise;
        return raise;
    }
}