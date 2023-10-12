package project.config;

import lombok.Getter;

public class ConfigProject {
    @Getter
    private final static int limitAmount;

    static {
        limitAmount = 11;
    }
}