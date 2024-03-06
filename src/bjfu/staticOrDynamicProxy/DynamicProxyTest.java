package bjfu.staticOrDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author 酸汤泡饭
 * data:2022/9/16
 */
interface Human{
    String getBelief();
    void eat(String food);
}
class  HumanUtils{
    public static void method1(){
        System.out.println("======================通用方法1======================");
    }


    public static void method2(){
        System.out.println("======================通用方法2======================");
    }

}




//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can belief I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我爱吃"+food);
    }
}
/*
要想生成动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的去创建一个代理类及其对象？

问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a？
 */

class ProxyFactory{
    //调用此方法，返回一个代理类的对象。
    public static Object getProxyFactory(Object obj){
        //obj 被代理类的对象
        //obj.getClass().getInterfaces() 实现了哪些接口

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                myInvocationHandler);


    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理的类进行赋值

    public void bind(Object obj){
        this.obj = obj;

    }

    //当我们通过代理类调用方法a时，就会自动调用如下方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //AOP编程示例
        HumanUtils.method1();

        Object invokeValue = method.invoke(obj, args);
        //method
        HumanUtils.method2();

        return  invokeValue;
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human human = (Human) ProxyFactory.getProxyFactory(superMan);//代理类对象，用于接口的回调
        /*
        动态创建代理类
        当通过代理类对象调用方法时，会自动调用被代理类中的同名方法
         */
        System.out.println(human.getClass());
        human.eat("四川麻辣烫");
        System.out.println("==============");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyFactory(nikeClothFactory);
        clothFactory.produceCloth();
    }
}
