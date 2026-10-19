package com.absolutebonkers.architecture.microfrontends;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class FrontendShell {
    private final List<FrontendModule> modules;

    public FrontendShell(List<FrontendModule> modules) {
        this.modules = List.copyOf(modules);
        Set<String> routes = new HashSet<>();
        for (FrontendModule module : this.modules) {
            String route = module.route();
            if (route == null || route.isBlank()) {
                throw new IllegalArgumentException("Module routes must not be blank");
            }
            if (!routes.add(route)) {
                throw new IllegalArgumentException("Duplicate module route: " + route);
            }
        }
    }

    public String navigate(String route) {
        return modules.stream()
                .filter(module -> module.route().equals(route))
                .findFirst()
                .map(FrontendModule::render)
                .orElseThrow(() -> new IllegalArgumentException("No module for route: " + route));
    }
}
