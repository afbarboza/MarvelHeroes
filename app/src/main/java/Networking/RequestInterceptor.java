package Networking;

import java.io.IOException;

import Utils.Constants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl url = request.url().newBuilder()
                .addQueryParameter(Constants.API_PUBLIC_KEY, Constants.API_PUBLIC_KEY_VALUE)
                .addQueryParameter(Constants.API_TIMESTAMP, Constants.API_TIMESTAMP_VALUE)
                .addQueryParameter(Constants.API_HASH, Constants.API_HASH_VALUE)
                .addQueryParameter(Constants.API_SEARCH_CRITERIA_SERIES, Constants.API_SEARCH_CRITERIA_SERIES_VALUE)
                .addQueryParameter(Constants.API_SEARCH_CRITERIA_ORDER_BY, Constants.API_SEARCH_CRITERIA_ORDER_BY_VALUE)

                .build();

        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
