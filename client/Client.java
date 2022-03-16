package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Client {
    Socket client;

    String HOST = "127.0.0.1";
    int PORT = 8080;

    DataOutputStream out;
    
    Client() throws IOException {
        client = new Socket(HOST, PORT);
        out = new DataOutputStream(client.getOutputStream());
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese \"0\" para salir, o cualq cosa para" + 
        " registrar un cliente");

        while (!scanner.nextLine().equalsIgnoreCase("0")) {
            out.writeUTF("cliente\n");
        }
        scanner.close();
        client.close();
        System.out.println("Client closed");
    }               
    
    public static void main(String[] args) {
        try {
            Client cl = new Client();
            cl.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}