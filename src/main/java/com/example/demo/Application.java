package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        StudentIdCardRepository studentIdCardRepository,
                                        BookRepository bookRepository) {
        return args -> {

            Faker faker = new Faker();
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = String.format("%s.%s@gmail.com", firstName, lastName);
                Student student = new Student(
                        firstName,
                        lastName,
                        email,
                        faker.number().numberBetween(17, 55));

                student.addBook(new Book("Clean Code", LocalDateTime.now().minusDays(4)));
                student.addBook(new Book("JavaCore", LocalDateTime.now().now()));
                student.addBook(new Book("Spring", LocalDateTime.now().minusYears(2)));

                StudentIdCard studentIdCard = new StudentIdCard("224344352235",student);
                student.setStudentIdCard(studentIdCard);
                studentRepository.save(student);

                studentRepository.findById(51l).ifPresent(System.out::println);



        };
    }


    private void generateRandomStudents(StudentRepository studentRepository, Faker faker) {
        for (int i = 0; i <= 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            studentRepository.save(student);
        }
    }

}


