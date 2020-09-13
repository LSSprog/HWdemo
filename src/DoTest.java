import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DoTest {
    private boolean before = false;
    private boolean after = false;

    public static void start(Class classik) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        DoTest doTest = new DoTest();
        Object Ob = classik.newInstance();
        Method[] methods = classik.getDeclaredMethods();
        //System.out.println(Arrays.toString(methods));
        List<Method> list = new ArrayList<>();
        for (Method m: methods) {
            if ((m.isAnnotationPresent(BeforeSuite.class) && doTest.before == true)
                   || (m.isAnnotationPresent(AfterSuite.class) && doTest.after == true)) {
                throw new RuntimeException("Два одинаковых метода");
            } else if(m.isAnnotationPresent(BeforeSuite.class)) {
                doTest.before = true;
                m.invoke(Ob);
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                doTest.after = true;
            } else if (m.isAnnotationPresent(Test.class)){
                list.add(m);
            }
        }
        //System.out.println(list);
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).prority() - o2.getAnnotation(Test.class).prority();
            }
        });
        //System.out.println(list);


        for (Method l: list) {
            l.invoke(Ob);
        }

        for (Method m: methods) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                m.invoke(Ob);
            }
        }
    }
}
