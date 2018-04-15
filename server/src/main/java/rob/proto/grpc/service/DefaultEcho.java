package rob.proto.grpc.service;

/**
 * @author rob
 */
public class DefaultEcho implements Echo
{
    /**
     * Prefixes the passed in string with 'echo: '.
     *
     * @param text String
     * @return String
     */
    @Override
    public String echo(String text)
    {
        return "echo: " + text;
    }
}
