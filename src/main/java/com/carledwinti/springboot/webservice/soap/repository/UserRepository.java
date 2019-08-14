
package com.carledwinti.springboot.webservice.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.DocumentationType;
import io.spring.guides.gs_producing_web_service.Note;
import io.spring.guides.gs_producing_web_service.User;

@Component
public class UserRepository {

	private static final Map<Long, User> users = new HashMap<>();
	
	
	@PostConstruct
	public void intData() {
		
		User user = new User();
		user.setName("Fulano De Tal");
		user.setAge(36);
		user.setDocument(12345698732l);
		user.setDocumentationType(DocumentationType.CPF);
		
		User user2 = new User();
		user2.setName("Beltrano De Lano");
		user2.setAge(36);
		user2.setDocument(12345698732654l);
		user2.setDocumentationType(DocumentationType.CNPJ);
		
		User user3 = new User();
		user3.setName("Cicrano De Pano");
		user3.setAge(36);
		user3.setDocument(12345698732654l);
		user3.setDocumentationType(DocumentationType.CNPJ);
		
		users.put(user.getDocument(), user);
		users.put(user2.getDocument(), user2);
		users.put(user3.getDocument(), user3);
	}
	
	public Note gradeRating(User user) {
		
		Assert.isNull(user, "Usuário não pode ser nulo!");
		
		Note note = new Note();
		note.setMessage("Confiável");
		note.setValue(10);
		
		return note;
	}
}
