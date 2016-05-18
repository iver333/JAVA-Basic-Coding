package net.zwb1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortMap {

	
	//��hashmap�������򣬿������ڶ��ı��еĵ���Ƶ�ʽ���ͳ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("love", 15);
		map.put("dota2", 45);
		map.put("jekyll", 5);
		map.put("lol", 41);
		map.put("gn", 34);
		List<Map.Entry<String, Integer>> mappingList = null;
		// ͨ��ArrayList���캯����map.entrySet()ת����list
		mappingList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(mappingList,
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Map.Entry<String, Integer> mapping1,
							Map.Entry<String, Integer> mapping2) {
						return mapping1.getValue().compareTo(
								mapping2.getValue());
					}
				});
		for (Map.Entry<String, Integer> mapping : mappingList) {
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
		}
	}

}
