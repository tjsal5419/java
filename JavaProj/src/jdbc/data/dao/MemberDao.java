package jdbc.data.dao;

import java.util.List;

import jdbc.data.entity.Member;
 // 재사용 , 컨트롤러와 뷰의 종속 제거 , 협업에 유리
public interface MemberDao {
	List<Member> getList();
	int add(Member member);
	void delete(String mid);
	void modify(Member member);
	List<Member> getList(String query);
} 
