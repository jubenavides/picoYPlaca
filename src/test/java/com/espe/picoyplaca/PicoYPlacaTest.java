/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.picoyplaca;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alter
 */
public class PicoYPlacaTest {

    public PicoYPlacaTest() {
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
     * Test of testVerifyPicoYplacaCaseDayCanRoad method, of class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCaseDayCanRoad() {
        System.out.println("testVerifyPicoYplacaCaseDayCanRoad");
        String plateNumber = "ABC-1234";
        String date = "2019/05/09";
        String time = "08:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = true;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of testVerifyPicoYplacaCaseDayAndHourCanNotRoad method, of class
     * PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCaseDayAndHourCanNotRoad() {
        System.out.println("testVerifyPicoYplacaCaseDayAndHourCanNotRoad");
        String plateNumber = "ABC-1234";
        String date = "2019/05/07";
        String time = "08:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = false;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of testVerifyPicoYplacaCaseDayCanNotRoadAndHourCanRoad method, of
     * class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCaseDayCanNotRoadAndHourCanRoad() {
        System.out.println("testVerifyPicoYplacaCaseDayCanNotRoadAndHourCanRoad");
        String plateNumber = "ABC-1234";
        String date = "2019/05/07";
        String time = "13:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = true;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of testVerifyPicoYplacaCasePlateNull method, of class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCasePlateNull() {
        System.out.println("testVerifyPicoYplacaCasePlateNull");
        String plateNumber = null;
        String date = "2019/05/07";
        String time = "13:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = false;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of testVerifyPicoYplacaCaseDateNull method, of class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCaseDateNull() {
        System.out.println("testVerifyPicoYplacaCaseDateNull");
        String plateNumber = "ABC-1234";
        String date = null;
        String time = "13:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = false;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of testVerifyPicoYplacaCaseTimeNull method, of class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCaseTimeNull() {
        System.out.println("testVerifyPicoYplacaCaseTimeNull");
        String plateNumber = "ABC-1234";
        String date = "2019/05/07";
        String time = null;
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = false;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of testVerifyPicoYplacaCasePlateLength method, of class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCasePlateLength() {
        System.out.println("testVerifyPicoYplacaCasePlateLength");
        String plateNumber = "ABC-12345";
        String date = "2019/05/07";
        String time = "13:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = false;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of testVerifyPicoYplacaCaseDateFormat method, of class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCaseDateFormat() {
        System.out.println("testVerifyPicoYplacaCaseDateFormat");
        String plateNumber = "ABC-1234";
        String date = "05/07/2019";
        String time = "13:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = false;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of testVerifyPicoYplacaCaseBadDate method, of class PicoYPlaca.
     */
    @Test
    public void testVerifyPicoYplacaCaseBadDate() {
        System.out.println("testVerifyPicoYplacaCaseBadDate");
        String plateNumber = "ABC-1234";
        String date = "2019/15/12";
        String time = "13:00";
        PicoYPlaca instance = new PicoYPlaca();
        Boolean expResult = false;
        Boolean result = instance.verifyPicoYplaca(plateNumber, date, time);
        assertEquals(expResult, result);
    }

}
