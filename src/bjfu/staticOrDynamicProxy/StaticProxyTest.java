package bjfu.staticOrDynamicProxy;

/**
 * 静态代理举例
 * @author 酸汤泡饭
 * data:2022/9/16
 */

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory clothFactory;//拿被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory clothFactory) {
        //ClothFactory 可能有多个实现
        //面向接口编程，不必关心接口是怎么实现的，只需要知道接口的功能
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理类进行一些控制");
        clothFactory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂进行衣服生产");
    }
}

public class StaticProxyTest {
    /*
    静态代理：编译期间直接把代理类和被代理类写死了
     */
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}
