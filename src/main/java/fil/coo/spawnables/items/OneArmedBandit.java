package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.items.interfaces.Item;

import java.util.Optional;
import java.util.Random;

public class OneArmedBandit extends Item implements ISingleSpawnable<OneArmedBandit> {


    private int cost;

    /**
     * The player must have enough money to use the {@link OneArmedBandit} otherwise he disappears. If he gives him the money, the oneArmedBandit attemps to spawn a random object. If an object is spawned, it will be used immediately.
     *
     * @param player
     */
    @Override
    protected void applySpecificEffect(GamePlayer player) {
        if (player.hasEnoughGold(cost)) {
            Optional<? extends Item> randomItem = generateRandomItem();
            randomItem.ifPresent(item -> item.use(player));
        }
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
        this.cost = cost;
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
