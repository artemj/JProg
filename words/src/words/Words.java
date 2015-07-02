package words;

import java.util.*;

public class Words {

    public static void main(String[] args) {
        String str = "mam dad father mam father mam mam dad sis father mam father mam"; //dad=2, father=4, mam=6, sis=1
        String strArr[] = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        int count;
        for(int i=0; i<strArr.length;i++){
            if (map.containsKey(strArr[i])){
                count = map.get(strArr[i])+1;                
                map.put(strArr[i], count);
            } else {
                count = 1;
                map.put(strArr[i], count);
            }
        }
        System.out.println (map);
    }  
}
