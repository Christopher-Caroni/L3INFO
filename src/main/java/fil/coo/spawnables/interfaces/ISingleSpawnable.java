package fil.coo.spawnables.interfaces;

import fil.coo.spawnables.Spawner;

public interface ISingleSpawnable<T extends ISingleSpawnable> extends ISpawnable {

    /**
     * @return a single {@link ISingleSpawnable} with random chance from {@link Spawner#getSpawnAmount(Spawner.Types)}
     */
    T getRandomSpawn();
}
