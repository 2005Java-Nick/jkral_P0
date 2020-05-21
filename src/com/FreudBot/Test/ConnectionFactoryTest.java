package com.FreudBot.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.FreudBot.jdbc.ConnectionFactory;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactoryTest {
	
	ConnectionFactory cf;
	static Dotenv dotenv = Dotenv.load();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void envTest() {
		String awsUrl = "freuddb.c4hlxdpgql5j.us-east-2.rds.amazonaws.com";
		assertEquals(awsUrl, dotenv.get("DB_AWS_URL"));
	}

}
