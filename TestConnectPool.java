/**
 * 
 */
package net.zwb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * @author IVER3ON
 * @email grepzwb@qq.com 2016��5��16��
 */
public class TestConnectPool implements DataSource {

	// ���� --- ʵ��ջ�ṹ
	private LinkedList<Connection> dataSources = new LinkedList<Connection>();

	public TestConnectPool() {
		// һ���Դ���10������
		for (int i = 0; i < 10; i++) {
			try {
				// 1��װ��sqlserver��������
				DriverManager.registerDriver(new SQLServerDriver());
				// 2��ͨ��JDBC�������ݿ�����
				Connection con = DriverManager.getConnection(
						"jdbc:sqlserver://127.0.0.1:1433;DatabaseName=user",
						"root", "root");
				// 3�������Ӽ������ӳ���
				dataSources.add(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 */
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
	 */
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#setLoginTimeout(int)
	 */
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#getLoginTimeout()
	 */
	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#getParentLogger()
	 */
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getConnection()
	 */
	@Override
	public Connection getConnection() throws SQLException {
		// ȡ�����ӳ���һ������
		final Connection conn = dataSources.removeFirst(); // ɾ����һ�����ӷ���
		return conn;
	}

	// �����ӷŻ����ӳ�
	public void releaseConnection(Connection conn) {
		dataSources.add(conn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getConnection(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1��ʹ�����ӳؽ������ݿ�����  
		TestConnectPool dataSource = new TestConnectPool();  
	       Connection conn =dataSource.getConnection();          
	       //2������״̬  
	       Statement state =con.createStatement();             
	       //3����ѯ���ݿⲢ���ؽ��  
	       ResultSet result =state.executeQuery("select * from users");             
	       //4�������ѯ���  
	       while(result.next()){  
	              System.out.println(result.getString("email"));  
	       }              
	       //5���Ͽ����ݿ�����  
	       result.close();  
	       state.close();  
	       //6���黹���ݿ����Ӹ����ӳ�  
	       dataSource.releaseConnection(conn);  

	}

}
