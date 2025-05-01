package org.malyka.student.repository;

import org.malyka.student.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,String> {


}
