package com.zs.genlib.test;

public class ReplaceTest {
    public static void main(String[] args) {
        String a = "Gel'fond-Baker方法在丢番图方程中的应用/现代数学基础丛书";
        System.out.println(a);
        a = a.replace("/","_");
        System.out.println(a);
    }
}
