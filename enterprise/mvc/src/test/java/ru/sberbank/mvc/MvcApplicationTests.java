package ru.sberbank.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sberbank.mvc.dao.UserRepository;
import ru.sberbank.mvc.dao.entity.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcApplicationTests {
	@Autowired
	private UserRepository  repository;

	@Test
	public void contextLoads() {
		List<UserModel> dtos = new ArrayList<>();
		String fish = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
				"Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt," +
				" dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!";
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Dan Doe", "1", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Dave Doe", "2", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Angela Doe", "3", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Jerry Smith", "4", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Alex Doe", "5", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Friend-or-Doe", "6", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Joseph FooBar", "7", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Kate Incognito", "8", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Liam aka i'll find you and i'll kill you Nelson", "9", fish));
		dtos.add(new UserModel(UUID.randomUUID().toString(), "Mr. Smith", "10", fish));

		dtos.forEach(repository::save);

	}

}
