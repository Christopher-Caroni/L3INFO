package fil.coo.spawnables.interfaces;

import fil.coo.spawnables.Spawner;

import java.util.List;

public interface IMultipleSpawnable extends ISpawnable {

    /**
     * @return a list of {@link ISpawnable} with random chance from {@link Spawner#getSpawnAmount(Spawner.Types)}
     */
    List<? extends ISpawnable> getRandomSpawn();

}
