package com.absolutebonkers.architecture.clean;

public final class ConsoleGreetingPresenter implements GreetingOutput {
    private String lastMessage;

    @Override
    public void present(Greeting greeting) {
        lastMessage = greeting.message();
    }

    public String lastMessage() {
        return lastMessage;
    }
}
