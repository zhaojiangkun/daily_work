package http.okhttp.get.post;

import okhttp3.*;

import java.io.IOException;

/**
 * @author: PingQiu
 * @date: 2023/8/26 16:25
 */
public class PostUtil {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                //授权信息
//                .addHeader(
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
