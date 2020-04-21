package pglp5_2.pglp5_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;


public class BaseDao {

	public Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Personnel","usr","usr");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	public void close(AutoCloseable auto) {
		if(auto!=null) {
			try {
				auto.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	public void executeSql(String sql,Object...objs) {

		Connection conn=this.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
	
			for(int i=0;i<objs.length;i++) {
				ps.setObject(i+1, objs[i]);
			}
			
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(ps);
			this.close(conn);
		}
	}

	public List<Map<String,Object>> executeQuery(String sql,Object...objs){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Connection conn=this.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++) {
				ps.setObject(i+1, objs[i]);
			}
		
			rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			
			while(rs.next()) {
				Map<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(rs);
			this.close(ps);
			this.close(conn);
		}		
		return list;
	}
}


