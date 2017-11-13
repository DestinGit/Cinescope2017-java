/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.calculette;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author formation
 */
public class AdditionTest {
    
    public AdditionTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
        protected Addition operation;
   @Test
    public void testAdditionner() throws Exception {
        operation = new Addition();

        long a = 3;
        long b = 5;
        long r = a + b; // ou r = 8; // dans ce cas-ci
//Assert.assertTrue(String.valueOf(r), true);
        Assert.assertEquals(8, operation.additionner(a, b));

    } /// testAdditionner    
}
