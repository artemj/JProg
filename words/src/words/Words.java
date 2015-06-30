package words;

import java.util.*;

public class Words {

    public static void main(String[] args) {
        String str = "mam dad father mam father mam";
        String strArr[] = str.split(" ");
        Set<String> set = new HashSet<>();
        int count = 0;        
        for (int i=0;i<strArr.length;i++){ 
            set.add(strArr[i]);
        }
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            String elemSet = iter.next().toString();
            for (int i=0; i<strArr.length;i++){
                if (elemSet.equals(strArr[i])){
                    count++;
                }
            }
            System.out.println(elemSet+" = "+count);
            count=0;
        }
    }  
}
