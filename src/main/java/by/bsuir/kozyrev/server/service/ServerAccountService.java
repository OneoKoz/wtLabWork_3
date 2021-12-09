package by.bsuir.kozyrev.server.service;

import by.bsuir.kozyrev.server.bean.Account;

public interface ServerAccountService {
    Account login(String login, String password) throws ServerServiceException;
}
