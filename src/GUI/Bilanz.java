package GUI;

import main.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.Serial;

public class Bilanz extends JFrame {

    /**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;

	private final JLabel umsatzlabel;

    private final JLabel kostenlabel;

    private final JScrollPane scrollPane;

    public Bilanz() {
    	setResizable(false);

        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                e.getWindow().setVisible(false);
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 229, 239);
        contentPane.add(scrollPane, BorderLayout.CENTER);


        umsatzlabel = new JLabel("Umsatz: 0");
        umsatzlabel.setBounds(267, 27, 102, 14);
        contentPane.add(umsatzlabel);

        kostenlabel = new JLabel("Kosten: 0");
        kostenlabel.setBounds(267, 52, 102, 14);
        contentPane.add(kostenlabel);
    }


    public void update(Game game) {
        String[] transactions = game.getTransactions().toArray(new String[0]);
        JList<String> transactionlist = new JList<>(transactions);
        scrollPane.setViewportView(transactionlist);
        umsatzlabel.setText("Umsatz: " + game.getUmsatz());
        kostenlabel.setText("Kosten: " + game.getKosten());

    }

}
