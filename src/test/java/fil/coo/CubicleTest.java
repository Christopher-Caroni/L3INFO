package fil.coo;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CubicleTest {

    @Test
    public void description() throws Exception {
        assertEquals(Cubicle.DESC, new Cubicle().description());
    }

}