/**
 * 
 */
package net.zhangwenbo.servlet;

/**
 * @author Iver3oN Zhang
 * @date 2016��3��14��
 * @email grepzwb@qq.com
 * TestString.java
 * Impossible is nothing
 */
public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*������Ϊ��true�����ڱ�final���εı�����
		 * ����class�ļ��������б���һ��������Ҳ����˵����ͨ�����Ӷ����з��ʣ�
		 * ��final�����ķ����ڱ����ڼ䶼��ֱ�ӱ����Ϊ��ʵ��ֵ����ôString c = b + 2;�ڱ����ڼ�ͻᱻ�Ż��ɣ�
		 * String c = ��hello�� + 2
		 */
		String a = "hello2";
		final String b = "hello";       
		String c = b + 2;       
		System.out.println((a == c));
	}

}
