package commonused.basic;

/**
 * Created by jasyu on 2019/12/11.
 **/
public class StaticWithExtends extends StaticWithExtendsParent{
    public StaticWithExtends(){
        System.out.println("Child的构造方法");
    }
    {
        System.out.println("Child的构造代码块");
    }
    static{
        System.out.println("Child的静态代码块");
    }

    public static void main(String[] args) {
        new StaticWithExtends();
    }
}

class StaticWithExtendsParent {
    public StaticWithExtendsParent(){
        System.out.println("Parent的构造方法");
    }
    {
        System.out.println("Parent的构造代码块");
    }
    static{
        System.out.println("Parent的静态代码块");
    }
}


