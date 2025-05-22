package com.grpcapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

import com.grpcapi.AddBikeRequest;
import com.grpcapi.AddBikeResponse;
import com.grpcapi.YamahaServiceGrpc.YamahaServiceImplBase;
import com.grpcapi.entity.Yamaha;
import com.grpcapi.repository.YamahaRepository;

import io.grpc.stub.StreamObserver;

@GrpcService
public class YamahaService  extends YamahaServiceImplBase {
	
	@Autowired
	private YamahaRepository yamahaRepository;
	
	@Override
	public void addBike(AddBikeRequest request, StreamObserver<AddBikeResponse> responseObserver) {
		String model=request.getModel();
		double price =request.getPrice();
		String bikeName=request.getBikeName();
		Yamaha yamaha =new Yamaha();
		yamaha.setDate(LocalDateTime.now());
		yamaha.setModel(model);
		yamaha.setPrice(price);
		yamaha.setBikeName(bikeName);
		yamahaRepository.save(yamaha);	
		AddBikeResponse response=AddBikeResponse.newBuilder()
				.setMessage("bike add successfully").build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	
	

}
