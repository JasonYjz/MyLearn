package commonused.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by jasyu on 2019/12/13.
 * Date对象存放的是自1970年1月1日0点时候到现在的毫秒数
 * 同一个date对象，即同一个时间。不同的时区，输出不同的时间
 *
 * Date对象里存的是自格林威治时间（ GMT）1970年1月1日0点至Date对象所表示时刻所经过的毫秒数。
 * 所以，如果某一时刻遍布于世界各地的程序员同时执行new Date语句，这些Date对象所存的毫秒数是完全一样的。
 * 也就是说，Date里存放的毫秒数是与时区无关的。
 *
 * 继续上述例子，如果上述3个程序员调用那一刻的时间是北京时间2017年8月24日11:17:10，他们继续调用
 * System.out.println(date);
 * 那么北京的程序员将会打印出2017年8月24日11:17:10，
 * 而东京的程序员会打印出2017年8月24日12:17:10，
 * 伦敦的程序员会打印出2017年8月24日4:17:10。
 *
 * 既然Date对象只存了一个毫秒数，为什么这3个毫秒数完全相同的Date对象，可以打印出不同的时间呢？
 * 这是因为Sysytem.out.println函数在打印时间时，会取操作系统当前所设置的时区，然后根据这个时区将同毫秒数解释成该时区的时间。
 * ————————————————
 * 版权声明：本文为CSDN博主「halfclear」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/halfclear/article/details/77573956
 **/
public class DifferentOutputWithSameDate {
    public static void main(String[] args) {
        Date date = new Date(1503544630000L);   // 对应的北京时间是2017-08-24 11:17:10

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));  // 设置伦敦时区

        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));
    }
}
