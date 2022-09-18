package com.cs.commandos.config;

import com.cs.commandos.service.SpaceMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStarter  {

    @Autowired
    private SpaceMasterService spaceMasterService;

    @EventListener
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("started");
        spaceMasterService.getAllSpaces();
        System.out.println("start completed");
    }
}
