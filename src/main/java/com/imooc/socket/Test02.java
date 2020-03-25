package com.imooc.socket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: URL 常用方法
 * @author: kangyong
 * @date: 2020/3/10 22:49
 * @version: v1.0
 */
public class Test02 {

    public static void  main(String[] args) {
        try {
            // 创建一个URL实例
            URL imooc = new URL("http://www.imooc.com");
            // ?后边表示参数，#后边表示锚点
            URL url = new URL(imooc, "/index.html?username=tom#test");

            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            System.out.println("端口：" + url.getPort());
            System.out.println("文件路径：" + url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("相对路径：" + url.getRef());
            System.out.println("查询字符串：" + url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
