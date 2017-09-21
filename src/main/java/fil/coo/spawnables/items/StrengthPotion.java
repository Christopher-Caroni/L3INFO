package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.ISingleSpawnable;
import fil.coo.spawnables.items.interfaces.Potion;

import java.util.Random;

public class StrengthPotion extends Potion implements ISingleSpawnable<StrengthPotion> {

    private int strengthBoost;

    @Override
    protected void applySpecificEffect(GamePlayer player) {
        player.changeStrength(strengthBoost);
    }

    @Override
    public String getMenuDescription() {
        return "Strength potion: +" + strengthBoost + " strength";
    }

    @Override
    public StrengthPotion getRandomSpawn() {
        if (willSpawn()) {
            return new StrengthPotion()
                    .withStrengthBoost(getUpperSpawnBoundForAmountHeld());
        }
        return null;
    }

    private StrengthPotion withStrengthBoost(int strengthBoost) {
        this.strengthBoost = strengthBoost;
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
