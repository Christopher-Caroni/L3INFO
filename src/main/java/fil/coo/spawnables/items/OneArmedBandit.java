package fil.coo.spawnables.items;

import fil.coo.exception.NotEnoughGoldException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.Item;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Random;

public class OneArmedBandit extends Item<OneArmedBandit> {

    final static Logger logger = Logger.getLogger(OneArmedBandit.class);


    private int cost;

    /**
     * The player must have enough money to use the {@link OneArmedBandit} otherwise he disappears. If he gives him the money, the oneArmedBandit attemps to spawn a random object. If an object is spawned, it will be used immediately.
     *
     * @param player
     * @throws NotEnoughGoldException if the player doesn't have enough gold
     */
    @Override
    protected void applySpecificEffect(GamePlayer player) throws NotEnoughGoldException {
        if (player.hasEnoughGold(cost)) {
            player.changeGold(-cost);
            Optional<? extends Item> randomItem = generateRandomItem();
            randomItem.ifPresent(item -> useNewItem(item, player));
        } else {
            throw new NotEnoughGoldException("Not enough gold to use.");
        }
    }

    @Override
    public int getAmount() {
        return cost;
    }

    @Override
    public void setAmount(int amount) {
        this.cost = amount;
    }

    private void useNewItem(Item item, GamePlayer player) {
        logger.info("The one-armed bandit spawned " + item.getMenuDescription());
        item.use(player);
    }

    /**
     * @return a random {@link Item}
     */
    private Optional<? extends Item> generateRandomItem() {
        int chance = new Random().nextInt(4);
        Optional<? extends Item> item;

        switch (chance) {
            case 1:
                item = new CoinPouch().getRandomSpawn();
                break;
            case 2:
                item = new HealthPotion().getRandomSpawn();
                break;
            case 3:
                item = new StrengthPotion().getRandomSpawn();
                break;
            default:
                item = new CoinPouch().getRandomSpawn();
                break;
        }
        return item;
    }


    @Override
    public String getMenuDescription() {
        return "One-armed bandit: generates a random item that will be used immeadiately.";
    }

    @Override
    public Optional<OneArmedBandit> getRandomSpawn() {
        if (willSpawn()) {
            return Optional.of(new OneArmedBandit()
                    .withCost(getRandomAmountHeld()));
        }
        return Optional.empty();
    }

    private OneArmedBandit withCost(int cost) {
        setAmount(cost);
        return this;
    }

    @Override
    public int getRandomAmountHeld() {
        return new Random().nextInt(21);
    }

    @Override
    public double getSpawnRate() {
        return 0.2;
    }

    @Override
    public boolean willSpawn() {
        return new Random().nextDouble() <= getSpawnRate();
    }

}
