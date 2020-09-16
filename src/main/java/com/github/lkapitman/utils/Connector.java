package com.github.lkapitman.utils;

import com.github.lkapitman.FLauncherPlugin;

import java.io.*;
import java.net.Socket;

public class Connector {
    // TODO: СДЕЛАТЬ ВОЗВРАТ ЗНАЧЕНИЯ ПРИ ОПРЕДЕЛЁННОМ СОБЫТИИ.

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static FLauncherPlugin plugin = new FLauncherPlugin();
    private String word;

    public void connect() {
        try {
            try {
                // адрес - локальный хост, порт - 4004, такой же как у сервера
                clientSocket = new Socket(plugin.getCommand().getIPAdress(), 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                word = reader.readLine();
                // Значение которое возвращается
                out.write(word + "\n");
                //
                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);
            } finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public void setWord(String word) {
        this.word = word;
    }
}
