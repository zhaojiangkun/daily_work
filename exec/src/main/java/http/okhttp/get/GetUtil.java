package http.okhttp.get;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sun.security.acl.AclEntryImpl;
import sun.security.acl.AclImpl;

import java.io.IOException;

/**
 * @author: PingQiu
 * @date: 2023/8/26 16:14
 */
public class GetUtil {
    OkHttpClient client = new OkHttpClient();

    public String get(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response execute = client.newCall(request).execute();
        return execute.body().string();
    }
}
