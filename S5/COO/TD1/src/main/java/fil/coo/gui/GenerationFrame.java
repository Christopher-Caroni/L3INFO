package fil.coo.gui;

import fil.coo.structures.Room;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerationFrame extends DungeonFrame {

    private Stack<Room> stack;
    private List<Room> visited;

    public GenerationFrame(Room[][] dungeon) {
        super(dungeon);

        this.stack = new Stack<>(); // clone to avoid modified the real stack
        visited = new ArrayList<>();
    }

    @Override
    protected void setCustomName() {
        setName("Dungeon Generation");
    }

    @Override
    protected DungeonPanel createSpecificPanel(Dimension panelDim) {
        return new GenerationPanel(panelDim);
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

    private class GenerationPanel extends DungeonPanel {

        public GenerationPanel(Dimension panelDim) {
            super(panelDim);
        }

        /**
         * Draws the progress of the generation algorithm. Current head in magenta. Potential rooms to link from in pink, and rooms linked with all its neighbours in light gray.
         *
         * @param g the graphics object that will draw the panel.
         */
        @Override
        protected void showProgress(Graphics2D g) {
            for (int i = 0; i < stack.size() - 1; i++) {
                Room room = stack.get(i);
                fillRoom(g, room.getX(), room.getY(), Color.PINK);
            }
            if (!stack.isEmpty()) {
                fillRoom(g, stack.peek().getX(), stack.peek().getY(), Color.MAGENTA);
            }
            for (int i = 0; i < visited.size(); i++) {
                fillRoom(g, visited.get(i).getX(), visited.get(i).getY(), Color.LIGHT_GRAY);
            }
        }
    }
}
