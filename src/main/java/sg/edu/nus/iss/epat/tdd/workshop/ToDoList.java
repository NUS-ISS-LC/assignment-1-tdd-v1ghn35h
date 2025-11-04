package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      // Add code here
      this.tasks.put(task.getDescription(), task);
   }

   public void completeTask(String description) {
      // Add code here
      Task task = tasks.get(description);
      if (task != null) {
         task.setComplete(true);
      }
   }

   public boolean getStatus(String description) {
      Task task = tasks.get(description);
      if (task != null) {
         return task.isComplete();
      }
      return false;
   }

   public Task getTask(String description) {
      return tasks.get(description);
   }

   public Task removeTask(String description) {
      return tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      return tasks.values()
            .stream()
            .filter(Task::isComplete)
            .collect(Collectors.toList());
      }
}
