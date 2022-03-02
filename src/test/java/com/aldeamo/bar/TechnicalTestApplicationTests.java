package com.aldeamo.bar;

import com.aldeamo.bar.controller.BarController;
import com.aldeamo.bar.service.BarService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BarController.class)
@WithMockUser
class TechnicalTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BarService barService;


	@Test
	void getCorrectAnswer(){
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(2,4,5,6,7,8));
		List<Integer> dbArray ;
		dbArray = barService.findById(1);
		System.out.println(dbArray);

	}

	@Test
	public void test() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());

	}



}
