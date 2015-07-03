
package words;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordsTest {

    @Test
    public void testMain() {
        System.out.println("Test of main method");
        String[] args = null;
        Words.main(args);
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
    public void testUnion() {
        System.out.println("Test of union method");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map1.put("aaa", 2);
        map1.put("bbb", 3);
        map2.put("ccc", 1);
        map2.put("aaa", 4);
        Words.union(map1, map2);
    }    
}
