import com.zs.genlib.model.FileInfo;
import com.zs.genlib.utils.DownloadUtil;
import com.zs.genlib.utils.FileInfoUtil;
import com.zs.genlib.utils.MD5Util;

import java.io.File;
import java.io.IOException;

/**
 * 下载线程1
 */
public class StartDownload {
    public static void main(String[] args)  throws IOException{
        downloadFiles();
    }

    public static void downloadFiles() throws IOException{

        String a =
//                "24e46c72bf3f16693029f38696dbffce\n" +
//                   "d594dd02580d53ff4ceb290e3aaeb38b";
//                "4368666006f10723bd072a043be01afd\n" +


                "d62ab774898efe5a0a8bc08eb53b7a7d\n" +
                        "a2f2bd8eb998e756d1be5d424c14b991\n" +
                        "2d97bc03b6aa2be35ebf968263154deb\n" +
                        "03888e87eee1f605bc38a88ae8eb8abf\n" +
                        "03888e87eee1f605bc38a88ae8eb8abf\n" +
                        "5499c1b9416bbd472c21375efb3358b8\n" +
                        "5499c1b9416bbd472c21375efb3358b8";
        String[] aa = a.split("\n");


        for(String md5 : aa){
            // 下载这个文件之前，先根据md5判断一下这个文件之前是否已经下载过了
            if(MD5Util.md5Exists(md5)){
                System.out.println(md5 + " has already download ...");
                continue;
            }
            System.out.println("start download file ,md5: " + md5);
            StartDownload.downloadSingleFile(md5);
        }


    }

    public static void downloadSingleFile(String md5) throws IOException{

        long start = System.currentTimeMillis();
        /**
         * 先根据MD5码，获取FileInfo信息，比如download url/file name
         */
        FileInfo fileInfo = FileInfoUtil.getFileInfoByPage(md5);

        String title = fileInfo.getTitle();
        String downloadUrl = fileInfo.getDownloadUrl();
        String fileDir = "/Users/zhoushuo/Downloads/genlib2/";  // 下载到本地的路径
        String fileType = fileInfo.getFileType();
        String fileName = title + "." + fileType; // 普通文件

        // dir+filename组装成完成的本地保存文件路径
        String filePath = fileDir + fileName;

        // 如果有文件名重复的情况(比如有些系列书籍，书名可能都是一样的)，文件名加入MD5，
        if(new File(filePath).exists()){
            fileName = title + "_" + md5 +".pdf";
            // 重新组装一下文件路径
            filePath = fileDir + fileName;
        }

        DownloadUtil.downloadFileByURL(filePath,downloadUrl);

        String downloadedFileMD5 = MD5Util.getFileMD5(filePath);
        if(downloadedFileMD5.equals(md5)){
            System.out.println("download succ: " + md5 + " " + title);
        }else{
            System.out.println("failed...  " + md5 + " " + title);
        }
        long end = System.currentTimeMillis();
        System.out.println("下载耗时： " + ( end - start ) + " ms");

        // 统计一下当前的下载流量
        long rate = FileInfoUtil.calcDownloadRate(filePath, (end - start));
        System.out.println("下载流量： " + rate + "  KB/s");


    }
}

