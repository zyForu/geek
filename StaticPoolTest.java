import java.util.ArrayList;

/**
 * @author zy
 * @date 2023/8/9 16:22
 */
public class StaticPoolTest {
    static String base = "string";
    public static void main(String[] args) throws Throwable{
        //ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < Integer.MAX_VALUE; i ++) {
			try {
				String str = base + base;
				base = str;
				str.intern();
				//list.add(str.intern());
			}catch(Throwable t) {
				System.out.println("current i is :" + i);
				throw t;
			}
			
            
        }

    }
}
