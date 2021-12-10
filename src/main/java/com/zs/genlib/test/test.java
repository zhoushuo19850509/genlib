package com.zs.genlib.test;

import com.zs.genlib.utils.MD5Util;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File dir = new File("/Users/zhoushuo/Downloads/genlib");
        File[] files = dir.listFiles();
        for(File file: files){
            if(file.getName().contains(".pdf")){
//                System.out.println(file.getName());
                String md5 = MD5Util.getFileMD5(file.getAbsolutePath());
                System.out.println(md5);
            }
        }

    }
}
