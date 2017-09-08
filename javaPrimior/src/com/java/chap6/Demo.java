package com.java.chap6;

public class Demo<T extends Animal> {
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public void print() {
		System.out.println("TÀàĞÍÎª£º" + ob.getClass().getName());
	}

	public Demo(T ob) {
		super();
		this.ob = ob;
	}

}
