package jdbc.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.data.dao.MemberDao;
import jdbc.data.entity.Member;

public class MySQLMemberDao implements MemberDao {

	@Override
	public List<Member> getList(String query){

		  String sql = "SELECT  *  From MEMBER WHERE ID LIKE'%"+query+"%' ORDER BY ID DESC";
		  
		  List<Member> list = new ArrayList<>();
		  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			Member member = null;
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getString("ID"));
				member.setPhone(rs.getString("PHONE"));
				member.setName(rs.getString("NAME"));
				member.setPwd(rs.getString("PWD"));
				member.setGender(rs.getString("GENDER"));
				member.setBirthday(rs.getString("BIRTHDAY"));
				member.setRegDate(rs.getDate("REG_DATE"));
				
				list.add(member);
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      return list;
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String mid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Member member) {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public int add(Member member) {
		  String sql = "INSERT INTO MEMBER(MID,PWD,PHONE,NAME,GENDER,AGE, MAJOR, BIRTHDAY,REGDATE) VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getMid());
			st.setString(2, member.getPwd());
			st.setString(3, member.getPhone());
			st.setString(4, member.getName());
			st.setString(5, member.getGender());
			st.setInt(6, member.getAge());
			st.setString(7, member.getMajor());
			st.setString(8, member.getBirthday());
			
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      return 0;
	}
*/



}
