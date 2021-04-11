package com.assignment.normapi;

import com.assignment.normapi.utils.StringNormalizer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@SpringBootTest()
class NormapiApplicationTests {

	private final Pattern pattern = compile("[^a-zA-Z0-9]");

	@Test
	public void testNormalizeStringMethod(){
		String s = "Abc123#$%Abc123";

		String normalizedString = StringNormalizer.normalizeString(s.toLowerCase(), pattern);

		Assertions.assertEquals("abc123abc123", normalizedString);
	}

}
