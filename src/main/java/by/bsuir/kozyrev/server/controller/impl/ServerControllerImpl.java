package by.bsuir.kozyrev.server.controller.impl;

import by.bsuir.kozyrev.server.bean.Account;
import by.bsuir.kozyrev.server.controller.ServerController;
import by.bsuir.kozyrev.server.controller.command.ServerCommand;
import by.bsuir.kozyrev.server.controller.command.ServerCommandProvider;

public class ServerControllerImpl implements ServerController {
    @Override
    public String executeRequest(String request, Account account) {
        String commandName;
        commandName = request.split("\\s+")[0];
        ServerCommand command = ServerCommandProvider.getServerCommandByName(commandName);
        return command.execute(request, account);
    }
}
