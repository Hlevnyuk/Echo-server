package com.luxoft.echo.client;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Client{
    public static void main(String[] args) throws IOException{
        byte[] buffer = new byte[100];
        Socket socket = new Socket("localhost", 4000);
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());
        InputStream inputStream = socket.getInputStream();
        int count = inputStream.read(buffer);
        System.out.println(new String(buffer, 0, count));
        inputStream.close();
        outputStream.close();
    }
}
