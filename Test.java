import sun.misc.Launcher;

public class Test {

    public static void main(String[] args) {
        ClassLoader launcherClassLoader = Launcher.class.getClassLoader();
        System.out.println(launcherClassLoader);   //���null

        ClassLoader testClassLoader = Test.class.getClassLoader();
        System.out.println(testClassLoader); // ��� sun.misc.Launcher$AppClassLoader@19821f
    }
}

