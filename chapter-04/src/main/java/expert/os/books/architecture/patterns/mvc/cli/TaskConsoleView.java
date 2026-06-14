package expert.os.books.architecture.patterns.mvc.cli;

import expert.os.books.architecture.patterns.mvc.TaskModel;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
class TaskConsoleView {
    public void render(TaskModel model) {
        System.out.println("\n--- Current To-Do List ---");
        List<String> tasks = model.getTasks();

        if (tasks.isEmpty()) {
            System.out.println("  [No tasks available]");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void renderError(String errorMessage) {
        System.err.println("[ERROR] " + errorMessage);
    }
}
