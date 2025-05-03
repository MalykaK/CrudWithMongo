package org.malyka.student.startup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import jakarta.annotation.PostConstruct;
import org.malyka.student.model.Student;
import org.malyka.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

//Understand this below annotation

@Configuration
public class LoadData {
    ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

    //ask chatgpt to explain like a kid

    @Value("${json.data.path}")
    private String jsonData;
    @Autowired
    StudentRepo studentRepo;

    //learn this
    @PostConstruct
    public void readMyStudentData() throws IOException {
        // Practice with more models
        var studentList = objectMapper.readValue(new File(jsonData), Student[].class);
        studentRepo.deleteAll();
        studentRepo.saveAll(Arrays.asList(studentList));
    }
}
