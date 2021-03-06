package chap09.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		
		map.put(10, "자바");
		map.put(20, "코틀린");
		map.put(10, "자바2");
		map.put(30, "리엑트");
		
		String val = map.get(10);
		System.out.println(val);
		
		Set<Integer> keySet = map.keySet();
		
		// key 집합을 가져와서 key로 value를 가져온다.
		for(Integer key: map.keySet()) {
			System.out.println(key + " = "+map.get(key));
		}
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		
		// entry 집합을 가져와서 key와 value을 동시에 가져온다.
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
