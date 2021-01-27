package com.example.line.server.constants;

public enum ConstantManager {

    FILE_PATH("");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    ConstantManager(String value) {
        this.value = value;
    }

}
