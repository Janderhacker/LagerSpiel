package GUI;

import main.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GUI extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void btnaction(JButton btn, int row, int col) {
        if (rbtnNr == 3) {
            if (!mainGame.destroy(row, col)) {
                JOptionPane.showMessageDialog(frame, "Hier gibt es kein Item");
            } else btn.setIcon(null);
        } else {
            heinlagerung(rbtnNr);
            if (!textmanager[rbtnNr].getText().equals("")) {
                if (!mainGame.ausfuehren(rbtnNr, row, col)) {
                    if (einlagerung) JOptionPane.showMessageDialog(frame, "Das item passt hier nicht");
                    else JOptionPane.showMessageDialog(frame, "Das ist das Falsche item");
                } else {
                    textmanager[rbtnNr].setText("");
                    if (einlagerung) {
                        try {
                        	System.out.println();
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(mainGame.img(row, col) + ".png")));
                            btn.setIcon(new ImageIcon(img));
                            labelmanager[rbtnNr].setIcon(null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        btn.setIcon(null);
                        btn.setText("");
                        labelmanager[rbtnNr].setIcon(null);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Du musst einen Auftrag auswaehlen um dies zu tun");

            }
        }
        bilanz.setText("Konto: " + mainGame.getMoney());
    }

    private final JLabel img1lbl;
    private final JLabel img2lbl;
    private final JLabel img3lbl;


    private final JLabel bilanz;

    private final Game mainGame = new Game();
    Bilanz bwindow = new Bilanz();

    private final JPanel frame;
    private final JTextPane auftrag0;
    private final JTextPane auftrag1;
    private final JTextPane auftrag2;

    private final JTextPane[] textmanager = new JTextPane[3];

    private final JLabel[] labelmanager = new JLabel[3];

    private int rbtnNr = 0;

    private boolean einlagerung;

    /**
     * Create the frame.
     */
    public GUI() {
        setResizable(false);
        setTitle("Lagerspiel INF22B Jan Denis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 900);
        frame = new JPanel();
        frame.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(frame);
        frame.setLayout(null);

        JButton button00 = new JButton("");
        button00.setBounds(42, 541, 100, 100);
        frame.add(button00);

        JButton button01 = new JButton("");
        button01.setBounds(152, 541, 100, 100);
        frame.add(button01);

        JButton button02 = new JButton("");
        button02.setBounds(262, 541, 100, 100);
        frame.add(button02);

        JButton button03 = new JButton("");
        button03.setBounds(372, 541, 100, 100);
        frame.add(button03);

        JButton button10 = new JButton("");
        button10.setBounds(42, 430, 100, 100);
        frame.add(button10);

        JButton button11 = new JButton("");
        button11.setBounds(152, 430, 100, 100);
        frame.add(button11);

        JButton button12 = new JButton("");
        button12.setBounds(262, 430, 100, 100);
        frame.add(button12);

        JButton button13 = new JButton("");
        button13.setBounds(372, 430, 100, 100);
        frame.add(button13);

        JButton button20 = new JButton("");
        button20.setBounds(42, 319, 100, 100);
        frame.add(button20);

        JButton button21 = new JButton("");
        button21.setBounds(152, 319, 100, 100);
        frame.add(button21);

        JButton button22 = new JButton("");
        button22.setBounds(262, 319, 100, 100);
        frame.add(button22);

        JButton button23 = new JButton("");
        button23.setBounds(372, 319, 100, 100);
        frame.add(button23);

        JButton button30 = new JButton("");
        button30.setBounds(42, 208, 100, 100);
        frame.add(button30);

        JButton button31 = new JButton("");
        button31.setBounds(152, 208, 100, 100);
        frame.add(button31);

        JButton button32 = new JButton("");
        button32.setBounds(262, 208, 100, 100);
        frame.add(button32);

        JButton button33 = new JButton("");
        button33.setBounds(372, 208, 100, 100);
        frame.add(button33);

        JButton neuAuftrag = new JButton("Neuer Auftrag");
        neuAuftrag.setBounds(1243, 802, 171, 48);
        frame.add(neuAuftrag);

        JButton delbutton = new JButton("Ablehnen");
        delbutton.setBounds(697, 554, 109, 42);
        frame.add(delbutton);


        auftrag0 = new JTextPane();
        auftrag0.setEditable(false);
        auftrag0.setBounds(697, 208, 206, 167);
        frame.add(auftrag0);
        auftrag0.setFont(auftrag0.getFont().deriveFont(20f));
        auftrag0.setText("");

        auftrag1 = new JTextPane();
        auftrag1.setEditable(false);
        auftrag1.setBounds(913, 208, 206, 167);
        auftrag1.setFont(auftrag1.getFont().deriveFont(20f));
        frame.add(auftrag1);
        auftrag1.setText("");

        auftrag2 = new JTextPane();
        auftrag2.setEditable(false);
        auftrag2.setBounds(1129, 208, 206, 167);
        auftrag2.setFont(auftrag2.getFont().deriveFont(20f));
        frame.add(auftrag2);
        auftrag2.setText("");

        textmanager[0] = this.auftrag0;
        textmanager[1] = this.auftrag1;
        textmanager[2] = this.auftrag2;

        bilanz = new JLabel("Konto: 0");
        bilanz.setBounds(10, 11, 104, 34);
        frame.add(bilanz);

        JButton bbutton = new JButton("Bilanz");
        bbutton.setBounds(10, 47, 89, 23);
        frame.add(bbutton);

        JRadioButton rbutton0 = new JRadioButton("1");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbutton0);
        rbutton0.setBounds(697, 500, 109, 23);
        rbutton0.setSelected(true);
        frame.add(rbutton0);

        JRadioButton rbutton1 = new JRadioButton("2");
        buttonGroup.add(rbutton1);
        rbutton1.setBounds(924, 500, 109, 23);
        frame.add(rbutton1);

        JRadioButton rbutton2 = new JRadioButton("3");
        buttonGroup.add(rbutton2);
        rbutton2.setBounds(1139, 500, 109, 23);
        frame.add(rbutton2);

        JRadioButton trash = new JRadioButton("Verschrotten");
        buttonGroup.add(trash);
        trash.setBounds(1272, 500, 109, 23);
        frame.add(trash);

        img1lbl = new JLabel("");
        img1lbl.setBounds(697, 386, 100, 100);
        frame.add(img1lbl);

        img2lbl = new JLabel("");
        img2lbl.setBounds(913, 386, 100, 100);
        frame.add(img2lbl);

        img3lbl = new JLabel("");
        img3lbl.setBounds(1129, 386, 100, 100);
        frame.add(img3lbl);

        labelmanager[0] = this.img1lbl;
        labelmanager[1] = this.img2lbl;
        labelmanager[2] = this.img3lbl;


        delbutton.addActionListener(e -> {
            if (rbutton0.isSelected() && !auftrag0.getText().equals("")) {
                mainGame.AuftragAblehnen(0);
                auftrag0.setText("");
                labelmanager[0].setIcon(null);
            } else if (rbutton1.isSelected() && !auftrag1.getText().equals("")) {
                mainGame.AuftragAblehnen(1);
                auftrag1.setText("");
                labelmanager[1].setIcon(null);
            } else if (rbutton2.isSelected() && !auftrag2.getText().equals("")) {
                mainGame.AuftragAblehnen(2);
                auftrag2.setText("");
                labelmanager[2].setIcon(null);
            } else {
                JOptionPane.showMessageDialog(frame, "Du musst einen Auftrag auswaehlen um dies zu tun");
            }
            bilanz.setText("Konto: " + mainGame.getMoney());


        });
        neuAuftrag.addActionListener(e -> {
            if (auftrag0.getText().equals("") || auftrag1.getText().equals("") || auftrag2.getText().equals("")) {
                String auftrag = mainGame.getAuftrag();

                if (!auftrag.equals("End")) {
                    if (auftrag0.getText().equals("")) {
                        Image img;
                        try {
                            img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(mainGame.img(0) + ".png")));
                            img1lbl.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                        auftrag0.setText(auftrag);


                    } else if (auftrag1.getText().equals("")) {
                        Image img;
                        try {
                            img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(mainGame.img(1) + ".png")));
                            img2lbl.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        auftrag1.setText(auftrag);

                    } else if (auftrag2.getText().equals("")) {
                        Image img;
                        try {
                            img = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(mainGame.img(2) + ".png")));
                            img3lbl.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        auftrag2.setText(auftrag);

                    }

                } else {
                    JOptionPane.showMessageDialog(frame, "Du hast Gewonnen dein Score ist: " + mainGame.getMoney());
                    System.exit(0);

                }
            }

        });


        button00.addActionListener(e -> btnaction(button00, 0, 0));

        button01.addActionListener(e -> btnaction(button01, 0, 1));

        button02.addActionListener(e -> btnaction(button02, 0, 2));

        button03.addActionListener(e -> btnaction(button03, 0, 3));


        button10.addActionListener(e -> btnaction(button10, 1, 0));

        button11.addActionListener(e -> btnaction(button11, 1, 1));

        button12.addActionListener(e -> btnaction(button12, 1, 2));

        button13.addActionListener(e -> btnaction(button13, 1, 3));

        button20.addActionListener(e -> btnaction(button20, 2, 0));

        button21.addActionListener(e -> btnaction(button21, 2, 1));

        button22.addActionListener(e -> btnaction(button22, 2, 2));

        button23.addActionListener(e -> btnaction(button23, 2, 3));

        button30.addActionListener(e -> btnaction(button30, 3, 0));

        button31.addActionListener(e -> btnaction(button31, 3, 1));

        button32.addActionListener(e -> btnaction(button32, 3, 2));

        button33.addActionListener(e -> btnaction(button33, 3, 3));

        rbutton0.addActionListener(e -> rbtnNr = 0);

        rbutton1.addActionListener(e -> rbtnNr = 1);

        rbutton2.addActionListener(e -> rbtnNr = 2);

        trash.addActionListener(e -> rbtnNr = 3);

        bbutton.addActionListener(e -> {
            bwindow.update(mainGame);
            bwindow.setVisible(true);
        });
    }

    /**
     * Launch the application.
     */

    private void heinlagerung(int aNr) {
        einlagerung = mainGame.atyp(aNr).equals("Einlagerung");
    }
}