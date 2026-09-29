package com.factory.copilot;

import com.factory.copilot.service.HindsightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hindsight")
public class HindsightTestController {

    private final HindsightService hindsightService;

    public HindsightTestController(HindsightService hindsightService) {
        this.hindsightService = hindsightService;
    }

    @PostMapping("/retain")
    public String retain(@RequestBody String content) {
        return hindsightService.retainMemory(content);
    }

    @PostMapping("/recall")
    public String recall(@RequestBody String query) {
        return hindsightService.recallMemory(query);
    }
}