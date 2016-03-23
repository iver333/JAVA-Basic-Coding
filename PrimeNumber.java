import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * CVTE������ prime number
 */
/**
 * @author Iver3oN Zhang
 * @date 2016��3��22��
 * @email grepzwb@qq.com PrimeNumber.java Impossible is nothing
 */
public class PrimeNumber {

	/**
	 * ������������,������1�������������κ������������������� �����������������������֪��������ȫ���������ټ�һ.
	 * ��һ������һ����Ȼ��N��ֻҪ�ܱ�һ����1������������������Ϳ϶��������������Բ� ��������������ȥ����
	 * �ڶ�������N��˵��ֻ����С��N������ȥ���Ϳ����ˡ����磬���N�ܱ�15������ʵ��
	 * �Ͼ��ܱ�3��5���������N���ܱ�3��5��������ôNҲ�����ᱻ15������
	 * ����������N��˵�������ô�2��Nһ1����������ȥ����ֻ����С�ڵ��ڡ�N(����N)����������ȥ���Ϳ����ˡ�
	 * ���һ��������N�Ƿ�Ϊ��������򵥵ķ��������Գ�����������N��С�ڵ��ڸ���N����������ȥ�Գ��������޷�������N��Ϊ�������μ������ж�����
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(5);
		for (int i = 7; i <= 1000; i++) {
			// ���ڱ�ʶ�����һֱû�б�����
			boolean tag = false;
			for (int j = 0; j < list.size(); j++) {
				// ֻ��Ҫ�ж�С�ڵ��ڸ���i�����ܷ�����i����
				if (list.get(j) <= Math.sqrt(i) && i % list.get(j) == 0) {
					tag = true;
					break;
				} else {
					continue;
				}
			}
			if (!tag) {
				list.add(i);
			}
		}

		for (int x : list) {
			System.out.print(x + " ");
		}

	}
	/*
	 * ��6N��1����������
�κ�һ����Ȼ�����ܿ��Ա�ʾ��Ϊ���µ���ʽ֮һ��
6N��6N+1��6N+2��6N+3��6N+4��6N+5 (N=0��1��2����)
��Ȼ����N��1ʱ��6N��6N+2��6N+3��6N+4������������ֻ������6N+1��6N+5����Ȼ���п�����������
���ԣ�����2��3֮�⣬���е����������Ա�ʾ��6N��1����ʽ(NΪ��Ȼ��)��
�����������������ǿ��Թ�����һ��ɸ�ӣ�ֻ������6 N��1����Ȼ������ɸѡ�������Ϳ��Դ�����ɸѡ�Ĵ�����
�Ӷ���һ����߳��������Ч�ʺ��ٶȡ�
�ڳ����ϣ����ǿ�����һ������ѭ��ʵ����һ�㣬��ѭ��i��3�ı�����������ѭ��jΪ0��1��ѭ������2(i+j)-1ǡ�þ�������6N��1����Ȼ��
	 */

	@Test
	public static void getPrimNumber() {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		for (int i = 0; i <= 1000; i = i + 3) {
			for (int j = 0; j < 1; j++) {
				// ���ڱ�ʶ�����һֱû�б�����
				int num = 2 * (i + j) - 1;
				boolean tag = false;
				for (int k = 0; k < list.size(); k++) {
					// ֻ��Ҫ�ж�С�ڵ��ڸ���i�����ܷ�����i����
					if (list.get(j) <= Math.sqrt(num) && num % list.get(j) == 0) {
						tag = true;
						break;
					} else {
						continue;
					}
				}
				if (!tag) {
					list.add(num);
				}
			}

		}

		for (int x : list) {
			System.out.print(x + " ");
		}
	}
}
