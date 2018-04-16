package rob.proto.grpc.client;

/**
 * GrpcClient defines the interface for a client to the GrpcServer defined in
 * the server module.
 *
 * @author rob
 */
public interface GrpcClient
{
    /**
     * Calls the echo remote service and returns its result. This is a blocking, synchronous call.
     *
     * @param message String
     * @return String result of the remote service call.
     */
    String echo(String message);

    /**
     * Calls the echo remote service asynchronously. No value is returned.
     * @param message String
     */
    void echoAsync(String message);

    /**
     * Called when done with this instance. Spring will call this automatically.
     *
     * @throws InterruptedException
     */
    void shutdown() throws InterruptedException;
}
