package com.nahush.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount, "udemy", "Learn Spring boot", LocalDate.now(),false));
        todos.add(new Todo(++todoCount, "udemy", "Learn Spark", LocalDate.now().plusDays(15),false));
        todos.add(new Todo(++todoCount, "udemy", "Learn Python", LocalDate.now().plusDays(20),false));
    }
    public List<Todo> findByUserName(String username) {
        return todos;
    }

    public void addNewTodo(String username, String description, LocalDate targetDate, boolean isDone){
        todos.add(new Todo(++todoCount, username, description, targetDate, isDone));
    }
}
