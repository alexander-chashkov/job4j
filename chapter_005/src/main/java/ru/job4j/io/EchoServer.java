package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 08.09.2020
 */


public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean exit = false;
            while (!exit) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.toUpperCase().contains("msg=Bye".toUpperCase()))
                            exit = true;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}