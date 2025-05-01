package org.malyka.student.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
@Data
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private LocalDate dob;
    private String course;
    private int year;
    private double gpa;
    private String enrollmentStatus;
}
