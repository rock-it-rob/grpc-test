package rob.proto.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rob.proto.grpc.api.EchoApi;
import rob.proto.grpc.api.EchoServiceGrpc;

import java.util.concurrent.TimeUnit;

/**
 * GrpcClientImpl is the implementation of the {@link GrpcClient}.
 *
 * @author rob
 */
public class GrpcClientImpl implements GrpcClient
{
    private final Logger log = LoggerFactory.getLogger(GrpcClientImpl.class);

    protected final String serverHostname;
    protected final int serverPort;
    protected final ManagedChannel channel;
    protected final EchoServiceGrpc.EchoServiceBlockingStub blockingStub;

    /**
     * Construct a new instance from the hostname and port of the grpc server.
     *
     * @param hostname String hostname where the gRPC server resides
     * @param port     int port on the host where the gRPC server resides
     */
    public GrpcClientImpl(String hostname, int port)
    {
        serverHostname = hostname;
        serverPort = port;
        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress(
            serverHostname, serverPort
        );
        channel = channelBuilder.usePlaintext().build();
        log.info(String.format("Channel created for: %s:%d", serverHostname, serverPort));
        blockingStub = EchoServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public String echo(String message)
    {
        EchoApi.EchoRequest echoRequest = EchoApi.EchoRequest
            .newBuilder().setContent(message).build();
        EchoApi.EchoResponse echoResponse = blockingStub.echo(echoRequest);

        return echoResponse.getContent();
    }

    @Override
    public void echoAsync(String message)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
