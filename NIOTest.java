import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ������ͨIO��NIO����ͬ
 */

/**
 * @author Iver3oN Zhang
 * @date 2016��3��15��
 * @email grepzwb@qq.com NIOTest.java Impossible is nothing
 */
public class NIOTest {
	 static private final byte message[] = { 83, 111, 109, 101, 32,  
	        98, 121, 116, 101, 115, 46 };  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NIORead();
		//NIOWrite();
	}
	public static void NIOWrite(){
		try {
			FileOutputStream fout = new FileOutputStream(new File("NIOBooks.txt"));
			FileChannel fc = fout.getChannel();
			//����һ��1024�ֽڵ�buffer 
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put("this is NIO test".getBytes());   
			//// ����˻�����������������Ϊ��ǰλ�ã�Ȼ�󽫵�ǰλ������Ϊ0 positionΪ0 limitҲΪ0  Ҳ���� ��ʼд��ܵ���
	        buffer.flip();          
	        try {
				fc.write( buffer );
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
	        try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void NIORead(){
		try {
			@SuppressWarnings("resource")
			FileInputStream fin = new FileInputStream("books.xml");
			FileChannel fc = fin.getChannel();
			//����һ��1024�ֽڵ�buffer 
			//  // �����µ�int������������Ϊ����������  
	        // �»������ĵ�ǰλ�ý�Ϊ�㣬�����(����λ��)��Ϊ����������������һ���ײ�ʵ�����飬������ƫ������Ϊ�㡣
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			try {
				//��Ҫ�����ݴ�ͨ��������������
				fc.read(buffer);
				//flip() �����û��������Խ��¶��������д����һ��ͨ��
				buffer.flip();	
				// �鿴�ڵ�ǰλ�ú�����λ��֮���Ƿ���Ԫ��
				 while (buffer.remaining()>0) {  
					 // ��ȡ�˻�������ǰλ�õ�������Ȼ��ǰλ�õ���  
			            byte b = buffer.get();  
			            System.out.print(((char)b));  
			        }            
			        fin.close();  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commonIO() {
		// ��ͨIO��ʽ��ȡbook.xml����
		try {
			InputStream in = new FileInputStream(new File("books.xml"));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			OutputStream out = new FileOutputStream(new File("newbooks.xml"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			String temp = "";
			// byte[] c = new byte[1024];
			try {
				while ((temp = br.readLine()) != null) {
					// c = temp.getBytes();
					System.out.println(temp);
					bw.write(temp + "\n");
				}
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
