import com.zs.genlib.utils.MD5Util;

import java.io.IOException;

/**
 * 下载线程3
 */
public class StartDownload3 {
    public static void main(String[] args)  throws IOException {
        downloadFiles();
    }

    public static void downloadFiles() throws IOException{
        String a =

//                "02472b07d7b1ec44b8f240db6bb87a3f\n" +
//                "80a8aa72dd29c0e0cf9102b6663c8a8e\n" +
//                        "a2a945915a700e14e00f48f99379e4a6\n" +
//                        "59457806d7885d4ae21de5fd3874f1ff\n" +
//                        "3b7935c8353a328d6d923f8f4ab69c82\n" +
//                        "8fc6d2ec90a63ec84f3140c5e5a3d90c\n" +
//                        "168f7cfacfb2b80a7647ddc1ef0508a3\n" +
//                        "0f7564fe21b3103751111e5240ac6a83\n" +
//                        "f6976017430fd438531d48862a0f476d\n";
//                        "915de2c2928986b1c1364a05674ccc85";
//                                "d37bb1b9b488ff54a72d85607789f23b\n" +
//                                "0e5b0ecd0403cd84fb9c449d256d18c9\n" +
//                                "4f38262046aa3273d74aba161aadb54e\n" +
//                                "72f71f152717e9a52116a773cf4f3757\n" +
//                                "800d50710434ba9d77af42a1fff6882b\n" +
//                                "a97fe7d13953b704332149c7f6c2a81d\n" +
//                                "e0f732480f796b5299a3da9a7bfd7764\n" +
                              "77de04a34d0637311621871be59aa281\n" +
                                      "a3add8479af1e7001166a762b0e8b290\n" +
                                      "8dc8c29eeac80431c5ba5e90521b0b87\n" +
                                      "54b55a32bb9b8f999f4feef23db873a1\n" +
                                      "e9afcec1487716b0ef80d7e7c09869c8\n" +
                                      "3e5f63b379b0c61fcc521a9ce03539ae\n" +
                                      "86278c57f3b997efe4d21a4c2b39894e\n" +
                                      "e57ff6072be52dc8337d60c1845f9e97\n" +
                                      "ab8fb4c4c4b6b69a07284ec921a3e7d8\n" +
                                      "409446c0348f3fffffbd24fd6fbecab8\n" +
                                      "0341817c3b0fd34d439baa4e123a6515\n" +
                                      "7b19d687afcbc7db62b0f22e738a369a\n" +
                                      "c5b4179b813447321ed7a961512910c2\n" +
                                      "2421a1027f2733470440cddeb2561ac1\n" +
                                      "e305566069efa4db687a713373feed0b";
        String[] aa = a.split("\n");


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
