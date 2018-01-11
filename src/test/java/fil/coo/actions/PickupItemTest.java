package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.items.CoinPouch;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PickupItemTest extends ActionTest {

    @Override
    protected Action getAction() {
        return new PickupItem();
    }

    @Test
    public void testNotPossibleWithRoomNotRevealedAndNoItems() {
        GamePlayer player = this.getSimplePlayerWithRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithRoomRevealedButNoItems() {
        GamePlayer player = this.getSimplePlayerWithRoom();
        player.revealCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithItemsButRoomNotRevealed() {
        GamePlayer player = this.getSimplePlayerWithRoom();
        CoinPouch coinPouch = new CoinPouch();
        player.getCurrentRoom().addSingleItem(coinPouch);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testIsPossibleWithRoomRevealedAndItems() {
        GamePlayer player = this.getSimplePlayerWithRoom();
        player.revealCurrentRoom();
        CoinPouch coinPouch = new CoinPouch();
        player.getCurrentRoom().addSingleItem(coinPouch);

        assertTrue(action.isPossible(player));
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithRoomNotRevealedAndNoItems() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayerWithRoom();

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithRoomRevealedButNoItems() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayerWithRoom();
        player.revealCurrentRoom();

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithItemsButRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayerWithRoom();
        CoinPouch coinPouch = new CoinPouch();
        player.getCurrentRoom().addSingleItem(coinPouch);

        setManualChoice(0);
        action.execute(player);
    }

    @Test
    public void testExecuteWithRoomRevealedAndItems() {
        GamePlayer player = this.getSimplePlayerWithRoom();
        player.revealCurrentRoom();
        CoinPouch coinPouch = new CoinPouch();
        player.getCurrentRoom().addSingleItem(coinPouch);

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should've been possible to execute");
        }
    }
}