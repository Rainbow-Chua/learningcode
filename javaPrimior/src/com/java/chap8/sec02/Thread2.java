package com.java.chap8.sec02;

public class Thread2 implements Runnable {

	private volatile int baoZi=1;
	private String threadName;
	private Thread2(String threadName){
		super();
		this.threadName=threadName;
	}
	/*
	 * 4����״̬
	 * 	һ������ִ�е��߳���ĳЩ��������£��类��Ϊ�������Ҫִ�к�ʱ�����롢�������ʱ
	 * ���ó�cpu������ֹ�Լ���ִ�У��������״̬������ʱ���̲߳��ܽ����ŶӶ��У�ֻ�е�
	 * ���������ԭ���������̲߳ſ���ת�����״̬��
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
					System.out.println(Thread.currentThread().getName()+"��"+threadName+"�Ե�"+baoZi+"����");
					baoZi++;
					a++;
				}
				else{
					System.out.println(Thread.currentThread().getName()+"����"+a+"������");
					break;
				}
			}
				
		}
		
	}
	/*
	 * 5����״̬
	 * 	�̵߳���stop()����ʱ��run()����ִ�н����󣬼���������״̬��
	 * ���ڸ�״̬���̲߳����м������е�������
	 */

	public static void main(String[] args) throws InterruptedException {
		/*
		 * �����߳̾�����100����
		 *
		 *
		 * 
		 * 1����״̬
		 * 	�ڳ������ù��췽��������һ���̶߳�����µ��̶߳���㴦���½�״̬����ʱ����
		 * �Ѿ�������Ӧ���ڴ�ռ��������Դ���������ڲ�������״̬���½�һ���̶߳���ɲ���
		 * Thread��Ĺ��췽����ʵ�֣����磬��Thread thread=new Thread();��
		 * 
		 */
		Thread2 t=new Thread2("������ջ");
		Thread t1=new Thread(t,"���");
		Thread t2=new Thread(t,"����");
		Thread t3=new Thread(t,"����");
		//�������ȼ�
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		/*
		 * 2����״̬
		 * 	�½��̶߳���󣬵��ø��̵߳�start()�����Ϳ��������̡߳����߳�����ʱ���߳̽���
		 * ����״̬����ʱ���߳̽����̶߳������Ŷӣ��ȴ�cpu��������������Ѿ��߱�����������
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
