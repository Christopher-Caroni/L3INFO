package fil.coo.spawnables.items;

import fil.coo.exception.NotEnoughGoldException;
import fil.coo.exception.NotEnoughStrengthException;
import fil.coo.spawnables.interfaces.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoinPouchTest extends ItemTest {


    @Override
    protected Item getItemToTest() {
        return new CoinPouch();
    }

    @Test
    public void testApplySpecificEffectWithPositiveValue() throws Exception {
        item.setAmount(20);
        int effect = item.getAmount();
        player.setGold(50);
        int initialGold = player.getGold();

        this.item.use(player);

        assertEquals(initialGold + effect, player.getGold());
    }

    @Test
    public void testApplySpecificEffectWithNegativeValue() throws Exception {
        item.setAmount(-20);
        int effect = item.getAmount();
        player.setGold(50);
        int initialGold = player.getGold();

        this.item.use(player);

        assertEquals(initialGold + effect, player.getGold());
    }

    @Test(expected = NotEnoughGoldException.class)
    public void testApplySpecificEffectShouldThrowException() {
        int effect = -20;
        player.setGold(0);
        item.setAmount(effect);

        this.item.use(player);

        fail("Not possible to have negative gold. This operation should've failed");
    }
}