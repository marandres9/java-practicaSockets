package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class Server {
    ServerSocket server;
    ArrayList<Socket> clients;
    int PORT = 8080;
    BufferedReader in;
    DataOutputStream out;

    int clientCount;
    int clientConnections;

    void addClient() {clientCount++;}
    int getClientCount() {return this.clientCount;}

    public class ConnectionHandler implements Runnable {
        @Override
        public void run() {
            
        }
    }
    
    Server() throws IOException {
        server = new ServerSocket(PORT);
        clientCount = 0;
        clientConnections = 0;
    }

    void addClientConnections() throws IOException {
        clients.add(server.accept());
        clientConnections++;}
    public int getClientConnections() {return clientConnections;}
    z
    public void start() throws IOException {
        addClientConnections();
        System.out.println("Client " + (getClientConnections()+1) + " online");
        new Thread(new ConnectionHandler()).start();
        
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