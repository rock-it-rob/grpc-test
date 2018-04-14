package rob.proto.grpc.service;

/**
 * Echo defines the business interface for the echo service.
 *
 * @author rob
 */
public interface Echo
{
    /**
     * Simple service method returning the string passed in.
     *
     * @param text String
     * @return String
     */
    String echo(String text);
}
