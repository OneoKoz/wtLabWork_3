package by.bsuir.kozyrev.client.controller.command.impl;

import by.bsuir.kozyrev.client.controller.command.ClientCommand;
import by.bsuir.kozyrev.client.service.ClientService;
import by.bsuir.kozyrev.client.service.ServiceException;
import by.bsuir.kozyrev.client.service.ClientServiceFactory;

public class AddCommand implements ClientCommand {

    @Override
    public String execute(String request) {
        ClientServiceFactory serviceFactory = ClientServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        String response;

        try {
            clientService.sendRequest(request);
            response = clientService.getResponse();
        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}
