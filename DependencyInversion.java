import java.util.ArrayList;
import java.util.List;

public class DependencyInversion {

  public static void main(String[] args) {
    // Using DatabaseTaskRepository
    TaskRepository databaseTaskRepository = new DatabaseTaskRepository();
    Project project1 = new Project((AddableTask) databaseTaskRepository);
    NotificationService notificationService1 = new NotificationService((RetrievableTask) databaseTaskRepository);

    Task task1 = new Task("Task 1", "Clean Room");
    Task task2 = new Task("Task 2", "Go to GYM");

    project1.addTask(task1);
    project1.addTask(task2);

    List<Task> tasks = databaseTaskRepository.getTasks();
    System.out.println("Loding tasks from Database:");
    for (Task task : tasks) {
      System.out.println("Task: " + task.getName() + ", Description: " + task.getDescription());
    }

    notificationService1.sendNotifications();

    System.out.println();

    // Using FileTaskRepository
    TaskRepository fileTaskRepository = new FileTaskRepository();
    Project project2 = new Project((AddableTask) fileTaskRepository);
    NotificationService notificationService2 = new NotificationService((RetrievableTask) fileTaskRepository);

    Task task3 = new Task("Task 3", "Make your Bed");
    Task task4 = new Task("Task 4", " Do SDA Lab and Mid");

    project2.addTask(task3);
    project2.addTask(task4);

    tasks = fileTaskRepository.getTasks();
    System.out.println("Tasks obtained :");
    for (Task task : tasks) {
      System.out.println("Task: " + task.getName() + ", Description: " + task.getDescription());
    }

    notificationService2.sendNotifications();
  }
}

// Liskov Principle
interface StorableTask {
  String getName();

  String getDescription();
}

// Interface Segregation Principle (ISP)
interface AddableTask {
  void addTask(Task task);
}

interface RetrievableTask {
  List<Task> getTasks();
}

// Dependency Inversion Principle (DIP)
interface TaskRepository extends AddableTask, RetrievableTask {
}

// Concrete implementation: DatabaseTaskRepository
class DatabaseTaskRepository implements TaskRepository {
  private List<Task> tasks = new ArrayList<>();

  @Override
  public void addTask(Task task) {
    tasks.add(task);
    System.out.println("Task added to the database.");
  }

  @Override
  public List<Task> getTasks() {
    System.out.println("Retrieving tasks from the database.");
    return tasks;
  }
}

// Concrete implementation: FileTaskRepository
class FileTaskRepository implements TaskRepository {
  private List<Task> tasks = new ArrayList<>();

  @Override
  public void addTask(Task task) {
    tasks.add(task);
    System.out.println("Task added to the file.");
  }

  @Override
  public List<Task> getTasks() {
    System.out.println("Retrieving tasks from the file.");
    return tasks;
  }
}

// Task class
class Task implements StorableTask {
  private String name;
  private String description;

  public Task(String name, String description) {
    this.name = name;
    this.description = description;
  }

  // Getters
  @Override
  public String gName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getName'");
  }
}

// Project class
class Project {
  private AddableTask taskRepository;

  public Project(AddableTask taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void addTask(Task task) {
    taskRepository.addTask(task);
  }
}

// NotificationService class
class NotificationService {
  private RetrievableTask taskRepository;

  public NotificationService(RetrievableTask taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void sendNotifications() {
    List<Task> tasks = taskRepository.getTasks();
    System.out.println("Sending reminder for " + tasks.size() + " tasks.");
  }
}