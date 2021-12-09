package by.bsuir.kozyrev.server.controller.command;

import by.bsuir.kozyrev.server.bean.Account;

public interface ServerCommand {
    String execute(String request, Account account);
}
