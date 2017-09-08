package com.java.chap6;

public class Test {
	/**
	 * ���ͷ���
	 * @param t
	 */
	public static <T> void f(T t){
		System.out.println("T�������ǣ�"+t.getClass().getName());
	}
	/**
	 * ͨ������ͣ���Ҫ���ݷ��Ͷ���ʱ
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
