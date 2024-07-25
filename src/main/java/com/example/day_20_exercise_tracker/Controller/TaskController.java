package com.example.day_20_exercise_tracker.Controller;

import com.example.day_20_exercise_tracker.Api.ApiResponse;
import com.example.day_20_exercise_tracker.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<Task>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/create")
    public ApiResponse createTask(@RequestBody Task task) {
        tasks.add(task);
        return new ApiResponse("Task added successfully");
    }


    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index,@RequestBody Task task) {
        tasks.set(index, task);
        return new ApiResponse("Task updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return new ApiResponse("Task deleted successfully");
    }

    @PutMapping("/changestatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index) {
        tasks.get(index).setStatus("done");
        return new ApiResponse("Task changed status successfully");
    }

    @GetMapping("/search/{title}")
    public Task searchByTitle(@PathVariable String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }


}
