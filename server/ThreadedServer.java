package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ThreadedServer {
    
    ServerSocket server;
    Socket client;
    final int PORT = 8080;
    // client instances
    int clientInstances = 0;
    void addClientInstance() {
        clientInstances++;
    }
    int getClientInstances() {
        return clientInstances;
    }
    
    ThreadedServer() throws IOException {
        server = new ServerSocket(PORT);
    }

    public void startServer() throws IOException {
        while(true) {
            client = server.accept();
            this.addClientInstance();
            new ClientHandler(client, getClientInstances()).start();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("program start");

            System.out.println("starting server");
            ThreadedServer sv = new ThreadedServer();
            sv.startServer();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }    
}