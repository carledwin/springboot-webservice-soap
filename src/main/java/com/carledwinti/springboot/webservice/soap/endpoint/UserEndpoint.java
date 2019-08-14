package com.carledwinti.springboot.webservice.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.carledwinti.springboot.webservice.soap.repository.UserRepository;

import io.spring.guides.gs_producing_web_service.GetNoteRequest;
import io.spring.guides.gs_producing_web_service.GetNoteResponse;

@Endpoint
public class UserEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	private UserRepository userRepository;
	
	@Autowired
	public UserEndpoint(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getNoteRequest")
	@ResponsePayload
	public GetNoteResponse getNote(@RequestPayload GetNoteRequest getNoteRequest) {
		
		GetNoteResponse getNoteResponse = new GetNoteResponse();
		getNoteResponse.setNote(userRepository.gradeRating(getNoteRequest.getUser()));
		
		return getNoteResponse;	
	}
}
