package rob.proto.grpc.server;

import java.io.IOException;

/**
 * GrpcServer defines the business interface for running a gRPC server.
 *
 * @author rob
 */
public interface GrpcServer
{
    /**
     * Starts the gRPC server.
     *
     * @throws IOException
     * @throws InterruptedException
     */
    void start() throws IOException, InterruptedException;

    /**
     * Stops the gRPC server.
     */
    void stop();
}
