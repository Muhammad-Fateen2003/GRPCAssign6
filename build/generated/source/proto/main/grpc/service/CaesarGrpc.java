package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/password.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CaesarGrpc {

  private CaesarGrpc() {}

  public static final String SERVICE_NAME = "services.Caesar";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.SaveReq,
      service.SaveRes> getEncryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "encrypt",
      requestType = service.SaveReq.class,
      responseType = service.SaveRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.SaveReq,
      service.SaveRes> getEncryptMethod() {
    io.grpc.MethodDescriptor<service.SaveReq, service.SaveRes> getEncryptMethod;
    if ((getEncryptMethod = CaesarGrpc.getEncryptMethod) == null) {
      synchronized (CaesarGrpc.class) {
        if ((getEncryptMethod = CaesarGrpc.getEncryptMethod) == null) {
          CaesarGrpc.getEncryptMethod = getEncryptMethod =
              io.grpc.MethodDescriptor.<service.SaveReq, service.SaveRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "encrypt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.SaveReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.SaveRes.getDefaultInstance()))
              .setSchemaDescriptor(new CaesarMethodDescriptorSupplier("encrypt"))
              .build();
        }
      }
    }
    return getEncryptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.PasswordReq,
      service.PasswordRes> getDecryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "decrypt",
      requestType = service.PasswordReq.class,
      responseType = service.PasswordRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.PasswordReq,
      service.PasswordRes> getDecryptMethod() {
    io.grpc.MethodDescriptor<service.PasswordReq, service.PasswordRes> getDecryptMethod;
    if ((getDecryptMethod = CaesarGrpc.getDecryptMethod) == null) {
      synchronized (CaesarGrpc.class) {
        if ((getDecryptMethod = CaesarGrpc.getDecryptMethod) == null) {
          CaesarGrpc.getDecryptMethod = getDecryptMethod =
              io.grpc.MethodDescriptor.<service.PasswordReq, service.PasswordRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "decrypt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.PasswordReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.PasswordRes.getDefaultInstance()))
              .setSchemaDescriptor(new CaesarMethodDescriptorSupplier("decrypt"))
              .build();
        }
      }
    }
    return getDecryptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.PasswordList> getListPasswordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listPasswords",
      requestType = com.google.protobuf.Empty.class,
      responseType = service.PasswordList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.PasswordList> getListPasswordsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, service.PasswordList> getListPasswordsMethod;
    if ((getListPasswordsMethod = CaesarGrpc.getListPasswordsMethod) == null) {
      synchronized (CaesarGrpc.class) {
        if ((getListPasswordsMethod = CaesarGrpc.getListPasswordsMethod) == null) {
          CaesarGrpc.getListPasswordsMethod = getListPasswordsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, service.PasswordList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listPasswords"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.PasswordList.getDefaultInstance()))
              .setSchemaDescriptor(new CaesarMethodDescriptorSupplier("listPasswords"))
              .build();
        }
      }
    }
    return getListPasswordsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CaesarStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaesarStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CaesarStub>() {
        @java.lang.Override
        public CaesarStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CaesarStub(channel, callOptions);
        }
      };
    return CaesarStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CaesarBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaesarBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CaesarBlockingStub>() {
        @java.lang.Override
        public CaesarBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CaesarBlockingStub(channel, callOptions);
        }
      };
    return CaesarBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CaesarFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CaesarFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CaesarFutureStub>() {
        @java.lang.Override
        public CaesarFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CaesarFutureStub(channel, callOptions);
        }
      };
    return CaesarFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CaesarImplBase implements io.grpc.BindableService {

    /**
     */
    public void encrypt(service.SaveReq request,
        io.grpc.stub.StreamObserver<service.SaveRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEncryptMethod(), responseObserver);
    }

    /**
     */
    public void decrypt(service.PasswordReq request,
        io.grpc.stub.StreamObserver<service.PasswordRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDecryptMethod(), responseObserver);
    }

    /**
     */
    public void listPasswords(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.PasswordList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPasswordsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEncryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.SaveReq,
                service.SaveRes>(
                  this, METHODID_ENCRYPT)))
          .addMethod(
            getDecryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.PasswordReq,
                service.PasswordRes>(
                  this, METHODID_DECRYPT)))
          .addMethod(
            getListPasswordsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                service.PasswordList>(
                  this, METHODID_LIST_PASSWORDS)))
          .build();
    }
  }

  /**
   */
  public static final class CaesarStub extends io.grpc.stub.AbstractAsyncStub<CaesarStub> {
    private CaesarStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaesarStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaesarStub(channel, callOptions);
    }

    /**
     */
    public void encrypt(service.SaveReq request,
        io.grpc.stub.StreamObserver<service.SaveRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEncryptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void decrypt(service.PasswordReq request,
        io.grpc.stub.StreamObserver<service.PasswordRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDecryptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listPasswords(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.PasswordList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPasswordsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CaesarBlockingStub extends io.grpc.stub.AbstractBlockingStub<CaesarBlockingStub> {
    private CaesarBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaesarBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaesarBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.SaveRes encrypt(service.SaveReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEncryptMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.PasswordRes decrypt(service.PasswordReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDecryptMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.PasswordList listPasswords(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPasswordsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CaesarFutureStub extends io.grpc.stub.AbstractFutureStub<CaesarFutureStub> {
    private CaesarFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CaesarFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CaesarFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.SaveRes> encrypt(
        service.SaveReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEncryptMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.PasswordRes> decrypt(
        service.PasswordReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDecryptMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.PasswordList> listPasswords(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPasswordsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENCRYPT = 0;
  private static final int METHODID_DECRYPT = 1;
  private static final int METHODID_LIST_PASSWORDS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CaesarImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CaesarImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENCRYPT:
          serviceImpl.encrypt((service.SaveReq) request,
              (io.grpc.stub.StreamObserver<service.SaveRes>) responseObserver);
          break;
        case METHODID_DECRYPT:
          serviceImpl.decrypt((service.PasswordReq) request,
              (io.grpc.stub.StreamObserver<service.PasswordRes>) responseObserver);
          break;
        case METHODID_LIST_PASSWORDS:
          serviceImpl.listPasswords((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<service.PasswordList>) responseObserver);
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

  private static abstract class CaesarBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CaesarBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.CaesarProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Caesar");
    }
  }

  private static final class CaesarFileDescriptorSupplier
      extends CaesarBaseDescriptorSupplier {
    CaesarFileDescriptorSupplier() {}
  }

  private static final class CaesarMethodDescriptorSupplier
      extends CaesarBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CaesarMethodDescriptorSupplier(String methodName) {
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
      synchronized (CaesarGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CaesarFileDescriptorSupplier())
              .addMethod(getEncryptMethod())
              .addMethod(getDecryptMethod())
              .addMethod(getListPasswordsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
