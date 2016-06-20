package com.bob.baseTutorials.finallyAndReturn;

/**
 * Created by Bob on 2016/4/11.
 */
public class Demo2 {

  public static void main(String[] args) {
    Demo2 demo = new Demo2();
    Student test = demo.test();
    System.out.println("main:" + test.age);
  }

  private Student test() {
    Student student = new Student("test", 18);
    try {
      System.out.println("init:" + student.age);
      return getReturn(student);
    } finally {
      student.age += 1;
      System.out.println("finally:" + student.age);
    }
  }

  private Student getReturn(Student student) {
    student.age += 2;
    System.out.println("return:" + student.age);
    return student;
  }

  class Student {

    public String name;
    public int age;

    public Student(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

}
