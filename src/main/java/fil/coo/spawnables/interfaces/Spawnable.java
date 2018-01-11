package fil.coo.spawnables.interfaces;

/**
 * Anythings that can be spawnable must implement a subclass of this: either {@link ISingleSpawnable} or {@link IMultipleSpawnable}
 */
public interface Spawnable {


    /**
     *
     * @return the spawn chance as a percent =&gt; 0.0 &amp;&amp; percent &lt;= 1.0
     */
    double getSpawnRate();

    /**
     *
     * @return if this object will be spawned according to {@link #getSpawnRate()}
     */
    boolean willSpawn();


}
