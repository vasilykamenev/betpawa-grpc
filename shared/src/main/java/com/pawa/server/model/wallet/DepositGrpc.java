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
public final class DepositGrpc {

  private DepositGrpc() {}

  public static final String SERVICE_NAME = "Deposit";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.DepositRequest,
      com.pawa.server.model.wallet.Wallet.DepositResponse> getDepositMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Deposit",
      requestType = com.pawa.server.model.wallet.Wallet.DepositRequest.class,
      responseType = com.pawa.server.model.wallet.Wallet.DepositResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.DepositRequest,
      com.pawa.server.model.wallet.Wallet.DepositResponse> getDepositMethod() {
    io.grpc.MethodDescriptor<com.pawa.server.model.wallet.Wallet.DepositRequest, com.pawa.server.model.wallet.Wallet.DepositResponse> getDepositMethod;
    if ((getDepositMethod = DepositGrpc.getDepositMethod) == null) {
      synchronized (DepositGrpc.class) {
        if ((getDepositMethod = DepositGrpc.getDepositMethod) == null) {
          DepositGrpc.getDepositMethod = getDepositMethod = 
              io.grpc.MethodDescriptor.<com.pawa.server.model.wallet.Wallet.DepositRequest, com.pawa.server.model.wallet.Wallet.DepositResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Deposit", "Deposit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pawa.server.model.wallet.Wallet.DepositRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.pawa.server.model.wallet.Wallet.DepositResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DepositMethodDescriptorSupplier("Deposit"))
                  .build();
          }
        }
     }
     return getDepositMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DepositStub newStub(io.grpc.Channel channel) {
    return new DepositStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DepositBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DepositBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DepositFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DepositFutureStub(channel);
  }

  /**
   */
  public static abstract class DepositImplBase implements io.grpc.BindableService {

    /**
     */
    public void deposit(com.pawa.server.model.wallet.Wallet.DepositRequest request,
        io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.DepositResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDepositMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDepositMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.pawa.server.model.wallet.Wallet.DepositRequest,
                com.pawa.server.model.wallet.Wallet.DepositResponse>(
                  this, METHODID_DEPOSIT)))
          .build();
    }
  }

  /**
   */
  public static final class DepositStub extends io.grpc.stub.AbstractStub<DepositStub> {
    private DepositStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepositStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepositStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepositStub(channel, callOptions);
    }

    /**
     */
    public void deposit(com.pawa.server.model.wallet.Wallet.DepositRequest request,
        io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.DepositResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DepositBlockingStub extends io.grpc.stub.AbstractStub<DepositBlockingStub> {
    private DepositBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepositBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepositBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepositBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.pawa.server.model.wallet.Wallet.DepositResponse deposit(com.pawa.server.model.wallet.Wallet.DepositRequest request) {
      return blockingUnaryCall(
          getChannel(), getDepositMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DepositFutureStub extends io.grpc.stub.AbstractStub<DepositFutureStub> {
    private DepositFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepositFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepositFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepositFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.pawa.server.model.wallet.Wallet.DepositResponse> deposit(
        com.pawa.server.model.wallet.Wallet.DepositRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEPOSIT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DepositImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DepositImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEPOSIT:
          serviceImpl.deposit((com.pawa.server.model.wallet.Wallet.DepositRequest) request,
              (io.grpc.stub.StreamObserver<com.pawa.server.model.wallet.Wallet.DepositResponse>) responseObserver);
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

  private static abstract class DepositBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DepositBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.pawa.server.model.wallet.Wallet.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Deposit");
    }
  }

  private static final class DepositFileDescriptorSupplier
      extends DepositBaseDescriptorSupplier {
    DepositFileDescriptorSupplier() {}
  }

  private static final class DepositMethodDescriptorSupplier
      extends DepositBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DepositMethodDescriptorSupplier(String methodName) {
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
      synchronized (DepositGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DepositFileDescriptorSupplier())
              .addMethod(getDepositMethod())
              .build();
        }
      }
    }
    return result;
  }
}
