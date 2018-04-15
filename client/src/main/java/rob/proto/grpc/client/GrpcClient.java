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
     * Calls the echo remote service and returns its result.
     *
     * @param message String
     * @return String result of the remote service call.
     */
    String echo(String message);
}
