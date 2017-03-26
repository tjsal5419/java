package hw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hw.dao.MemberDao;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("[회원 검색 프로그램]");
		System.out.print("이름 분류 아이디(1) 이름(2) 나이(3) : ");
	
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		System.out.print("검색어 입력");	
		String query = scan.nextLine();

		
		scan.close();

		MemberDao memberDao = new MemberDao();
		List<Member> list = new ArrayList<>();
		
		list = memberDao.getList(input, query);
		
		System.out.println("아이디                      이름                      나이");
		System.out.println("----------------------------------------------");

		for(Member m : list)
		{
			System.out.format("%-25s%-25s%5d\n", m.getMid(), m.getName(), m.getAge());
			
		}
	}

}
