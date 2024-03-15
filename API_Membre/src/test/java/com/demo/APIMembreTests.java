package com.demo;

import com.controllers.MainController;
import com.dtos.MembreDto;
import com.services.MembreService;
import com.services.impl.MembreServiceImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
class APIMembreTests {

	@Autowired
	MockMvc controller;

	@MockBean
	private MembreServiceImpl membreService;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	@Order(1)
	void testSaveMembre() throws Exception {
		String mbr = "{ " +
				"\"Id\" : null," +
				"\"nom\" : \"Dupond\"," +
				"\"prenom\": \"Emile\"," +
				"\"dateNaiss\": \"07-12-2000\"," +
				"\"email\": \"emile.dupond@gmail.com\"," +
				"\"mdp\": \"MdpSuperSecret\"" +
			"}";


		controller.perform(post("/membre")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mbr))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	void testGetAllMembre() throws Exception {
		controller.perform(get("/membre"))
				.andExpect(status().isOk());
	}


	@Test
	@Order(3)
	void testGetMembreById() throws Exception {
		String id = "5";
		controller.perform(get("/membre/" + id))
				.andExpect(status().isOk());
	}



}
