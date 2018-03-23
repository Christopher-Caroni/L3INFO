package fil.coo.spawnables.beings;

import fil.coo.structures.Room;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class GameCharacterTest {

    protected static Room.Builder roomBuilder;

    @BeforeClass
    public static void setupRoomFactory() {
        roomBuilder = new Room.Builder();
    }

    protected GameCharacter character;

    @Before
    public void setup() {
        character = createCharacter();
    }

    protected abstract GameCharacter createCharacter();


    @Test
    public void testIsAlive() throws Exception {
        assertTrue(character.isAlive());

        character.setHP(0);

        assertFalse(character.isAlive());
    }

    @Test
    public void testSetGetHP() throws Exception {
        int amountToSet = character.getHP() + 20;

        character.setHP(amountToSet);
        assertEquals(amountToSet, character.getHP());
    }

    @Test
    public void testChangeHPForNegativeValue() throws Exception {
        int initialPlayerHP = character.getHP();

        int hpReduction = -10;

        character.changeHP(hpReduction);
        assertEquals(initialPlayerHP + hpReduction, character.getHP());
    }

    @Test
    public void testChangeHPForPositiveValue() throws Exception {
        int initialPlayerHP = character.getHP();

        int hpBoost = 10;

        character.changeHP(hpBoost);
        assertEquals(initialPlayerHP + hpBoost, character.getHP());
    }

    @Test
    public void testSetGetGold() throws Exception {
        int amountToSet = character.getGold() + 20;

        character.setGold(amountToSet);
        assertEquals(amountToSet, character.getGold());
    }

    @Test
    public void testChangeGoldForNegativeValue() throws Exception {
        int initialGold = 10;
        character.setGold(initialGold);

        int goldReduction = -10;

        character.changeGold(goldReduction);
        assertEquals(initialGold + goldReduction, character.getGold());
    }

    @Test
    public void testChangeGoldForPositiveValue() throws Exception {
        int initialPlayerGold = character.getGold();

        int goldBoost = 10;

        character.changeGold(goldBoost);
        assertEquals(initialPlayerGold + goldBoost, character.getGold());
    }

    @Test
    public void testSetGetStrength() throws Exception {
        int amountToSet = character.getStrength() + 20;

        character.setStrength(amountToSet);
        assertEquals(amountToSet, character.getStrength());
    }

    @Test
    public void testChangeStrengthForNegativeValue() throws Exception {
        int initialStrength = 10;
        character.setStrength(initialStrength);

        int strengthReduction = -10;

        character.changeStrength(strengthReduction);
        assertEquals(initialStrength + strengthReduction, character.getStrength());
    }

    @Test
    public void testChangeStrengthForPositiveValue() throws Exception {
        int initialStrength = character.getStrength();

        int strengthBoost = 10;

        character.changeStrength(strengthBoost);
        assertEquals(initialStrength + strengthBoost, character.getStrength());
    }

    @Test
    public void testSetGetCurrentRoom() throws Exception {
        assertNull(character.getCurrentRoom());

        Room room = roomBuilder.createSimpleRoom(0,0).build();
        character.setCurrentRoom(room);

        assertSame(room, character.getCurrentRoom());
    }

}