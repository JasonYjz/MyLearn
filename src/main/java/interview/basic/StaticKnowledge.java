package interview.basic;

/**
 * Created by jasyu on 2019/11/25.
 * 执行顺序：静态域〉构造块〉构造方法
 * 静态域包括：静态变量、静态方法、静态块
 **/
public class StaticKnowledge {
    public static StaticKnowledge t1 = new StaticKnowledge();
    public static StaticKnowledge t2 = new StaticKnowledge();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        StaticKnowledge t = new StaticKnowledge();
    }

}
/*链接：https://www.nowcoder.com/questionTerminal/ab6eb06face84c4e81ab5bc6f0f7f258?orderByHotValue=1&mutiTagIds=134&page=1&onlyReference=false
来源：牛客网
StaticKnowledge --> B

开始时JVM加载B.class，对所有的静态成员进行声明，t1 t2被初始化为默认值，为null，又因为t1 t2需要被显式初始化，所以对t1进行显式初始化，
初始化代码块→构造函数（没有就是调用默认的构造函数），咦！静态代码块咋不初始化？因为在开始时已经对static部分进行了初始化，
虽然只对static变量进行了初始化，但在初始化t1时也不会再执行static块了，因为JVM认为这是第二次加载类B了，
所以static会在t1初始化时被忽略掉，所以直接初始化非static部分，也就是构造块部分（输出''构造块''）接着构造函数（无输出）。
接着对t2进行初始化过程同t1相同（输出'构造块'），此时就对所有的static变量都完成了初始化，接着就执行static块部分（输出'静态块'），
接着执行，main方法，同样也，new了对象，调用构造函数输出（'构造块'）

之前我一直有一个误区!就是认为静态块一定是最先初始化的!但是,阿里爸爸今天又用一记重拳猛击我的脸,额,好疼....当时的情况是这样的:
我在牛客网找虐中,碰到了这样的一道题,心中充满了鄙夷,心想"这tm还用看吗,肯定先是静态块,再接着三个构造块,弱鸡题",但是 = = ,答案却是"构造块 构造块 静态块 构造块".
......[黑线|||||||||]
于是总结了一下,以警后世 - -
正确的理解是这样的:
并不是静态块最先初始化,而是静态域.(BM：啊!多么痛的领悟!)
而静态域中包含静态变量、静态块和静态方法,其中需要初始化的是静态变量和静态块.而他们两个的初始化顺序是靠他们俩的位置决定的!
So！
初始化顺序是 t1 t2 静态块
* */