package net.yogstation.ping.service;

import net.yogstation.ping.pojo.ServerPingResponse;

public interface StatusService {
    void updateStatus();
    ServerPingResponse getServerStatus();
}
