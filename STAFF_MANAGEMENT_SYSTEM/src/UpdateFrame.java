import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.border.Border;

public class UpdateFrame extends JFrame implements ActionListener, java.awt.event.ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel panel, panel1;
    public JLabel ID, name, email, Contact, position, initialsalary;
    public JTextField idField, nameField, contactfield, emaField, positionfField, initialsalaryField;
    public JButton updatebutton, cancelButton, Show;

    public UpdateFrame() {

        Border b = BorderFactory.createLineBorder(Color.black);
        Border b2 = BorderFactory.createLineBorder(Color.blue);

        panel = new JPanel();
        // panel.setLayout(new GridLayout(7, 2, 10, 30));
        panel.setPreferredSize(new Dimension(400, 2500));

        // Make the panel opaque.
        panel.setOpaque(true);
        panel.setBorder(b2);
        panel1 = new JPanel();
        panel1.setSize(400, 50);
        // panel1.setLayout(new GridLayout(1, 2, 10, 30));

        panel1.setBorder(b);

        ID = new JLabel("ID");
        idField = new JTextField(15);
        panel.add(ID);
        panel.add(idField);
        ID.setFont(new Font("HARDIGAN", Font.BOLD, 20));

        name = new JLabel("Name");
        nameField = new JTextField(15);
        panel.add(name);
        panel.add(nameField);
        name.setFont(new Font("HARDIGAN", Font.BOLD, 20));

        email = new JLabel("Email");
        emaField = new JTextField(15);
        panel.add(email);
        panel.add(emaField);
        email.setFont(new Font("HARDIGAN", Font.BOLD, 20));

        Contact = new JLabel("Contact");
        contactfield = new JTextField(15);
        panel.add(Contact);
        panel.add(contactfield);
        Contact.setFont(new Font("HARDIGAN", Font.BOLD, 20));

        position = new JLabel("Position");
        positionfField = new JTextField(15);
        panel.add(position);
        panel.add(positionfField);
        position.setFont(new Font("HARDIGAN", Font.BOLD, 20));

        initialsalary = new JLabel("initial Salary");
        initialsalaryField = new JTextField(15);
        panel.add(initialsalary);
        panel.add(initialsalaryField);
        initialsalary.setFont(new Font("HARDIGAN", Font.BOLD, 20));

        Show = new JButton("Show");
        panel1.add(Show);
        Show.addActionListener((java.awt.event.ActionListener) this);

        updatebutton = new JButton("Update");
        updatebutton.setMnemonic(KeyEvent.VK_U);
        panel1.add(updatebutton);
        updatebutton.addActionListener((java.awt.event.ActionListener) this);

        cancelButton = new JButton("Back");
        cancelButton.setMnemonic(KeyEvent.VK_B);
        panel1.add(cancelButton);
        cancelButton.addActionListener((java.awt.event.ActionListener) this);

        panel.setBackground(Color.cyan);
        panel1.setBackground(Color.DARK_GRAY);
        add(panel, BorderLayout.CENTER);
        add(panel1, BorderLayout.SOUTH);
        setSize(910, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updatebutton) {
            try {
                MainConnection connection = new MainConnection();
                connection.UpdateEmployee(new UpdateEmployee(nameField.getText(), emaField.getText(),
                        contactfield.getText(), positionfField.getText(),
                        Double.parseDouble(initialsalaryField.getText()), Integer.parseInt(idField.getText())));
                JOptionPane.showMessageDialog(panel, "The record has been updated successfully.");

            } catch (Exception ee) {
                ee.printStackTrace();

            }
        }

        if (e.getSource() == cancelButton) {
            new HomeFrame().setVisible(true);
            setVisible(false);
        }

    }

}
