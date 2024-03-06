package bjfu.package1;

import java.io.Serializable;

/**
 * @author 酸汤泡饭
 * data:2022/9/14
 */
public class Creature <T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
