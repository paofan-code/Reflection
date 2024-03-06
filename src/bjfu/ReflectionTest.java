package bjfu;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 酸汤泡饭
 * data:2022/9/12
 */
public class ReflectionTest {
    @Test
    public void test1(){
        //1 创建person对象
        Person person = new Person("Tom",12);

        //2.通过对象，调用其内部的属性和方法
        person.age = 10;
        System.out.println(person);
        person.show();

        //不能调用Person的私有Field,Method,Constructor

    }
    @Test
    public void test2() throws Exception{
        Class<Person> personClass = Person.class;

        //拿到构造器对应的对象
        Constructor<Person> constructor1 = personClass.getConstructor(String.class, int.class);
        //调用构造器创建对象
        Person person = constructor1.newInstance("tom", 12);
        System.out.println(person);

        //调用属性
        Field age = personClass.getField("age");
        age.set(person,10);
        System.out.println(person);

        //调用方法
        Method method = personClass.getMethod("show");
        method.invoke(person);

        //通过反射访问私有的属性、方法、构造器
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        //反射爆破，取消类型检查、等安全措施
        constructor.setAccessible(true);
        Person person1 = constructor.newInstance("rainbow");
        System.out.println(person1);

        Field name = personClass.getDeclaredField("name");
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);

    }
    //面试问问题？可以问问接下来的工作对应的项目，用的是什么技术选型？
    /*
    疑问：通过直接new的方式创建对象和通过反射创建对象都可以调用公共的结构开发中，用哪一个？
        答：直接new的方式。
    什么时候使用反射的方式创建？
        答：不知道要创建哪个类的对象的时候，比如前端发起向后端的请求，此时根据前端的url创建对应的对象。
        反射的特征：动态性。
    疑问：反射机制与面向对象的封装性是不是矛盾的？如何看待两个技术？
    答：不是矛盾的。封装性我认为它是建议你调公用的方法，因为公用的方法可能功能更强大。
        而反射在这个方向的体现是能调。


     */
    /*
        关于java.lang.Class类的理解
        1.类java的过程：
            （1）源代码经过javac.exe 处理后 会形成一个或者多个字节码文件.class文件
            （2）java.exe 对.class文件进行解释和运行。相当于将某个字节码文件加载到内存中，这个过程就叫做类的加载，
    加载到内存中的类，我们称为运行时类，此运行时类就作为Class类的一个实例（有且仅有一个）。
        2. 换句活说，Class的一个实例就对应着一个运行时类。
        3. 加载到内存中的类，会缓存一段时间。在此时间段内，我们可以通过不同的方式来获取此运行时类
     */
    //Class实例的获取方式
    @Test
    public void testGetClass() throws Exception{
        //方式1
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //方法2：通过运行时类的对象
        Person p1 =new Person();
        Class<? extends Person> aClass = p1.getClass();
        System.out.println(aClass);

        //方式3：调用Class的静态方法：forName(String classPath)
        Class<?> aClass1 = Class.forName("bjfu.Person");

        //方式4 使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("bjfu.Person");
        System.out.println(aClass2==aClass1);
        System.out.println(aClass1==personClass);
    }

    @Test
    public void test3(){
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> c10 = a.getClass();
        Class<? extends int[]> c11 = b.getClass();
// 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
