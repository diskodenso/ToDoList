import java.util.GregorianCalendar;

public class ToDoList implements ToDoListInterface {
    private Entry head = null;

    //---------------------------------------------
    //in der Klasse wird KEIN Konstruktor mit Parametern zur Verfuegung gestellt, 
    //da die Methode add() das Einfuegen in die Liste realisiert
    //und nur so die Liste befuellt wird
    //---------------------------------------------

    public ToDoList() {
        head = null;
    }

    @Override
    public int length() {
        int length = 0;
        Entry current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    //region [Getter]
    @Override
    public Task getTask(int index) {
        if (index < 0 || index >= length()) {
            return null;
        }

        Entry current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.task;
    }

    @Override
    public int[] getPendingTasksUntilDeadline(GregorianCalendar deadline) throws NullPointerException {
        if (deadline == null) {
            throw new NullPointerException("deadline cannot be null");
        }

        int[] indices = new int[length()];
        int count = 0;
        int index = 0;
        Entry current = head;

        while (current != null) {
            if (!current.task.getDone() && current.task.getDeadline().compareTo(deadline) <= 0) {
                indices[count++] = index;
            }
            index++;
            current = current.next;
        }

        int[] results = new int[count];
        System.arraycopy(indices, 0, results, 0, count);
        return results;
    }
    //endregion

    @Override
    public void addTask(Task task) throws NullPointerException {
        if (task == null) {
            throw new NullPointerException("task cannot be null");
        }

        Entry newEntry = new Entry(task);

        if (head == null || task.compareTo(head.task) < 0) {
            newEntry.next = head;
            head = newEntry;
            return;
        }

        Entry current = head;
        while (current.next != null && current.task.compareTo(task) < 0) {
            current = current.next;
        }

        newEntry.next = current.next;
        current.next = newEntry;
    }

    @Override
    public void removeTask(int index) throws IndexOutOfBoundsException, IllegalStateException {
        if (index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Entry current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    @Override
    public void removeAllDoneTasks() throws IllegalStateException {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        while (head != null && head.task.getDone()) {
            head = head.next;
        }

        Entry current = head;
        while (current != null && current.next != null) {
            if (current.next.task.getDone()) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    @Override
    public void markTaskAsDone(int index) throws IndexOutOfBoundsException, IllegalStateException {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        Entry current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.task.setDone(true);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToDos:\n");
        Entry current = head;
        int index = 0;

        while (current != null) {
            sb.append("[").append(index).append("] ").append(current.task.toString()).append("\n");
            index++;
            current = current.next;
        }
        return sb.toString();
    }
}
