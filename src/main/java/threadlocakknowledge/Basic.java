package threadlocakknowledge;

public class Basic {
    private static ThreadLocal<Long> x = ThreadLocal.withInitial(() -> {
        System.out.println("initial value.");
        return Thread.currentThread().getId();
    });

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("new Thread:" + x.get());
            }
        }.start();

        x.set(107L);
        x.remove();

        System.out.println("main Thread:" + x.get());
    }
}
