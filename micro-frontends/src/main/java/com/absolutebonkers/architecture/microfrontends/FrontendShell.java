package com.absolutebonkers.architecture.microfrontends;

import java.util.List;

public final class FrontendShell {
    private final List<FrontendModule> modules;

    public FrontendShell(List<FrontendModule> modules) {
        this.modules = List.copyOf(modules);
    }

    public String navigate(String route) {
        return modules.stream()
                .filter(module -> module.route().equals(route))
                .findFirst()
                .map(FrontendModule::render)
                .orElseThrow(() -> new IllegalArgumentException("No module for route: " + route));
    }
}
