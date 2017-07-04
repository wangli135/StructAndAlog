package leetcode.dp;

/**
 * Created by Xingfeng on 2017-03-29.
 */
public class Person implements Cloneable{

    String name;

    public static void main(String[] args) throws CloneNotSupportedException {

        Person person = new Person();
        person.name="wangli";
        Person p2 = (Person) person.clone();
        System.out.println(p2);
        System.out.println(person);
        System.out.println(person.name);
        System.out.println(p2.name);
        p2.name="yanpeng";
        System.out.println(person.name);
        System.out.println(p2.name);
    }

}
