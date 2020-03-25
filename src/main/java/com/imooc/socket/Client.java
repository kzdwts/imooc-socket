package com.imooc.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 客户端
 * @author: kangyong
 * @date: 2020/3/24 21:47
 * @version: v1.0
 */
public class Client {

    public static void main(String[] args) {
        try {
            // 1、创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("127.0.0.1", 8888);
            // 2、获取输出流，向服务端发送信息
            OutputStream os = socket.getOutputStream(); // 字节输出流
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin;密码：123");
            pw.flush();
            socket.shutdownOutput();// 关闭输出流

            // 3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务端说：" + info);
            }

            br.close();
            is.close();
            // 4、关闭资源
            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
