package fil.coo.actions.interfaces;

import fil.coo.client.interfaces.ResourceUser;
import fil.coo.resource.pools.BasketPool;
import fil.coo.resource.pools.ResourcePool;
import org.junit.Before;

public abstract class ResourceUsingActionTest extends ActionTest {

    protected static final int NB_RESOURCES = 2;

    protected ResourceUser resourceUser;
    protected ResourcePool resourcePool;

    protected ResourceUsingAction resourceUsingAction;

    @Before
    public void setupResourceUsingAction() {
        resourceUser = new ResourceUser();
        resourcePool = new BasketPool(NB_RESOURCES);

        resourceUsingAction = createResourceUsingAction();
    }

    protected abstract ResourceUsingAction createResourceUsingAction();

}