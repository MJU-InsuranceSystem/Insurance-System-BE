package fourservings_fiveservings.insurance_system_be.team.complaint.model;

public interface ComplaintList {
    public void add(Complaint complaint);

    public void delete(Complaint complaint);

    public Object read();

    public void update();
}
