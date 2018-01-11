package fil.coo.gui;

import fil.coo.other.Direction;
import fil.coo.structures.Room;

import javax.swing.*;
import java.awt.*;

public abstract class DungeonFrame extends JFrame {

    protected static final int ROOM_HEIGHT = 50;
    protected static final int ROOM_WIDTH = 50;

    protected static final int BORDER_HEIGHT = 50;
    protected static final int BORDER_WIDTH = 50;

    protected Dimension panelDim;

    protected Room[][] dungeon;

    protected DungeonPanel panel;

    public DungeonFrame(Room[][] dungeon) {
        this.dungeon = dungeon;

        setPanelDim();

//        DrawPane
        initDungeonPanel(panelDim);

//        JFRAME
        setupFrame();

        setCustomName();
    }

    protected abstract void setCustomName();

    private void setupFrame() {
        getContentPane().add(panel);
        setPreferredSize(panelDim);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void setPanelDim() {
        int panelHeight = (ROOM_HEIGHT * dungeon.length) + (2 * BORDER_HEIGHT);
        int panelWidth = (ROOM_WIDTH * dungeon[0].length) + (2 * BORDER_WIDTH);
        panelDim = new Dimension(panelWidth, panelHeight);
    }

    private void initDungeonPanel(Dimension panelDim) {
        panel = createSpecificPanel(panelDim);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(this.panelDim);
    }

    protected abstract DungeonPanel createSpecificPanel(Dimension panelDim);

    public abstract class DungeonPanel extends JPanel {

        public DungeonPanel(Dimension panelDim) {
            setPreferredSize(panelDim);
        }

        @Override
        public void paintComponent(Graphics gg) {
            super.paintComponents(gg);
            Graphics2D g = (Graphics2D) gg.create();

            paintEdges(g, Color.BLACK);
            paintInside(g, Color.WHITE);

            showProgress(g);

            paintRoomBorders(g);
        }

        /**
         * Draw the "progress" depending on the implementing class.
         *
         * @param g the graphics object that will draw the panel.
         */
        protected abstract void showProgress(Graphics2D g);

        /**
         * Paints the borders of the room by painting lines where a room doesn't have a neighbour.
         *
         * @param g the graphics object to draw with
         */
        private void paintRoomBorders(Graphics2D g) {
            g.setColor(Color.BLUE);
            g.setStroke(new BasicStroke(2));
            for (int y = 0; y < dungeon.length; y++) {
                for (int x = 0; x < dungeon[0].length; x++) {

                    int startX = BORDER_WIDTH + (ROOM_WIDTH * x);
                    int startY = BORDER_HEIGHT + (ROOM_HEIGHT * y);

                    g.drawString(x + ", " + y, startX + 5, startY + 15);

                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.NORTH)) {
                        g.drawLine(startX, startY, startX + ROOM_WIDTH, startY);
                    }
                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.EAST)) {
                        g.drawLine(startX + ROOM_WIDTH, startY, startX + ROOM_WIDTH, startY + ROOM_HEIGHT);
                    }
                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.SOUTH)) {
                        g.drawLine(startX, startY + ROOM_HEIGHT, startX + ROOM_WIDTH, startY + ROOM_HEIGHT);
                    }
                    if (!dungeon[y][x].hasLinkedNeighbourForDirection(Direction.WEST)) {
                        g.drawLine(startX, startY, startX, startY + ROOM_HEIGHT);
                    }

                }
            }
        }


        /**
         * Fills a cell that corresponds to a room by its coordinates.
         *
         * @param g     the graphics object to draw with
         * @param x     the x coordinate of the room
         * @param y     the y coordinate of the room
         * @param color the color to fill with
         */
        protected void fillRoom(Graphics2D g, int x, int y, Color color) {
            int startX = BORDER_WIDTH + (ROOM_WIDTH * x);
            int startY = BORDER_HEIGHT + (ROOM_HEIGHT * y);

            g.setColor(color);
            g.fillRect(startX, startY, ROOM_WIDTH, ROOM_HEIGHT);
        }

        /**
         * Paints the inside of the dungeon to the color specified.
         *
         * @param g     the graphics object to draw with
         * @param color the color to paint with
         */
        private void paintInside(Graphics2D g, Color color) {
            g.setColor(color);
            g.fillRect(BORDER_WIDTH, BORDER_HEIGHT, ROOM_WIDTH * dungeon[0].length, ROOM_HEIGHT * dungeon.length);
        }

        /**
         * Paints the edges of the dungeon to the color specified since they cant have neighbours leading "outside".
         *
         * @param g     the graphics object to draw with
         * @param color the color to paint with
         */
        private void paintEdges(Graphics2D g, Color color) {
            g.setColor(color);
            g.setStroke(new BasicStroke(2));
            g.drawRect(0, 0, panelDim.width, panelDim.height);
        }
    }

}
