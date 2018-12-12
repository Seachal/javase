package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

	private Map<String, Object> cache = new HashMap<String, Object>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
  /**
   * ���϶���,д������д��
   * �������Զ���߳�ͬʱ����,��Ϊ�����ݲ����������,д����ֻ��һ���߳̽���,��Ϊд����ֻ��ͬʱ��һ���߳̽��С���Ȼ����߳�
   * ����ͬһ���ݻ�������ݻ���.
   * 
   * �������϶���,���������ݻ�գ�����д��,д�����ݺ��ٽ�д��,�����϶�����
   */
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public  Object getData(String key){
		rwl.readLock().lock(); //�����϶���
		Object value = null;
		try{
			value = cache.get(key);
			if(value == null){
				rwl.readLock().unlock();  //���û������������  ��д��
				rwl.writeLock().lock();  //��д��
				try{
					if(value==null){ //�ٴ��ж��Ƿ�Ϊnull,�����ظ���ѯ
						value = "aaaa";//ʵ��ʧȥqueryDB();
					}
				}finally{
					rwl.writeLock().unlock(); //��finally��֤��д��
				}
				rwl.readLock().lock(); //�����϶���
			}
		}finally{
			rwl.readLock().unlock();
		}
		return value;
	}
}
