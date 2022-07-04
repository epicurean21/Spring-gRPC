package com.example.grpcclient.service;

import org.example.demo.proto.GreetingRequest;
import org.example.demo.proto.GreetingResponse;
import org.example.demo.proto.GreetingServiceGrpc.GreetingServiceBlockingStub;
import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;

import io.grpc.StatusRuntimeException;

@Service
public class GreetingsClientService {
    @GrpcClient("test")
    private GreetingServiceBlockingStub stub;

    public String greetingsToServer(final String name) {
        try {
            GreetingResponse greetingResponse = this.stub.greetings(GreetingRequest.newBuilder()
                                                                                   .setName(name)
                                                                                   .build());
            return greetingResponse.getMessage();
        } catch (StatusRuntimeException e) {
            return "Failed " + e.getStatus().getCode();
        }
    }
}
