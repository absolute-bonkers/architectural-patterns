package com.absolutebonkers.architecture.microfrontends;

public final class AccountModule implements FrontendModule {
    @Override
    public String route() {
        return "/account";
    }

    @Override
    public String render() {
        return "Account";
    }
}
