package com.java.chap7.sec04;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		/*
		 * ���HashSet
		 * ������˳�������²����Ӱ��
		 * ע�⣬��ʵ�ֲ���ͬ���ġ��������߳�ͬʱ�������ӵĹ�ϣ set������������
		 * һ���߳��޸��˸� set���������� �����ⲿͬ������һ��ͨ����
		 * ��Ȼ��װ�� set �Ķ������ͬ����������ɡ��������
		 * �������Ķ�����Ӧ��ʹ�� Collections.synchronizedSet ��
		 * ��������װ���� set������ڴ���ʱ�����һ�������Է�ֹ����
		 * �ķ�ͬ�����ʣ� 
		 * Set s = Collections.synchronizedSet(new LinkedHashSet(...));
		 */
		LinkedHashSet<String> lhs=new LinkedHashSet<String>();
		lhs.add("2");
		lhs.add("3");
		lhs.add("4");
		lhs.add("1");
		lhs.add("3");
		System.out.println(lhs.hashCode());
		for(String s:lhs){
			System.out.println(s);
		}
		/*
		 * ����� iterator �������صĵ������ǿ���ʧ�� �ģ�
		 * �ڵ���������֮������� set �����޸ģ�����ͨ������������� remove ��������
		 * ���κ�ʱ���κη�ʽ���޸ģ�����������
		 * �׳� ConcurrentModificationException����ˣ���Բ���
		 * ���޸ģ��������ܿ�ͻ���ȫʧ�ܣ�����ð������ȷ����ʱ��
		 * ���ⷢ����ȷ����Ϊ�ķ��ա� 
		 */
		Iterator<String> it=lhs.iterator();
		lhs.add("s");
		lhs.remove("3");
		while(it.hasNext()){
			try {
				String s=it.next();
				System.out.println(s);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				break;
			}
		}
	}
}
