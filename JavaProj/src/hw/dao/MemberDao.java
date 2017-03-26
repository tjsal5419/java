package hw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hw.Member;

 // 재사용 , 컨트롤러와 뷰의 종속 제거 , 협업에 유리
public class MemberDao {
	public List<Member> getList(String input, String query) throws ClassNotFoundException, SQLException{

	
		  String sql = null;
		  
			switch(input)
			{
				case "1":
					sql = "SELECT  * FROM MEMBER where MID LIKE '%" + query +"%'";
					break;
				case "2":
					sql = "SELECT  * FROM MEMBER where NAME LIKE '%" + query +"%'";
					break;
				case "3":
					sql = "SELECT  * FROM MEMBER where AGE LIKE '%" + query +"%'";
					break;
				default :
					System.out.println("1~3 사이의 정수를 입력해주세요");
			}	
		  
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	            
	      String url = "jdbc.data.entity:oracle:thin:@211.238.142.251:1521:orcl";
	      Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(sql);

	      
	      Member member = null;
	      List<Member> list = new ArrayList<>();
	      
	      
	      while(rs.next()){
	    	  member = new Member();
		      member.setMid(rs.getString("MID"));
		      member.setName(rs.getString("Name"));
		      member.setAge(rs.getInt("AGE"));
		      list.add(member);
	      }
	      rs.close();
	      st.close();
	      con.close();
	      
	      return list;
	}
} 
