package http.okhttp;

import http.okhttp.get.GetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @author: PingQiu
 * @date: 2023/8/26 16:18
 */
@Slf4j
public class HTTPTest {


    @Test
    public void getTest(){
        String url = "http://***/get";
        GetUtil getUtil = new GetUtil();
        try {
            String s = getUtil.get(url);
            log.info(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
