package cn.itcast.heima2;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ��д��
 *ʵ�ֶ����֮��� ������,����д֮��Ļ��⡣
 *����߳�ȥ��ͬһ����,����������ݵĻ���,����߳�ͬʱȥ����дͬһ����,���������ݵĻ���
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		for(int i=0;i<3;i++) //����3���߳�ȥ�����ݺ�д����
		{
			new Thread(){  //������
				public void run(){
					while(true){
						q3.get();						
					}
				}
				
			}.start();

			new Thread(){ //д����
				public void run(){
					while(true){
						q3.put(new Random().nextInt(10000));
					}
				}			
				
			}.start();
		}
		
	}
}

/**
 * �����֮�䲻����,����д֮�以��,д��д֮�以��
 * ��ʵ���ˣ������ж�,д��ֻ��д
 *
 */
class Queue3{
	private Object data = null;//�������ݣ�ֻ����һ���߳���д�����ݣ��������ж���߳�ͬʱ�������ݡ�
	ReadWriteLock rwl = new ReentrantReadWriteLock(); //һ��Ҫʹ��ͬһ�����������������ͽ���
	public void get(){
		rwl.readLock().lock(); //�������ö���  �����ɶ���߳���ִ��
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to read data!");
			Thread.sleep((long)(Math.random()*1000));
			System.out.println(Thread.currentThread().getName() + "have read data :" + data);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.readLock().unlock();
		}
	}
	
	public void put(Object data){
        
		rwl.writeLock().lock(); //��������д�� ,ֻ����ͬһ���߳�ȥִ��
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to write data!");					
			Thread.sleep((long)(Math.random()*1000));
			this.data = data;		
			System.out.println(Thread.currentThread().getName() + " have write data: " + data);					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.writeLock().unlock();
		}
		
	
	}
}
