package ex3gui;

import ex3.SingleMulticastClientServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.InetAddress;

public class ChatFrame extends JFrame implements MessageClient {

    private SingleMulticastClientServer clientServer;
    private JTextArea chatArea;
    private JTextArea inputArea;

    private String localHost;
    private String extendedLocalhost;
    private boolean firstMessage;

    public ChatFrame() throws IOException {
        super("Chat");

        initFrame();
        initServer();
    }

    private void initServer() throws IOException {
        clientServer = new SingleMulticastClientServer(InetAddress.getByName("224.0.0.1"),7654);

        clientServer.addListener(this);
        localHost = InetAddress.getLocalHost().getHostName();
        extendedLocalhost = localHost + ".fil.univ-lille1.fr";
        firstMessage = true;
    }

    private void initFrame() {
        Dimension dim = new Dimension(800, 800);

        setPreferredSize(dim);

        JPanel mainPanel = setupMainPanel();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(mainPanel);
        this.pack();
        setLocationRelativeTo(null);
    }

    private JPanel setupMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        JPanel chatPanel = setupChatPanel();
        JPanel inputPanel = setupInputPanel();

        mainPanel.add(chatPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        return mainPanel;
    }

    private JPanel setupChatPanel() {
        JPanel chatPanel = new JPanel();


        chatArea = new JTextArea();
        JScrollPane scrollChat = new JScrollPane(chatArea);
        scrollChat.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getValue());
            }
        });

        scrollChat.setPreferredSize(new Dimension(775, 700));

        chatPanel.add(scrollChat);
        return chatPanel;
    }

    private JPanel setupInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2));

        inputArea = new JTextArea();
        inputArea.requestFocus();
        inputArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                boolean isEnter = keyEvent.getKeyChar() == '\n';
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER || isEnter) {
                    String input = inputArea.getText();
                    input = input.substring(0, input.length() - 1);

                    sendMessage(input);
                }
            }
        });

        JButton enterButton = new JButton("Send");
        enterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sendMessage(inputArea.getText());
            }
        });

        inputPanel.add(inputArea);
        inputPanel.add(enterButton);

        return inputPanel;
    }

    /**
     * Sends a message through the client/server
     *
     * @param message the message to send
     */
    private void sendMessage(String message) {
        clientServer.send(message);
        inputArea.setText("");
    }

    /**
     * Starts the client/server
     */
    public void run() {
        clientServer.run();
    }

    @Override
    public void receiveMessage(String message, String host) {
        String chatLogMessage = extractChatLogMessage(message, host);

        if (firstMessage) {
            chatArea.setText(chatLogMessage);
            firstMessage = false;
        } else {
            chatArea.append("\n" + chatLogMessage);
        }
    }

    /**
     * @param message the message received
     * @param host    the host origin
     * @return the message preceded by the hostname, formatted with 30 chars width for the hostname
     */
    private String extractChatLogMessage(String message, String host) {
        String displayHostname = "";
        if (localHost.equals(host) || extendedLocalhost.equals(host)) {
            displayHostname = "you";
        } else {
            displayHostname = host;
        }

        displayHostname += ":";
        return String.format("%-30s %s", displayHostname, message);
    }
}
