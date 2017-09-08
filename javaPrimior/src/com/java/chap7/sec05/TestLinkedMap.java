package com.java.chap7.sec05;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class TestLinkedMap {

	public static void main(String[] args) {
		/*
		 * Map �ӿڵĹ�ϣ��������б�ʵ�֣����п�
		 * Ԥ֪�ĵ���˳�򡣴�ʵ���� HashMap �Ĳ�ͬ
		 * ֮�����ڣ�����ά����һ��������������Ŀ��
		 * ˫�������б��������б����˵���˳�򣬸�
		 * ����˳��ͨ�����ǽ������뵽ӳ���е�˳��
		 * ����˳�򣩡�ע�⣬�����ӳ�������²��� ������
		 * ����˳����Ӱ�졣������ڵ��� m.put(k, v) ǰ 
		 * m.containsKey(k) ������ true�������ʱ�Ὣ�� k ���²��뵽ӳ�� m �С��� 
		 * ��ͬ��������������ʧ��
		 */
		LinkedHashMap<String, Integer> numbers=new LinkedHashMap<String, Integer>();
		   numbers.put("one", 1);
		   numbers.put("two", 2);
		   numbers.put("three", 3);
			Iterator<String> it=numbers.keySet().iterator();//��ȡkey�ļ����ٻ�ȡ������
			while(it.hasNext()){
				String key=it.next();
				Integer s1=numbers.get(key);
				System.out.println(s1);
			}
	}
}
