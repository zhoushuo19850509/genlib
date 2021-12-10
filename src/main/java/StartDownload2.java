import com.zs.genlib.utils.MD5Util;


import java.io.IOException;

/**
 * 下载线程2
 */
public class StartDownload2 {
    public static void main(String[] args)  throws IOException {
        downloadFiles();
    }

    public static void downloadFiles() throws IOException{

        String a =
//                "8a7d1d176d9d8918e984b6d8bd33c254\n"
//                        "5991b27f0e08d03ed7cfb2181d0e8968\n" +


                               "3d702d3df9d6e220cb2ed38c4df72e88\n" +
                               "6c71fa0d153bd74f1e1a462508dcf890\n" +
                               "df5f046f9274220476ab5ebb17f51b01\n" +
                               "6b132ea74996f6a10ceba47a63f20d22\n" +
                               "8bad317254650ec4b7732ce4e095b0b7\n" +
                               "63752a69f8f200199da701bfea5b7a2b\n" +
                               "ff0fd8c72dc3085d3f60e10d6efcfcfc\n" +
                               "96ffba2e31848f0b0310c3b7b6a20752\n" +
                               "e02bd3b7cc8798f0a0e54fb0aedc4ec3\n" +
                               "28707945c53cd963185c2a4f52c60a3e\n" +
                               "bbcc2eb17b0dd8057f606325ac4a061d\n" +
                               "b961350a9f2101027ea6cdee6b11e15d\n" +
                               "6fcb9ff04edd0376b0c8737e794c03a6\n" +
                               "0b1d7a7ae3c2b6fb1df20056b3e64a00\n" +
                               "b8045fc5de9e914c9f9a9e1eb86909f0\n" +
                               "e318bb9e2c4218187df09340fd958af8\n" +
                               "0dc65e2b360c9751ff0638f94a4643fd\n" +
                               "b38f78c56b2bb6b8077dceb23ffaa341\n" +
                               "88de9ea3a2539761243d889b844d984d\n" +
                               "b315205d601b10a2fdbd907b1aa75465\n" +
                               "de2d8023a018bc3c7180445386584e24\n" +
                               "667e79aff6bb07ddb14c93a7f9de9f3c\n" +
                               "85e0ec0073d910d6cbdec4626f93d2db\n";

        String aa[] = a.split("\n");



        for(String md5 : aa){
            if(MD5Util.md5Exists(md5)){
                System.out.println(md5 + " has already download ...");
                continue;
            }
            System.out.println("start download file ,md5: " + md5);
            StartDownload.downloadSingleFile(md5);
        }


    }
}
