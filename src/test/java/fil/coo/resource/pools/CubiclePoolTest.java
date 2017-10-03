package fil.coo.resource.pools;

import fil.coo.resource.Cubicle;
import fil.coo.resource.Resource;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CubiclePoolTest extends ResourcePoolTest {

    protected ResourcePool getResourcePool(int i) {
        return new CubiclePool(i);
    }

    protected Resource getOneResource() {
        return resourcePool.createOneResource();
    }

    @Test
    public void testCreateOneResourcesGivesCubicle() {
        assertTrue(resourcePool.createOneResource() instanceof Cubicle);
    }
}