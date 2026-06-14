package expert.os.books.architecture.patterns.mvc;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class HelloController implements Serializable {

    private String name = "Jakarta EE";

    public String getMessage() {
        return "Hello " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}