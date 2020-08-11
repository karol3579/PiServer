package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class  Server implements Runnable {

    ServerSocket serverSocket;
    Socket clientSocket;

    BufferedReader bufferedReader;






    Server() {
        try {
            System.out.println("starting server...");

            serverSocket = new ServerSocket(3310);

            while (true) {
                clientSocket = serverSocket.accept();
                new Thread(this::run).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startCommunication(){
        //opens input and output on clientsocket
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeCommunication(){
        try {
            System.out.println("ending");
            bufferedReader.close();

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void run() {
        startCommunication();
        LedControl ledControl = new LedControl();

        try {
            while(true) {
                String message = bufferedReader.readLine();
                System.out.println(message);
                if(message.equals("on")){
                    ledControl.turnOn();
                }
                else if(message.equals("off")){
                    ledControl.turnOff();
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        closeCommunication();

    }
}
