package fil.coo.resources.resource;

import static org.junit.Assert.*;

import fil.coo.resources.resource.Basket;
import org.junit.Test;

public class BasketTest {

	@Test
	public void testDescription() {
		assertEquals("Basket", new Basket().description());
	}

}
