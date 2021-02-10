
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeFrame extends JFrame implements ActionListener, java.awt.event.ActionListener {

    /**
    *
    */
    JPanel Toppanel, ButtoPanel;
    JButton addd, del, upd, sho, Lout;
    JTable table1;
    JScrollPane scrollPane;

    private static final long serialVersionUID = 1L;

    public HomeFrame() {

        Toppanel = new JPanel();
        ButtoPanel = new JPanel();

        // adding all button on top panel
        addd = new JButton("Add");

        del = new JButton("Delete");
        upd = new JButton("Update");
        sho = new JButton("Show-detail");
        Lout = new JButton("Log-Out");
        Toppanel.add(addd);
        Toppanel.add(del);
        Toppanel.add(upd);
        Toppanel.add(sho);
        Toppanel.add(Lout);
        Lout.addActionListener(this);
        upd.addActionListener(this);
        addd.addActionListener(this);
        sho.addActionListener(this);
        del.addActionListener(this);

        JLabel background = new JLabel(new ImageIcon("EMP.png"));
        ButtoPanel.add(background);

        add(Toppanel, BorderLayout.NORTH);// 2 ota panel ko frame layout
        add(ButtoPanel, BorderLayout.CENTER);
        ButtoPanel.setBackground(Color.CYAN);

        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addd) {
                new DetailFrame().setVisible(true);
                dispose();

            }
            if (e.getSource() == upd) {
                new UpdateFrame().setVisible(true);
                dispose();
            }
            if (e.getSource() == sho) {
                new DisplayEmpData().setVisible(true);
            }
            if (e.getSource() == del) {
                new DeleteFrame().setVisible(true);
                dispose();
            }
            if (e.getSource() == Lout) {
                new LoginFrame().setVisible(true);
                dispose();
            }

        } catch (Exception e1) {
            e1.printStackTrace();

        }
    }
}
