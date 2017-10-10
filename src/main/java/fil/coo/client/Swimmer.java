package fil.coo.client;

import fil.coo.actions.scheduler.SequentialScheduler;
import fil.coo.client.interfaces.ResourceUser;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;

public class Swimmer extends SequentialScheduler {

    private ResourceUser<Basket> basketResourceUser;
    private ResourceUser<Cubicle> cubicleResourceUser;


}
