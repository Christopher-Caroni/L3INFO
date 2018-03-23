package ex3gui;

import java.io.IOException;

public class GuiApp {

    public static void main(String[] args) throws IOException {
        ChatFrame chatFrame = new ChatFrame();
        chatFrame.setVisible(true);
        chatFrame.run();
    }

}