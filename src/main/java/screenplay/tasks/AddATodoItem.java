package screenplay.tasks;

import static screenplay.pages.TodoMvcPageElements.TODO_FIELD;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import screenplay.models.Actor;
import screenplay.models.Task;

public class AddATodoItem implements Task {

    private String todoText;

    public AddATodoItem(final String todoText) {
        this.todoText = todoText;
    }

    public static AddATodoItem called(String todoText) {
        return new AddATodoItem(todoText);
    }

    @Override
    public void perform(WebDriver driver, Actor actor) {
        driver.findElement(TODO_FIELD.locator()).sendKeys(todoText, Keys.ENTER);
        logger.info(() -> actor.name() + " added a todo list item called '" + todoText + "'");
    }
}
