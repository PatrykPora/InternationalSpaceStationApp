package pl.patrykpora.internationalspacestation.services;

import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class HTTPClientProvider {

    public static final Logger logger = LoggerFactory.getLogger(HTTPClientProvider.class);
    private static HTTPClientProvider httpClientProvider;
    private final OkHttpClient client;

    private HTTPClientProvider() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static synchronized HTTPClientProvider getInstance() {
        if (httpClientProvider == null) {
            httpClientProvider = new HTTPClientProvider();
        }
        return httpClientProvider;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void closeHttpClient() {
        logger.info("closing an http client ");
        try {
            if (client != null) {
                client.dispatcher().executorService().shutdown();
                client.connectionPool().evictAll();
            }
        } catch (Exception e) {
            logger.error("closeHttpClient error ", e);
        }
    }
}
