package net.yogstation.ping.controller;

import net.yogstation.ping.pojo.ServerPingResponse;
import net.yogstation.ping.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Autowired
    StatusService statusService;

    @GetMapping("/status")
    public ServerPingResponse getServerStatus() {
        return statusService.getServerStatus();
    }

}
