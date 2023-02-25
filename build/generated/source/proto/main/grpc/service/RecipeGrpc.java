package service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.1)",
    comments = "Source: services/recipes.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecipeGrpc {

  private RecipeGrpc() {}

  public static final String SERVICE_NAME = "services.Recipe";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.RecipeReq,
      service.RecipeResp> getAddRecipeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addRecipe",
      requestType = service.RecipeReq.class,
      responseType = service.RecipeResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.RecipeReq,
      service.RecipeResp> getAddRecipeMethod() {
    io.grpc.MethodDescriptor<service.RecipeReq, service.RecipeResp> getAddRecipeMethod;
    if ((getAddRecipeMethod = RecipeGrpc.getAddRecipeMethod) == null) {
      synchronized (RecipeGrpc.class) {
        if ((getAddRecipeMethod = RecipeGrpc.getAddRecipeMethod) == null) {
          RecipeGrpc.getAddRecipeMethod = getAddRecipeMethod =
              io.grpc.MethodDescriptor.<service.RecipeReq, service.RecipeResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addRecipe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.RecipeReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.RecipeResp.getDefaultInstance()))
              .setSchemaDescriptor(new RecipeMethodDescriptorSupplier("addRecipe"))
              .build();
        }
      }
    }
    return getAddRecipeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.RecipeViewResp> getViewRecipesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewRecipes",
      requestType = com.google.protobuf.Empty.class,
      responseType = service.RecipeViewResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      service.RecipeViewResp> getViewRecipesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, service.RecipeViewResp> getViewRecipesMethod;
    if ((getViewRecipesMethod = RecipeGrpc.getViewRecipesMethod) == null) {
      synchronized (RecipeGrpc.class) {
        if ((getViewRecipesMethod = RecipeGrpc.getViewRecipesMethod) == null) {
          RecipeGrpc.getViewRecipesMethod = getViewRecipesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, service.RecipeViewResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "viewRecipes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.RecipeViewResp.getDefaultInstance()))
              .setSchemaDescriptor(new RecipeMethodDescriptorSupplier("viewRecipes"))
              .build();
        }
      }
    }
    return getViewRecipesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.RecipeRateReq,
      service.RecipeResp> getRateRecipeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "rateRecipe",
      requestType = service.RecipeRateReq.class,
      responseType = service.RecipeResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.RecipeRateReq,
      service.RecipeResp> getRateRecipeMethod() {
    io.grpc.MethodDescriptor<service.RecipeRateReq, service.RecipeResp> getRateRecipeMethod;
    if ((getRateRecipeMethod = RecipeGrpc.getRateRecipeMethod) == null) {
      synchronized (RecipeGrpc.class) {
        if ((getRateRecipeMethod = RecipeGrpc.getRateRecipeMethod) == null) {
          RecipeGrpc.getRateRecipeMethod = getRateRecipeMethod =
              io.grpc.MethodDescriptor.<service.RecipeRateReq, service.RecipeResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "rateRecipe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.RecipeRateReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.RecipeResp.getDefaultInstance()))
              .setSchemaDescriptor(new RecipeMethodDescriptorSupplier("rateRecipe"))
              .build();
        }
      }
    }
    return getRateRecipeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecipeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipeStub>() {
        @java.lang.Override
        public RecipeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipeStub(channel, callOptions);
        }
      };
    return RecipeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecipeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipeBlockingStub>() {
        @java.lang.Override
        public RecipeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipeBlockingStub(channel, callOptions);
        }
      };
    return RecipeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecipeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecipeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecipeFutureStub>() {
        @java.lang.Override
        public RecipeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecipeFutureStub(channel, callOptions);
        }
      };
    return RecipeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RecipeImplBase implements io.grpc.BindableService {

    /**
     */
    public void addRecipe(service.RecipeReq request,
        io.grpc.stub.StreamObserver<service.RecipeResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddRecipeMethod(), responseObserver);
    }

    /**
     */
    public void viewRecipes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.RecipeViewResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getViewRecipesMethod(), responseObserver);
    }

    /**
     */
    public void rateRecipe(service.RecipeRateReq request,
        io.grpc.stub.StreamObserver<service.RecipeResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRateRecipeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddRecipeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.RecipeReq,
                service.RecipeResp>(
                  this, METHODID_ADD_RECIPE)))
          .addMethod(
            getViewRecipesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                service.RecipeViewResp>(
                  this, METHODID_VIEW_RECIPES)))
          .addMethod(
            getRateRecipeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.RecipeRateReq,
                service.RecipeResp>(
                  this, METHODID_RATE_RECIPE)))
          .build();
    }
  }

  /**
   */
  public static final class RecipeStub extends io.grpc.stub.AbstractAsyncStub<RecipeStub> {
    private RecipeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipeStub(channel, callOptions);
    }

    /**
     */
    public void addRecipe(service.RecipeReq request,
        io.grpc.stub.StreamObserver<service.RecipeResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddRecipeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void viewRecipes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<service.RecipeViewResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getViewRecipesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rateRecipe(service.RecipeRateReq request,
        io.grpc.stub.StreamObserver<service.RecipeResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRateRecipeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecipeBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecipeBlockingStub> {
    private RecipeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipeBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.RecipeResp addRecipe(service.RecipeReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddRecipeMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.RecipeViewResp viewRecipes(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getViewRecipesMethod(), getCallOptions(), request);
    }

    /**
     */
    public service.RecipeResp rateRecipe(service.RecipeRateReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRateRecipeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecipeFutureStub extends io.grpc.stub.AbstractFutureStub<RecipeFutureStub> {
    private RecipeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecipeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.RecipeResp> addRecipe(
        service.RecipeReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddRecipeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.RecipeViewResp> viewRecipes(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getViewRecipesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.RecipeResp> rateRecipe(
        service.RecipeRateReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRateRecipeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_RECIPE = 0;
  private static final int METHODID_VIEW_RECIPES = 1;
  private static final int METHODID_RATE_RECIPE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecipeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecipeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_RECIPE:
          serviceImpl.addRecipe((service.RecipeReq) request,
              (io.grpc.stub.StreamObserver<service.RecipeResp>) responseObserver);
          break;
        case METHODID_VIEW_RECIPES:
          serviceImpl.viewRecipes((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<service.RecipeViewResp>) responseObserver);
          break;
        case METHODID_RATE_RECIPE:
          serviceImpl.rateRecipe((service.RecipeRateReq) request,
              (io.grpc.stub.StreamObserver<service.RecipeResp>) responseObserver);
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

  private static abstract class RecipeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecipeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.RecipeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Recipe");
    }
  }

  private static final class RecipeFileDescriptorSupplier
      extends RecipeBaseDescriptorSupplier {
    RecipeFileDescriptorSupplier() {}
  }

  private static final class RecipeMethodDescriptorSupplier
      extends RecipeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecipeMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecipeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecipeFileDescriptorSupplier())
              .addMethod(getAddRecipeMethod())
              .addMethod(getViewRecipesMethod())
              .addMethod(getRateRecipeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
