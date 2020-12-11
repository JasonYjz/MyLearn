package commonused.basic;

/**
 * Created by jasyu on 2019/12/26.
 *
 * 包装类型与基本数据类型的比较
 * 装箱过程是通过调用包装器的valueOf方法实现的
 * 拆箱过程是通过调用包装器的xxxValue方法实现的（xxx表示对应的基本数据类型）
 **/
public class CompareDataType {
    public static void main(String[] args) {
        //a, b, c, d都进行了装箱，其中，a, b的对象都是取自IntegerCache.cache数组，
        // 如果他们装箱前的值相同，那么a, b就是同一个对象，所以  a==b为true
        Integer i = 10;
        Integer j = 10;
        System.out.println(i == j);

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);

        int k = 10;
        System.out.println(k == i);     //Integer 的自动拆箱功能，也就是比较两个基本数据类型，结果当然为true
        int kk = 128;
        System.out.println(kk == a);    //解释和第三个一样。int和integer(无论new否)比，都为true，因为会把Integer自动拆箱为int再去比较。

        Integer m = new Integer(10);    //new Integer会创建对象，存储在堆中。而Integer在[-128,127]中，从缓存中取，否则会new Integer
        Integer n = new Integer(10);
        System.out.println(m == n);     //因为这个虽然值为10，但是我们都是通过 new 关键字来创建的两个对象，是不存在缓存的概念的。两个用new关键字创建的对象用 == 进行比较，结果当然为 false。

        int aaa = 100;
        TestClass bbb = new TestClass();
        bbb.setMax(10);
        int ccc = bbb.getMax() == null ? 0 : bbb.getMax();


        if (ccc != 0 && aaa > bbb.getMax()) {
            System.out.println("xxxx");
        }else {
            System.out.println("bbbbbbbb");
        }
    }

    private static class TestClass {
        private Integer max;

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }
    }
}
