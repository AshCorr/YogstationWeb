package net.yogstation.ping.pojo;

public class ServerPingResponse {
    private int players;
    private String mapName;
    private int roundDuration;

    public ServerPingResponse(int players, String mapName, int roundDuration) {
        this.players = players;
        this.mapName = mapName;
        this.roundDuration = roundDuration;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getRoundDuration() {
        return roundDuration;
    }

    public void setRoundDuration(int roundDuration) {
        this.roundDuration = roundDuration;
    }
}
