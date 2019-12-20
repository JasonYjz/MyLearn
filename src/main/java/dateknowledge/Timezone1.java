package dateknowledge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by jasyu on 2019/12/13.
 * 我的操作系统 是"Asia/Shanghai"，即GMT+8的北京时间，那么执行日期转字符串的format方法时，
 * 由于日期生成时默认是操作系统时区，因此 2014-1-31 21:20:50是北京时间，那么推算到GMT时区，
 * 自然是要减8个小时的,即结果（2014-01-31 13:20:50）；而执行字符串转日期的parse方法时，
 * 由于字符串本身没有时区的概念，因此 2013-1-31 22:17:14就是指GMT（UTC）时间【ps：所有字符串都看做是GMT时间】，
 * 那么当转化为日期时要加上默认时区， 即"Asia/Shanghai"，因此要加上8个小时。
 **/
public class Timezone1 {
    public static void main(String[] args) {
        Date date = new Date(1391174450000L); // 2014-1-31 21:20:50
        String dateStr = "2014-1-31 21:20:50 ";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date dateTmp = dateFormat.parse(dateStr);
            System.out.println(dateTmp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateStrTmp = dateFormat.format(date);
        System.out.println(dateStrTmp);
    }
}
