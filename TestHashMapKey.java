import java.util.HashMap;
import java.util.Map;

/**��HashMap�У�����key�ıȽ�˳��Ϊ��
��������Hash Code�����ڱ����Ƿ���ڡ�
����ӦHash Codeλ���еĶ���͵�ǰ�����Ƿ���ȡ�
 */

/**
 * @author Iver3oN Zhang
 * @date 2016��3��25��
 * @email grepzwb@qq.com
 * T.java
 * Impossible is nothing
 */
public class TestHashMapKey{

	static class Person{

		String id;
		public Person(String id){
			this.id = id;
		}
		@Override
		public int hashCode() {
			//������ͬ���ݵ��ַ���������ͬ��Hash Code��
			return id != null ? id.hashCode() : 0;
		}

		//����Object�У�Hash Code�ļ��㷽���Ǹ��ݶ���ĵ�ַ���м���ģ�
		//������Person("003")�Ķ����ַ�ǲ�ͬ�ģ��������ǵ�Hash CodeҲ��ͬ��
		//��ȻHashMapҲ��������ǵ�����ͬһ��key��
		/*
		 * Ϊʲô����֪hashCode()��ȵ�����£�����Ҫ��equals()���бȽ��أ�
		 * ������Ϊ����������������еĳ��ֵ��������Ϊ���ݶ�Person���hashCode()����������ʵ�֣�
		 * Person���ֱ����id���String���ͳ�Ա��Hash Codeֵ��Ϊ�Լ���Hash Codeֵ�����Ǻ���Ȼ�ģ�
		 * һ��Person("003")��һ��String("003")�ǲ���ȵģ�������hashCode()��ȵ�����£�
		 * ����Ҫ��equals()���бȽϡ� 
		 * */
		@Override
		public boolean equals(Object o) {
			 if (this == o) return true;
		        if (o == null || getClass() != o.getClass()) return false;
		        Person person = (Person) o;
		        if (id != null ? !id.equals(person.id) : person.id != null) return false;
		        return true;
		}	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Person,Integer> map = new HashMap<>();
		map.put(new Person("1"),11);
		map.put(new Person("2"),34);
		map.put(new Person("3"), 21);
		map.put(new Person("3"), 31);
		System.out.println(map.toString());
		System.out.println(map.get(new Person("1")));
		System.out.println(map.get(new Person("2")));
		System.out.println(map.get(new Person("3")));
	}

}
