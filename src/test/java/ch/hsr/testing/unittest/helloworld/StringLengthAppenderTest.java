package ch.hsr.testing.unittest.helloworld;

import org.junit.jupiter.api.*;


class StringLengthAppenderTest {
    private StringLengthAppender appender;

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
        appender = new StringLengthAppender();
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @Test
    void stringWithlengthGtZeroReturnsLen() {
        System.out.println("Test1");
        String appended = appender.append("blabla");
        Assertions.assertTrue(appended.contains("6 characters"));
    }

    @Test
    void emptyStringReturnsLengthZero() {
        System.out.println("Test2");
        String appended = appender.append("");
        Assertions.assertTrue(appended.contains("0 characters"));
    }
}
