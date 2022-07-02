package qa.tests;

import org.testng.annotations.*;

public class TestNGWithAllTags {
  @Test
  public void testCaseI() {
    System.out.println("I am from testCaseI");
  }

  @Test
  public void testCaseII() {
    System.out.println("I am from testCaseII");
  }
  @BeforeMethod
  public void beforeMethod() {
    System.out.println("I am from beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println("I am from afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
    System.out.println("I am from beforeClass");
  }

  @AfterClass
  public void afterClass() {
    System.out.println("I am from afterClass");
  }

  @BeforeTest
  public void beforeTest() {
    System.out.println("I am from beforeTest");
  }

  @AfterTest
  public void afterTest() {
    System.out.println("I am from afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
    System.out.println("I am from beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
    System.out.println("I am from afterSuite");
  }

}
