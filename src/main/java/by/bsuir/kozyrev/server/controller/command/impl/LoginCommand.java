package by.bsuir.kozyrev.server.controller.command.impl;

import by.bsuir.kozyrev.server.bean.Account;
import by.bsuir.kozyrev.server.controller.command.ServerCommand;
import by.bsuir.kozyrev.server.service.ServerAccountService;
import by.bsuir.kozyrev.server.service.ServerServiceException;
import by.bsuir.kozyrev.server.service.ServerServiceFactory;

public class LoginCommand implements ServerCommand {
    @Override
    public String execute(String request, Account account) {
        ServerServiceFactory serviceFactory = ServerServiceFactory.getInstance();
        ServerAccountService serverAccountService = serviceFactory.getServerAccountService();

        StringBuilder response = new StringBuilder();

        try {
            if (request.split(" ").length < 3) {
                return "Invalid command parameters\n";
            }
            String login = request.split(" ")[1];
            String password = request.split(" ")[2];
            Account newAccount = serverAccountService.login(login, password);
            account.setLogin(newAccount.getLogin());
            account.setPassword(newAccount.getPassword());
            account.setRole(newAccount.getRole());
            return "Login" + login + ", role: " + account.getRole().toString();
        } catch (ServerServiceException e) {
            response.append(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
