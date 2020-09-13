import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        Class cl = Tester.class;


        try {
            DoTest.start(cl);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
