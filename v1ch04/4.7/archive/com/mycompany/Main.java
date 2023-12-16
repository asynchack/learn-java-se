package com.mycompany;

import com.wang.learnjava.*;

import static  java.lang.System.*;

/**
 * 没有定义package，默认就是default package中，
 */
public class Main {
    public static void main(String[] args) {

        com.wang.learnjava.Person p = new com.wang.learnjava.Person("wang", 18);
        p.getName();
        out.println(p.getName());
    }
}