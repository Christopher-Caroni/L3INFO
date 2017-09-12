package generics;

public class Carrot implements Vegetable, Cloneable {
    private String name;
    private static final String DEFAULT = "Carot";

    public Carrot (int i) {
	this.name = DEFAULT+"-"+i;
    }

    public String toString() { 
	return this.name;
    }

}
