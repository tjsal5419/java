package jdbc.data.dao;

import java.util.List;

import jdbc.data.entity.Member;
 // ���� , ��Ʈ�ѷ��� ���� ���� ���� , ������ ����
public interface MemberDao {
	List<Member> getList();
	int add(Member member);
	void delete(String mid);
	void modify(Member member);
	List<Member> getList(String query);
} 
