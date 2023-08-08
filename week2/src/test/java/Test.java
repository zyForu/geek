import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zy
 * @date 2023/8/7 13:57
 */
public class Test {
    @org.junit.Test
    public void testClassLoader() {
        MyClassLoader myClassLoader = new MyClassLoader("C:\\Users\\imyed\\Desktop\\gk\\gkcode\\week2\\target\\classes");
        try {
            Class<?> test = myClassLoader.findClass("Test");
            Object obj = test.newInstance();
            Method sayHello = test.getMethod("sayHello");
            sayHello.invoke(obj);
            System.out.println(test.getClassLoader());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
