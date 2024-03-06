package bjfu.package1.test;

import bjfu.package1.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author 酸汤泡饭
 * data:2022/9/14
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println();
            System.out.println("======================================");
            System.out.println(declaredMethod);
            Class<?> returnType = declaredMethod.getReturnType();
            System.out.println(
                    "函数名字："+declaredMethod.getName()+
                    "返回类型："+returnType);
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            System.out.println("参数列表：");
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            System.out.println("异常信息：");
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType);
            }
            System.out.println("获取注解信息：");
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
                //框架等于设计模式+注解+反射
            }
            System.out.println("======================================");
        }
    }
}
