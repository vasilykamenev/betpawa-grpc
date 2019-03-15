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
public final class WithdrawGrpc {

  private WithdrawGrpc() {}

  public static final String SERVICE_NAME = "Withdraw";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.WithdrawRequest,
      com.pawa.server.model.wallet.Wallet.WithdrawResponse> getWithdrawMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Withdraw",
      requestType = com.pawa.server.model.wallet.Wallet.WithdrawRequest.class,
      responseType = com.pawa.server.model.wallet.Wallet.WithdrawResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.WithdrawRequest,
      com.pawa.server.model.wallet.Wallet.WithdrawResponse> getWithdrawMethod() {
    io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.WithdrawRequest, com.pawa.server.model.wallet.Wallet.WithdrawResponse> getWithdrawMethod;
    if ((getWithdrawMethod = WithdrawGrpc.getWithdrawMethod) == null) {
      synchronized (WithdrawGrpc.class) {
        if ((getWithdrawMethod = WithdrawGrpc.getWithdrawMethod) == null) {
          WithdrawGrpc.getWithdrawMethod = getWithdrawMethod = 
              io.grpc.MethodDescriptor.<com.pawa.server.model.wallet.Wallet.WithdrawRequest, com.pawa.server.model.wallet.Wallet.WithdrawResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Withdraw", "Withdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pawa.server.model.wallet.Wallet.WithdrawRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pawa.server.model.wallet.Wallet.WithdrawResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WithdrawMethodDescriptorSupplier("Withdraw"))
                  .build();
          }
        }
     }
     return getWithdrawMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WithdrawStub newStub(io.grpc.Channel channel) {
    return new WithdrawStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WithdrawBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WithdrawBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WithdrawFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WithdrawFutureStub(channel);
  }

  /**
   */
  public static abstract class WithdrawImplBase implements io.grpc.BindableService {

    /**
     */
    public void withdraw(com.pawa.server.model.wallet.Wallet.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.WithdrawResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getWithdrawMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWithdrawMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.pawa.server.model.wallet.Wallet.WithdrawRequest,
                com.pawa.server.model.wallet.Wallet.WithdrawResponse>(
                  this, METHODID_WITHDRAW)))
          .build();
    }
  }

  /**
   */
  public static final class WithdrawStub extends io.grpc.stub.AbstractStub<WithdrawStub> {
    private WithdrawStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawStub(channel, callOptions);
    }

    /**
     */
    public void withdraw(com.pawa.server.model.wallet.Wallet.WithdrawRequest request,
        io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.WithdrawResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WithdrawBlockingStub extends io.grpc.stub.AbstractStub<WithdrawBlockingStub> {
    private WithdrawBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.pawa.server.model.wallet.Wallet.WithdrawResponse withdraw(com.pawa.server.model.wallet.Wallet.WithdrawRequest request) {
      return blockingUnaryCall(
          getChannel(), getWithdrawMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WithdrawFutureStub extends io.grpc.stub.AbstractStub<WithdrawFutureStub> {
    private WithdrawFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WithdrawFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WithdrawFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WithdrawFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pawa.server.model.wallet.Wallet.WithdrawResponse> withdraw(
        com.pawa.server.model.wallet.Wallet.WithdrawRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WITHDRAW = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WithdrawImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WithdrawImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((com.pawa.server.model.wallet.Wallet.WithdrawRequest) request,
              (io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.WithdrawResponse>) responseObserver);
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

  private static abstract class WithdrawBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WithdrawBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pawa.server.model.wallet.Wallet.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Withdraw");
    }
  }

  private static final class WithdrawFileDescriptorSupplier
      extends WithdrawBaseDescriptorSupplier {
    WithdrawFileDescriptorSupplier() {}
  }

  private static final class WithdrawMethodDescriptorSupplier
      extends WithdrawBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WithdrawMethodDescriptorSupplier(String methodName) {
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
      synchronized (WithdrawGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WithdrawFileDescriptorSupplier())
              .addMethod(getWithdrawMethod())
              .build();
        }
      }
    }
    return result;
  }
}
