package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.Item;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Random;

public class HealthPotion extends Item<HealthPotion> {

    private final static Logger logger = Logger.getLogger(HealthPotion.class);

    private int healthBoost;

    @Override
    protected void applySpecificEffect(GamePlayer player) {
        player.changeHP(healthBoost);
        logger.info("You gained " + healthBoost + " HP and now have " + player.getHP() + " HP.");
    }

    @Override
    public int getAmount() {
        return healthBoost;
    }

    @Override
    public void setAmount(int amount) {
        this.healthBoost = amount;
    }

    @Override
    public String getMenuDescription() {
        return "Health potion: +" + healthBoost + " health";
    }

    @Override
    public Optional<HealthPotion> getRandomSpawn() {
        if (willSpawn()) {
            return Optional.of(new HealthPotion()
                    .withHealthBoost(getRandomAmountHeld()));
        }
        return Optional.empty();
    }

    private HealthPotion withHealthBoost(int healthBoost) {
        setAmount(healthBoost);
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
