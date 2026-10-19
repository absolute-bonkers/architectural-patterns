package com.absolutebonkers.architecture.soa;

public final class OrderDesk {
    private final CustomerProfileService profiles;

    public OrderDesk(CustomerProfileService profiles) {
        this.profiles = profiles;
    }

    public String addressOrder(String customerId) {
        return profiles.findProfile(customerId).email();
    }
}
