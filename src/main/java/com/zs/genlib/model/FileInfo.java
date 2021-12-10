package com.zs.genlib.model;

public class FileInfo {
    private String fileName;  // 文件名
    private String title;   // 书名
    private String downloadUrl;  // 下载链接
    private String description;  // 文件描述
    private String author;  // 作者
    private String publisher;  // 出版社
    private String fileType; // 文件类型， 根据文件后缀判断，比如.pdf的类型就是PDF
    private String md5; // 文件的MD5码

    public FileInfo(String md5) {
        this.md5 = md5;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
