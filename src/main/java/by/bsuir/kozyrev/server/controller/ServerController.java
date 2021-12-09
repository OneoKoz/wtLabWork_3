package by.bsuir.kozyrev.server.controller;

import by.bsuir.kozyrev.server.bean.Account;

public interface ServerController {
    String executeRequest(String request, Account account);
}
