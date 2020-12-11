package commonused.basic;

import java.util.concurrent.TimeUnit;

/**
 * Created by jasyu on 2020/6/22.
 **/
public class ReturnTest {
    private int times;

    public static void main(String[] args) {
        ReturnTest returnTest = new ReturnTest();
        System.out.println(returnTest.doAction());
    }

    public int doAction() {
        int result = 0;
        try {
            result = doThrowException();
        } catch (Exception e) {
            for (int i = 1; i < 4; i++) {
                try {
                    long sleepMilliseconds = i * 1000L;
                    System.out.println("sleep " + sleepMilliseconds + "milliseconds");
                    TimeUnit.MILLISECONDS.sleep(sleepMilliseconds);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    break;
                }

                try {
                    return doThrowException();
                } catch (Exception ex) {
                    if (i == 3) {
                        System.out.println("3 times exception.");
                        throw e;
                    }
                }
            }
        }

        return result;
    }

    private int doThrowException() {
        times++;
        System.out.println("execute doThrowException method. " + times);
        if (times == 3) {
            return 999999;
        }
        throw new RuntimeException("runtime exception.");
    }
}
