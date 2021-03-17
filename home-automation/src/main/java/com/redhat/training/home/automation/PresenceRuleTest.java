package com.redhat.training.home.automation;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.redhat.training.home.automation.rules.PresenceRule;

public class PresenceRuleTest {
    @Test
    public void isMetWhenPresenceDetected() {
        PresenceRule rule = new PresenceRule();

        RoomConditions conditions = new RoomConditions(0);
        conditions.presenceDetected = true;

        assertTrue(rule.meets(conditions));
    }
}