package fil.coo.spawnables;

import fil.coo.spawnables.interfaces.ISpawnable;

import java.util.Random;

import static fil.coo.util.SpawnRates.*;

/**
 * Contains static methods to get spawn amount according to the spawnables chance.
 */
public class Spawner {


    /**
     * @param type the type of {@link ISpawnable} for which the {@link Types} specifies the spawn chance and amount
     * @return an amount of type to spawn if the spawn chance threshold was achieved.
     */
    public static int getSpawnAmount(Spawner.Types type) {
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
     * The types that have spawn chances and spawn rates.
     */
    public enum Types {
        GOLD, MONSTER;
    }

}
