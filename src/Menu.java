import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private static final int width = 500;
    private static final int height = 500;

    private static final int buttonWidth = 300;
    private static final int buttonHeight = 50;
    ImageIcon backGround = new ImageIcon("images//Menu_Background.png");
    JLabel backGroundLabel = new JLabel();

    JButton quit = new JButton();
    JButton Uno = new JButton();
    JButton BlackJack = new JButton();

    Menu(){
        this.setSize(width,height);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("MENU");


        quit.setBounds(100,300,buttonWidth,buttonHeight);
        quit.addActionListener(this);
        quit.setText("quit");
        quit.setFont(new Font("Distant Galaxy", Font.BOLD, 30));
        quit.setForeground(new Color(0, 0, 0));
        quit.setBackground(new Color(0, 0, 0));
        quit.setBorderPainted(true);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);
        quit.setBorder(new LineBorder(Color.BLACK));
        this.add(quit);


        Uno.setBounds(100,100,buttonWidth,buttonHeight);
        Uno.addActionListener(this);
        Uno.setText("Uno");
        Uno.setFont(new Font("Distant Galaxy", Font.BOLD, 30));
        Uno.setForeground(new Color(0, 0, 0));
        Uno.setBackground(new Color(0, 0, 0));
        Uno.setBorderPainted(true);
        Uno.setContentAreaFilled(false);
        Uno.setFocusPainted(false);
        Uno.setBorder(new LineBorder(Color.BLACK));
        this.add(Uno);

        BlackJack.setBounds(100,200,buttonWidth,buttonHeight);
        BlackJack.addActionListener(this);
        BlackJack.setText("BlackJack");
        BlackJack.setFont(new Font("Distant Galaxy", Font.BOLD, 30));
        BlackJack.setForeground(new Color(0, 0, 0));
        BlackJack.setBackground(new Color(0, 0, 0));
        BlackJack.setBorderPainted(true);
        BlackJack.setContentAreaFilled(false);
        BlackJack.setFocusPainted(false);
        BlackJack.setBorder(new LineBorder(Color.BLACK));
        this.add(BlackJack);









    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(Uno)){
            Uno uno = new Uno();
            this.dispose();


        }
        if (e.getSource().equals(quit)){

            this.dispose();


        }

        if (e.getSource().equals(BlackJack)){

            BlackJack blackJack = new BlackJack();
            this.dispose();


        }

    }
}
