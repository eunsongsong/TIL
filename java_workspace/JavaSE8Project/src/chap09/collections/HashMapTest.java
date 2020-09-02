package chap09.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		
		map.put(10, "�ڹ�");
		map.put(20, "��Ʋ��");
		map.put(10, "�ڹ�2");
		map.put(30, "����Ʈ");
		
		String val = map.get(10);
		System.out.println(val);
		
		Set<Integer> keySet = map.keySet();
		
		// key ������ �����ͼ� key�� value�� �����´�.
		for(Integer key: map.keySet()) {
			System.out.println(key + " = "+map.get(key));
		}
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		
		// entry ������ �����ͼ� key�� value�� ���ÿ� �����´�.
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
