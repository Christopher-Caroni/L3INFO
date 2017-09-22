package fil.coo.spawnables.interfaces;

import java.util.List;

/**
 * Interface that specifies methods necessary to spawn <b>multiple</b> spawnables
 */
public interface IMultipleSpawnable<T extends IMultipleSpawnable<T>> extends Spawnable {

    /**
     * @return a list of {@link Spawnable} with random chance from {@link Spawnable#getSpawnRate()}
     */
    List<T> getRandomSpawn();

    /**
     *
     * @return the upper bound of how many of this object should be spawned
     */
    int getRandomAmount();

}
