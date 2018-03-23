package ex1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {


    private static final int PACKET_LENGTH = 1024;

    private DatagramSocket socket;
    private DatagramPacket packet;

    public void init(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void listen() {
        try {
            byte[] buffer = new byte[PACKET_LENGTH];
            packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("client is listening");

            socket.receive(packet);


            String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("received: " + result);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("could not receive");
        }

    }

    public static void main(String[] args) throws SocketException {
        Client client = new Client();
        client.init(49500);

        while (true) {
            client.listen();
        }
//        client.closeSocket();
    }

    private void closeSocket() {
        socket.close();
    }

}
