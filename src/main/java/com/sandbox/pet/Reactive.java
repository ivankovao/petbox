package com.sandbox.pet;

import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/log")
public class Reactive {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getLogData() {
        return Flux.just("Log1", "Log2", "Log3", "Log4", "Log5").delayElements(Duration.ofSeconds(1));
    }
}
