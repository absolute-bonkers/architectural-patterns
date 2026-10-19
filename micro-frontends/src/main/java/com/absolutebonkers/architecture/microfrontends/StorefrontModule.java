package com.absolutebonkers.architecture.microfrontends;

public final class StorefrontModule implements FrontendModule {
    @Override
    public String route() {
        return "/shop";
    }

    @Override
    public String render() {
        return "Storefront";
    }
}
