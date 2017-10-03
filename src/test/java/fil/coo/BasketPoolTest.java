package fil.coo;

import org.junit.Test;

public class BasketPoolTest {

	@Test
	public void provideRessourceException() throws Exception{
		new BasketPool(0).provideResource();
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testRecoverResourceException() throws Exception{
		new BasketPool(5).recoverResource(null);
	}
	
	@Test
	public void testRecoverResourceWithOneElement() throws Exception{
		new BasketPool(1).recoverResource(null);
	}

}
