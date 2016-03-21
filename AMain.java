/**
 * 
 */

/**
 * @author Iver3oN Zhang
 * @date 2016��3��21��
 * @email grepzwb@qq.com A.java Impossible is nothing
 */
public class AMain {
	static class A {
		public String show(D obj) {
			return ("A and D");
		}

		public String show(A obj) {
			return ("A and A");
		}
	}

	static class B extends A {
		public String show(B obj) {
			return ("B and B");
		}

		public String show(A obj) {
			return ("B and A");
		}
	}

	static class C extends B {
	}

	static class D extends B {
	}

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		//ʵ������ΪA������Ϊ����B��BΪA�����ࡣִ��A.class��show(A obj)
		System.out.println(a1.show(b));//A and A
		//ͬ��
		System.out.println(a1.show(c));//A and A
		//ʵ������ΪA������Ϊ����D��ִ��A.class��show(D obj)
		System.out.println(a1.show(d));//A and D
		//ʵ��������ȻΪA������ΪB����Ӧִ��A.class��show(A obj)�����ǣ�B.class��д��show(A obj),����ִ��B.class show(A obj)
		System.out.println(a2.show(b));//B and A
		//ͬ��
		System.out.println(a2.show(c));//B and A
		//ִ��A.class show(D obj) B�в�û����д��
		System.out.println(a2.show(d));//A and D
		//8.ʵ������ΪB������ΪB����B�����ִ࣬��show(B obj)
		System.out.println(b.show(b));//B and B
		//8.ʵ������ΪB������ΪB����B�����ִ࣬��show(B obj)
		System.out.println(b.show(c));//B and B
		//ʵ������ΪB������ΪD����ΪB�̳���A��Ҳ����ִ��A�е�show(D obj)
		System.out.println(b.show(d));//A and D
	}
}
