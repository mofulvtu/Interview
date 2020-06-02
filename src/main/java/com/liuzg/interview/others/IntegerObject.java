package com.liuzg.interview.others;

/**
 * <pre>
 *  Desc: Integer -128到127之间的值都是直接从缓存中取出，在此范围的数值不创建新对象
 *  </pre>
 *
 * @author liuzg
 * @date 2020/5/25 9:18
 **/
public class IntegerObject {

    public static void main(String[] args) {
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);

        System.out.println(i01 == i02);//true
        System.out.println(i01 == i03);//true
        System.out.println(i02 == i04);//true
        System.out.println(i03 == i04);// == 比较双方是都是引用类型时，则比较的时引用地址，对象不同，地址不同，结果为false
        System.out.println(i03.equals(i04));// equals 比较的是真实的数值，所以相等，为true

    }
}
