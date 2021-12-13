package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.gb.persist.Student;
import ru.gb.persist.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentRestController {

    private final StudentRepository repository;

    @Autowired
    public StudentRestController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}/id")
    public Student findById(@PathVariable("id") long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found"));
    }

    @Transactional
    @PostMapping()
    public Student create(@RequestBody Student student) {
        if (student.getId() != null) {
            throw new BadRequestException();
        }
        return repository.save(student);
    }

    @Transactional
    @PutMapping()
    public Student update(@RequestBody Student student) {
        if (student.getId() == null) {
            throw new BadRequestException();
        }
        return repository.save(student);
    }

    @Transactional
    @DeleteMapping("/{id}/id")
    public void delete(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    @ExceptionHandler
    public ResponseEntity<Void> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    public ResponseEntity<Void> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().build();
    }
}
