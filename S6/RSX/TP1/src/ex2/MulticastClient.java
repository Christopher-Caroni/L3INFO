package ex2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

    private static final int PACKET_LENGTH = 1024;

    private DatagramPacket packet;

    private InetAddress group;
    private MulticastSocket multicastSocket;


    public MulticastClient(InetAddress group, int port) throws IOException {
        this.group = group;
        multicastSocket = new MulticastSocket(port);
        multicastSocket.joinGroup(group);
    }

    public void listen() {
        try {
            byte[] buffer = new byte[PACKET_LENGTH];
            packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("multicastclient is listening");

            multicastSocket.receive(packet);


            String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("received: " + result);
            System.out.println("was from " + packet.getAddress().getHostName());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("could not receive");
        }
    }

    public void leaveGroup() throws IOException {
        multicastSocket.leaveGroup(group);
    }

    public static void main(String[] args) throws IOException {
        MulticastClient client = new MulticastClient(InetAddress.getByName("224.0.0.1"), 7654);
        while (true) {
            client.listen();
        }
    }

    public MulticastSocket getMulticastSocket() {
        return multicastSocket;
    }
}
