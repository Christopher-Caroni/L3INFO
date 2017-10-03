package fil.coo.resource;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CubicleTest {

    @Test
    public void description() throws Exception {
        Assert.assertEquals(Cubicle.DESC, new Cubicle().description());
    }

}