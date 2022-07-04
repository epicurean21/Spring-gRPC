package com.example.grpcserver.service;

import org.example.demo.proto.GreetingRequest;
import org.example.demo.proto.GreetingResponse;
import org.example.demo.proto.GreetingServiceGrpc.GreetingServiceImplBase;

import net.devh.boot.grpc.server.service.GrpcService;

import io.grpc.stub.StreamObserver;

@GrpcService
public class GreetingServerService extends GreetingServiceImplBase {

    @Override
    public void greetings(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        GreetingResponse response = GreetingResponse.newBuilder()
                                                    .setMessage("Greetings, " + request.getName())
                                                    .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
