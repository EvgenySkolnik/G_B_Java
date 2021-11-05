package ru.gb.java2.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class Server {
    private ServerSocket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server()  {
        try {
            socket = new ServerSocket(8080);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void start() throws IOException {

        System.out.println("Сервер запущен...");
        System.out.println("Ожидаем подключения ...");
        Socket accepted = socket.accept();
        System.out.println("Клиент подключен...");
        System.out.println("Адрес: " + accepted.getInetAddress());

        in = new DataInputStream(accepted.getInputStream());
        out = new DataOutputStream(accepted.getOutputStream());

        listenInMessage();


    }
    private void listenInMessage() {
        try {
            while (true) {
                String message = readInMessage();
                System.out.println("Поступило входящее сообщение...");
                System.out.println("Сообщение: " + message);
                sendOutMessage(message);
            }

        }
        catch (MyServerException ex) {
            System.out.println("Клиент отключился");
            System.out.println("Соединение корректно завершено");
            System.out.println("NOTE: Check log files at detail information. ");
        }
    }

    private  void sendOutMessage(String message) {
        try {
            out.writeUTF("ECHO: " + message);
        }
        catch (IOException ex){
            throw new MyServerException("Что то сломалось при отсылке входящего сообщения", ex);
        }
    }

    private String readInMessage(){
        try {
            return in.readUTF();
        }
        catch (EOFException ex){
            throw new MyServerException("Обнаружено окончание потока. Отключение со стороны клиента");
        }
        catch (IOException ex) {
            throw new MyServerException("Что то сломалось при чтении входящего сообщения...",ex);
        }
    }
}
