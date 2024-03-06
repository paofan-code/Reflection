package bjfu.package1;

/**
 * @author 酸汤泡饭
 * data:2022/9/14
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){

    }

    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    Person(String name,int age){
        this.name=name;
        this.age = age;
    }

    @MyAnnotation
    private void showNation(String nation){
        System.out.println("我的国籍是"+nation);
    }

    public String display(){
        return "唱跳、rap、打篮球";
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void showDesc(){
        System.out.println("今天是个好日子");
    }
}
