import java.util.GregorianCalendar;

public interface TaskInterface {

    //Konstruktor: bitte Reihenfolge der Parameter nicht veraendern!
    //public Task(String description, GregorianCalendar deadline, boolean done)

    /**
     * Sets the description of the task.
     *
     * @param description the new task description; must not be null or empty
     * @throws NullPointerException     if description is null
     * @throws IllegalArgumentException if description is empty
     */
    public abstract void setDescription(String description) throws NullPointerException, IllegalArgumentException;

    /**
     * Sets the deadline of the task
     *
     * @param deadline the new task deadline; can not be null
     * @throws NullPointerException if deadline is null
     */
    public abstract void setDeadline(GregorianCalendar deadline) throws NullPointerException;

    /**
     * Sets the completion status of the task either to true or to false
     *
     * @param done the new completion status (true if done, false otherwise)
     */
    public abstract void setDone(boolean done);

    /**
     * Gets the description of the task.
     *
     * @return the task description
     */
    public abstract String getDescription();

    /**
     * Gets the deadline of the task
     *
     * @return the task deadline
     */
    public abstract GregorianCalendar getDeadline();

    /**
     * Gets the completion status of the task
     *
     * @return true if the task is done, false otherwise
     */
    public abstract boolean getDone();

    /**
     * Compares this with the parameter obeject anotherTask
     *
     * @param anotherTask compare parameter object with this
     * @return -1, if this is smaller than anotherTask;
     * 0, if both objects have the same size;
     * 1, if this is bigger than anotherTask;
     * @throws NullPointerException if parameter is null
     */
    public abstract int compareTo(Task anotherTask) throws NullPointerException;

    /**
     * Returns a string representation of the task in the format:
     * <description>, <deadline> <✔ or ✘>
     *
     * @return the formatted string representation of the task
     */
    public abstract String toString();

}
