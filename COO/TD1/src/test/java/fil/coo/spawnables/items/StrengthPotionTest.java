package fil.coo.spawnables.items;

import fil.coo.exception.NotEnoughStrengthException;
import fil.coo.spawnables.interfaces.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StrengthPotionTest extends ItemTest {

    @Override
    protected Item getItemToTest() {
        return new StrengthPotion();
    }

    @Test
    public void testApplySpecificEffectWithPositiveValue() throws Exception {
        int effect = 20;
        player.setStrength(50);
        item.setAmount(effect);
        int initialStrength = player.getStrength();

        this.item.use(player);

        assertEquals(initialStrength + effect, player.getStrength());
    }

    @Test
    public void testApplySpecificEffectWithNegativeValue() throws Exception {
        int effect = -20;
        player.setStrength(50);
        item.setAmount(effect);
        int initialStrength = player.getStrength();

        this.item.use(player);

        assertEquals(initialStrength + effect, player.getStrength());
    }

    @Test(expected = NotEnoughStrengthException.class)
    public void testApplySpecificEffectShouldThrowException() {
        int effect = -20;
        player.setStrength(0);
        item.setAmount(effect);

        this.item.use(player);

        fail("Not possible to have negative strength. This operation should've failed");
    }
}