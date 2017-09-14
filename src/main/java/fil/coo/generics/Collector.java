package fil.coo.generics;

/**
 * define collectors able to collect (and carry) one specific type T of objects
 * only one T object can be carried at a time
 */

public class Collector<T> {

    /**
     * The name of this instance
     */
    private String name;

    /**
     * The object carried of type T
     */
    private T carriedObject = null;

    /**
     * Default constructor
     *
     * @param name the name of this collector
     */
    public Collector(String name) {
        this.name = name;
    }


    /**
     * @return the name of this {@link Collector}
     */
    public String toString() {
        return this.name;
    }


    /**
     * @return the name of this collector and the carried object
     */
    public String description() {
        return this.name + " carries " + this.carriedObject;
    }

    /**
     * Takes an object of type T if not already carrying one else throw {@link AlreadyCarryingException}
     *
     * @param object the object to carry
     */
    public void take(T object) {
        if (carriedObject == null) {
            carriedObject = object;
        } else {
            throw new AlreadyCarryingException(this.description());
        }
    }

    /**
     * @return the carried object
     */
    public T getCarriedObject() {
        return carriedObject;
    }

    /**
     * Gives the carried object to otherCollector and sets this instance's to null.
     *
     * @param otherCollector the other collector that must be a super class of T
     */
    public void giveTo(Collector<? super T> otherCollector) {
        otherCollector.take(carriedObject);
        carriedObject = null;
    }

    /**
     * Same as {@link #take(Object)} but used in main()
     *
     * @param object the object to carry
     */
    private void collect(T object) {
        take(object);
    }

    /**
     * Drops the carried object.
     */
    public void drop() {
        carriedObject = null;
    }

    public static void main(String[] args) {

        Carrot c1 = new Carrot(1);
        Carrot c2 = new Carrot(2);
        Carrot c3 = new Carrot(3);
        Apple p1 = new Apple(1);
        Apple p2 = new Apple(2);

        Collector<Carrot> carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
        Collector<Carrot> carrotCollector2 = new Collector<Carrot>("carrot-collector-2");
        Collector<Apple> appleCollector1 = new Collector<Apple>("apple-collector-1");

        // attention ici le type d'objets ramasses est Legume :
        Collector<Vegetable> vegetableCollector = new Collector<Vegetable>("vegetable-collector");

        carrotCollector1.take(c3);
        System.out.println(carrotCollector1.description());
        // NE COMPILE PAS
        // carrotCollector2.take(p1);

        // NE COMPILE PAS
        // carrotCollector1.giveTo(appleCollector1);

        // COMPILE :
        carrotCollector1.giveTo(vegetableCollector);

        // NE COMPILE PAS
        // vegetableCollector.giveTo(carrotCollector1);
        // NE COMPILE PAS
        // appleCollector1.giveTo(vegetableCollector);

        carrotCollector1.collect(c1);
        carrotCollector1.giveTo(carrotCollector2);
        System.out.println(carrotCollector1.description());
        System.out.println(carrotCollector2.description());
        carrotCollector1.collect(c2);


        try {
            carrotCollector1.giveTo(carrotCollector2);
        } catch (AlreadyCarryingException e) {
            //System.out.println("*** exception : " + carrotCollector2 + " porte deja qque chose");
            System.out.println(" * " + e.getMessage());
        }

        appleCollector1.collect(p2);
        System.out.println(appleCollector1.description());
        try {
            appleCollector1.collect(p1);
        } catch (AlreadyCarryingException e) {
            //System.out.println("*** exception : " + appleCollector1 + " porte deja qque chose");
            System.out.println(" * " + e.getMessage());
        }
        appleCollector1.drop();
        System.out.println(appleCollector1.description());
        appleCollector1.collect(p1);

    }
}
