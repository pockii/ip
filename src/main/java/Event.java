public class Event extends Task {
    protected String eventTime;

    Event(String desc) throws MissingDeadlineException {
        super(desc.split(" /at ", 2)[0]);
        String[] temp = desc.split(" /at ", 2);
        if (temp.length == 1) {
            throw new MissingDeadlineException("event");
        } else {
            String date = desc.split(" /at ", 2)[1];
            this.eventTime = containsTime(date)
                                ? formatDateTime(date)
                                : formatDate(date);
        }
    }

    @Override
    public String toString() {
        return "[E]" + this.getStatusIcon() + this.description + " (at: " + this.eventTime + ")";
    }
}
