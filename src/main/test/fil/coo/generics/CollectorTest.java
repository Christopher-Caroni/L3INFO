package fil.coo.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class CollectorTest {


    /**
     * Tests that {@link Collector#description()} returns a proper string with and without an object.
     */
    @Test
    public void testDescription() {
        String name = "carrotCollector 1";
        Collector<Carrot> carrotCollector = new Collector<>(name);

        assertEquals(name + " carries null", carrotCollector.description());

        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        assertEquals(name + " carries Carrot-0", carrotCollector.description());

    }

    /**
     * Tests {@link Collector#take(Object)} and {@link Collector#getCarriedObject()} with and without objects.
     */
    @Test
    public void testTakeAndGetCarriedObject() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        assertNull(carrotCollector.getCarriedObject());

        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        assertNotNull(carrotCollector.getCarriedObject());
    }

    /**
     * Tests that {@link Collector#take(Object)} throws {@link AlreadyCarryingException}.
     */
    @Test(expected = AlreadyCarryingException.class)
    public void testTakeAlreadyCarrying() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");

        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        carrotCollector.take(carrot);
    }


    /**
     * Tests that {@link Collector#giveTo(Collector)} correctly transfers the object by comparing the reference of the object.
     */
    @Test
    public void testGiveTo() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        Collector<Vegetable> vegetableCollector = new Collector<>("vegetableCollector 1");

        carrotCollector.giveTo(vegetableCollector);

        assertSame(carrot, vegetableCollector.getCarriedObject());
    }

    /**
     * Tests that {@link Collector#giveTo(Collector)} throws {@link AlreadyCarryingException} if the receiving object already has one.
     */
    @Test(expected = AlreadyCarryingException.class)
    public void testGiveToAlreadyCarrying() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);

        Collector<Vegetable> vegetableCollector = new Collector<>("vegetableCollector 1");

        carrotCollector.giveTo(vegetableCollector);

        carrotCollector.giveTo(vegetableCollector);

    }


    /**
     * Tests that {@link Collector#drop()} correctly removes a carried object.
     */
    @Test
    public void drop() {
        Collector<Carrot> carrotCollector = new Collector<>("carrotCollector 1");
        assertNull(carrotCollector.getCarriedObject());

        Carrot carrot = new Carrot(0);
        carrotCollector.take(carrot);
        assertSame(carrot, carrotCollector.getCarriedObject());

        carrotCollector.drop();
        assertNull(carrotCollector.getCarriedObject());
    }

}