package fil.coo.spawnables.beings;

import fil.coo.spawnables.interfaces.IMultipleSpawnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends GameCharacter implements IMultipleSpawnable<Monster> {

    public static final int UPPER_BOUND_RANDOM_AMOUNT = 3;
    public static final double UPPER_BOUND_SPAWN_CHANCE = 0.2;

    public static final String MENU_DESC_FORMAT = "Monster: %d HP";

    public Monster() {
        super();
    }

    @Override
    void setSpecificAttributes(Random random) {
        setRandomStrength(random);
        setRandomGoldCarried(random);
    }

    @Override
    protected void setRandomStrength(Random random) {
        strength = random.nextInt(10) + 10;
    }

    private void setRandomGoldCarried(Random random) {
        this.gold = random.nextInt(10) + 20;
    }

    @Override
    public String getMenuDescription() {
        return String.format(MENU_DESC_FORMAT, getHP());
    }

    /**
     * @return a spawn of a random amount of {@link Monster} specified by {@link #getSpawnRate()}
     */
    @Override
    public List<Monster> getRandomSpawn() {
        List<Monster> monsters = new ArrayList<>();

        if (willSpawn()) {
            int spawnAmount = getRandomAmount();

            if (spawnAmount > 0) {
                for (int i = 0; i < spawnAmount; i++) {
                    Monster monster = new Monster();
                    monsters.add(monster);
                }
            }
        }

        return monsters;
    }

    @Override
    public int getRandomAmount() {
        return new Random().nextInt(UPPER_BOUND_RANDOM_AMOUNT);
    }

    @Override
    public double getSpawnRate() {
        return UPPER_BOUND_SPAWN_CHANCE;
    }

    @Override
    public boolean willSpawn() {
        return new Random().nextDouble() <= getSpawnRate();
    }
}
