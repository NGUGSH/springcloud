import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
public class Test2 {
    public static void main(String[] args) {
//        获取当前时区的时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
//        2021-07-17T15:15:49.927+08:00[Asia/Shanghai]
    }
}
