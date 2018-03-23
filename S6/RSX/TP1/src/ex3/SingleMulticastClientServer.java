package ex3;

import ex3gui.MessageClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleMulticastClientServer {


    private static final int PACKET_LENGTH = 1024;
    private final InetAddress group;
    private final int receivePort;

    private MulticastSocket multiClient;
    private MulticastSocket multiServer;

    private List<MessageClient> listeners;

    public SingleMulticastClientServer(InetAddress group, int receivePort) throws IOException {
        this.group = group;
        this.receivePort = receivePort;

        multiClient = new MulticastSocket(receivePort);
        multiClient.setTimeToLive(1);
        multiClient.joinGroup(group);

        multiServer = new MulticastSocket(receivePort);
        multiServer.setTimeToLive(1);
        multiServer.joinGroup(group);

        listeners = new ArrayList<>();
    }

    public void listen() {
        try {
            byte[] buffer = new byte[PACKET_LENGTH];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            multiClient.receive(packet);


            String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("received: " + result + " from " + packet.getAddress().getHostName());

            notifyListeners(result, packet.getAddress().getHostName());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("could not receive");
        }
    }

    private void notifyListeners(String result, String hostName) {
        for (MessageClient client : listeners) {
            client.receiveMessage(result, hostName);
        }
    }


    public void send(String message) {
        byte[] byteData = message.getBytes();
        DatagramPacket packet = new DatagramPacket(byteData, byteData.length, group, receivePort);

        try {
            multiServer.send(packet);
            System.out.println("sent message: " + message + " to " + group.getHostName());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to send message");
        }
    }

    public void close() {
        multiClient.close();
        multiServer.close();
    }

    /**
     * Starts waiting to receive messages in one thread and in another thread, continuously waits for user input to send
     */
    public void run() {
        new Thread(
                () -> {
                    System.out.println("client is listening");
                    while (true) {
                        listen();
                    }
                }
        ).start();


        new Thread(
                () -> {
                    Scanner scanner = new Scanner(System.in);

                    while (true) {
                        String msg = scanner.nextLine();
                        send(msg);
                    }
                }
        ).start();

    }

    public void addListener(MessageClient client) {
        listeners.add(client);
    }
}
