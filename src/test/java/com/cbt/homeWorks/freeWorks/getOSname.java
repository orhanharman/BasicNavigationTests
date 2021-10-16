package com.cbt.homeWorks.freeWorks;

import org.apache.commons.lang3.SystemUtils;
import org.testng.annotations.Test;

public class getOSname {

    @Test
    public void getOSname(){
        System.out.println(SystemUtils.OS_NAME);
        System.out.println(System.getProperty("os.name"));
    }

}
