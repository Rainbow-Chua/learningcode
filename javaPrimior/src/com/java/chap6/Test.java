package com.java.chap6;

public class Test {
	/**
	 * 泛型方法
	 * @param t
	 */
	public static <T> void f(T t){
		System.out.println("T的类型是："+t.getClass().getName());
	}
	/**
	 * 通配符泛型，需要传递泛型对象时
	 * @param a
	 */
	private static void take(Demo<?> a){
		a.print();
	}
	public static void main(String[] args) {
		Demo<Dog> demo = new Demo<Dog>(new Dog());
		Dog dog = demo.getOb();
		dog.say();

		Demo<Cat> demo2 = new Demo<Cat>(new Cat());
		Cat cat = demo2.getOb();
		cat.say();
		
		f(cat);
		f(dog);
		
		take(demo);
		take(demo2);

	}

}
