/**
 * 
 */
package net.zwb;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com
 * 2016��5��16��
 */
public class ConcurrentHashMapTest {
	static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
	/**
	 * @param args
	 * 
	 * ConcurrentHashMap��Ĭ���ǰ�segments��ʼ��Ϊ����Ϊ16�����顣
����ConcurrentHashMap.segmentFor���㷨��3��4��Ӧ��Segment����segments[1]��7��Ӧ��Segment��segments[12]��
��1��Thread1��Thread2�Ⱥ����Segment.put����ʱ��Thread1�����Ȼ�ȡ���������Խ��룬��Thread2������������ϣ�
��2���л���Thread3��Ҳ�ߵ�Segment.put��������Ϊ7���洢��Segment��3��4��ͬ����ˣ�����������lock()��
���Ͼ���ConcurrentHashMap�Ĺ������ƣ�ͨ��������Map��ΪN��Segment������HashTable���������ṩ��ͬ���̰߳�ȫ������Ч������N����Ĭ������16����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  new Thread("Thread1"){  
	            @Override  
	            public void run() {  
	                map.put(3, 33);  
	            }  
	        };  
	          
	        new Thread("Thread2"){  
	            @Override  
	            public void run() {  
	                map.put(4, 44);  
	            }  
	        };  
	          
	        new Thread("Thread3"){  
	            @Override  
	            public void run() {  
	                map.put(7, 77);  
	            }  
	        };  
	        System.out.println(map);  
	}

}
