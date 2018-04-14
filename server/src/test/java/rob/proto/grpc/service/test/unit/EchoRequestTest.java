package rob.proto.grpc.service.test.unit;

import org.junit.Test;
import rob.proto.grpc.api.EchoApi;

import static org.junit.Assert.*;

/**
 * @author rob
 */
public class EchoRequestTest
{
    /**
     * Test creating a protobuf message request instance.
     */
    @Test
    public void testMessageRequest()
    {
        String c = "test content";
        EchoApi.EchoRequest echoRequest = EchoApi.EchoRequest.newBuilder().setContent(c).build();
        String result = echoRequest.getContent();
        assertNotNull(result);
        assertEquals(c, result);
    }

    /**
     * Test creating a protobuf message response instance.
     */
    @Test
    public void testMessageResponse()
    {
        String c = "test response";
        EchoApi.EchoResponse echoResponse = EchoApi.EchoResponse.newBuilder().setContent(c).build();
        String result = echoResponse.getContent();
        assertNotNull(result);
        assertEquals(c, result);
    }
}
