package fil.coo.spawnables.items;

import fil.coo.exception.NotEnoughGoldException;
import fil.coo.spawnables.interfaces.Item;
import org.junit.Test;

public class OneArmedBanditTest extends ItemTest {

    @Override
    protected Item getItemToTest() {
        return new OneArmedBandit();
    }

    @Test(expected = NotEnoughGoldException.class)
    public void testUseWithoutEnoughGoldThrowsException() {
        player.setGold(0);
        item.setAmount(20);

        item.use(player);
    }
    /*
    We can't test that the cost of the OneArmedBandit is applied because it may spawn a CoinPouch that is used immediately
     */

}