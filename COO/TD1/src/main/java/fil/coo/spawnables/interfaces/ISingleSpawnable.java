package fil.coo.spawnables.interfaces;

import java.util.Optional;

/**
 * Interface that holds methods necessary to spawn a single spawnable object
 *
 * @param <T> the type that this class will spawn. Must be generic so that one class will only spawn itself
 */
public interface ISingleSpawnable<T extends ISingleSpawnable<T>> extends Spawnable {

    /**
     * @return a single {@link ISingleSpawnable} with random chance from {@link Spawnable#getSpawnRate()}
     */
    Optional<T> getRandomSpawn();

    /**
     * @return the upper bound of how many things this object will hold
     */
    int getRandomAmountHeld();
}
