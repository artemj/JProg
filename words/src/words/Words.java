package words;

import java.util.*;

public class Words {

    public static void main(String[] args) {
        Map<String, Integer> res1 = map(str1);
        Map<String, Integer> res2 = map(str2);
        union(res1,res2);
    }
    
    private static final String str1 = "mam dad father mam father mam mam dad sis father mam father mam";
    private static final String str2 = "mam dad father mam bob dad";
    
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
    
    private static Map<String, Integer> map1;
    private static Map<String, Integer> map2;
    
    public static void union(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, String> mapRes = new HashMap<>();
        int count1;
        int count2;
        for (Map.Entry<String, Integer> pair1 : map1.entrySet()) {
            String str1 = pair1.getKey();
            for (Map.Entry<String, Integer> pair2 : map2.entrySet()) {
                String str2 = pair2.getKey();
                if(str1.equals(str2)){
                    count1 = map1.get(str1);
                    count2 = map2.get(str2);
                    mapRes.put(str1," "+count1+","+count2);
                }                
            }                      
        }
        System.out.println(mapRes);
    }

    @Override
    public String toString() {
        return "Words{" + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    
    
}
