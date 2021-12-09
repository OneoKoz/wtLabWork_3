package by.bsuir.kozyrev.client;

import by.bsuir.kozyrev.client.controller.ClientController;
import by.bsuir.kozyrev.client.controller.impl.ClientControllerImpl;

import java.util.Scanner;

public class Client extends Thread implements Runnable {
    private boolean isActive;

    public Client() {
        this.isActive = true;
    }

    protected void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        ClientController clientController = new ClientControllerImpl();

        String request;
        String response;
        clientController.executeRequest("connect");

        while (isActive) {
            System.out.print("input command: ");
            request = scanner.nextLine();
            response = clientController.executeRequest(request);
            System.out.println(response);
        }
    }
}
