package expert.os.books.architecture.patterns.mvc.jsf;

import expert.os.books.architecture.patterns.mvc.TaskModel;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * In JSF, the Backing Bean bridges the gap between HTTP and Desktop MVC.
 * Because it is @ViewScoped, the framework keeps this state alive in memory
 * across multiple HTTP POST requests made from the same screen.
 */
@Named("taskBackingBean")
@ViewScoped
public class TaskBackingBean implements Serializable {

    private TaskModel model;
    private String newTask;

    protected TaskBackingBean() {}

    @Inject
    public TaskBackingBean(TaskModel model) {
        this.model = model;
    }

    public void addTask() {
        try {
            model.addTask(newTask);

            newTask = "";
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<String> getTasks() {
        return model.getTasks();
    }
    public String getNewTask() { return newTask; }
    public void setNewTask(String newTask) { this.newTask = newTask; }
}