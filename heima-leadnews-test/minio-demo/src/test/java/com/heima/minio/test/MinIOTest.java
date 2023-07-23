package com.heima.minio.test;

import com.heima.file.service.FileStorageService;
import com.heima.file.service.impl.MinIOFileStorageService;
import com.heima.minio.MinIOApplication;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinIOTest {

    @Autowired
    private FileStorageService fileStorageService;

    @Test
    public void testUpdateImgFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/k/java/src/2023年学习合集/B站微服务/B站版黑马头条/从0开始自己造/图片素材/Xnip2022-07-01_20-45-30.jpg");
            String filePath = fileStorageService.uploadImgFile("", "ak47.jpg", fileInputStream);
            System.out.println(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() throws Exception{
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/k/java/src/2023年学习合集/B站微服务/B站版黑马头条/从0开始自己造/模版页面/list.html");
            String filePath = fileStorageService.uploadImgFile("", "list1.html", fileInputStream);
            System.out.println(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        try {

            fileInputStream =  new FileInputStream("/Volumes/My Passport/学习/黑马v14/B站Netty/3、黑马程序员Java微服务项目《黑马头条》/day02-app端文章查看，静态化freemarker,分布式文件系统minIO/资料/模板文件/plugins/js/axios.min.js");;
//            fileInputStream =  new FileInputStream("/Users/k/java/src/2023年学习合集/B站微服务/B站版黑马头条/从0开始自己造/模版页面/list.html");;

            //1.创建minio链接客户端
            MinioClient minioClient = MinioClient.builder().credentials("账号", "密码").endpoint("http://ip地址:9000").build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("/plugins/js/axios.min.js")//文件名
                    .contentType("text/js")//文件类型
                    .bucket("leadnews")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
            minioClient.putObject(putObjectArgs);

            System.out.println("http://192.168.200.130:9000/leadnews/ak47.jpg");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}