package com.absolutebonkers.architecture.soa;

import java.util.Map;

public final class CustomerProfileService {
    private final Map<String, CustomerProfile> profiles;

    public CustomerProfileService(Map<String, CustomerProfile> profiles) {
        this.profiles = Map.copyOf(profiles);
    }

    public CustomerProfile findProfile(String customerId) {
        var profile = profiles.get(customerId);
        if (profile == null) {
            throw new IllegalArgumentException("Unknown customer: " + customerId);
        }
        return profile;
    }

    public record CustomerProfile(String id, String displayName, String email) {}
}
