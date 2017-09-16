package fil.coo.other;

public enum Direction implements Selectable {

    NORTH {
        @Override
        public String getMenuDescription() {
            return "NORTH";
        }
    }, EAST {
        @Override
        public String getMenuDescription() {
            return "EAST";
        }
    }, SOUTH {
        @Override
        public String getMenuDescription() {
            return "SOUTH";
        }
    }, WEST {
        @Override
        public String getMenuDescription() {
            return "WEST";
        }
    };

    /**
     *
     * @param initialDirection
     * @return the opposite direction of initialDirection
     */
    public static Direction getOppositeDirection(Direction initialDirection) {
        switch (initialDirection) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            default:
                return null;
        }
    }
}
