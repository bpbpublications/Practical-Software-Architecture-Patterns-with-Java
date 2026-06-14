package expert.os.books.architecture.patterns.mvc.cli;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ============================================================================
// 1. THE MODEL
// ============================================================================

/**
 * The Model represents the enterprise data and business rules.
 * ARCHITECTURAL RULE: The Model MUST NOT depend on the Controller or the View.
 */
@ApplicationScoped
class TaskModel {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty.");
        }
        tasks.add(task);
    }

    public List<String> getTasks() {
        return Collections.unmodifiableList(tasks);
    }
}