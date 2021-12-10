package com.zs.genlib.utils;

import com.zs.genlib.model.FileInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 这个Util类主要是用于根据md5获取FileInfo各种信息
 */
public class FileInfoUtil {


    /**
     * 根据MD5码访问genlib网站的下载页面，目前页面URL为：
     * http://library.lol/main/e656088814c03c304a33f83a594110b9
     * 并且通过解析这页面获取FileInfo各个信息
     *
     * 备注：这个页面的地址、格式会一直变化，需要特别注意
     * @param MD5
     * @return
     * @throws IOException
     */
    public static FileInfo getFileInfoByPage(String MD5) throws IOException {

        FileInfo fileInfo = new FileInfo(MD5);

        // 先根据MD5码找到下载页
        String baseUrl = "http://library.lol/main/";
        String url = baseUrl + MD5;

        /**
         * 然后根据下载页，找到下载链接，比如：
         * <h2><a href="http://31.42.184.140/main/2273000/17c37fbd9796a26a7c97c269f89ec149/%28%E6%9D%8E%E8%B4%BD%E5%85%A8%E9%9B%86%E6%B3%A8%29%20%E6%9D%8E%E8%B4%BD%20-%20%E6%9D%8E%E8%B4%BD%E5%85%A8%E9%9B%86%E6%B3%A8%EF%BC%8812%EF%BC%89%EF%BC%9A%E5%88%9D%E6%BD%AD%E9%9B%86%E6%B3%A8%EF%BC%88%E4%B8%80%EF%BC%89-%E7%A4%BE%E4%BC%9A%E7%A7%91%E5%AD%A6%E6%96%87%E7%8C%AE%E5%87%BA%E7%89%88%E7%A4%BE%20%282010%29.pdf">GET</a></h2>
         *
         * 这个下载链接是genlib自动生成的
         */

        int timeout = 5000;
        Document document = Jsoup.connect(url).timeout(timeout).get();
        // 先尝试找下载链接
        // 方法是：找出包含<a href="" ... /a>的element
        // 这个element包含了下载链接，但是下载链接有多个
        Elements elements = document.select("a[href]");

        for(Element element: elements){
            // 找出下载连接(href="...")
            String attr = element.attr("href");
            // 找出<a href="...">GET</a>的那个链接，那个链接一般是最可靠的
            String text = element.text();
            if(text.trim().equals("GET")){
                System.out.println(attr);
                fileInfo.setDownloadUrl(attr);

                String fileType = getFileType(attr);
                fileInfo.setFileType(fileType);

            }
        }

        // 再尝试找书名 <h1>秘密会议</h1>
        Elements elementsBookName = document.select("h1");
        if(null != elementsBookName && elementsBookName.size() >0){
            String bookName = elementsBookName.get(0).text();
            System.out.println("电子书的文件名为： " + bookName);
            // 如果书名包含"/"，会影响后续的下载(本地文件名称不能带有"/")，必须优化
            bookName = bookName.replace("/","_");
            fileInfo.setTitle(bookName);
        }

        return fileInfo;

    }

    /**
     * TODO
     * 访问genlib提供的API，根据MD5获取文件信息
     * 这个效率比解析页面要高很多
     * @param MD5
     * @return
     * @throws IOException
     */
    public static FileInfo getFileInfoByAPI(String MD5) throws IOException {
        return null;
    }

    /**
     * 根据文件下载路径，获取文件类型
     * @param downloadUrl
     * @return
     */
    public static String getFileType(String downloadUrl){


        // "."的位置 如果没有"." 这个值就是-1
        int lastIndex = downloadUrl.lastIndexOf(".");

        // 后缀的长度
        int typelength = downloadUrl.length() - lastIndex - 1;

        String type = "others";
        if(lastIndex > 0 && typelength > 0 && typelength < 10){
            type = downloadUrl.substring(lastIndex + 1, downloadUrl.length());
        }
        System.out.println(type);

        return type;
    }


    /**
     * 统计下载流量
     * @param filePath
     * @param downloadElapse
     * @return XX KB/s
     */
    public static long calcDownloadRate(String filePath , long downloadElapse){

        File file = new File(filePath);
        if(!file.exists()){
            return 0;
        }

        if(downloadElapse == 0){
            return 0;
        }

        long fileSize = file.length();
        return fileSize  / downloadElapse;
    }

    public static void main(String[] args) throws IOException {
        String MD5 = "f9d7691737352f4be37fd46060a3669a";
        FileInfo fileInfo = FileInfoUtil.getFileInfoByPage(MD5);
        System.out.println("download url:  " + fileInfo.getDownloadUrl());
        System.out.println("file title:  " + fileInfo.getTitle());
        System.out.println("file type: " + fileInfo.getFileType());

        String filePath = "/Users/zhoushuo/Downloads/genlib2/Cloud Without Compromise: Hybrid Cloud for the Enterprise.pdf";
        long downloadRate = FileInfoUtil.calcDownloadRate(filePath,10);
        System.out.println(downloadRate + " KB/s");

    }
}
