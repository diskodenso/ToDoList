import java.util.GregorianCalendar;


public class Task implements TaskInterface {
    private String description;
    private GregorianCalendar deadline;
    private boolean done;

    public Task() {
        this.description = "Unbekannt";
        this.deadline = new GregorianCalendar();
        this.done = false;
    }

    public Task(String description, GregorianCalendar deadline, boolean done) {
        setDescription(description);
        setDeadline(deadline);
        setDone(done);
    }

    //region [Setter]
    @Override
    public void setDescription(String description) throws NullPointerException, IllegalArgumentException {
        if (description == null) {
            throw new NullPointerException("Description can not be null.");
        }
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Description can not be empty.");
        }
        this.description = description;
    }

    @Override
    public void setDeadline(GregorianCalendar deadline) throws NullPointerException {
        if (deadline == null) {
            throw new NullPointerException("Deadline can not be null.");
        }
        this.deadline = deadline;
    }

    @Override
    public void setDone(boolean done) {
        this.done = done;
    }
    //endregion

    //region [Getter]
    @Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public GregorianCalendar getDeadline() {
        return this.deadline;
    }

    @Override
    public boolean getDone() {
        return this.done;
    }
    //endregion

    @Override
    public int compareTo(Task anotherTask) throws NullPointerException {
        if (anotherTask == null) {
            throw new NullPointerException("Cannot compare to a null Task.");
        }
        if (this.deadline.compareTo(anotherTask.getDeadline()) < 0) {
            return -1;
        }
        if (this.deadline.compareTo(anotherTask.getDeadline()) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        // Format the deadline as <day>.<month>.<year>
        String formattedDate = deadline.get(GregorianCalendar.DAY_OF_MONTH) + "." +
                (deadline.get(GregorianCalendar.MONTH) + 1) + "." +
                deadline.get(GregorianCalendar.YEAR);

        String status = done ? "✔" : "✘";

        return description + ", " + formattedDate + " " + status;
    }
}
