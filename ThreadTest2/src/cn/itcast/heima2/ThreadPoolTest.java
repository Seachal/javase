package cn.itcast.heima2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	/**
	 * �̳߳�
	 */
	public static void main(String[] args) {
		//ExecutorService threadPool = Executors.newFixedThreadPool(3);//�̶��̳߳�
		//ExecutorService threadPool = Executors.newCachedThreadPool(); //�����̳߳� �̳߳��еĸ�����һ��,�������������Զ������߳�,����������,���Զ��ջ�һЩ�߳�
		ExecutorService threadPool = Executors.newSingleThreadExecutor();//��һ�̳߳�,ֻ��һ���߳�
		for(int i=1;i<=10;i++){ //����10������
			final int task = i;
			threadPool.execute(new Runnable(){ 
				@Override
				public void run() {
					for(int j=1;j<=10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
					
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for  task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed! ");
		//threadPool.shutdownNow(); //�ر��̳߳�
		
		/**�����̳߳�*/
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
				new Runnable(){
					@Override
				public void run() {
					System.out.println("bombing!");
					
				}},
				6,
				2,
				TimeUnit.SECONDS);
	}

}
