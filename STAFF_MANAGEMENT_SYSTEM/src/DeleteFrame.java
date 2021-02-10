
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteFrame extends JFrame implements ActionListener, java.awt.event.ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JButton Delete, back;
    JLabel search;
    JTextField tf;
    JPanel pn;

    DeleteFrame() {
        setLayout(new FlowLayout());
        pn = new JPanel();
        Delete = new JButton("Delete Now");
        search = new JLabel("Enter Id");
        tf = new JTextField(20);
        back = new JButton("Back");

        pn.add(search);
        pn.add(tf);
        pn.add(Delete);
        pn.add(back);
        Delete.addActionListener(this);
        back.addActionListener(this);
        back.setMnemonic(KeyEvent.VK_B);
        Delete.setMnemonic(KeyEvent.VK_D);

        add(pn);
        setSize(500, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Delete) {

            try {
                String id = tf.getText();
                String uname = "root";
                String pas = "";
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/semproject",
                        uname, pas);
                PreparedStatement st = (PreparedStatement) conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?;");
                st.setString(1, id);

                st.executeUpdate();
                JOptionPane.showMessageDialog(pn, "The record has been deleted successfully.");

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                JOptionPane.showMessageDialog(pn, "Record couldn't be deleted. Please try again.");

            }
        }
        if (e.getSource() == back) {
            new HomeFrame().setVisible(true);
            dispose();
        }

    }

}
