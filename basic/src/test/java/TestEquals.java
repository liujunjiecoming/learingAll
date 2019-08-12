import org.junit.Test;

/**
 * @ClassName TestEqual
 * @Description TODO
 * @Author JJLiu
 * @Date 19-8-1 下午3:56
 * @Version 1.0
 **/

public class TestEquals {

    @Test
    public void testString1() {
        String s1 = "Monday";
        String s2 = "Monday";
        System.out.println(s1 == s2); //true
    }

    @Test
    public void testString2() {
        String s1 = "Monday";
        //试用了new就是新的对象
        String s2 = new String("Monday");
        System.out.println(s1 == s2);           //false
        System.out.println(s1.equals(s2));      //true

        String s3 = new String("Monday");
        System.out.println(s2 == s3);           //false
        s3 = s3.intern();
        System.out.println(s1 == s3);           //true


    }


}



