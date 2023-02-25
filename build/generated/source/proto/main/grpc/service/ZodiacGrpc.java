package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/zodiac.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ZodiacGrpc {

  private ZodiacGrpc() {}

  public static final String SERVICE_NAME = "services.Zodiac";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.SignRequest,
      service.SignResponse> getSignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sign",
      requestType = service.SignRequest.class,
      responseType = service.SignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.SignRequest,
      service.SignResponse> getSignMethod() {
    io.grpc.MethodDescriptor<service.SignRequest, service.SignResponse> getSignMethod;
    if ((getSignMethod = ZodiacGrpc.getSignMethod) == null) {
      synchronized (ZodiacGrpc.class) {
        if ((getSignMethod = ZodiacGrpc.getSignMethod) == null) {
          ZodiacGrpc.getSignMethod = getSignMethod =
              io.grpc.MethodDescriptor.<service.SignRequest, service.SignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.SignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.SignResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZodiacMethodDescriptorSupplier("sign"))
              .build();
        }
      }
    }
    return getSignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.FindRequest,
      service.FindResponse> getFindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "find",
      requestType = service.FindRequest.class,
      responseType = service.FindResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.FindRequest,
      service.FindResponse> getFindMethod() {
    io.grpc.MethodDescriptor<service.FindRequest, service.FindResponse> getFindMethod;
    if ((getFindMethod = ZodiacGrpc.getFindMethod) == null) {
      synchronized (ZodiacGrpc.class) {
        if ((getFindMethod = ZodiacGrpc.getFindMethod) == null) {
          ZodiacGrpc.getFindMethod = getFindMethod =
              io.grpc.MethodDescriptor.<service.FindRequest, service.FindResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "find"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.FindRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.FindResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZodiacMethodDescriptorSupplier("find"))
              .build();
        }
      }
    }
    return getFindMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ZodiacStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZodiacStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZodiacStub>() {
        @java.lang.Override
        public ZodiacStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZodiacStub(channel, callOptions);
        }
      };
    return ZodiacStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ZodiacBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZodiacBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZodiacBlockingStub>() {
        @java.lang.Override
        public ZodiacBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZodiacBlockingStub(channel, callOptions);
        }
      };
    return ZodiacBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ZodiacFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZodiacFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZodiacFutureStub>() {
        @java.lang.Override
        public ZodiacFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZodiacFutureStub(channel, callOptions);
        }
      };
    return ZodiacFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ZodiacImplBase implements io.grpc.BindableService {

    /**
     */
    public void sign(service.SignRequest request,
        io.grpc.stub.StreamObserver<service.SignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSignMethod(), responseObserver);
    }

    /**
     */
    public void find(service.FindRequest request,
        io.grpc.stub.StreamObserver<service.FindResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSignMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.SignRequest,
                service.SignResponse>(
                  this, METHODID_SIGN)))
          .addMethod(
            getFindMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.FindRequest,
                service.FindResponse>(
                  this, METHODID_FIND)))
          .build();
    }
  }

  /**
   */
  public static final class ZodiacStub extends io.grpc.stub.AbstractAsyncStub<ZodiacStub> {
    private ZodiacStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZodiacStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZodiacStub(channel, callOptions);
    }

    /**
     */
    public void sign(service.SignRequest request,
        io.grpc.stub.StreamObserver<service.SignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void find(service.FindRequest request,
        io.grpc.stub.StreamObserver<service.FindResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ZodiacBlockingStub extends io.grpc.stub.AbstractBlockingStub<ZodiacBlockingStub> {
    private ZodiacBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZodiacBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZodiacBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.SignResponse sign(service.SignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.FindResponse find(service.FindRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ZodiacFutureStub extends io.grpc.stub.AbstractFutureStub<ZodiacFutureStub> {
    private ZodiacFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZodiacFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZodiacFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.SignResponse> sign(
        service.SignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.FindResponse> find(
        service.FindRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIGN = 0;
  private static final int METHODID_FIND = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ZodiacImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ZodiacImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIGN:
          serviceImpl.sign((service.SignRequest) request,
              (io.grpc.stub.StreamObserver<service.SignResponse>) responseObserver);
          break;
        case METHODID_FIND:
          serviceImpl.find((service.FindRequest) request,
              (io.grpc.stub.StreamObserver<service.FindResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ZodiacBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ZodiacBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.ZodiacProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Zodiac");
    }
  }

  private static final class ZodiacFileDescriptorSupplier
      extends ZodiacBaseDescriptorSupplier {
    ZodiacFileDescriptorSupplier() {}
  }

  private static final class ZodiacMethodDescriptorSupplier
      extends ZodiacBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ZodiacMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ZodiacGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ZodiacFileDescriptorSupplier())
              .addMethod(getSignMethod())
              .addMethod(getFindMethod())
              .build();
        }
      }
    }
    return result;
  }
}
