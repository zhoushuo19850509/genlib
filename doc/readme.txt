这个工程主要是为了从genlib网站下载电子书

大致步骤有如下：
1.根据某个检索结果，找出这个页面中的各个电子书的MD5
参考代码：
MD5FetchTest.java

2.根据MD5找到文件信息，比如下载链接/文件名等
参考代码：
FileInfoUtil.java

3.根据下载链接，下载文件
参考代码：
DownloadUtil.java




