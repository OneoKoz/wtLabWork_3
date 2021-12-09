package by.bsuir.kozyrev.server.dao.impl;

import by.bsuir.kozyrev.server.bean.Account;
import by.bsuir.kozyrev.server.dao.DaoException;
import by.bsuir.kozyrev.server.dao.parser.XMLParser;
import by.bsuir.kozyrev.server.dao.parser.XMLParserException;
import by.bsuir.kozyrev.server.dao.parser.impl.XMLUniversityParser;
import by.bsuir.kozyrev.server.dao.AccountDao;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AccountDaoImpl implements AccountDao {
    private final File dbFile = new File(
            Objects.requireNonNull(getClass().getClassLoader().getResource("accounts_db.xml")).getFile());

    @Override
    public Account login(String login, String passwordHash) throws DaoException {
        try {
            XMLParser parser = new XMLUniversityParser();
            List<Map<String, String>> profileParams = parser.parse(dbFile);
            for (Map<String, String> params : profileParams) {
                if (params.get("login").equals(login) && params.get("password").equals(passwordHash)) {
                    return new Account(params);
                }
            }
            return new Account();
        } catch (XMLParserException | ParserConfigurationException | IOException | SAXException e) {
            throw new DaoException(e);
        }
    }
}
