package cwe;

/**
 * Created by jasyu on 2020/12/14.
 **/
public final class Foo implements Runnable {
    @Override public void run() {
        // ...
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread threadFoo = new Thread(foo);

        threadFoo.run();
    }
}
