package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("Frist Assertion");
        Assert.assertEquals(123456,123456);

        System.out.println("Second Assertion");
        Assert.assertEquals("title","title");
    }
    @Test
    public void test2(){
       String actualTitle="Cybertek";
       String expecTitle="C";
        System.out.println("first assertion");
       Assert.assertTrue(actualTitle.startsWith(expecTitle),"Veryfiy title starts with C");

        String actualEmail="mail@gmail.com";
        String expectedEmail="mail1@gmail.com";
        Assert.assertTrue(actualEmail.contains("@"),"verify @ in the email");
    }
    @Test
    public void test3(){
        Assert.assertNotEquals("one","one","one shouldnt equal to two");
    }
    @Test
    public void test4(){
        Assert.assertFalse(1<0);
    }
}
