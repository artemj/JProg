package new_energo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;

public class TestMeterReading {
    
    @Test
    public void TestMeterReading() throws ParseException {
        DateFormat format;
        format = new SimpleDateFormat("dd-MM-yy");
        int a = 10, b = 1;
        Date c = format.parse("23-10-14");       
        ArrayList<Fields> listElements = new ArrayList<>();
        Fields elem = new Fields(a,c,b);
        listElements.add(elem);
        assertNotNull(Energo.meterReading(listElements));
    }    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.run(TestMeterReading.class);
    }
}
