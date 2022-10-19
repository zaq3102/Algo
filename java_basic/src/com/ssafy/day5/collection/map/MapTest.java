package com.ssafy.day5.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @since 2021. 7. 8.
 */
public class MapTest {
	// interface, 구현체 클래스
	
    Map<String, String> hMap = new HashMap<>();

    private void addMethod() {
        System.out.println("추가 성공?: " + hMap.put("andy", "1234"));
        // 동일한 키의 사용 결과는?
        System.out.println("추가 성공?: " + hMap.put("andy", "4567"));
        hMap.put("kate", "9999");
        // 기존에 해당 키에 대한 값이 없을 때만 추가하기
        hMap.putIfAbsent("kate", "1234");

        hMap.put("henry", "4567"); // 동일한 값
        
        // TODO: 친한 친구의 전화번호를 추가해보세요. 
        hMap.put("hong", "9999");
        
        // END:
        System.out.println("추가 결과: " + hMap);
    }

    private void retrieveMethod() {
        // TODO: kate의 전화번호가 있나요?
    	System.out.println(hMap.containsKey("kate"));
    	
        // END:

        // TODO: map이 가지고 있는 key와 거기에 연결된 value를 출력하시오.
    	Set<String> keys = hMap.keySet();
    	for(String key:keys) {
    		String val = hMap.get(key);
    		System.out.println(key + " : " + val);
    	}
    	
        // END:

        // TODO: 값이 4567인 사람의 이름은?
    	Set<Entry<String, String>> entrySet =  hMap.entrySet();
    	for(Entry<String, String> entry: entrySet) {
    		if(entry.getValue().equals("4567")) {
    			System.out.println("번호가 4567인 사람? : " + entry.getKey());
    		}
    	}
    	
        // END:
    }

    private void removeMethod() {
        // TODO: andy의 자료를 삭제하고 출력하시오.
    	hMap.remove("andy");
    	System.out.println("삭제 결과 : " + hMap);
        // END:
    }

    public static void main(String[] args) {
        MapTest hmt = new MapTest();
        hmt.addMethod();
        hmt.retrieveMethod();
        hmt.removeMethod();
    }
}
