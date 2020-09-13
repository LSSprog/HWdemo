public class Tester {

    @BeforeSuite
    public void before() {
        System.out.println("START");
    }

    @AfterSuite
    public void after() {
        System.out.println("END");
    }

    @Test (prority = 2)
    public void test1() {
        System.out.println("Тест1");
    }

    @Test (prority = 1)
    public void test2() {
        System.out.println("Самый важный Тест");
    }

    @Test (prority = 4)
    public void test4() {
        System.out.println("Тест4");
    }

    @Test (prority = 4)
    public void test3() {
        System.out.println("Тест3");
    }


    public void notTest() {
        System.out.println("Это был не тестовый метод");
    }
}
