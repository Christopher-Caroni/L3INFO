package fil.coo.resources.pools;

import fil.coo.exception.DuplicateRecoveryException;
import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.resource.interfaces.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public abstract class ResourcePoolTest {

    private final static int NB_RESOURCES = 2;

    protected ResourcePool<Resource> resourcePool;

    /**
     * Initialises the {@link #resourcePool} with one resource.
     */
    @Before
    public void initResourcePool() {
        resourcePool = getResourcePool(NB_RESOURCES);
    }

    /**
     * @param i the number of resources to create the {@link ResourcePool} with
     * @return a {@link ResourcePool} of the type implemented in the sub Test class.
     */
    protected abstract ResourcePool<Resource> getResourcePool(int i);

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
        // empty the pool
        for (int i = 0; i < NB_RESOURCES; i++) {
            resourcePool.provideResource();
        }

        Resource badResource = resourcePool.provideResource(); // throws because pools is empty
    }

    @Test
    public void testProvideResourceWithResourcesGiveNonNull() throws NoFreeResourcesException {
        Resource firstResource = resourcePool.provideResource();
        assertNotNull(firstResource);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecoverResourceWithNullThrowsException() throws TooManyResourcesException, ForeignResourceException, DuplicateRecoveryException {
        resourcePool.recoverResource(null);
    }

    /**
     * Make sure {@link ResourcePool#recoverResource(Resource)} throws {@link TooManyResourcesException} when already full
     *
     * @throws TooManyResourcesException if the pool is already full
     * @throws ForeignResourceException  if the object being recovered did not originate from the pool
     */
    @Test(expected = TooManyResourcesException.class)
    public void testRecoverResourceAlreadyFullThrowsException() throws TooManyResourcesException, ForeignResourceException, DuplicateRecoveryException {
        resourcePool.recoverResource(getOneResource());
    }

    @Test
    public void testRecoverResourceWithOriginalDoesNotThrow() throws NoFreeResourcesException {
        Resource firstResource = resourcePool.provideResource();

        try {
            resourcePool.recoverResource(firstResource);
        } catch (TooManyResourcesException | ForeignResourceException | DuplicateRecoveryException e) {
            fail("Should not have thrown exception since list should've been empty, and we provide non null resource");
        }
    }

    @Test(expected = ForeignResourceException.class)
    public void testRecoverForeignResourceThrowsException() throws ForeignResourceException, TooManyResourcesException, NoFreeResourcesException, DuplicateRecoveryException {
        Resource firstResource = resourcePool.provideResource();

        // resource has one free slot
        Resource badResource = getOneResource();
        resourcePool.recoverResource(badResource); // throws ForeignResourceException
    }

    @Test(expected = DuplicateRecoveryException.class)
    public void testCannotRecoverResourceTwice() throws NoFreeResourcesException, ForeignResourceException, TooManyResourcesException, DuplicateRecoveryException {

        // free two slots from the pool so we can try to recover the same object twice
        Resource firstResource = resourcePool.provideResource();
        Resource secondResource = resourcePool.provideResource();

        try {
            resourcePool.recoverResource(firstResource);
        } catch (TooManyResourcesException | DuplicateRecoveryException | ForeignResourceException e) {
            fail("No reason to fail here");
        }

        try {
            resourcePool.recoverResource(firstResource);
        } catch (TooManyResourcesException | DuplicateRecoveryException | ForeignResourceException e) {
            // expected
            throw (e);
        }
    }

}