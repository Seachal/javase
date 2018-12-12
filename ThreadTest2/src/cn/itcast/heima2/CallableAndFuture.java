package cn.itcast.heima2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**    �߳�ִ������,�����Եõ�����ķ��ؽ��
 * ��ͨ���߳�û�з��ؽ��,ʹ���̳߳ص�submit�������Եõ�����ֵ����ʵ��һ��Futrue����
 */
public class CallableAndFuture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService threadPool =  Executors.newSingleThreadExecutor();
		Future<String> future =  //Future��������Callable����
			threadPool.submit(
				new Callable<String>() { //����ֵΪString����
					public String call() throws Exception {
						Thread.sleep(2000);
						return "hello"; //����ֵ   ����Future
					};
				}
		);
		System.out.println("�ȴ����");
		try {
			System.out.println("�õ������" + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**��ɵķ���*/
		ExecutorService threadPool2 =  Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
		for(int i=1;i<=10;i++){
			final int seq = i;
			completionService.submit(new Callable<Integer>() {//CompletionService�ύһ��Callable����
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return seq;
				}
			});
		}
		//��Ϊ�̳߳�����10���߳�,�����ύ��10������,����Եõ�10�����ؽ��
		for(int i=0;i<10;i++){
			try {
				System.out.println(
						completionService.take().get()); //���ؽ��
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}
		}
	}
	

}
