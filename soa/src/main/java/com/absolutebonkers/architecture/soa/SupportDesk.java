package com.absolutebonkers.architecture.soa;

public final class SupportDesk {
    private final CustomerProfileService profiles;

    public SupportDesk(CustomerProfileService profiles) {
        this.profiles = profiles;
    }

    public String greetCustomer(String customerId) {
        return "Hello, " + profiles.findProfile(customerId).displayName();
    }
}
