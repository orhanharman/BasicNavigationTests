package com.cbt.utilities;

public class StringUtility {

    public void verifyEquals(String expected, String actual){

        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result: " + actual);
        }

    }

}
