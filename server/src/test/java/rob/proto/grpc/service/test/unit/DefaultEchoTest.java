package rob.proto.grpc.service.test.unit;

import org.junit.Before;
import org.junit.Test;
import rob.proto.grpc.service.DefaultEcho;

import static org.junit.Assert.*;

/**
 * @author rob
 */
public class DefaultEchoTest
{
    private DefaultEcho defaultEcho;

    @Before
    public void before()
    {
        defaultEcho = new DefaultEcho();
    }

    @Test
    public void testDefault()
    {
        String t = "test";
        String result = defaultEcho.echo(t);
        assertNotNull(result);
        assertEquals("echo: " + t, result);
    }
}
