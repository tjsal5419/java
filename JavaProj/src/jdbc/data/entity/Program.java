package jdbc.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdbc.dao.mysql.MySQLMemberDao;
import jdbc.data.dao.MemberDao;

public class Program {

	public static void main(String[] args){
		System.out.println("�˻��� ID�� �Է����ּ���");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		
		MemberDao member = new MySQLMemberDao();
		List<Member> list = new ArrayList<>(); 
		list = member.getList(id);
		
		System.out.println("���");
		for(Member m : list)
			System.out.printf("%s		%s	%s	%s	%s	%s	\n", m.getId(), m.getName(), m.getPhone(), m.getGender(),m.getBirthday(),m.getRegDate());


		
/*		System.out.println("����������������������������������������������������������������");
		System.out.println("��                      ��         ��       ��          ��                                  ��");
		System.out.println("����������������������������������������������������������������");
		
		boolean exit = true;
		Scanner scan = new Scanner(System.in);
		
		do{
		System.out.println("1. ȸ�� ����");
		System.out.println("2. �Խñ� ����");
		System.out.println("3. ����");
		System.out.print(" > ");
		String menu = scan.nextLine();
		switch(menu){
		case "1":
			manage();
			break;
		case "2":
			System.out.println("�Խñ� ����");
			break;
		case "3":
			exit = false;
			break;
		default:
			System.out.println("1, 2, 3 �߿��� �Է����ּ���.");
		}
		}while(exit);
	      
	}


	public static void manage(){
		Scanner scan = new Scanner(System.in);
		System.out.println("����������������������������������������������������������������");
		System.out.println("��              ȸ         ��              ��               ��                              ��");
		System.out.println("����������������������������������������������������������������");

		MemberDao memberDao = new OracleMemberDao();
		List<Member> list = new ArrayList<>();
		list = memberDao.getList();
		boolean repeat = true;
		
		System.out.println("���̵�	�̸�	��ȭ��ȣ	����	����	����	����	��������");
		for(Member m : list)
			System.out.printf("%s		%s	%s	%s	%s	%s	%s	%s	\n", m.getMid(), m.getName(), m.getPhone(), m.getGender(),m.getAge(),m.getMajor(),m.getBirthday(),m.getRegDate());

		
		do{
		System.out.println("����������������������������������������������������");
		System.out.println("1.�߰� 2.���� 3. ���� 4. �����޴�");
		System.out.printf(" �޴� >");
		String menu = scan.nextLine();
		
		switch(menu){
			case "1":
				input();
				break;		
				
			case "2" :
				modify();
				break;		
	 		case "3" :
	 			delete();
				break;					
			case "4" :
				repeat = false;
				break;					
			default :
				System.out.println("1~4 ������ ���ڸ� �Է����ּ���.");
		}
		}while(repeat);
	}

	public static void input(){
		Scanner scan = new Scanner(System.in);

		System.out.println("����������������������������������������������������������������");
		System.out.println("��                      ȸ         ��       ��          ��                                  ��");
		System.out.println("����������������������������������������������������������������");

		System.out.println("�߰��� ȸ�� ������ �Է��ϼ���.");
		Member member = new Member();
		boolean input = true;
		
		do{
		System.out.print("���̵� :");
		String mid = scan.nextLine();
		member.setMid(mid);

		System.out.print("�̸� :");
		String name = scan.nextLine();
		member.setName(name);

		System.out.print("��ȭ��ȣ :");
		String phone = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("��й�ȣ :");
		String pwd = scan.nextLine();
		member.setPwd(pwd);

		System.out.print("���� :");
		String gender = scan.nextLine();
		member.setGender(gender);

		System.out.print("���� :");
		int age = Integer.parseInt(scan.nextLine());
		member.setAge(age);
		
		System.out.print("���� :");
		String major = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("���� : ");
		String birthday = scan.nextLine();
		member.setBirthday(birthday);
		
		MemberDao memberDao = new OracleMemberDao();
		memberDao.add(member);
		
		System.out.println("��� �Է��Ͻðڽ��ϱ�? [y/n]");
		
		if(scan.nextLine().equals("n")){
			input = false;
			break;
		}
		}while(input);
	}
	public static void delete() {
		
		boolean repeat = true;
		do{
		System.out.println("����� ���� ID�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		String mid = scan.nextLine();
		MemberDao memberDao = new OracleMemberDao();
		
		memberDao.delete(mid);
		
		System.out.println("�߰��� �� ����ðڽ��ϱ�? [y/n]");
		
		if(scan.nextLine().equals("n")){
			repeat = false;
			break;
		}
		
		}while(repeat);
	}
	
	
	
	public static void modify() {
		
		boolean repeat = true;
		do{
			
		Member member = new Member();
	
		System.out.println("������ ID�� �Է����ּ���.");
		Scanner scan = new Scanner(System.in);
		String mid = scan.nextLine();
		member.setMid(mid);
		
		System.out.println("���� ������ ���� ������ �Է����ּ���.");

		System.out.print("�̸� :");
		String name = scan.nextLine();
		member.setName(name);

		System.out.print("��ȭ��ȣ :");
		String phone = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("��й�ȣ :");
		String pwd = scan.nextLine();
		member.setPwd(pwd);

		System.out.print("���� :");
		String gender = scan.nextLine();
		member.setGender(gender);

		System.out.print("���� :");
		int age = Integer.parseInt(scan.nextLine());
		member.setAge(age);
		
		System.out.print("���� :");
		String major = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("���� : ");
		String birthday = scan.nextLine();
		member.setBirthday(birthday);
		
		MemberDao memberDao = new OracleMemberDao();
		
		memberDao.modify(member);
		
		System.out.println("�߰��� �� �����Ͻðڽ��ϱ�? [y/n]");
		
		if(scan.nextLine().equals("n")){
			repeat = false;
			break;
		}
		
		}while(repeat);
*/		
	}

}
