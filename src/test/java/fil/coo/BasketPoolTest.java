package fil.coo;

import org.junit.Test;

public class BasketPoolTest {

	
	@Test (expected= IllegalArgumentException.class)
	public void testRecoverResourceException() throws Exception{
		new BasketPool(5).recoverResource(null);
	}


}
