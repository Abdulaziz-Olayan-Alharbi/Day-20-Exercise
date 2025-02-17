package com.example.day_20_exercise_tracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String ID;
    private String title;
    private String description;
    private String status;
}
