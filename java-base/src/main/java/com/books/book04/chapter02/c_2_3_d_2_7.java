package com.books.book04.chapter02;

public class c_2_3_d_2_7 {
	public static void main(String[] args) {
		LoggingWidget loggingWidget = new LoggingWidget();
		loggingWidget.doSomething();

		Someclass sc = new Someclass();
		sc.method1();

	}
}

class Widget{
	public synchronized void doSomething(){
		System.out.println("I'm Widget.doSomething()");
	}
}

class LoggingWidget extends Widget{
	public synchronized void doSomething(){
		System.out.println("I'm LoggingWidget.doSomething() START");
		super.doSomething();
		System.out.println("I'm LoggingWidget.doSomething() END");
	}
}

 class Someclass {
	private static final Object LCK_OBJ = new Object();

	public void method1() {
		System.out.println(Thread.currentThread().getName() + " method1");
		synchronized (LCK_OBJ) {
			System.out.println(Thread.currentThread().getName() + " ready in method3");
			method3();
		}
	}

	public void method3() {
		synchronized (LCK_OBJ) {
			System.out.println(Thread.currentThread().getName() + " method3");
		}
	}

}




