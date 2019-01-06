package net.yogstation.ping.service.impl;

import io.github.spair.byond.message.ByondClient;
import io.github.spair.byond.message.ByondMessage;
import io.github.spair.byond.message.ByondResponse;
import net.yogstation.ping.pojo.ServerPingResponse;
import net.yogstation.ping.service.StatusService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImplStatusService implements StatusService {
    private ServerPingResponse serverPingResponse;

    @Value("${net.yogstation.statusServerIp}")
    private String serverIP;
    @Value("${net.yogstation.statusServerPort}")
    private int serverPort;

    @Scheduled(fixedRate = 5000)
    public void updateStatus() {
        ByondMessage message = new ByondMessage(serverIP, serverPort, "status");
        ByondResponse response = new ByondClient().sendMessage(message);
        Map<String, String> decodedData = decodeData(response.getResponse(String.class));

        serverPingResponse = new ServerPingResponse(Integer.parseInt(decodedData.get("players")),
                decodedData.get("map_name"),
                Integer.parseInt(decodedData.get("round_duration")));
    }

    public ServerPingResponse getServerStatus() {
        return serverPingResponse;
    }

    public Map<String, String> decodeData(String raw) {
        Map<String, String> decodedData = new HashMap<String, String>();

        for (String keyValue : raw.split("&")) {
            String[] splitKeyValue = keyValue.split("=");

            if (splitKeyValue.length < 2)
                continue;

            try {
                decodedData.put(splitKeyValue[0], URLDecoder.decode(splitKeyValue[1], "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return decodedData;
    }
}
