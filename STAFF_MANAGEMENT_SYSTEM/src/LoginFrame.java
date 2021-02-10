import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener, java.awt.event.ActionListener {

    /**
    	 *
    	 */

    private static final long serialVersionUID = 1L;
    JPanel panel, Rightpanel, LeftPanel;
    JLabel username, password, error;
    JTextField userarea;
    JPasswordField passwordarea;
    JButton login, exit;
    JOptionPane dialouge;

    LoginFrame() {
        setLayout(new FlowLayout()); // setting layout for loginframe

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        username = new JLabel("Email or Username");
        userarea = new JTextField(20);

        password = new JLabel("Password");
        passwordarea = new JPasswordField(20);

        login = new JButton("LOGIN");
        login.addActionListener(this);

        login.setBackground(new Color(59, 89, 182));
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        login.setFont(new Font("Tahoma", Font.BOLD, 12));
        login.setMnemonic(KeyEvent.VK_S);

        exit = new JButton("Exit");

        panel.add(username);
        panel.add(userarea);
        panel.add(password);
        panel.add(passwordarea);

        panel.add(login);
        panel.add(exit);

        setBackground(Color.cyan);

        add(panel);
        setBackground(Color.orange);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = userarea.getText();
            String password = new String(passwordarea.getPassword());

            try {
                String uname = "root";
                String pas = "";
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/semproject",
                        uname, pas);
                PreparedStatement st = (PreparedStatement) conn.prepareStatement(
                        "select username, password from passwordtable where username=? and password=?");
                st.setString(1, username);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    dispose();
                    // HomePageFrame Hf=new HomePageFrame(username);
                    new HomeFrame().setVisible(true);

                } else {
                    // error.setVisible(true);
                    JOptionPane.showMessageDialog(login, "OOPS wrong entry!!!! please try again");
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }
        }
        if (e.getSource() == exit) {
            dispose();
        }

    }

    public static void main(String[] args) throws Exception, NullPointerException {
        new LoginFrame();
        //new HomePageFrame().setVisible(false);
        new HomeFrame();
        new DetailFrame();
        new UpdateFrame();
        new DisplayEmpData();
        new DeleteFrame();
    }
}
