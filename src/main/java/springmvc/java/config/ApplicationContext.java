package springmvc.java.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import springmvc.java.domain.Cart;
import springmvc.java.domain.Purchase;
import springmvc.java.service.CategoryService;
import springmvc.java.service.LoginService;
import springmvc.java.service.ProductService;

import springmvc.java.service.SearchService;
import springmvc.java.service.UserService;
import springmvc.java.service.impl.CategoryServiceImpl;
import springmvc.java.service.impl.LoginServiceImpl;
import springmvc.java.service.impl.ProductServiceImpl;

import springmvc.java.service.impl.SearchServiceImpl;
import springmvc.java.service.impl.UserServiceImpl;

@EnableJpaRepositories(basePackages = { "springmvc.java.dao" })
@Configuration
public class ApplicationContext {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));

		return dataSource;
	}

	@Bean
	public LoginService loginService() {
		return new LoginServiceImpl();
	}

	@Bean
	public Cart cartService() {
		return new Cart();
	}

	@Bean
	public CategoryService categoryService() {
		return new CategoryServiceImpl();
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public Purchase purchaseService() {
		return new Purchase();
	}

	@Bean
	public SearchService searchService() {
		return new SearchServiceImpl();
	}

	// @Bean(name = "embedded")
	// public DataSource embeddedDataSource()
	// {
	// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	// EmbeddedDatabase embeddedDatabase =
	// builder.setType(EmbeddedDatabaseType.HSQL).
	// addScript("dbschema.sql")
	// .addScript("test-data.sql").build();
	//
	// return embeddedDatabase;
	// }

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

		return jpaTransactionManager;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setPackagesToScan("springmvc.java.domain");

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");

		entityManagerFactory.setJpaProperties(jpaProperties);
		return entityManagerFactory;
	}
}
