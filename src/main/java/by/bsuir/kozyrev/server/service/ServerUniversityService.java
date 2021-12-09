package by.bsuir.kozyrev.server.service;

import by.bsuir.kozyrev.server.bean.Student;

import java.util.List;

public interface ServerUniversityService {
    void add(Student student) throws ServerServiceException;

    void edit(Student student) throws ServerServiceException;

    List<Student> getById(String id) throws ServerServiceException;
}
