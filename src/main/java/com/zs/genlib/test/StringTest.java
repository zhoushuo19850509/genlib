package com.zs.genlib.test;

public class StringTest {
    public static void main(String[] args) {
        String a = "9de19859de4e1e6b37d1d6f63d3a2d69&downloadname=10.3905/jai.2001.83";
        String b = a.substring(0,32);
        System.out.println(b);

        String aa = "http://31.42.184.140/main/2343000/28f6ca5f8fa9c5c68160d1e32e7d3a63/Dougherty%2C%20Dale_%20Robbins%2C%20Arnold%20-%20Sed%20and%20Awk-O%E2%80%99Reilly%20Media%20%28March%201997%29.pdf";
        int lastIndex = aa.lastIndexOf(".");
        System.out.println(lastIndex);

        // 后缀的长度
        int typelength = aa.length() - lastIndex - 1;
        System.out.println(typelength);

        String bb = aa.substring(aa.lastIndexOf(".") + 1,aa.length());
        System.out.println(bb);

    }
}
