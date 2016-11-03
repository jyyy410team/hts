package com.jeecms.aoptest;

/**
 * 
 * [一句话功能简述] [功能详细描述] action
 * 
 * @作者 Administrator
 * @version [版本号, 2016-9-9]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestBean
{
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
    
    public void test() {
        System.out.println("this is test");
    }
}
