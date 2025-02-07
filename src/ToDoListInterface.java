import java.util.GregorianCalendar;

public interface ToDoListInterface {

    /**
     * Returns the length of the to-do list
     *
     * @return length of the todo list
     */
    //2 Punkte
    public abstract int length();


    /**
     * Returns the task by index in the ToDo list, and null otherwise
     *
     * @param index given index
     * @return Task that exists at the given index in the ToDo list, null otherwise
     */
    //2 Punkte
    public abstract Task getTask(int index);


    /**
     * Returns the indices of the tasks that are due by the given deadline
     *
     * @param deadline given deadline
     * @return array of Indexes of due tasks
     */
    //3 Punkte
    public int[] getPendingTasksUntilDeadline(GregorianCalendar deadline);


    /**
     * Adds a new task to the ToDo-List sorted by deadline
     *
     * @param task Task to be inserted
     * @throws NullPointerException if task is null
     */
    //4 Punkte
    public abstract void addTask(Task task) throws NullPointerException;


    /**
     * Removes a task by index from the ToDo-List
     *
     * @param index Index of task to be removed
     * @throws IndexOutOfBoundsException if index is invalid
     * @throws IllegalStateException     if ToDo-List is empty
     */
    //3 Punkte
    public abstract void removeTask(int index) throws IndexOutOfBoundsException, IllegalStateException;


    /**
     * Removes all done tasks from the ToDo-List;
     *
     * @throws IllegalStateException if ToDo-List is empty
     */
    //4 Punkte
    public void removeAllDoneTasks() throws IllegalStateException;


    /**
     * Marks task by index as done
     *
     * @param index Index of the task to be marked
     * @throws IndexOutOfBoundsException if index is invalid
     * @throws IllegalStateException     if ToDo-List is empty
     */
    //3 Punkte
    public abstract void markTaskAsDone(int index) throws IndexOutOfBoundsException, IllegalStateException;

    /**
     * Formatted string reprensentation of task
     *
     * @return the formatted string of the task
     */
    //2 Punkte
    public abstract String toString();


}
