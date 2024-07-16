package com.prokys.crudDemo.dao;

import com.prokys.crudDemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
