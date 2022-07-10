package ru.hogwartS.school.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class InfoController {

    private final ServerProperties serverProperties;
    Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Value("${server.port}")
    private int serverPort;

    public InfoController(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    @GetMapping("/getPort")
    public ResponseEntity<Integer> getPortNumber() {
        int port = serverProperties.getPort();
        return ResponseEntity.ok(port);
    }

    @GetMapping("/sum")
    public int getSum() {
        long start = System.currentTimeMillis();
        List<Integer> limit = Stream
                .iterate(1, a -> a +1)
                .limit(1_000_000)
                .collect(Collectors.toList());
        int sum = limit.stream()
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        return (int) (System.currentTimeMillis() - start);


    }
}

