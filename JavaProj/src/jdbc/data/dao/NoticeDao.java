package jdbc.data.dao;

import java.util.List;

import jdbc.data.view.NoticeView;

public interface NoticeDao {
	List<NoticeView> getList();
	List<NoticeView> getList(int page, String field, String query);
	List<NoticeView> getList(int page);

}
