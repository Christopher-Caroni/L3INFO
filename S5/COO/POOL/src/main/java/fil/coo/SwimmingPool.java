package fil.coo;

import fil.coo.actions.scheduler.FairScheduler;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;
import fil.coo.resources.client.Swimmer;
import fil.coo.resources.pools.BasketPool;
import fil.coo.resources.pools.CubiclePool;

public class SwimmingPool {

    public static void main(String[] args) throws ActionFinishedException, SchedulerStartedException {
        BasketPool baskets = new BasketPool(6);
        CubiclePool cubicles = new CubiclePool(3);
        FairScheduler s = new FairScheduler();

        s.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
        s.addAction(new Swimmer("Loïs", baskets, cubicles, 2, 10, 4));
        s.addAction(new Swimmer("Maé", baskets, cubicles, 10, 18, 10));
        s.addAction(new Swimmer("Ange", baskets, cubicles, 3, 7, 5));
        s.addAction(new Swimmer("Louison", baskets, cubicles, 18, 3, 3));
        s.addAction(new Swimmer("Charlie", baskets, cubicles, 3, 6, 10));
        s.addAction(new Swimmer("Alexis", baskets, cubicles, 6, 5, 7));

        int nbSteps = 0;
        while (!s.isFinished()) {
            nbSteps++;
            s.doStep();
        }

        System.out.println("Finished in " + nbSteps + " steps");
    }

}
