package rob.proto.grpc;

import org.springframework.context.support.GenericXmlApplicationContext;
import rob.proto.grpc.server.GrpcServer;

import java.io.IOException;

/**
 * Start is the main entry point for the application.
 *
 * @author rob
 */
public class Start
{
    private static final String SPRING_XML = "classpath:server-spring.xml";

    public static void main(String[] args) throws IOException, InterruptedException
    {
        try (
                GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext(SPRING_XML);
        )
        {
            GrpcServer grpcServer = applicationContext.getBean(GrpcServer.class);
            grpcServer.start();
        }
    }
}
