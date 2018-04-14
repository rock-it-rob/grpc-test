package rob.proto.grpc.service.test.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rob.proto.grpc.service.DefaultEcho;
import rob.proto.grpc.service.Echo;

import static org.junit.Assert.*;

/**
 * EchoIT is an integration test for the {@link rob.proto.grpc.service.Echo}
 * service.
 *
 * @author rob
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EchoIT
{
    @Configuration
    @Import(DefaultEcho.class)
    static class Config
    {
    }

    @Autowired
    private Echo echo;

    /**
     * Validate default implementation works.
     */
    @Test
    public void testEcho()
    {
        String message = "test message";
        String result = echo.echo(message);
        assertNotNull(result);
        assertEquals(message, result);
    }



}
