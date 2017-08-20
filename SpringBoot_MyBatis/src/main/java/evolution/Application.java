package evolution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import evolution.entity.AnyEntity;
import evolution.mapper.AnyMapper;

@SpringBootApplication// Automatically scans mappers.
public class Application implements CommandLineRunner {
	@Autowired
	private AnyMapper anyMapper;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean// Detects DataSource
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/any_database");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<AnyEntity> anyEntities = anyMapper.findByName("chen");
		System.out.println(anyEntities);
		List<Map<String, Object>> anotherEntities = anyMapper.findAll();
		System.out.println(anotherEntities);
		List<AnyEntity> theOtherEntities = anyMapper.findById(1L);
		System.out.println(theOtherEntities);
		anyMapper.insertInBatch(Arrays.asList(new AnyEntity("Anna"), new AnyEntity("Elsa")));
		anyMapper.insert(new AnyEntity("Bob"));
	}
}
