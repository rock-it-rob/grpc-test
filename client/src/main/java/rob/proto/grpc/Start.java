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

    private static final int CALLS = 100;

    public static void main(String[] args)
    {
        try (
                GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext(SPRING_XML);
        )
        {
            GrpcClient grpcClient = applicationContext.getBean(GrpcClient.class);
            Start start = new Start(grpcClient);

            for (int i = 0; i < CALLS; ++i)
            {
                final String message = "Sending call " + i;
                System.out.println("Sending message: " + message);
                final String result = start.sendEcho(message);
                System.out.println("Received message: " + result);
            }
        }
    }

    private final GrpcClient grpcClient;

    private Start(GrpcClient grpcClient)
    {
        this.grpcClient = grpcClient;
    }

    private String sendEcho(String message)
    {
        return grpcClient.echo(message);
    }
}
