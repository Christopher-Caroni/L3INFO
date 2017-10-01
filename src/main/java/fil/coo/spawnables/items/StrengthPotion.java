package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.Item;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Random;

public class StrengthPotion extends Item<StrengthPotion> {

    final static Logger logger = Logger.getLogger(StrengthPotion.class);

    private int strengthBoost;

    @Override
    protected void applySpecificEffect(GamePlayer player) {
        player.changeStrength(strengthBoost);
        logger.info("You gained " + strengthBoost + " strength and now have " + player.getStrength() + " strength.");
    }

    @Override
    public int getAmount() {
        return strengthBoost;
    }

    @Override
    public void setAmount(int amount) {
        this.strengthBoost = amount;
    }

    @Override
    public String getMenuDescription() {
        return "Strength potion: +" + strengthBoost + " strength";
    }

    @Override
    public Optional<StrengthPotion> getRandomSpawn() {
        if (willSpawn()) {
            return Optional.of(new StrengthPotion()
                    .withStrengthBoost(getRandomAmountHeld()));
        }
        return Optional.empty();
    }

    private StrengthPotion withStrengthBoost(int strengthBoost) {
        setAmount(strengthBoost);
        return this;
    }

    @Override
    public int getRandomAmountHeld() {
        return new Random().nextInt(10);
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
