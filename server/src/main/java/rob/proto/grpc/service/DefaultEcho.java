package rob.proto.grpc.service;

/**
 * @author rob
 */
public class DefaultEcho implements Echo
{
    @Override
    public String echo(String text)
    {
        return text;
    }
}
