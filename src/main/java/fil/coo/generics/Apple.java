package generics;

public class Apple implements Fruit {
	private String name;
	private static final String DEFAULT = "Apple";

	public Apple(int i) {
		this.name = DEFAULT + "-" + i;
	}

	public String toString() {
		return this.name;
	}

}
