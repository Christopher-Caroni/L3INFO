package fil.coo;

import fil.coo.exception.TooManyResourcesException;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CubiclePoolTest {

    @Test
    public void testProvideResourceGivesCorrectElement() {
        CubiclePool cubiclePool = new CubiclePool(1);
        assertNotNull(cubiclePool.provideResource());
    }

    @Test(expected = NoSuchElementException.class)
    public void testProvideResourceAlreadyEmpty() {
        CubiclePool cubiclePool = new CubiclePool(1);
        Cubicle usedCubicle = cubiclePool.provideResource();

        Cubicle badCubicle = cubiclePool.provideResource();
        fail("Above method call should've thrown NoSuchElementException");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecoverResouceWithNullThrowsException() throws TooManyResourcesException {
        CubiclePool cubiclePool = new CubiclePool(1);
        cubiclePool.recoverResource(null);
        fail("Above method call should've thrown IllegalArgumentException");
    }

    @Test
    public void testRecoverResourceWithoutNullDoesNotThrow() {
        CubiclePool cubiclePool = new CubiclePool(1);
        Cubicle removedCubicle = cubiclePool.provideResource();
        try {
            cubiclePool.recoverResource(new Cubicle());
        } catch (IllegalArgumentException e) {
            fail("recoverResource should've accepted correct object");
        } catch (TooManyResourcesException e) {
            fail("cubiclePool should've accepted new Cubicle since we emptied it");
        }
    }

}