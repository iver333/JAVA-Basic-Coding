/**
 * �ӿ��ǹ����ģ����治����˽�еķ�����������������ñ���ʹ�õģ����������ǿ�����˽�з�����˽�б����ģ�

���⣬ʵ�ֽӿڵ�һ��Ҫʵ�ֽӿ��ﶨ������з�������ʵ�ֳ����������ѡ�����д��Ҫ�õ��ķ�����
һ���Ӧ���������ǽӿڣ�Ȼ���ǳ�����ʵ�ֽӿڣ����ŵ�������ʵ�֡�

���У��ӿڿ���ʵ�ֶ��ؼ̳У���һ����ֻ�ܼ̳�һ�����࣬������ͨ���̳ж���ӿ�ʵ�ֶ��ؼ̳У�
�ӿڻ��б�ʶ������û���κη�������Remote�ӿڣ������ݹ�������ı���ȫ�ǳ�����������.
 */
//�����಻��ȫ��ʵ�ֽӿ��е����з���������ķ���ʵ�ֿ��Խ����ó����������ȥʵ�ּ��ɡ�

/**
 * @author Iver3on
 * @date 2016��8��27��
 */
abstract class Animal{
    abstract void say();
    abstract void hi();
}	
public class Cat extends Animal{
    public Cat(){
        System.out.printf("I am a cat");
    }
    public static void main(String[] args) {
        Cat cat=new Cat();
    }
	/* (non-Javadoc)
	 * @see Animal#say()
	 */
	@Override
	void say() {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see Animal#hi()
	 */
	/* (non-Javadoc)
	 * @see Animal#hi()
	 */
	@Override
	void hi() {
		// TODO Auto-generated method stub
		
	}

}
