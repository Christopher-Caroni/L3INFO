package fil.coo.gui;

import fil.coo.other.Direction;
import fil.coo.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DungeonFrame extends JFrame {

    private static final int roomHeight = 50;
    private static final int roomWidth = 50;

    private static final int borderHeight = 50;
    private static final int borderWidth = 50;

    private final Dimension panelDim;

    private Room[][] dungeon;
    private Stack<Room> stack;
    private List<Room> visited;

    public DungeonFrame(Room[][] dungeon) {
        this.dungeon = dungeon;
        this.stack = new Stack<>(); // clone to avoid modified the real stack
        visited = new ArrayList<>();

        int panelHeight = (roomHeight * dungeon.length) + (2 * borderHeight);
        int panelWidth = (roomWidth * dungeon[0].length) + (2 * borderWidth);
        panelDim = new Dimension(panelWidth, panelHeight);

//        DrawPane
        DrawPane panel = new DrawPane();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(panelDim);

//        JFRAME
        getContentPane().add(panel);
        setTitle("Dungeon");
        setPreferredSize(panelDim);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void refresh() {
        repaint();
    }

    public void addInitialRoom(Room startingRoom) {
        stack.push(startingRoom);
    }

    public void push(Room room) {
        stack.push(room);
    }

    public void pop() {
        visited.add(stack.peek());
        stack.pop();
    }

    private class DrawPane extends JPanel {
        @Override
        public void paintComponent(Graphics gg) {
            super.paintComponents(gg);

            Graphics2D g = (Graphics2D) gg.create();
            g.setColor(Color.BLUE);
            g.setStroke(new BasicStroke(2));

            paintEdges(g);
            paintInside(g);
            showAlgorithmProgress(g);

            g.setColor(Color.BLUE);
            g.setStroke(new BasicStroke(2));
            for (int y = 0; y < dungeon.length; y++) {
                for (int x = 0; x < dungeon[0].length; x++) {

                    int startX = borderWidth + (roomWidth * x);
                    int startY = borderHeight + (roomHeight * y);

                    g.drawString(x + ", " + y, startX + 5, startY + 15);

                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.NORTH)) {
                        g.drawLine(startX, startY, startX + roomWidth, startY);
                    }
                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.EAST)) {
                        g.drawLine(startX + roomWidth, startY, startX + roomWidth, startY + roomHeight);
                    }
                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.SOUTH)) {
                        g.drawLine(startX, startY + roomHeight, startX + roomWidth, startY + roomHeight);
                    }
                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.WEST)) {
                        g.drawLine(startX, startY, startX, startY + roomHeight);
                    }

                }
            }
        }

        private void showAlgorithmProgress(Graphics2D g) {
            for (int i = 0; i < stack.size() - 1; i++) {
                Room room = stack.get(i);
                fillRoom(g, room, Color.PINK);
            }
            if (!stack.isEmpty()) {
                fillRoom(g, stack.peek(), Color.MAGENTA);
            }
            for (int i=0;i<visited.size();i++) {
                fillRoom(g, visited.get(i), Color.LIGHT_GRAY);
            }

        }

        private void fillRoom(Graphics2D g, Room room, Color color) {
            int startX = borderWidth + (roomWidth * room.getX());
            int startY = borderHeight + (roomHeight * room.getY());

            g.setColor(color);
            g.fillRect(startX, startY, roomWidth, roomHeight);
        }

        private void paintInside(Graphics2D g) {
            g.setColor(Color.WHITE);
            g.fillRect(borderWidth, borderHeight, roomWidth * dungeon[0].length, roomHeight * dungeon.length);
        }

        private void paintEdges(Graphics2D g) {
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(2));
            g.drawRect(0, 0, panelDim.width, panelDim.height);
        }
    }
}
