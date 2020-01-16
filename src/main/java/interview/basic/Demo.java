package interview.basic;

import java.util.TimeZone;

/**
 * Created by jasyu on 2019/12/11.
 **/
public class Demo {
    public static void main(String[] args) {
        /*int count = 0;
        int num = 0;

        for (int i = 0; i <= 100; i++) {
            num = num + i;
            count = count++;
        }
        System.out.println("num=" + num);
        System.out.println("count=" + count);
        System.out.println("num * count = " + num * count);

        int x=20, y=5;
        System.out.println(x+y +""+(x+y)+y);*/

        String[] ids = TimeZone.getAvailableIDs();
        System.out.println(ids.length);
        for (String id:ids)
        {
            System.out.println(id);
        }
    }
}
