package fil.coo.actions.interfaces;

import fil.coo.client.interfaces.ResourceUser;
import fil.coo.resource.Basket;
import fil.coo.resource.pools.BasketPool;
import fil.coo.resource.pools.ResourcePool;
import org.junit.Before;

public abstract class ResourceUsingActionTest extends SingleActionStepTest {

    protected static final int NB_RESOURCES = 2;

    protected ResourceUser<Basket> resourceUser;
    protected ResourcePool<Basket> resourcePool;

    protected ResourceUsingAction<Basket> resourceUsingAction;

    @Before
    public void setupResourceUsingAction() {
        if (this.resourceUsingAction == null) {
            initFields();
            this.resourceUsingAction = this.createResourceUsingAction();
        }
    }

    private void initFields() {
        resourceUser = new ResourceUser<>();
        resourcePool = new BasketPool(NB_RESOURCES);
    }

    protected abstract ResourceUsingAction<Basket> createResourceUsingAction();

    @Override
    protected Action createAction() {
        if (this.resourceUsingAction == null) {
            this.setupResourceUsingAction();
        }
        return this.resourceUsingAction;
    }

}