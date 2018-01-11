package fil.coo.resources.client;

import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.resource.Basket;
import fil.coo.resources.pools.BasketPool;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResourceUserTest {

    private static final int NB_RESOURCES = 2;

    private BasketPool basketPool;
    private ResourceUser<Basket> resourceUser;

    @Before
    public void setupResources() {
        basketPool = new BasketPool(NB_RESOURCES);
        resourceUser = new ResourceUser<>();
    }

    @Test
    public void testGetSetResource() throws NoFreeResourcesException, TooManyResourcesException {
        assertNull(resourceUser.getResource());

        Basket basket = basketPool.provideResource();
        resourceUser.setResource(basket);
        assertSame(basket, resourceUser.getResource());
    }

    @Test(expected = TooManyResourcesException.class)
    public void testSetResourceWhenAlreadyHasOneThrowsException() throws NoFreeResourcesException, TooManyResourcesException {
        assertNull(resourceUser.getResource());

        Basket basket = basketPool.provideResource();
        resourceUser.setResource(basket);

        resourceUser.setResource(new Basket());
    }

    @Test
    public void resetResource() throws Exception {
        assertNull(resourceUser.getResource());

        Basket basket = basketPool.provideResource();
        resourceUser.setResource(basket);
        assertSame(basket, resourceUser.getResource());

        resourceUser.resetResource();
        assertNull(resourceUser.getResource());
    }

}