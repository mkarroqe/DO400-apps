package com.redhat.training.home.automation;

public interface LightSystem {
    void switchOff();

    void switchOn();

    boolean isOn();
}