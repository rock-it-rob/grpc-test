package rob.proto.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rob.proto.grpc.api.EchoApi;
import rob.proto.grpc.api.EchoServiceGrpc;
import rob.proto.grpc.service.Echo;

import java.io.IOException;

/**
 * GrpcServerImpl runs a gRPC server.
 *
 * @author rob
 */
public class GrpcServerImpl implements GrpcServer
{
    private static final Logger log = LoggerFactory.getLogger(GrpcServerImpl.class);

    private final int port;
    private final Server server;

    @Autowired
    private Echo echo;

    /**
     * Create a new instance
     *
     * @param port int port to run the server on.
     */
    public GrpcServerImpl(int port)
    {
        this.port = port;
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        server = serverBuilder.addService(new EchoService()).build();
    }

    @Override
    public void start() throws IOException, InterruptedException
    {
        server.start();
        log.info("Server started on port: " + port);

        // Set up a clean shutdown.
        Runtime.getRuntime().addShutdownHook(
            new Thread(() -> stop())
        );

        server.awaitTermination();
    }

    @Override
    public void stop()
    {
        log.info("Stopping gRPC server.");
        server.shutdown();
    }

    /**
     * EchoService does the heavy lifting.
     * <p>
     * NOTE: this class was originally defined as a private, static, inner
     * class in the example. Other examples had it created as an anonymous
     * class. Using it as a static class makes using spring beans a little
     * harder.
     */
    private class EchoService extends EchoServiceGrpc.EchoServiceImplBase
    {
        @Override
        public void echo(EchoApi.EchoRequest request, StreamObserver<EchoApi.EchoResponse> responseObserver)
        {
            String r = request.getContent();
            String sendBack = echo.echo(r);
            EchoApi.EchoResponse echoResponse = EchoApi.EchoResponse
                .newBuilder().setContent(sendBack).build();
            responseObserver.onNext(echoResponse);
            responseObserver.onCompleted();
        }
    }
}
