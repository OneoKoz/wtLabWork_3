package by.bsuir.kozyrev.client.controller.impl;

import by.bsuir.kozyrev.client.controller.ClientController;
import by.bsuir.kozyrev.client.controller.command.ClientCommand;
import by.bsuir.kozyrev.client.controller.command.ClientCommandProvider;
import by.bsuir.kozyrev.client.controller.constant.ClientControllerConstant;

public class ClientControllerImpl implements ClientController {
    @Override
    public String executeRequest(String request) {
        String commandName;
        commandName = request.split("\\s+")[0];

        ClientCommand command = ClientCommandProvider.getCommandByName(commandName);

        if (command == null) {
            return ClientControllerConstant.INVALID_COMMAND_RESPONSE;
        } else {
            return command.execute(request);
        }
    }
}
