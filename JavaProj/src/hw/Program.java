package hw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hw.dao.MemberDao;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("[ȸ�� �˻� ���α׷�]");
		System.out.print("�̸� �з� ���̵�(1) �̸�(2) ����(3) : ");
	
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		System.out.print("�˻��� �Է�");	
		String query = scan.nextLine();

		
		scan.close();

		MemberDao memberDao = new MemberDao();
		List<Member> list = new ArrayList<>();
		
		list = memberDao.getList(input, query);
		
		System.out.println("���̵�                      �̸�                      ����");
		System.out.println("----------------------------------------------");

		for(Member m : list)
		{
			System.out.format("%-25s%-25s%5d\n", m.getMid(), m.getName(), m.getAge());
			
		}
	}

}
