package collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		// �÷��� 3����
		
		//1. set �� �÷��� 2. List �� �÷��� 3. Map �� �÷��� ( ���� ��Ŀ� ���� �޶�����.)
		Set s = new HashSet();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(1);
		s.add(2);		
		
		Iterator it = s.iterator();
		
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		
		
		for(Object o : s) // for each�� �÷��ǿ����� ��� ����. Iterator�Լ��� ������ ��� ����.
			System.out.println(o);
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);

		
		for(Object o : list)
			System.out.printf("����Ʈ : %d\n",o);
		
		Map map = new HashMap();
		map.put("��", 1);
		map.put("��", 2);
		map.put("��", 3);
		map.put("��", 4);
		map.put("��", 5);
		map.put("��", 5);
				
		System.out.println(map.get("��"));
		
		for(Object o : map.keySet())
			System.out.printf("�� : %d\n", map.get(o));
		
	}

}
