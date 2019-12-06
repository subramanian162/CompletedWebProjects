package com.subu2code.expenses_tracker.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/*
 * This is the Spring Hibernate Configuration class.
 * 
 * In this class, I create a datasource and hibernate propertie object with the help of data which is present
 * application.properties file that can be accessed through Environment class object.
 * 
 * And with the help of that two objects I created a LocalSessionFactoryBean.
 * 
 * Then passed the SessionFactory onject in to transactionManager() method to make a HibernateTransactionManager Bean.
 * 
 * which was now available on our container.
 * 
 * So we can use it for later purpose in our code.
 * 
 * */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.subu2code.expenses_tracker")
@PropertySource("classpath:application.properties")
public class SpringHibernateConfig {
	
	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource()
	{
		System.out.println("dataSource Bean was created");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		try{
			dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		}
		catch(Exception exception)
		{
			throw new RuntimeException();
		}

		//here, I set the JDBC Connection Properties to our ComboPooledDatasource object.
		
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	// This is the helper method, 
	// which helps to read environment property and convert it in to int.
	
	/*private int getIntProperty(String propName) {
		
		String propVal = environment.getRequiredProperty(propName);

		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}*/
	
	@Bean
	public Properties hibernateProperties()
	{	
		System.out.println("Hibernate Properties Bean was created");
		
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		System.out.println("SessionFactory Bean was created");
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan(environment.getProperty("hiberante.packagesToScan"));
		
		return sessionFactory;
	}
	
    @Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager Bean was created");
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
	
	/*This function is used to test our PROPERTIE FILE */
	@Bean
	public String testPropertieFile()
	{
		System.out.println("Inside the Propertie File Test Function \n");
		
		System.out.println("JDBC Connectionn Properties\n");
		
		System.out.println(environment.getProperty("jdbc.driverClassName"));
		System.out.println(environment.getProperty("jdbc.url"));
		System.out.println(environment.getProperty("jdbc.username"));
		System.out.println(environment.getProperty("jdbc.password"));
		
		System.out.println("Hibernate Properties\n");
		
		System.out.println(environment.getProperty("hibernate.dialect"));
		System.out.println(environment.getProperty("hibernate.show_sql"));
		System.out.println(environment.getProperty("hibernate.format_sql"));
		System.out.println(environment.getProperty("hiberante.packagesToScan"));
		
		System.out.println("ConnectionPool Properties\n");
		
		System.out.println(environment.getProperty("connection.pool.initialPoolSize"));
		System.out.println(environment.getProperty("connection.pool.minPoolSize"));
		System.out.println(environment.getProperty("connection.pool.maxPoolSize"));
		System.out.println(environment.getProperty("connection.pool.maxIdleTime"));
		System.out.println();
		
		return "hello";
	}
	
	/*This function is used to test our JDBC Connection locally */
    
	//@Bean
	public void testConnection()
	{
		Connection connection = null;
		System.out.println("\nTest Connection Started to \n URL : jdbc:mysql://localhost:3306/expense_db?useSSL=false \n Status:Connecting....");
		try{
			Class.forName(environment.getProperty("jdbc.driverClassName"));
			
		   connection = DriverManager.getConnection(environment.getProperty("jdbc.url"),environment.getProperty("jdbc.username"),environment.getProperty("jdbc.password"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(connection!=null)
		{
			try{
			connection.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			System.out.println(" Status:Connected\n");
		}
	}
}
