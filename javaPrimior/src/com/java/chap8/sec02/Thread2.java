package com.java.chap8.sec02;

public class Thread2 implements Runnable {

	private volatile int baoZi=1;
	private String threadName;
	private Thread2(String threadName){
		super();
		this.threadName=threadName;
	}
	/*
	 * 4堵塞状态
	 * 	一个正在执行的线程在某些特殊情况下，如被人为挂起或需要执行耗时的输入、输出操作时
	 * 将让出cpu并且中止自己的执行，进入堵塞状态。堵塞时，线程不能进入排队队列，只有当
	 * 引起堵塞的原因被消除后，线程才可以转入就绪状态。
	 */
	@Override
	public void run() {
		int a = 0;

			
		while(true){

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//System.out.println(Thread.currentThread().getName());	
			synchronized (this) {
				if(baoZi<=100) {
					System.out.println(Thread.currentThread().getName()+"在"+threadName+"吃第"+baoZi+"包子");
					baoZi++;
					a++;
				}
				else{
					System.out.println(Thread.currentThread().getName()+"吃了"+a+"个包子");
					break;
				}
			}
				
		}
		
	}
	/*
	 * 5死亡状态
	 * 	线程调用stop()方法时或run()方法执行结束后，即处于死亡状态。
	 * 处于该状态的线程不具有继续运行的能力。
	 */

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 三个线程竞争吃100包子
		 *
		 *
		 * 
		 * 1创建状态
		 * 	在程序中用构造方法创建了一个线程对象后，新的线程对象便处于新建状态，此时，它
		 * 已经有了相应的内存空间和其他资源，但还处于不可运行状态。新建一个线程对象可采用
		 * Thread类的构造方法来实现，例如，“Thread thread=new Thread();”
		 * 
		 */
		Thread2 t=new Thread2("张三客栈");
		Thread t1=new Thread(t,"大黄");
		Thread t2=new Thread(t,"二狗");
		Thread t3=new Thread(t,"三叔");
		//设置优先级
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		/*
		 * 2就绪状态
		 * 	新建线程对象后，调用该线程的start()方法就可以启动线程。当线程启动时，线程进入
		 * 就绪状态。此时，线程进入线程队列中排队，等待cpu服务，这表明了它已经具备了运行条件
		 */
		t1.start();
		t2.start();
		t3.start();
		System.out.println("t1 is alive: "+t1.isAlive());
		t2.join();
		t1.join();
		System.out.println("t1 is alive: "+t1.isAlive());
		t3.join();
		System.out.println("Main thread is exiting...");
		
	}
}
