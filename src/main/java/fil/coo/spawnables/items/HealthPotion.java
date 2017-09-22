package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.Item;

import java.util.Optional;
import java.util.Random;

public class HealthPotion extends Item<HealthPotion> {

    private int healthBoost;

    @Override
    protected void applySpecificEffect(GamePlayer player) {
        player.changeHP(healthBoost);
        System.out.println("You gained " + healthBoost + " HP and now have " + player.getHP() + " HP.");
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
        this.healthBoost = healthBoost;
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
