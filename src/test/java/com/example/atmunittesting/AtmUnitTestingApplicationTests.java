package com.example.atmunittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtmUnitTestingApplicationTests {

    @Test
    void contextLoads() {
    }

    /*In JUnit 5, the @BeforeEach annotation is used to mark a method that should be run before each test method

     in your test class. It allows you to set up the common or shared state for your tests before each individual
      test method is executed. This is particularly useful for initialization and setup that needs to be performed
      repeatedly before every test method.

Common use cases for the @BeforeEach method include:

Initializing Objects: You can create and set up instances of objects that are used across multiple test methods.
 For example, you can create mock objects or set up data that your test methods rely on.

Resetting State: If your test methods modify the state of objects, you can reset the state back to a known
 initial state before each test. This ensures that each test starts from a clean slate.

Opening and Closing Resources: If your tests work with external resources like files, databases, or network
connections, you can use @BeforeEach to open and prepare these resources and ensure they are properly closed
or cleaned up after each test.*/

    /*import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {

    private MyObject myObject;

    @BeforeEach
    void setUp() {
        // This method is executed before each test method.
        // You can initialize objects or perform common setup here.
        myObject = new MyObject();
        // Additional setup or resource allocation can be performed here.
    }

    @Test
    void testMethod1() {
        // Test method 1 can use the initialized myObject.
    }

    @Test
    void testMethod2() {
        // Test method 2 can also use the same myObject.
    }
}
*/

}
