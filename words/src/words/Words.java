package words;

import java.util.*;

public class Words {  

    public static Map<String, Integer> map(String str){
        String strArr[] = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        int count;
        for(int i=0; i<strArr.length;i++){
            if (map.containsKey(strArr[i])){
                count = map.get(strArr[i])+1;                
            } else {
                count = 1;
            }
            map.put(strArr[i], count);
        }
        System.out.println (map);
        return map;
    }
    
    public static Map<String, String> intersect(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, String> mapRes = new HashMap<>();
        int count1;
        int count2;
        for (Map.Entry<String, Integer> pair1 : map1.entrySet()) {
            if (map2.containsKey(pair1.getKey())){
                count1 = map1.get(pair1.getKey());
                count2 = map2.get(pair1.getKey());
                mapRes.put(pair1.getKey(),count1+","+count2);                                
            }          
        }
        System.out.println(mapRes);
        return mapRes;
    }  
    
    public static void intersectWord (String str1, String str2){
        Map<String, Integer> res1 = map(str1);
        Map<String, Integer> res2 = map(str2);
        intersect(res1,res2);
    }
}
