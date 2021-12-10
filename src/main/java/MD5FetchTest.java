import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 能够根据某个页面，找到这个页面下所有包含"md5"的下载连接
 * 后续可以进一步操作，通过这些md5码，组装下载连接
 */
public class MD5FetchTest {
    public static void main(String[] args) throws IOException {

        /**
         * 基础URL
         * 可以按照任意的检索条件，进行检索，
         * 注意，为了减少pageCount，在检索的时候尽量选择每页显示100条
         */
        int pageCount = 10;
//        String baseUrl = "http://176.123.10.47/index.php?req=PRENTICE-HALL&columns%5B%5D=t&columns%5B%5D=a&columns%5B%5D=s&columns%5B%5D=y&columns%5B%5D=p&columns%5B%5D=i&objects%5B%5D=f&objects%5B%5D=e&objects%5B%5D=s&objects%5B%5D=a&objects%5B%5D=p&objects%5B%5D=w&topics%5B%5D=l&topics%5B%5D=c&topics%5B%5D=f&topics%5B%5D=a&topics%5B%5D=m&topics%5B%5D=r&topics%5B%5D=s&res=25&order=&order=&curtab=f&order=&ordermode=desc&page=";
        String baseUrl = "http://176.123.10.47/index.php?req=Addison+Wesley&columns%5B%5D=p&objects%5B%5D=f&topics%5B%5D=l&topics%5B%5D=c&topics%5B%5D=f&topics%5B%5D=a&topics%5B%5D=m&topics%5B%5D=r&topics%5B%5D=s&res=100&curtab=f&order=year&ordermode=desc&page=";
        boolean singlePage = false;

        int index = 0;   // 总共有多少下载链接

        int timeout = 15000; //访问URL的超时时间
        String url = "";
        String MD5 = "";
        // 遍历各个url
        for (int i = 1; i <= pageCount; i++) {
            if(singlePage){
                url = baseUrl;
            }else{
                url = baseUrl + i;
            }
            Document document = Jsoup.connect(url).timeout(timeout).get();
            Elements elements = document.select("a[href]");

            for(Element element: elements){
                String attr = element.attr("href");
                if(attr.contains("md5=")){
                    MD5 = attr.substring(attr.indexOf("md5=") + 4,attr.length());

                    if(MD5.length() > 32){
                        MD5 = MD5.substring(0,32);
                    }
                    System.out.println(MD5);
                    index++;
                }
            }

            // 两个页面之间要稍微休息一段时间，访问不能太频繁
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("共计多少MD5： " + index);


    }
}