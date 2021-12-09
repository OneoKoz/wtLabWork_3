package by.bsuir.kozyrev.server.controller.command.impl;

import by.bsuir.kozyrev.server.bean.Account;
import by.bsuir.kozyrev.server.bean.Role;
import by.bsuir.kozyrev.server.bean.Student;
import by.bsuir.kozyrev.server.controller.command.ServerCommand;
import by.bsuir.kozyrev.server.service.ServerUniversityService;
import by.bsuir.kozyrev.server.service.ServerServiceException;
import by.bsuir.kozyrev.server.service.ServerServiceFactory;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class EditCommand implements ServerCommand {
    @Override
    public String execute(String request, Account account) {
        if (account.getRole() == Role.GUEST) {
            return "Not authorized";
        } else if (account.getRole() != Role.ADMIN) {
            return "Not enough rights";
        }

        ServerServiceFactory serviceFactory = ServerServiceFactory.getInstance();
        ServerUniversityService serverService = serviceFactory.getServerServiceUniversityService();

        Map<String, String> params = new HashMap<>();
        for (String param : request.split("\\s+")) {
            String[] keyValue = param.split("=");
            if (keyValue.length == 2) {
                params.put(keyValue[0], keyValue[1].replaceAll("\"", ""));
            }
        }

        StringBuilder response = new StringBuilder();

        try {
            serverService.edit(new Student(params));
            return "Student edited\n";
        } catch (ServerServiceException | ParseException e) {
            response.append(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
