package com.leaveplanner.domain;

public enum LeaveType {
    ANNUAL("연가"),
    REWARD("포상휴가"),
    COMFORT("위로휴가"),
    SPECIAL("특별휴가"),
    EXTERIOR("외출/외박");

    private final String displayName;

    LeaveType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}