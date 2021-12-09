package by.bsuir.kozyrev.server.controller.command.impl;

import by.bsuir.kozyrev.server.bean.Account;
import by.bsuir.kozyrev.server.bean.Role;
import by.bsuir.kozyrev.server.bean.Student;
import by.bsuir.kozyrev.server.controller.command.ServerCommand;
import by.bsuir.kozyrev.server.service.ServerUniversityService;
import by.bsuir.kozyrev.server.service.ServerServiceException;
import by.bsuir.kozyrev.server.service.ServerServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUserByIdCommand implements ServerCommand {
    @Override
    public String execute(String request, Account account) {
        if (account.getRole() == Role.GUEST) {
            return "Not authorized";
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
            String id = params.get("id");
            if (id == null) {
                return "Invalid command parameters\n";
            }
            List<Student> students = serverService.getById(id);
            if (students.size() == 0) {
                return "No student with id = " + id + "\n";
            } else {
                for (Student student : serverService.getById(id)) {
                    response.append(student.toString()).append("\n");
                }
            }
        } catch (ServerServiceException e) {
            response = new StringBuilder(e.getMessage()).append("\n");
        }

        return response.toString();
    }
}
