import java.util.Arrays;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Einkaufen", new GregorianCalendar(2024, 6, 9), false);
        Task task2 = new Task("Programmieren", new GregorianCalendar(2024, 6, 9), true);
        Task task3 = new Task("Putzen", new GregorianCalendar(2025, 2, 3), false);
        Task task6 = new Task("Java++", new GregorianCalendar(2024, 10, 20), true);
        Task task4 = new Task("C++", new GregorianCalendar(2025, 4, 6), false);
        Task task5 = new Task("Javascript", new GregorianCalendar(2023, 4, 6), false);

        if (task1.compareTo(task2) == 0) {
            System.out.println("Gleiches datum");
        }
        System.out.println(task1.compareTo(task2)); // 0 (gleiches Datum)
        System.out.println(task1.compareTo(task3)); // -1 (task1 hat frühere Deadline)
        System.out.println(task3.compareTo(task1)); // 1 (task3 hat spätere Deadline)


        // Erstelle ToDo-Liste
        ToDoList toDoList = new ToDoList();

        // Eine neue Aufgabe hinzufügen
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);
        toDoList.addTask(task5);
        toDoList.addTask(task6);

        System.out.println("ToDoList nachdem adden neuer aufgaben: " + toDoList);
        System.out.println("Länge der Liste: " + toDoList.length());

        // 3. Setze eine Deadline für den Test
        GregorianCalendar testDeadline = new GregorianCalendar(2024, 6, 9);

        // 4. Rufe die Methode getPendingTasksUntilDeadline auf
        int[] pendingTasks = toDoList.getPendingTasksUntilDeadline(testDeadline);

        for (int elem : pendingTasks) {
            Task task = toDoList.getTask(elem);
            System.out.println("Pending Task" + task);
        }


        // Mark Task at index 0 as done
        toDoList.markTaskAsDone(0);
        System.out.println("todolist nach markasdone" + toDoList);

        // Teste removeTask mit index 0 und index 1
        toDoList.removeTask(0);
        toDoList.removeTask(1);
        System.out.println("ToDoList nachdem removen von index1: " + toDoList);
        System.out.println("Länge der Liste nach removen von index1: " + toDoList.length());

        // Teste removeAllDoneTasks
        toDoList.removeAllDoneTasks();
        System.out.println("ToDoList nachdem entfernen erledigter Aufgaben" + toDoList);
        System.out.println("Länge der Liste nachdem entfernen: " + toDoList.length());

    }
}