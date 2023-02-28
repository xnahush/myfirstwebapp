package com.nahush.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount, "Kanishka", "Learn Spring boot", LocalDate.now(),false));
        todos.add(new Todo(++todoCount, "Nahush", "Learn Spark", LocalDate.now().plusDays(15),false));
        todos.add(new Todo(++todoCount, "Nahush", "Learn Python", LocalDate.now().plusDays(20),false));
    }
    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addNewTodo(String username, String description, LocalDate targetDate, boolean isDone){
        todos.add(new Todo(++todoCount, username, description, targetDate, isDone));
    }

    public void deleteTodo(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteTodo(todo.getId());
        todos.add(todo);
    }
}
