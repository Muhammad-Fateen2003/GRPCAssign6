package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/woof.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WoofGrpc {

  private WoofGrpc() {}

  public static final String SERVICE_NAME = "services.Woof";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.WoofReq,
      service.WoofRes> getWoofMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "woof",
      requestType = service.WoofReq.class,
      responseType = service.WoofRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.WoofReq,
      service.WoofRes> getWoofMethod() {
    io.grpc.MethodDescriptor<service.WoofReq, service.WoofRes> getWoofMethod;
    if ((getWoofMethod = WoofGrpc.getWoofMethod) == null) {
      synchronized (WoofGrpc.class) {
        if ((getWoofMethod = WoofGrpc.getWoofMethod) == null) {
          WoofGrpc.getWoofMethod = getWoofMethod =
              io.grpc.MethodDescriptor.<service.WoofReq, service.WoofRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "woof"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.WoofReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.WoofRes.getDefaultInstance()))
              .setSchemaDescriptor(new WoofMethodDescriptorSupplier("woof"))
              .build();
        }
      }
    }
    return getWoofMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.GetWoofsReq,
      service.GetWoofsResp> getGetUsersWoofsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUsersWoofs",
      requestType = service.GetWoofsReq.class,
      responseType = service.GetWoofsResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.GetWoofsReq,
      service.GetWoofsResp> getGetUsersWoofsMethod() {
    io.grpc.MethodDescriptor<service.GetWoofsReq, service.GetWoofsResp> getGetUsersWoofsMethod;
    if ((getGetUsersWoofsMethod = WoofGrpc.getGetUsersWoofsMethod) == null) {
      synchronized (WoofGrpc.class) {
        if ((getGetUsersWoofsMethod = WoofGrpc.getGetUsersWoofsMethod) == null) {
          WoofGrpc.getGetUsersWoofsMethod = getGetUsersWoofsMethod =
              io.grpc.MethodDescriptor.<service.GetWoofsReq, service.GetWoofsResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUsersWoofs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.GetWoofsReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.GetWoofsResp.getDefaultInstance()))
              .setSchemaDescriptor(new WoofMethodDescriptorSupplier("getUsersWoofs"))
              .build();
        }
      }
    }
    return getGetUsersWoofsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.GetWoofsResp> getGetAllWoofsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllWoofs",
      requestType = com.google.protobuf.Empty.class,
      responseType = service.GetWoofsResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.GetWoofsResp> getGetAllWoofsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, service.GetWoofsResp> getGetAllWoofsMethod;
    if ((getGetAllWoofsMethod = WoofGrpc.getGetAllWoofsMethod) == null) {
      synchronized (WoofGrpc.class) {
        if ((getGetAllWoofsMethod = WoofGrpc.getGetAllWoofsMethod) == null) {
          WoofGrpc.getGetAllWoofsMethod = getGetAllWoofsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, service.GetWoofsResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllWoofs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.GetWoofsResp.getDefaultInstance()))
              .setSchemaDescriptor(new WoofMethodDescriptorSupplier("getAllWoofs"))
              .build();
        }
      }
    }
    return getGetAllWoofsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WoofStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WoofStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WoofStub>() {
        @java.lang.Override
        public WoofStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WoofStub(channel, callOptions);
        }
      };
    return WoofStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WoofBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WoofBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WoofBlockingStub>() {
        @java.lang.Override
        public WoofBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WoofBlockingStub(channel, callOptions);
        }
      };
    return WoofBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WoofFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WoofFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WoofFutureStub>() {
        @java.lang.Override
        public WoofFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WoofFutureStub(channel, callOptions);
        }
      };
    return WoofFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WoofImplBase implements io.grpc.BindableService {

    /**
     */
    public void woof(service.WoofReq request,
        io.grpc.stub.StreamObserver<service.WoofRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWoofMethod(), responseObserver);
    }

    /**
     */
    public void getUsersWoofs(service.GetWoofsReq request,
        io.grpc.stub.StreamObserver<service.GetWoofsResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUsersWoofsMethod(), responseObserver);
    }

    /**
     */
    public void getAllWoofs(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.GetWoofsResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllWoofsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWoofMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.WoofReq,
                service.WoofRes>(
                  this, METHODID_WOOF)))
          .addMethod(
            getGetUsersWoofsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.GetWoofsReq,
                service.GetWoofsResp>(
                  this, METHODID_GET_USERS_WOOFS)))
          .addMethod(
            getGetAllWoofsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                service.GetWoofsResp>(
                  this, METHODID_GET_ALL_WOOFS)))
          .build();
    }
  }

  /**
   */
  public static final class WoofStub extends io.grpc.stub.AbstractAsyncStub<WoofStub> {
    private WoofStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WoofStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WoofStub(channel, callOptions);
    }

    /**
     */
    public void woof(service.WoofReq request,
        io.grpc.stub.StreamObserver<service.WoofRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWoofMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsersWoofs(service.GetWoofsReq request,
        io.grpc.stub.StreamObserver<service.GetWoofsResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUsersWoofsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllWoofs(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.GetWoofsResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllWoofsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WoofBlockingStub extends io.grpc.stub.AbstractBlockingStub<WoofBlockingStub> {
    private WoofBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WoofBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WoofBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.WoofRes woof(service.WoofReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWoofMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.GetWoofsResp getUsersWoofs(service.GetWoofsReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUsersWoofsMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.GetWoofsResp getAllWoofs(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllWoofsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WoofFutureStub extends io.grpc.stub.AbstractFutureStub<WoofFutureStub> {
    private WoofFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WoofFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WoofFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.WoofRes> woof(
        service.WoofReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWoofMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.GetWoofsResp> getUsersWoofs(
        service.GetWoofsReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUsersWoofsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.GetWoofsResp> getAllWoofs(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllWoofsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WOOF = 0;
  private static final int METHODID_GET_USERS_WOOFS = 1;
  private static final int METHODID_GET_ALL_WOOFS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WoofImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WoofImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WOOF:
          serviceImpl.woof((service.WoofReq) request,
              (io.grpc.stub.StreamObserver<service.WoofRes>) responseObserver);
          break;
        case METHODID_GET_USERS_WOOFS:
          serviceImpl.getUsersWoofs((service.GetWoofsReq) request,
              (io.grpc.stub.StreamObserver<service.GetWoofsResp>) responseObserver);
          break;
        case METHODID_GET_ALL_WOOFS:
          serviceImpl.getAllWoofs((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<service.GetWoofsResp>) responseObserver);
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

  private static abstract class WoofBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WoofBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.WoofProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Woof");
    }
  }

  private static final class WoofFileDescriptorSupplier
      extends WoofBaseDescriptorSupplier {
    WoofFileDescriptorSupplier() {}
  }

  private static final class WoofMethodDescriptorSupplier
      extends WoofBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WoofMethodDescriptorSupplier(String methodName) {
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
      synchronized (WoofGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WoofFileDescriptorSupplier())
              .addMethod(getWoofMethod())
              .addMethod(getGetUsersWoofsMethod())
              .addMethod(getGetAllWoofsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
