package ex3;

import java.io.IOException;
import java.net.InetAddress;

public class App {

    public static void main(String[] args) throws IOException {
        SingleMulticastClientServer single = new SingleMulticastClientServer(InetAddress.getByName("224.0.0.1"),
                7654);

        single.run();
    }

}
