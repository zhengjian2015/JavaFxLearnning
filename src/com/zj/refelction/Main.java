package com.zj.refelction;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class stdClass = Student.class;

        System.out.println(stdClass.getMethod("getScore", String.class));

        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
    }
}


class Student extends Person {
    public int getScore(String type) {
        return 99;
    }
    private int getGrade(int year) {
        return 1;
    }
}

class Person {
    public String getName() {
        return "Person";
    }
}
