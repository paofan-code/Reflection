package bjfu.package1.test;

import bjfu.package1.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author 酸汤泡饭
 * data:2022/9/14
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //获取这个字段对应的Class
            Class<?> type = declaredField.getType();
            System.out.println(type);
        }
    }
}
