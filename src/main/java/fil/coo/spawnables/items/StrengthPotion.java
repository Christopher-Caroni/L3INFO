package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.items.interfaces.Potion;

import java.util.Optional;
import java.util.Random;

public class StrengthPotion extends Potion implements ISingleSpawnable<StrengthPotion> {

    private int strengthBoost;

    @Override
    protected void applySpecificEffect(GamePlayer player) {
        player.changeStrength(strengthBoost);
        System.out.println("You gained " + strengthBoost + " strength and now have " + player.getStrength() + " strength.");
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
        this.strengthBoost = strengthBoost;
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
