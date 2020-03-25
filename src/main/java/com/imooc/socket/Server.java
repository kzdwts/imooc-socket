package com.imooc.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 * @author: kangyong
 * @date: 2020/3/24 21:47
 * @version: v1.0
 */
public class Server {

    public static void main(String[] args) {
        try {
            // 1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            // 记录客户端连接的数量
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            while (true) {
                // 2、调用accept() 方法开始监听，等待客户端的链接
                socket = serverSocket.accept();
                // 创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                // 启动线程
                serverThread.start();

                // 统计客户端数量
                count++;
                System.out.println("客户端数量：" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP：" + address.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
