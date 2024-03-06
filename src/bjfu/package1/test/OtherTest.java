package bjfu.package1.test;

import bjfu.package1.Person;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @author 酸汤泡饭
 * data:2022/9/14
 */
public class OtherTest {
    /*
    获取构造器结构
     */
    @Test
    public void test1(){


    }

    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        //获取父类
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /*
    逻辑性代码 功能性代码
    功能性代码只需要知道怎么用就行
     */
    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        //获取带泛型的父类
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取父类的泛型参数
        System.out.println(genericSuperclass.getClass());
        ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) genericSuperclass;
        // ParameterizedType parameterizedType1 = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getClass());
        Class<?> clzz1 = (Class<?>)actualTypeArguments[0];
        System.out.println(clzz1.getName());
    }

    /*
    获取运行时类的实现接口
     */
    @Test
    public void test4(){
        Class<Person> personClass = Person.class;

        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        //获取带泛型的父接口
        Type[] genericInterfaces = personClass.getGenericInterfaces();



    }

    @Test
    public void test5(){
        Class<Person> personClass = Person.class;

        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        /*
        获取接口上泛型的参数
         */
        Type[] genericInterfaces = personClass.getGenericInterfaces();
        System.out.println(genericInterfaces[0].getClass());
        ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) genericInterfaces[0];
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?> clazz1 = (Class<?>) actualTypeArguments[0];
        System.out.println(clazz1);

    }

    /*
    获取类上的注解
    框架常获取类或方法上的注解来看你是干什么
     */
    @Test
    public void test6(){
        Class<Person> personClass = Person.class;

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }
}
