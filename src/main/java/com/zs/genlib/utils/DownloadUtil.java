package com.zs.genlib.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件下载相关
 */
public class DownloadUtil {
    public static void main(String[] args){

        String filePath = "/Users/zhoushuo/Downloads/genlib/生物绘图法1.pdf";

        String downloadUrl = "http://31.42.184.140/main/3115000/746e9b8a13694ec8cbc24db0f76f0cc4/%E5%86%AF%E6%BE%84%E5%A6%82%20-%20%E7%94%9F%E7%89%A9%E7%BB%98%E5%9B%BE%E6%B3%95-%E7%A7%91%E5%AD%A6%E5%87%BA%E7%89%88%E7%A4%BE%20%281959%29.pdf";

        DownloadUtil.downloadFileByURL(filePath,downloadUrl);

    }

    /**
     * download file by url
     * @param filePath 文件本地保存路径
     * @param downloadUrl 下载链接
     */
    public static void downloadFileByURL(String filePath, String downloadUrl){

        CloseableHttpClient client = null;
        HttpGet httpGet = new HttpGet(downloadUrl);
        HttpResponse response = null;

        InputStream is = null;
        FileOutputStream fos = null;

        try{

            client = HttpClients.createDefault();
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            File file = new File(filePath);
            fos = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int ch = 0;
            while( (ch = is.read(buffer)) != -1){
                fos.write(buffer,0, ch );
            }
            System.out.println("finish download file...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
