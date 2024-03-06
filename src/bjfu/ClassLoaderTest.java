package bjfu;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 酸汤泡饭
 * data:2022/9/13
 * 类的加载测试
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader==systemClassLoader);//系统类加载器
        System.out.println(systemClassLoader);

        //获得扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //不能直接获取到引导类加载器
        ClassLoader parent1 = parent.getParent();
        //核心类库由引导类加载器加载
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(parent1);
        System.out.println(classLoader1);
    }

    /*
    Properties:读取配置文件
     */
    @Test
    public void test2() throws Exception{
        //new FileInputStream("src/jdbc.properties")在当前模块下找找
        Properties properties = new Properties();
//        properties.load(new FileInputStream("jdbc.properties"));
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");


        //此时识别目录从src开始

        System.out.println(user);
    }
}
