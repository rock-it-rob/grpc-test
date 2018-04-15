package rob.proto.grpc;

import org.springframework.context.support.GenericXmlApplicationContext;
import rob.proto.grpc.client.GrpcClient;

/**
 * Launches the client and sends a test message.
 *
 * @author rob
 */
public class Start
{
    private static final String SPRING_XML = "classpath:client-spring.xml";

    public static void main(String[] args)
    {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext(SPRING_XML);
        GrpcClient grpcClient = applicationContext.getBean(GrpcClient.class);
        final String message = "Testing 1, 2, 3";
        System.out.println(String.format("Sending message '%s'", message));
        final String result = grpcClient.echo(message);
        System.out.println(String.format("Received: '%s'", result));
    }
}
