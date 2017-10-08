package fil.coo.resource.pools;

import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public abstract class ResourcePoolTest {

    ResourcePool resourcePool;

    /**
     * Initialises the {@link #resourcePool} with one resource.
     */
    @Before
    public void initResourcePool() {
        resourcePool = getResourcePool(1);
    }

    /**
     * @param i the number of resources to create the {@link ResourcePool} with
     * @return a {@link ResourcePool} of the type implemented in the sub Test class.
     */
    protected abstract ResourcePool getResourcePool(int i);

    protected abstract Resource getOneResource();

    /**
     * Asserts that using the constructor with a 0 value throws {@link IllegalArgumentException}
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWith0ThrowsException() {
        ResourcePool badResource = getResourcePool(0);
    }

    /**
     * Asserts that using the constructor with a negative value throws {@link IllegalArgumentException}
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeValueThrowsException() {
        ResourcePool badResource = getResourcePool(-10);
    }

    /**
     * Asserts that using the constructor with a positive value does NOT throw {@link IllegalArgumentException}
     */
    @Test
    public void testConstructorWithPositiveValueThrowsException() {
        try {
            ResourcePool resourcePool = getResourcePool(10);
        } catch (IllegalArgumentException e) {
            fail("This instantiation should not have failed with a positive value");
        }
    }

    /**
     * Asserts that {@link ResourcePool#createOneResource()} returns a non null object
     */
    @Test
    public void testCreateOneResourceGiveNonNull() {
        assertNotNull(resourcePool.createOneResource());
    }

    @Test(expected = NoFreeResourcesException.class)
    public void testProvideResourceWithoutResourcesThrowsException() throws NoFreeResourcesException {
        try {
            Resource firstResource = resourcePool.provideResource(); // empty the pools
        } catch (NoFreeResourcesException e) {
            e.printStackTrace();
            fail("Should succeed");
        }
        Resource badResource = resourcePool.provideResource(); // throws because pools is empty

    }

    @Test
    public void testProvideResourceWithResourcesGiveNonNull() {
        Resource firstResource = null;
        try {
            firstResource = resourcePool.provideResource();
        } catch (NoSuchElementException e) {
            fail("We should get the first resource here");
        } catch (fil.coo.exception.NoFreeResourcesException e) {
            e.printStackTrace();
        }
        assertNotNull(firstResource);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecoverResourceWithNullThrowsException() throws TooManyResourcesException, ForeignResourceException {
        resourcePool.recoverResource(null);
    }

    @Test(expected = TooManyResourcesException.class)
    public void testRecoverResourceAlreadyFullThrowsException() throws TooManyResourcesException, ForeignResourceException {
        resourcePool.recoverResource(getOneResource());
    }

    @Test
    public void testRecoverResourceWithOriginalDoesNotThrow() throws ForeignResourceException {
        Resource firstResource = null;
        try {
            firstResource = resourcePool.provideResource();
        } catch (fil.coo.exception.NoFreeResourcesException e) {
            e.printStackTrace();
        }
        try {
            resourcePool.recoverResource(firstResource);
        } catch (TooManyResourcesException e) {
            fail("Should not have thrown exception since list should've been empty, and we provide non null resource");
        }
    }

    @Test(expected = ForeignResourceException.class)
    public void testRecoverForgeinResourceThrowsException() throws ForeignResourceException, TooManyResourcesException {
        try {
            Resource firstResource = resourcePool.provideResource();
        } catch (fil.coo.exception.NoFreeResourcesException e) {
            e.printStackTrace();
        }
        // resource has one free slot
        Resource badResource = getOneResource();
        resourcePool.recoverResource(badResource);
    }

}