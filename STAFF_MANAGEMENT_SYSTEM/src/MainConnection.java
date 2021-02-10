import java.sql.*;

public class MainConnection {

    String url = "jdbc:mysql://localhost:3306/SEMPROJECT";
    String username = "root";
    String password = "";

    public Connection getConnection() throws Exception {

        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        // String userName=" root";
        // String password= "";
        con = DriverManager.getConnection(url, username, password);
        return con;

    }

    public void closeConnection(Connection con, Statement stmt) throws SQLException {
        stmt.close();
        con.close();
    }

    public PreparedStatement prepareStatement(String string) {
        return null;
    }

    public void insertEmployee(Employee e) {
        try {
            // Calendar calendar = Calendar.getInstance();
            Connection con = getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(
                    "insert into  employee (Name,email,phone,Position,initialSalary) VALUES(?,?,?,?,?)");
            // update empoyee set()

            stmt.setString(1, e.getname());
            stmt.setString(2, e.getemail());
            stmt.setString(3, e.getphone());
            stmt.setString(4, e.getposition());
            stmt.setDouble(5, e.getinitialsalary());

            stmt.executeUpdate();

            con.close();

        } catch (Exception ea) {

            ea.printStackTrace();
        }
    }

    public void UpdateEmployee(UpdateEmployee e1) {
        try {
            Connection con = getConnection();
            String sql = ("UPDATE EMPLOYEE SET Name=?,phone=?,email=?,Position=?,initialSalary=? WHERE id=?");
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, e1.getname());
            stmt.setString(2, e1.getphone());
            stmt.setString(3, e1.getemail());
            stmt.setString(4, e1.getposition());
            stmt.setDouble(5, e1.getinitialsalary());
            stmt.setInt(6, e1.getID());

            stmt.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
