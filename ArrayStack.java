import java.util.Arrays;

/**
 * ������ģ��ջ ע������
 */

/**
 * @author IVER3ON
 * @param <T>
 * @email grepzwb@qq.com
 * 2016��5��17��
 */
public class ArrayStack<T> implements Stack<T>{
	private final int DEFAULT_SIZE=2;//����Ĭ�ϵ�����  
    private int capacity;//ջ������  
    private int size;//ջ�Ĵ�С  
    private int top;//ָ����һ��Ҫ��ӵ�Ԫ�ص�λ��  
    private Object[] array;  
    
    public ArrayStack(){
    	this.capacity=DEFAULT_SIZE;  
        this.array=new Object[this.capacity];  
        this.size=0; 
    }
    public ArrayStack(int capacity){  
        this.capacity=capacity;  
        this.array=new Object[this.capacity];  
        this.size=0;  
    }  
	
	public void clear() {
		Arrays.fill(this.array, null);  
        this.size=0;  
        this.top=0;  
        this.capacity=DEFAULT_SIZE;  
        this.array=new Object[capacity]; 
		
	}

	public boolean isEmpty() {
		return size==0;
	}

	public T peek() {
		if(isEmpty()){  
            return null;  
        }  
        return (T) this.array[this.top-1];  
	}

	public T pop() {
		T elment=(T) this.array[top-1];  
        array[this.top-1]=null;  
        this.top=this.top-1;  
        this.size--;  
        return elment;  
	}

	public void push(T elment) {
		 if(this.size<this.capacity){  
	            this.array[top]=elment;  
	            this.size++;  
	            this.top++;  
	        }  
	        else {   //��ջ����������������ջ������  
	            addStackCapacity();  
	            push(elment);  
	        }         
	}

	private void addStackCapacity() {
		this.capacity=this.capacity+DEFAULT_SIZE;//Ĭ�����ӵķ���Ϊ2  
        Object[] newArray=new Object[this.capacity];  
        System.arraycopy(this.array, 0, newArray, 0,this.array.length);//�Ѿ������ֵ���Ƶ��µ�������  
        Arrays.fill(array, null);//��ԭ���������ֵ����Ϊ��  
        this.array=newArray; 
	}
	public int size() {
		 return this.size;  
	}
	
	
	public static void main(String[] args) {
		 ArrayStack<Integer> testStack=new ArrayStack<Integer>();  
	        testStack.push(3);  
	        testStack.push(5);  
	        testStack.push(2);  
	        testStack.push(1);  
	        testStack.push(6);  
	        System.out.println("ջ��С:"+testStack.size());  
	        System.out.println("ջ������:"+testStack.capacity);  
	        System.out.println("ջ��Ԫ��:"+testStack.peek());  
	        while(!testStack.isEmpty()){  
	            System.out.println(testStack.pop());  
	        }  
	        System.out.println("ջ�Ĵ�С:"+testStack.size());  
	        System.out.println("ջ��Ԫ��:"+testStack.peek());  
	        System.out.println("ջ������:"+testStack.capacity);  
	        System.out.println("*****************"+"\n");  
	        testStack.push(1);  
	        testStack.push(6);  
	        testStack.push(2);  
	        System.out.println("ջ�Ĵ�С:"+testStack.size());  
	        testStack.clear();  
	        System.out.println("���ջ��ջ�Ĵ�С:"+testStack.size());  
	        System.out.println("���ջ��ջ������:"+testStack.capacity);  
	}

}
