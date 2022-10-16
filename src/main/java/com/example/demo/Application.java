package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student maria = new Student("Maria2", "Jones", "nadya2.jones@gmail.com", 25);
            Student ahmed = new Student("Igor", "Ali", "igor22.jones@gmail.com", 32);


//            studentRepository.findStudentsByFirstNameEqualsAndAgeEquals(
//                    "Maria",
//                    21).forEach(System.out::println);

            studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThan(
                    "Igor",
                    18).forEach(System.out::println);

            studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThanNative(
                    "Igor",
                    18).forEach(System.out::println);
            studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThanExp2(
                    "Igor",
                    18).forEach(System.out::println);

            int result = studentRepository.deleteStudentById(15L);
            System.out.println(result);

            studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThanExp2(
                    "Igor",
                    18).forEach(System.out::println);


        };
    }

}


