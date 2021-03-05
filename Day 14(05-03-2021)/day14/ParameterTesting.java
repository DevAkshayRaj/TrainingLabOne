package day14;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTesting {
	@Parameter(0)
	public int a;
	@Parameter(1)
	public int b;
	@Parameter(2)
	public int result;

	@Parameters
	public static Collection<Object[]> getDat() {
		Object[][] o = new Object[][] { { 1, 2, 0 }, { 5, 5, 1 }, { 24, 6, 4 }, { 32, 8, 4 }, { 40, 5, 8 } };

		return Arrays.asList(o);
	}

	static Calculator ca = null;

	@BeforeClass
	public static void init() {
		ca = new Calculator();
	}

	@Test
	public void test() {
		assertEquals(result, ca.divide(a, b));
	}
}
