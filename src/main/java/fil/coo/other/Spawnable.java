package fil.coo.other;

import fil.coo.objects.GoldItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static fil.coo.util.SpawnRates.*;

/**
 *
 */
public abstract class Spawnable {

    public static int getSpawnAmount(Types type) {
        Random random = new Random();
        double spawnChance = random.nextDouble();
        switch (type) {
            case GOLD:
                if (spawnChance <= SPAWN_RATE_GOLD) {
                    return random.nextInt(SPAWN_UPPER_BOUND_GOLD);
                }
                break;
            case MONSTER:
                if (spawnChance <= SPAWN_RATE_MONSTER) {
                    return random.nextInt(SPAWN_UPPER_BOUND_MONSTERS);
                }
                break;
            default:
                break;
        }
        return 0;
    }

    /**
     * @return a list of {@link Spawnable} with random chance from {@link #getSpawnAmount(Types)}
     */
    public abstract List<? extends Spawnable> getRandomSpawn();

    public static List<? extends Spawnable> generateRandomSpawn(Types type) {
        int spawnAmount = getSpawnAmount(type);
        List<Spawnable> items = new ArrayList<>();

        switch (type) {
            case GOLD:
                for (int i = 0; i < spawnAmount; i++) {
                    GoldItem goldItem = new GoldItem();
                    items.add(goldItem);
                }
                break;
            case MONSTER:
                break;
            default:
                break;
        }


        return items;
    }

    public enum Types {
        GOLD, MONSTER;
    }

}
