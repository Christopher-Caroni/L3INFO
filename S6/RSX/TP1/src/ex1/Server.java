package ex1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server {


    private DatagramSocket socket;
    private DatagramPacket packet;

    public void send(String message, InetAddress dest, int port) {
        byte[] byteData = message.getBytes();
        packet = new DatagramPacket(byteData, byteData.length, dest, port);

        try {
            socket = new DatagramSocket();
            socket.send(packet);
            System.out.println("sent message: " + message + " to " + dest.getHostName());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to send message");
        }


        socket.close();
    }

    public static void main(String[] args) throws UnknownHostException {
        Server server = new Server();
        server.send("first message", InetAddress.getByName("a15p12"), 9090);
        server.send("second message", InetAddress.getByName("a15p12"), 9090);

    }

}
