package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.items.interfaces.Item;

import java.util.Random;

public class OneArmedBandit extends Item implements ISingleSpawnable<OneArmedBandit> {


    private int cost;

    /**
     * The player must have enough money to use the {@link OneArmedBandit} otherwise he disappears. If he gives him the money, the oneArmedBandit gives him a random item which is used by the player immediately.
     *
     * @param player
     */
    @Override
    protected void applySpecificEffect(GamePlayer player) {
        if (player.hasEnoughGold(cost)) {
            Item randomItem = generateRandomItem();
            randomItem.use(player);
        }
    }

    /**
     * @return a random {@link Item}
     */
    private Item generateRandomItem() {
        int chance = new Random().nextInt(4);
        Item item;

        switch (chance) {
            case 1:
                item = new GoldPurse().getRandomSpawn();
                break;
            case 2:
                item = new HealthPotion().getRandomSpawn();
                break;
            case 3:
                item = new StrengthPotion().getRandomSpawn();
                break;
            default:
                item = new GoldPurse().getRandomSpawn();
                break;
        }
        return item;
    }


    @Override
    public String getMenuDescription() {
        return "One-armed bandit: generates a random item that will be used immeadiately.";
    }

    @Override
    public OneArmedBandit getRandomSpawn() {
        if (willSpawn()) {
            return new OneArmedBandit()
                    .withCost(getUpperSpawnBoundForAmountHeld());
        }
        return null;
    }

    private OneArmedBandit withCost(int cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public int getUpperSpawnBoundForAmountHeld() {
        return 21;
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
