/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Artem
 */
public class EnergoTest {
    
    public EnergoTest() {
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

    /**
     * Test of main method, of class Energo.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("testing for method main");
        String[] args = null;
        Energo.main(args);
    }

    /**
     * Test of readFile method, of class Energo.
     */
//    @Test
//    public void testReadFile() throws Exception {
//        System.out.println("readFile");
//        String fileName = "";
//        ArrayList<Fields> expResult = null;
//        ArrayList<Fields> result = Energo.readFile(fileName);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of meterReading method, of class Energo.
     */
    @Test
    public void testMeterReading() throws ParseException {
        System.out.println("testing for method meterReading");
        DateFormat format;
        format = new SimpleDateFormat("dd-MM-yy");
        int a = 1, c = 3;
        Date b = format.parse("23-10-14");       
        ArrayList<Fields> listElements = new ArrayList<>();
        Fields elem = new Fields(a,b,c);
        listElements.add(elem);
        ArrayList<Integer> expResult = new ArrayList<>();
        ArrayList<Integer> result = Energo.meterReading(listElements);
        expResult.add(4);
        assertEquals(expResult, result);
    }

    /**
     * Test of plot method, of class Energo.
     */
    @Test
    public void testPlot() {
        System.out.println("testing for method plot");
        ArrayList<Integer> resList = new ArrayList<>();
        resList.add(5);
        Energo.plot(resList);
    }
    
}
