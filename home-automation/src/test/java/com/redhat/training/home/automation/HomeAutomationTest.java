package com.redhat.training.home.automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.redhat.training.home.automation.rules.InMemoryRulesRepository;
import com.redhat.training.home.automation.rules.RulesRepository;

public class HomeAutomationTest {
    LightSystem light;
    HomeAutomation home;
    RulesRepository rulesRepository;

    @BeforeEach
    public void setUp() {
        light = new ConsoleLightSystem();
        rulesRepository = new InMemoryRulesRepository();
        home = new HomeAutomation(light, rulesRepository);
    }

    @Test
    public void switchOffLightsUnderEnoughDaylight() {
        home.processConditions(new RoomConditions(0.20));

        assertFalse(light.isOn());
    }

    @Test
    public void switchOnLightsUnderLowDaylight() {
        home.processConditions(new RoomConditions(0.19));

        assertTrue(light.isOn());
    }

    @Test
    public void transitionToLightsOnUnderEnoughDaylight() {
        light.switchOn();

        home.processConditions(new RoomConditions(0.30));

        assertFalse(light.isOn());
    }
}
