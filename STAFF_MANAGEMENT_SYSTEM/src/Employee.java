
class Employee extends DetailFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String phone;
    private String email;
    private String position;
    private double initialSalary;

    public Employee(String name, String email, String phone, String position, double initialSalary) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.initialSalary = initialSalary;
    }

    public void setname(String name) {
        this.name = nameField.getText();

    }

    public String getname() {
        return name;
    }

    public void setphone(String phone) {
        this.phone = conField.getText();
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
        this.initialSalary = Double.parseDouble(iniField.getText());
    }

    public Double getinitialsalary() {
        return initialSalary;
    }

    public void setposition() {
        this.position = posiField.getText();
    }

    public String getposition() {
        return position;
    }

}
