package fil.coo.gui;

import fil.coo.structures.Room;

import java.awt.*;

public class ProgressFrame extends DungeonFrame {

    private Room currentRoom;
    private boolean[][] visitedRooms;

    public ProgressFrame(Room[][] dungeon) {
        super(dungeon);

        visitedRooms = new boolean[dungeon.length][dungeon[0].length];
        for (int i = 0; i < visitedRooms.length; i++) {
            for (int j = 0; j < visitedRooms[0].length; j++) {
                visitedRooms[i][j] = false;
            }
        }
    }

    @Override
    protected void setCustomName() {
        setName("Dungeon progress");
    }

    @Override
    protected DungeonPanel createSpecificPanel(Dimension panelDim) {
        return new ProgressPanel(panelDim);
    }


    /**
     * Saves the currentRoom and marks it as visited for future reference.
     *
     * @param currentRoom the current room the player is in
     */
    public void updateCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        markCurrentRoomAsVisited(currentRoom);
        repaint();
    }

    /**
     * Saves the currentRoom to the {@link #visitedRooms} array for future drawing.
     *
     * @param currentRoom the player's current room
     */
    private void markCurrentRoomAsVisited(Room currentRoom) {
        visitedRooms[currentRoom.getY()][currentRoom.getX()] = true;
    }


    private class ProgressPanel extends DungeonPanel {
        public ProgressPanel(Dimension panelDim) {
            super(panelDim);
        }

        /**
         * Draws the progress of the player. The visited rooms are in pink, non visited in light gray, and current position in magenta
         *
         * @param g the graphics object that will draw the panel.
         */
        @Override
        protected void showProgress(Graphics2D g) {
            for (int y = 0; y < visitedRooms.length; y++) {
                for (int x = 0; x < visitedRooms[0].length; x++) {
                    if (visitedRooms[y][x]) {
                        fillRoom(g, x, y, Color.PINK);
                    } else {
                        fillRoom(g, x, y, Color.LIGHT_GRAY);
                    }
                }
            }

            if (currentRoom != null) {
                fillRoom(g, currentRoom.getX(), currentRoom.getY(), Color.MAGENTA);
            }
        }
    }
}
