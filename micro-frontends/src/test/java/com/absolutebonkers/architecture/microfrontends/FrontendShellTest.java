package com.absolutebonkers.architecture.microfrontends;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class FrontendShellTest {
    @Test
    void shellRoutesToIndependentlyImplementedFeatureModules() {
        var shell = new FrontendShell(List.of(new StorefrontModule(), new AccountModule()));

        assertEquals("Storefront", shell.navigate("/shop"));
        assertEquals("Account", shell.navigate("/account"));
    }
}
