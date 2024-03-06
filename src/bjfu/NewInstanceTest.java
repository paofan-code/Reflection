package bjfu;

import org.junit.jupiter.api.Test;

/**
 * @author 酸汤泡饭
 * data:2022/9/13
 */
public class NewInstanceTest {

    @Test
    public void test1() throws Exception{
        //举例体会反射的动态性
        //可以根据classPath 创建不同的对象
        //结合xml解析技术，只需要修改配置文件就行
        String classPath = "bjfu.Person";
        System.out.println(getNewInstance(classPath));
    }

    public Object getNewInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }

}
