package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * �̷߳�Χ�ڵ����ݹ���
 * ��Ҫ����Ծ�̬������Ϊ����̲߳����Ŀ�����ͬһ������,�κ�һ���߳��޸����ݶ����������ݵı仯,����ԭ���߳�ȡ���������ݲ�
 * ��ȷ��������Լ��߳��ڵ������򲻴����������⡣
 * 
 * Ӧ�ð��������ݿ������ԭ����,ת��(ת���ת��)
 */
public class ThreadScopeShareData {

	private static int data = 0;
	 /*ͬ����map��������*/
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			int data = threadData.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}
	}
	
	static class B{
		public void get(){
			int data = threadData.get(Thread.currentThread());			
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}		
	}
}

/**
 *                ����İ���
 * �߳�1��data��ֵ��,��ʱ��ģ��A,ģ��B��������ȡֵ,�߳�2�ͽ�data��ֵ�ı��ˣ���ʱ��ģ��A,ģ��Bȡ������
 * ֵ�����߳�2��ֵ��,�������߳�1��ֵ�ġ�
 */
/*public class ThreadScopeShareData {

	private static int data = 0;
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					 data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}
	}
	
	static class B{
		public void get(){
		
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " get data :" + data);
		}		
	}
}*/

