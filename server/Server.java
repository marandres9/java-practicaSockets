package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    ServerSocket server;
    Socket client;
    int PORT = 8080;
    BufferedReader in;
    DataOutputStream out;

    int clientCount;

    void addClient() {clientCount++;}
    int getClientCount() {return this.clientCount;}

    Server() throws IOException {
        server = new ServerSocket(PORT);
    }
    
    public void start() throws IOException {
        client = server.accept();
        System.out.println("Server online");

        in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String nextLine;
        while ((nextLine = in.readLine()) != null) {
            System.out.println("reading...");

            addClient();
            System.out.println(nextLine);
            System.out.println("Client count: " + clientCount);
        }

        System.out.println("server offline");
        client.close();
        server.close();       
    }

    public static void main(String[] args) {
        try {
            System.out.println("program start");
            Server sv = new Server();
            sv.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}