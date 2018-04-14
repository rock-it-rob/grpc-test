# GRPC Test

This project is a testbed for testing client-server connections using [grpc][1].

## Server

The server module contains the server.

### Generating protobuf Classes and Service Classes

Use the documented maven plugin execute the `protobuf:compile` and
`protbuf:compile-custom` goals.

## Client

The client module contains the client.

## Protocol Buffers

Based on the recommendation on the [grpc site][2] I am using proto3 version
of the protocol buffers. Check the main site for more info on
[protocol buffers][3].

## Notes on Code Generation Using protoc

I'm not quite sure how the code generation fits into the maven build
lifecycle. If you rely on the code to be generated at compile time then
you have no source to reference as you develop other classes that
interact with that generated code. At first attempt it seems a better
approach to generate the source classes outside of the build lifecycle and
add them to the standard source locations.

[1]: https://grpc.io
[2]: https://grpc.io/docs/guides/index.html
[3]: https://developers.google.com/protocol-buffers/docs/overview