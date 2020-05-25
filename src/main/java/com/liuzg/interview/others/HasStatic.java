package com.liuzg.interview.others;

/**
 * <pre>
 *  Desc:  static修饰的属性为类属性，类所有，所有实例间共享
 * </pre>
 *
 * @author liuzg
 * @date 2020/5/25 9:17
 **/
public class HasStatic {
    private static int x = 100;

    public static void main(String args[]) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);
    }
}