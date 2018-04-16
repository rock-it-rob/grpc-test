package rob.proto.grpc.client;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rob.proto.grpc.api.EchoApi;
import rob.proto.grpc.api.EchoServiceGrpc;

import java.util.concurrent.TimeUnit;

/**
 * AsyncGrpcClient uses an asynchronous stub to call the gRPC server.
 * @author Rob Benton
 */
public class AsyncGrpcClient extends GrpcClientImpl
{
    private static final Logger log = LoggerFactory.getLogger(AsyncGrpcClient.class);

    private final EchoServiceGrpc.EchoServiceStub stub;

    public AsyncGrpcClient(String hostname, int port)
    {
        super(hostname, port);
        stub = EchoServiceGrpc.newStub(channel);
    }

    @Override
    public void echoAsync(String message)
    {
        EchoApi.EchoRequest echoRequest = EchoApi.EchoRequest
                .newBuilder().setContent(message).build();
        stub.echo(echoRequest, new StreamObserver<EchoApi.EchoResponse>()
        {
            @Override
            public void onNext(EchoApi.EchoResponse echoResponse)
            {
                System.out.println("Received: " + echoResponse.getContent());
            }

            @Override
            public void onError(Throwable throwable)
            {
                throw new RuntimeException(throwable);
            }

            @Override
            public void onCompleted()
            {
            }
        });
    }

    @Override
    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
