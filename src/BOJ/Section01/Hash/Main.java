package BOJ.Section01.Hash;

import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // HashSet 선언
        HashSet<Integer> setTest = new HashSet<>();

        // 데이터 삽입
        setTest.add(10);
        setTest.add(20);
        setTest.add(30);
        setTest.add(40);
        setTest.add(50);

        // 중복을 허용하지 않음
        setTest.add(10);
        setTest.add(20);
        setTest.add(30);

        // remove Element
        setTest.remove(40);

        // Element 존재 확인
        System.out.println(setTest.contains(10)); // true

        // isEmpty()
        System.out.println(setTest.isEmpty()); // false

        // size()
        System.out.println(setTest.size()); // 4

        // get iterator()
        Iterator setIter = setTest.iterator();
        while (setIter.hasNext()) {
            System.out.println(setIter.next());
        }

        // Removes all of the elements from this set.
        setTest.clear();

    }
}
