package expert.os.books.architecture.patterns.mvc.cli;

import expert.os.books.architecture.patterns.mvc.TaskModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class TaskController {
    private final TaskModel model;
    private final TaskConsoleView view;

    @Inject
    public TaskController(TaskModel model, TaskConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void handleUserInput(String rawInput) {
        try {
            model.addTask(rawInput);
            view.render(model);
        } catch (IllegalArgumentException e) {
            view.renderError(e.getMessage());
        }
    }
}