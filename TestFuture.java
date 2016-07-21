import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*�����̵߳�2�ַ�ʽ��һ����ֱ�Ӽ̳�Thread������һ�־���ʵ��Runnable�ӿڡ�
��2�ַ�ʽ����һ��ȱ�ݾ��ǣ���ִ��������֮���޷���ȡִ�н����
 * �����Ҫ��ȡִ�н�����ͱ���ͨ�������������ʹ���߳�ͨ�ŵķ�ʽ���ﵽЧ��������ʹ�������ͱȽ��鷳��

�������Դ�Java 1.5��ʼ�����ṩ��Callable��Future��ͨ�����ǿ���������ִ�����֮��õ�����ִ�н����

�����������Ǿ�������һ��Callable��Future��FutureTask�������ʹ�÷����������Ǳ��ĵ�Ŀ¼��٣�

����һ.Callable��Runnable

������.Future

������.FutureTask
 */
//ʹ��Callable+Future��ȡִ�н��
public class TestFuture {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();
		Future<Integer> result = executor.submit(task);
		executor.shutdown();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("���߳���ִ������");

		try {
			System.out.println("task���н��" + result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("��������ִ�����");
	}
}

class Task implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println("���߳��ڽ��м���");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}
