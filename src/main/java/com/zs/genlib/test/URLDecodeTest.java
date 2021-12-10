package com.zs.genlib.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "%28%E5%8C%BA%E5%9D%97%E9%93%BE%E6%8A%80%E6%9C%AF%E4%B8%9B%E4%B9%A6%29%20%E7%BA%B3%E6%8B%89%E6%89%AC%C2%B7%E6%99%AE%E9%B2%81%E6%96%AF%E8%92%82%20-%20%E5%8C%BA%E5%9D%97%E9%93%BE%E9%A1%B9%E7%9B%AE%E5%BC%80%E5%8F%91%E6%8C%87%E5%8D%97-%E6%9C%BA%E6%A2%B0%E5%B7%A5%E4%B8%9A%E5%87%BA%E7%89%88%E7%A4%BE%20%282017%29.pdf";


        String a = URLDecoder.decode(url,"UTF-8");
        System.out.println(a);

        String b = URLEncoder.encode(a);
        System.out.println(b);


        String url1 = "http://176.123.10.47/index.php?req=Oxford+University+Press&columns%5B%5D=t&columns%5B%5D=a&columns%5B%5D=s&columns%5B%5D=y&columns%5B%5D=p&columns%5B%5D=i&objects%5B%5D=f&objects%5B%5D=e&objects%5B%5D=s&objects%5B%5D=a&objects%5B%5D=p&objects%5B%5D=w&topics%5B%5D=l&topics%5B%5D=c&topics%5B%5D=f&topics%5B%5D=a&topics%5B%5D=m&topics%5B%5D=r&topics%5B%5D=s&res=100&curtab=f&order=&ordermode=desc&page=";
        String c = URLDecoder.decode(url1,"UTF-8");
        System.out.println("C:" +c);

        String url2 = "http://31.42.184.140/main/2273000/17c37fbd9796a26a7c97c269f89ec149/%28%E6%9D%8E%E8%B4%BD%E5%85%A8%E9%9B%86%E6%B3%A8%29%20%E6%9D%8E%E8%B4%BD%20-%20%E6%9D%8E%E8%B4%BD%E5%85%A8%E9%9B%86%E6%B3%A8%EF%BC%8812%EF%BC%89%EF%BC%9A%E5%88%9D%E6%BD%AD%E9%9B%86%E6%B3%A8%EF%BC%88%E4%B8%80%EF%BC%89-%E7%A4%BE%E4%BC%9A%E7%A7%91%E5%AD%A6%E6%96%87%E7%8C%AE%E5%87%BA%E7%89%88%E7%A4%BE%20%282010%29.pdf";
        String d = URLDecoder.decode(url2,"UTF-8");
        System.out.println(d);


    }
}
