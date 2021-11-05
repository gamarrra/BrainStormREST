 	package com.brainstorm;


import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

class brainstormApplicationTest {

	@Test
	void testMain() throws JsonProcessingException {
		brainstormApplication.main(new String[] {});
	}

}
