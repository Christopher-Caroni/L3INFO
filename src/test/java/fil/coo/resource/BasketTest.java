package fil.coo.resource;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasketTest {

	@Test
	public void testDescription() {
		assertEquals("Basket", new Basket().description());
	}

}
