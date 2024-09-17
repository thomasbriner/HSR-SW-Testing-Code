package ch.hsr.testing.unittest.whitebox;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/integer-to-roman/solutions/3135854/java-solution-using-linkedhashmap-11ms-with-comments/
// Java Program to convert decimal number to
// roman numerals

public class RomanNumberConverterForWhiteboxTesting {

    public static String convertToRoman(int num) {
        Map<Integer, String> hp = new LinkedHashMap();
        hp.put(1, "I");
        hp.put(4, "IV");
        hp.put(5, "V");
        hp.put(9, "IX");
        hp.put(10, "X");
        hp.put(40, "XL");
        hp.put(50, "L");
        hp.put(90, "XC");
        hp.put(100, "C");
        hp.put(400, "CD");
        hp.put(500, "D");
        hp.put(900, "CM");
        hp.put(1000, "M");
        if (hp.containsKey(num)) return hp.get(num); //if num is directly from map
        List<Integer> al = new ArrayList(); //used to traverse hashmap from end.
        for (int key : hp.keySet()) {
            al.add(key);
        }
        String res = "";
        for (int i = al.size() - 1; i >= 0 && num > 0; i--) {
            int temp = 0;
            if (num > al.get(i)) {
                temp = num / al.get(i);
                //System.out.println(num + " "+ temp);
                num = num % al.get(i);
                res += hp.get(al.get(i)).repeat(temp);
                if (hp.containsKey(num)) {
                    res += hp.get(num);
                    num = 0;
                }
            }
        }
        return res;
    }
}


