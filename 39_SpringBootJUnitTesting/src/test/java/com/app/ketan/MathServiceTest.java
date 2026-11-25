package com.app.ketan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathServiceTest {
	MathService ms = null;
	int expected;
	
	@BeforeEach
	public void setUp() {
		ms = new MathService();
		expected = 30;
	}
	
	@Test
	public void testAdd() {
		boolean result = ms.isPrime(4);
		assertTrue(result);
		int actual = ms.add(10,20);
		assertEquals(expected, actual);
	}
	
	@AfterEach
	public void clean() {
		ms=null;
	}

}
