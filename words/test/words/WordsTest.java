
package words;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import static words.Words.intersectWord;

public class WordsTest {
    
    @Test
    public  void main() {
        intersectWord(str1,str2);
    }   


    @Test
    public void testMap() {
        System.out.println("Test of map method");
        String str = "one";
        Map<String, Integer> expResult = new HashMap<>();
        int test = 1;
        expResult.put("one", test);
        Map<String, Integer> result = Words.map(str);
        assertEquals(expResult, result);
    }

    @Test
    public void testIntersect() {
        System.out.println("Test of intersect method");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map1.put("aaa", 2);
        map1.put("bbb", 3);
        map2.put("ccc", 1);
        map2.put("aaa", 4);
        Map<String, String> expResult = new HashMap<>();
        expResult.put("aaa", "2,4");
        assertEquals(expResult, Words.intersect(map1, map2));
    }    
    
    @Test
    public void testIntersectWord() {
        System.out.println("Test of intersectWord method");
        String str1 = "aaa aaa bbb ccc";
        String str2 = "bbb bbb ccc fff";
        Words.intersectWord(str1, str2);
    }
    
    public static final String str1 = "mam dad father mam father mam mam dad sis father mam father mam";
    public static final String str2 = "mam dad father mam bob dad";   

}


