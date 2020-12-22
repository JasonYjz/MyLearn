package commonused.basic;


import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;

/**
 * Created by jasyu on 2020/12/22.
 **/
public class TryCatchFinally {
    public static void main(String[] args) {
        TryCatchFinally tryCatchFinally = new TryCatchFinally();

        try {
            tryCatchFinally.doThrowMethod("2020-20-45");
        } catch (Exception e) {
            System.out.println("main: " + e.getMessage());
        }

    }

    private void doThrowMethod(String source) throws ParseException {
        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");

        try {
            System.out.println("doThrowMethod:" + format.parse(source));
        } finally {
            System.out.println("doThrowMethod: finally");;
        }
    }
}
