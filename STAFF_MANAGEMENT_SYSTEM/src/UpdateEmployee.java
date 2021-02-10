public class UpdateEmployee extends UpdateFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String phone;
    private String email;
    private String position;
    private double initialsalary;

    public UpdateEmployee(String name, String email, String phone, String position, double initialsalary, int id) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.initialsalary = initialsalary;
        this.id = id;
    }

    public void setname(String name) {
        this.name = nameField.getText();

    }

    public String getname() {
        return name;
    }

    public void setphone(String phone) {
        this.phone = contactfield.getText();
    }

    public String getphone() {
        return phone;
    }

    public void setemail() {
        this.email = emaField.getText();
    }

    public String getemail() {
        return email;
    }

    public void setinitialsalary() {
        this.initialsalary = Double.parseDouble(initialsalaryField.getText());
    }

    public Double getinitialsalary() {
        return initialsalary;
    }

    public void setposition() {
        this.position = positionfField.getText();
    }

    public String getposition() {
        return position;
    }

    public void setID(int id) {
        this.id = Integer.parseInt(idField.getText());

    }

    public int getID() {
        return id;
    }

    // id bata update garna ko lagi constructure
    public UpdateEmployee(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = Integer.parseInt(idField.getText());
    }

    public int getid() {
        return id;
    }

}
