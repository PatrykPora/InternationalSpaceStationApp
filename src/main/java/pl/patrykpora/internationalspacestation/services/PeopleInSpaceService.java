package pl.patrykpora.internationalspacestation.services;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykpora.internationalspacestation.model.Astronaut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeopleInSpaceService {

    public static final Logger logger = LoggerFactory.getLogger(PeopleInSpaceService.class);
    private final String URL = "http://api.open-notify.org/astros.json/";
    private final OkHttpClient client;

    private final Request request;

    private final List<Astronaut> astronautList;

    private long numberOfPeopleInSpace;

    public PeopleInSpaceService() {
        this.client = HTTPClientProvider.getInstance().getClient();
        this.request = new Request.Builder()
                .url(URL)
                .build();
        this.astronautList = new ArrayList<>();
        this.numberOfPeopleInSpace = 0;
    }

    public List<Astronaut> getAstronautList() {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                logger.error("error trying to get people in space from api", e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String jsonData = response.body().string();
                parseAstronautData(jsonData);
            }
        });
        return astronautList;
    }

    private void parseAstronautData(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray astronauts = jsonObject.getJSONArray("people");
        for (int i = 0; i < astronauts.length(); i++) {
            JSONObject person = astronauts.getJSONObject(i);
            String craft = person.getString("craft");
            String name = person.getString("name");
            astronautList.add(new Astronaut(name, craft));
        }
    }

    public long getNumberOfPeopleInSpace() {
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            numberOfPeopleInSpace = Long.parseLong(jsonObject.get("number").toString());

        } catch (IOException e) {
            logger.error("exception trying to get number of astronauts in space");
        }
        return numberOfPeopleInSpace;
    }



}
