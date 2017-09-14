package fil.coo.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class CollectorTest {


    @Test
    public void description() {
        String name = "carrotCollector 1";
        Collector<Carrot> carrotCollector = new Collector<>(name);

        assertEquals(name + " carries null", carrotCollector.description());

        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        assertEquals(name + " carries Carrot-0", carrotCollector.description());

    }

    @Test
    public void testTakeAndGetCarriedObject() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        assertNull(carrotCollector.getCarriedObject());

        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        assertNotNull(carrotCollector.getCarriedObject());
    }


    @Test
    public void testGiveTo() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        Collector<Vegetable> vegetableCollector = new Collector<>("vegetableCollector 1");

        carrotCollector.giveTo(vegetableCollector);

        assertSame(carrot, vegetableCollector.getCarriedObject());
    }

    @Test(expected=AlreadyCarryingException.class)
    public void testGiveToAlreadyCarrying() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        Collector<Vegetable> vegetableCollector = new Collector<>("vegetableCollector 1");

        carrotCollector.giveTo(vegetableCollector);

        carrotCollector.giveTo(vegetableCollector);

    }


    @Test
    public void drop() throws Exception {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        assertNull(carrotCollector.getCarriedObject());

        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);
        assertSame(carrot, carrotCollector.getCarriedObject());

        carrotCollector.drop();
        assertNull(carrotCollector.getCarriedObject());
    }

}