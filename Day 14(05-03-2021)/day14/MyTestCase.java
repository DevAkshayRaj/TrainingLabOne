package day14;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyTestCase {

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("SetUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void SetUp() {
		System.out.println("SetUp");
	}

	@After
	public void tearDown() {
		System.out.println("tearDown");
	}

	@Test
	public void test4() {
		System.out.println("test");
	}
	@Test
	public void test1() {
		System.out.println("test 1");
	}
	@Test
	public void test2() {
		System.out.println("test 2");
	}

}
