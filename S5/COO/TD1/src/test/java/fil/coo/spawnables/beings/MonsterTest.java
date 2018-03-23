package fil.coo.spawnables.beings;

import org.junit.Test;

import static fil.coo.spawnables.beings.Monster.MENU_DESC_FORMAT;
import static fil.coo.spawnables.beings.Monster.UPPER_BOUND_RANDOM_AMOUNT;
import static fil.coo.spawnables.beings.Monster.UPPER_BOUND_SPAWN_CHANCE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MonsterTest extends GameCharacterTest {

    @Override
    protected GameCharacter createCharacter() {
        return new Monster();
    }

    @Test
    public void testGetMenuDescription() throws Exception {
        Monster monster = new Monster();
        String expected = String.format(MENU_DESC_FORMAT, monster.getHP());
        assertEquals(expected, monster.getMenuDescription());
    }

    @Test
    public void testGetRandomAmount() throws Exception {
        Monster monster = new Monster();
        for (int i = 0; i < 20; i++) {
            assertTrue(monster.getRandomAmount() < UPPER_BOUND_RANDOM_AMOUNT);
        }
    }

}