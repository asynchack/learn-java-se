package com.wang.learnjava;

/**
 * @author wang
 * @date 2023/11/1
 * @Version 1.0
 * @Since version 0.1
 * @deprecated Use <code> setVisible(true) </code> instead
 * @see com.wang.learnjava.Card2#raiseSalary2(double)
 * @see <a href="www.baidu.com/index.html">baidu</a>
 * @see "just see"
 * A {@code Card} represents a playing card.
 * such as "quee of hearts".
 * good luck!
 */

public class Card {
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
    public double raiseSalary(double byPersent) {
        double raise = this.salary * byPersent / 100;
        this.salary += raise;
        return raise;
    }
}