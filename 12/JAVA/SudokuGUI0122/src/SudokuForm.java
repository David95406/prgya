import javax.swing.*;
import java.awt.event.*;

public class SudokuForm {
    private javax.swing.JPanel JPanel;
    private JTextField meretValue;
    private JButton csokkent;
    private JButton novel;
    private JTextField kezdoallapotValue;
    private JLabel hosszErtek;
    private JButton ellenorzes;

    public SudokuForm() {
        csokkent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int ertek = Integer.parseInt(meretValue.getText());
                if (ertek > 4) {
                    meretValue.setText(String.valueOf(ertek - 1));
                }
            }
        });

        novel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int ertek = Integer.parseInt(meretValue.getText());
                if (ertek < 9)
                    meretValue.setText(String.valueOf(ertek + 1));
            }
        });

        kezdoallapotValue.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int hosszValue = kezdoallapotValue.getText().length();
                hosszErtek.setText(String.valueOf(hosszValue));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SudokuForm");
        frame.setContentPane(new SudokuForm().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
