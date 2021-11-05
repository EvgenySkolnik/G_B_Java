package ru.gb.java2.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Scanner scanner;

    public Client() {

        try {
            this.socket = new Socket("127.0.0.1", 8080);
            this.scanner = new Scanner(System.in);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private void start() throws IOException {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    try {
                        String inMessage = in.readUTF();
                        System.out.println(inMessage);
                    }
                    catch (IOException ex){
                        System.out.println("Соединение разорвано со стороны сервера.");
                        break;
                    //    throw new MyClientException("Что то сломалось при отсылке входящего сообщения", ex);
                    }
                }
            })
                .start();

            while (true){
                try {
                    System.out.println("Введите сообщение...");
                    String outMessage = scanner.nextLine();
                    out.writeUTF(outMessage);
                    if (outMessage.equalsIgnoreCase("EXIT")){
                        try {
                            out.close();
                            in.close();
                            socket.close();
                            return;

                        } catch (IOException ex) {
                            System.out.println("Сессия завершена");
                        }
                    }
                }
                catch (IOException ex) {
                    System.out.println("Соединение разорвано со стороны сервера.");
                    break;
                }
            }
    }
}
