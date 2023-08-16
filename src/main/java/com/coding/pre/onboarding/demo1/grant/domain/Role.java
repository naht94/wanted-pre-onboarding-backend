package com.coding.pre.onboarding.demo1.grant.domain;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");
    private String role;
    Role(String role) {
        this.role = role;
    }
    public String grant() {
        return this.role;
    }
}
