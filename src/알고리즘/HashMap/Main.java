package 알고리즘.HashMap;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // HashMap 선언
        HashMap<Integer, String> mapTest = new HashMap<>();

        // 데이터 삽입
        mapTest.put(1, "Java");
        mapTest.put(2, "C++");
        mapTest.put(3, "python");
        mapTest.put(4, "JavaScript");

        // Key 삭제
        mapTest.remove(4);

        // Key 존재 확인
        System.out.println(mapTest.containsKey(4)); // false

        // Value 존재 확인
        System.out.println(mapTest.containsValue("Java")); // true

        // Key의 Value 확인
        System.out.println(mapTest.get(1)); // Java

        // isEmpty()
        System.out.println(mapTest.isEmpty()); // false

        // check HashMap size
        System.out.println(mapTest.size()); // 3

        // HashMap toString
        System.out.println(mapTest.toString()); // {1=Java, 2=C++, 3=python}

        // Return a Collection view of the values contained in this map
        System.out.println(mapTest.values()); // [Java, C++, python]

        // 데이터 출력
        // keySet : a set view of the keys contained in this map
        Iterator<Integer> keys = mapTest.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            String value = mapTest.get(key);

            System.out.println(key + " " + value);
        }

        // HashMap removes all of the mappings from this map
        mapTest.clear();

    }

}
