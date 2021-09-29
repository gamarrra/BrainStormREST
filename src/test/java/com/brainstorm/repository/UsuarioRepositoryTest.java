package com.brainstorm.repository;
import static org.junit.jupiter.api.Assertions.*;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UsuarioRepositoryTest {
	
	  @Autowired private DataSource dataSource;
	  @Autowired private JdbcTemplate jdbcTemplate;
	  @Autowired private EntityManager entityManager;
	  @Autowired private UsuarioRepository usuarioRepository;

	@Test
	void test() {
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
		assertNotNull(usuarioRepository);
	}

}
