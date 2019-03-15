package com.pawa.server.model.wallet;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: wallet.proto")
public final class BalanceGrpc {

  private BalanceGrpc() {}

  public static final String SERVICE_NAME = "Balance";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.BalanceRequest,
      com.pawa.server.model.wallet.Wallet.BalanceResponse> getBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Balance",
      requestType = com.pawa.server.model.wallet.Wallet.BalanceRequest.class,
      responseType = com.pawa.server.model.wallet.Wallet.BalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.BalanceRequest,
      com.pawa.server.model.wallet.Wallet.BalanceResponse> getBalanceMethod() {
    io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.BalanceRequest, com.pawa.server.model.wallet.Wallet.BalanceResponse> getBalanceMethod;
    if ((getBalanceMethod = BalanceGrpc.getBalanceMethod) == null) {
      synchronized (BalanceGrpc.class) {
        if ((getBalanceMethod = BalanceGrpc.getBalanceMethod) == null) {
          BalanceGrpc.getBalanceMethod = getBalanceMethod = 
              io.grpc.MethodDescriptor.<com.pawa.server.model.wallet.Wallet.BalanceRequest, com.pawa.server.model.wallet.Wallet.BalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Balance", "Balance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pawa.server.model.wallet.Wallet.BalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pawa.server.model.wallet.Wallet.BalanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceMethodDescriptorSupplier("Balance"))
                  .build();
          }
        }
     }
     return getBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BalanceStub newStub(io.grpc.Channel channel) {
    return new BalanceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BalanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BalanceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BalanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BalanceFutureStub(channel);
  }

  /**
   */
  public static abstract class BalanceImplBase implements io.grpc.BindableService {

    /**
     */
    public void balance(com.pawa.server.model.wallet.Wallet.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.BalanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBalanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.pawa.server.model.wallet.Wallet.BalanceRequest,
                com.pawa.server.model.wallet.Wallet.BalanceResponse>(
                  this, METHODID_BALANCE)))
          .build();
    }
  }

  /**
   */
  public static final class BalanceStub extends io.grpc.stub.AbstractStub<BalanceStub> {
    private BalanceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceStub(channel, callOptions);
    }

    /**
     */
    public void balance(com.pawa.server.model.wallet.Wallet.BalanceRequest request,
        io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.BalanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BalanceBlockingStub extends io.grpc.stub.AbstractStub<BalanceBlockingStub> {
    private BalanceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.pawa.server.model.wallet.Wallet.BalanceResponse balance(com.pawa.server.model.wallet.Wallet.BalanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BalanceFutureStub extends io.grpc.stub.AbstractStub<BalanceFutureStub> {
    private BalanceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pawa.server.model.wallet.Wallet.BalanceResponse> balance(
        com.pawa.server.model.wallet.Wallet.BalanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BALANCE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BalanceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BalanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BALANCE:
          serviceImpl.balance((com.pawa.server.model.wallet.Wallet.BalanceRequest) request,
              (io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.BalanceResponse>) responseObserver);
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

  private static abstract class BalanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BalanceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pawa.server.model.wallet.Wallet.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Balance");
    }
  }

  private static final class BalanceFileDescriptorSupplier
      extends BalanceBaseDescriptorSupplier {
    BalanceFileDescriptorSupplier() {}
  }

  private static final class BalanceMethodDescriptorSupplier
      extends BalanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BalanceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BalanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BalanceFileDescriptorSupplier())
              .addMethod(getBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
