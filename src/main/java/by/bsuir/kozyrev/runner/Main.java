package by.bsuir.kozyrev.runner;

import by.bsuir.kozyrev.client.Client;
import by.bsuir.kozyrev.server.Server;

public class Main {
    public static void main(String[] args) {
        new Server().start();
        new Client().start();
    }
}
