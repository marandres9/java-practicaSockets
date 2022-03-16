package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {
    Socket client;
    // i/o
    BufferedReader in;
    DataOutputStream out;
    // client counter
    static int clientCount = 0;
    void addClient() {
        clientCount++;
    }
    int getClientCount() {
        return clientCount;
    }

    int instanceNumber;
    
    ClientHandler(Socket client, int instanceNumber) {
        this.client = client;
        this.instanceNumber = instanceNumber;
    }
    @Override
    public void run() {
        try {
            // get input stream from client
            this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            System.out.println("Socket " + (this.instanceNumber) + " online");

            String nextLine;
            System.out.println("reading...");
            while ((nextLine = in.readLine()) != null) {    
                addClient();
                System.out.print(nextLine);
                System.out.println(" -- Client count: " + this.getClientCount());
            }
    
            System.out.println("Socket " + (this.instanceNumber) + "  offline");
            client.close();    
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
