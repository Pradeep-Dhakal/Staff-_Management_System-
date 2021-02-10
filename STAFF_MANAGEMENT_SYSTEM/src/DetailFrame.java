import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;

public class DetailFrame extends JFrame implements ActionListener, java.awt.event.ActionListener {
    /**
     *
     */

    private static final long serialVersionUID = 1L;

    public JLabel ID, Name, Contact, email, position, Initial;
    public JTextField idField, nameField, conField, emaField, posiField, iniField;
    GridBagConstraints GBC = new GridBagConstraints();
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    private JButton button, back;

    public DetailFrame() {

        ID = new JLabel("ID");

        idField = new JTextField(10);

        idField.addActionListener(this);

        Name = new JLabel("Name:");

        nameField = new JTextField(10);

        nameField.addActionListener(this);

        email = new JLabel("Email: ");

        emaField = new JTextField(10);

        emaField.addActionListener(this);

        Contact = new JLabel("Contact no:");

        conField = new JTextField(10);

        conField.addActionListener(this);

        position = new JLabel("Position: ");

        posiField = new JTextField(10);

        posiField.addActionListener(this);

        Initial = new JLabel("Initial Salary:");

        iniField = new JTextField(10);

        iniField.addActionListener(this);

        button = new JButton("Finish");

        button.addActionListener(this);

        back = new JButton("Back");

        back.addActionListener(this);
        back.setPreferredSize(new Dimension(80, 30));

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();

        // panel1.setLayout(new GridLayout(6,2));

        panel1.add(ID);
        panel1.add(idField);
        panel2.add(Name);
        panel2.add(nameField);
        panel3.add(email);
        panel3.add(emaField);
        panel4.add(Contact);
        panel4.add(conField);
        panel5.add(position);
        panel5.add(posiField);
        panel6.add(Initial);
        panel6.add(iniField);

        panel7.setBackground(Color.cyan);
        panel7.add(button);
        panel7.add(back);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);

        add(panel7, BorderLayout.SOUTH);
        setLayout(new GridLayout(0, 1));
        setTitle("See Details");
        setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            new HomeFrame().setVisible(true);
            setVisible(false);
        }
        if (e.getSource() == button) {
            try {
                MainConnection connection = new MainConnection();
                connection.insertEmployee(new Employee(nameField.getText(), emaField.getText(), conField.getText(),
                        posiField.getText(), Double.parseDouble(iniField.getText())));
                JOptionPane.showMessageDialog(panel2, "The record has been updated successfully.");

            } catch (Exception ee) {
                ee.printStackTrace();
                JOptionPane.showMessageDialog(panel2, "Record is not Updated \n please try again.");

            }
        }

    }
}
