package fil.coo.spawnables.beings;

import fil.coo.other.Selectable;
import fil.coo.spawnables.interfaces.IMultipleSpawnable;
import fil.coo.spawnables.Spawner;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character implements Selectable, IMultipleSpawnable {

    @Override
    public String getMenuDescription() {
        return "Monster: " + "";
    }

    /**
     * @return a spawn of a random amount of {@link Monster} specified by {@link Spawner#getSpawnAmount(Spawner.Types)}
     */
    @Override
    public List<Monster> getRandomSpawn() {
        List<Monster> monsters = new ArrayList<>();

        int spawnAmount = Spawner.getSpawnAmount(Spawner.Types.MONSTER);

        if (spawnAmount > 0) {
            for (int i = 0; i < spawnAmount; i++) {
                Monster monster = new Monster();
                monsters.add(monster);
            }
        }

        return monsters;
    }
}
