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
		// 컬렉션 3가지
		
		//1. set 형 컬렉션 2. List 형 컬렉션 3. Map 형 컬렉션 ( 수집 방식에 따라 달라진다.)
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
		
		
		for(Object o : s) // for each는 컬렉션에서만 사용 가능. Iterator함수를 가져야 사용 가능.
			System.out.println(o);
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);

		
		for(Object o : list)
			System.out.printf("리스트 : %d\n",o);
		
		Map map = new HashMap();
		map.put("가", 1);
		map.put("나", 2);
		map.put("다", 3);
		map.put("라", 4);
		map.put("마", 5);
		map.put("바", 5);
				
		System.out.println(map.get("가"));
		
		for(Object o : map.keySet())
			System.out.printf("맵 : %d\n", map.get(o));
		
	}

}
