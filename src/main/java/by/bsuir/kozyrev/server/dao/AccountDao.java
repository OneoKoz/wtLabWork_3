package by.bsuir.kozyrev.server.dao;

import by.bsuir.kozyrev.server.bean.Account;

public interface AccountDao {
    Account login(String login, String passwordHash) throws DaoException;
}
