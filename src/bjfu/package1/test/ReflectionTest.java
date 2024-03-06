package bjfu.package1.test;

import bjfu.package1.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @author 酸汤泡饭
 * data:2022/9/16
 */
public class ReflectionTest {
    @Test
    public void test() throws Exception {
        Class<Person> personClass = Person.class;
        System.out.println("================获取静态方法==============");
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //没有参数可以写为null
        showDesc.invoke(null);
    }
}
