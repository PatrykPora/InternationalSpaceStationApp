package pl.patrykpora.internationalspacestation.services;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.model.IssPosition;
import pl.patrykpora.internationalspacestation.services.exceptions.IssCurrentPositionException;

import java.io.IOException;
import java.time.Duration;

public class IssSpeedService {
    public static final Logger logger = LoggerFactory.getLogger(IssSpeedService.class);

    private final String URL = "http://api.open-notify.org/iss-now.json";
    private final OkHttpClient client;
    private final Request request;


    public IssSpeedService() {
        this.client = HTTPClientProvider.getInstance().getClient();
        this.request = new Request.Builder()
                .url(URL)
                .build();
    }


    private IssPosition getIssCurrentPosition() throws IssCurrentPositionException {
        IssPosition issPosition = new IssPosition();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            long timestamp = jsonObject.getLong("timestamp");
            double latitude = jsonObject.getJSONObject("iss_position").getDouble("latitude");
            double longitude = jsonObject.getJSONObject("iss_position").getDouble("longitude");
            issPosition.setLongitude(longitude);
            issPosition.setLatitude(latitude);
            issPosition.setTimestamp(timestamp);
        } catch (IOException e) {
            logger.error("exception trying to get iss current position");
            throw new IssCurrentPositionException("error trying to get iss position from api", e);
        }
        return issPosition;
    }


    public double calculateIssSpeed() throws IssCurrentPositionException {
        logger.info("starting to calculate ");
        IssPosition one = getIssCurrentPosition();


        try {
            Thread.sleep(Duration.ofSeconds(7));
        } catch (InterruptedException e) {
            logger.info("thread sleep in calculate iss speed due to api configuration that have to wait at least 7 seconds to retrieve current position");
        }

        IssPosition two = getIssCurrentPosition();

        long time = two.getTimestamp() - one.getTimestamp();
        logger.info("time in seconds between two positions is {}", time);
        logger.info("starting to calculate the distance by using haversine method");
        double distanceInKilometers = calculateDistance(one.getLatitude(), one.getLongitude(), two.getLatitude(), two.getLongitude());
        logger.info("calculated distance in kilometers is {} ", distanceInKilometers);
        double kilometersPerSecond = distanceInKilometers / time;
        double kilometersPerHour = kilometersPerSecond * 3600;
        logger.info("calculated speed kilometer per second {}", kilometersPerSecond);
        logger.info("calculated speed kilometer per hour {}", kilometersPerHour);
        return kilometersPerHour;
    }

    private double calculateDistance(double startLat, double startLong, double endLat, double endLong) {
        final int EARTH_RADIUS = 6371;
        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = haversine(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversine(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    private double haversine(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
