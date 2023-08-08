import sun.misc.Launcher;

public class Test {

    public static void main(String[] args) {
        ClassLoader launcherClassLoader = Launcher.class.getClassLoader();
        System.out.println(launcherClassLoader);   //Êä³önull

        ClassLoader testClassLoader = Test.class.getClassLoader();
        System.out.println(testClassLoader); // Êä³ö sun.misc.Launcher$AppClassLoader@19821f
    }
}

