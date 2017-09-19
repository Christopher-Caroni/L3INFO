package fil.coo.spawnables.beings;

import fil.coo.spawnables.interfaces.IMultipleSpawnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends GameCharacter implements IMultipleSpawnable {

    @Override
    public String getMenuDescription() {
        return "Monster: " + "";
    }

    /**
     * @return a spawn of a random amount of {@link Monster} specified by {@link #getSpawnRate()}
     */
    @Override
    public List<Monster> getRandomSpawn() {
        List<Monster> monsters = new ArrayList<>();

        if (willSpawn()) {
            int spawnAmount = getUpperSpawnBoundForObject();

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
    public int getUpperSpawnBoundForObject() {
        return 3;
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
