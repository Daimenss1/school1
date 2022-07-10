package ru.hogwartS.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.hogwartS.school.Controller.StudentController;
import ru.hogwartS.school.Model.Student;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private StudentController studentController;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() throws Exception{
		Assertions.assertThat(studentController).isNotNull();
	}

	@Test
	public void postStudentTest() throws Exception {
		Student student = new Student(1L, "Bob", 13);

		Assertions.
				assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/id", student, String.class))
				.isNotNull();
	}

	@Test
	public void putStudentTest() throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("id", "1");
		Student updatedStudent= new Student(1L, "Alex", 123);

		testRestTemplate.put("http://localhost:" + port + "/student", updatedStudent, params);
	}

	@Test
	public void getStudentTest() throws Exception {

		Assertions.
				assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/id", String.class))
				.isNotNull();
	}

	@Test
	public void deleteStudentTest() throws Exception {
		Student student = new Student(1L, "Bob", 13);

		testRestTemplate.delete("http://localhost:" + port + "/id", student, String.class);
	}

	@Test
	public void getStudentsByAgeTest() throws Exception {
		Student student1 = new Student(1L, "Bob", 13);
		Student student2 = new Student(2L, "Rob", 13);
		Student student3 = new Student(3L, "Michael", 25);
		Student student4 = new Student(4L, "Richard", 63);

		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student1, Student.class);
		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student2, Student.class);
		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student3, Student.class);
		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student4, Student.class);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("age", "13");
	}

	@Test
	public void getStudentByAgeBetweenTest() throws Exception {
		Student student1 = new Student(1L, "Bob", 13);
		Student student2 = new Student(2L, "Rob", 13);
		Student student3 = new Student(3L, "Michael", 25);
		Student student4 = new Student(4L, "Richard", 63);

		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student1, Student.class);
		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student2, Student.class);
		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student3, Student.class);
		testRestTemplate.postForEntity("http://localhost:" + port + "/id", student4, Student.class);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("minAge", "25");
		params.add("maxAge", "63");
	}
}