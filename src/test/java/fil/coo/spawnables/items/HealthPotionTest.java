package fil.coo.spawnables.items;

import fil.coo.spawnables.interfaces.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class HealthPotionTest extends ItemTest {

    @Override
    protected Item getItemToTest() {
        return new HealthPotion();
    }

    @Test
    public void testApplySpecificEffectWithPositiveValue() throws Exception {
        int effect = 20;
        player.setHP(50);
        item.setAmount(effect);
        int initialHP = player.getHP();

        this.item.use(player);

        assertEquals(initialHP + effect, player.getHP());
    }

    @Test
    public void testApplySpecificEffectWithNegativeValue() throws Exception {
        int effect = -20;
        player.setHP(50);
        item.setAmount(effect);
        int initialHP = player.getHP();

        this.item.use(player);

        assertEquals(initialHP + effect, player.getHP());
    }

    @Test
    public void testApplySpecificEffectWithHigherNegativeValueThanCurrent() throws Exception {
        int effect = -20;
        player.setHP(10);
        item.setAmount(effect);

        this.item.use(player);

        assertEquals(0, player.getHP());
    }
}