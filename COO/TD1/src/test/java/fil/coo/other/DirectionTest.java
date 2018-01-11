package fil.coo.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void testOppositeOfNorthIsSouth() {
        assertEquals(Direction.SOUTH, Direction.getOppositeDirection(Direction.NORTH));
    }

    @Test
    public void testOppositeOfSouthIsNorth() {
        assertEquals(Direction.NORTH, Direction.getOppositeDirection(Direction.SOUTH));
    }

    @Test
    public void testOppositeOfEastIsWest() {
        assertEquals(Direction.WEST, Direction.getOppositeDirection(Direction.EAST));
    }

    @Test
    public void testOppositeOfWestIsEast() {
        assertEquals(Direction.EAST, Direction.getOppositeDirection(Direction.WEST));
    }

    @Test(expected = NullPointerException.class)
    public void testOppositeOfNullThrowsNullPointer() {
        Direction oppositeDirection = Direction.getOppositeDirection(null);
    }


}