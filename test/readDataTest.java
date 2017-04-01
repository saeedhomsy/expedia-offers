/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DevPC
 */
public class readDataTest {
    
    public readDataTest() {
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
     * Test of readJsonFromUrl method, of class readData.
     */
    @Test
    public void testReadJsonFromUrl() throws Exception {
        System.out.println("readJsonFromUrl");
        String url = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
        JSONObject expResult = null;
        JSONObject result = readData.readJsonFromUrl(url);
        assertNotEquals(expResult, result);
    }
    
}
