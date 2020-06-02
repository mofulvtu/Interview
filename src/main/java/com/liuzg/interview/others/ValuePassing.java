package com.liuzg.interview.others;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  Desc:   Java是值传递，a是引用类型，会将此引用地址传递给方法，
 *          如果在方法中没有改变地址，只是赋值，则原地址指向的内存发生变化；
 *          如果在方法中重新创建的新地址，比如new一个新对象，则a的地址指向新的内存区域，无论是否变化，都与传递进来的地址无关。
 * </pre>
 *
 * @author liuzg
 * @date 2020/5/25 9:51
 **/
public class ValuePassing {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        test(a);
        System.out.println(a.size());    // 1

        List<String> b = new ArrayList<>();
        test2(b);
        System.out.println(b.size()); //0

        List<String> c = null;
        test2(c);
        test(c);
        System.out.println(c.size()); // c没有初始化，NullPointerException
    }


    //直接赋值给a地址
    private static void test(List<String> a) {
        a.add("123");
    }

    //创建新对象,开辟了新内存，然后赋值
    private static void test2(List<String> a) {
        a = new ArrayList<>();
        a.add("123");
    }
}
