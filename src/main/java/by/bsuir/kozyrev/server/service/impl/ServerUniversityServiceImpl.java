package by.bsuir.kozyrev.server.service.impl;

import by.bsuir.kozyrev.server.bean.Student;
import by.bsuir.kozyrev.server.dao.DaoException;
import by.bsuir.kozyrev.server.dao.DaoFactory;
import by.bsuir.kozyrev.server.service.ServerUniversityService;
import by.bsuir.kozyrev.server.service.ServerServiceException;

import java.util.List;

public class ServerUniversityServiceImpl implements ServerUniversityService {
    public ServerUniversityServiceImpl() {
    }

    @Override
    public void add(Student student) throws ServerServiceException {
        try {
            DaoFactory.getInstance().getUniversityDao().add(student);
        } catch (DaoException e) {
            throw new ServerServiceException(e);
        }
    }

    @Override
    public void edit(Student student) throws ServerServiceException {
        try {
            DaoFactory.getInstance().getUniversityDao().edit(student);
        } catch (DaoException e) {
            throw new ServerServiceException(e);
        }
    }

    @Override
    public List<Student> getById(String id) throws ServerServiceException {
        try {
            return DaoFactory.getInstance().getUniversityDao().getById(id);
        } catch (DaoException e) {
            throw new ServerServiceException(e);
        }
    }
}
