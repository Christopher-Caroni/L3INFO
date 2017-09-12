package generics;

public class Cauliflower implements Vegetable, Cloneable {
	private String name;
	private static final String DEFAULT = "Cauliflower";

	public Cauliflower(int i) {
		this.name = DEFAULT + "-" + i;
	}

	public String toString() {
		return this.name;
	}

}
