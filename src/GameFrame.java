
    import javax.swing.*;
import javax.swing.*;
import java.awt.*;
    import java.awt.Color;
    import java.util.ArrayList;
import java.util.List;

    public class GameFrame extends JFrame {

        JButton deck = new JButton();
        JButton playButton = new JButton("Play card");
        JLabel lastCardLabel = new JLabel();
        JButton[] changeButtons = new JButton[4];
        JPanel changePanel = new JPanel();
        public List<JPanel> playerPanels = new ArrayList<>();
        public List<JLabel> playerLabels = new ArrayList<>();
        public List<JComboBox<Card>> hands = new ArrayList<>();
        JLabel backgroundLabel = new JLabel();
        JLabel winLabel = new JLabel();
        JPanel winPanel = new JPanel();
        ImageIcon background = new ImageIcon("Background.png");
        ImageIcon backCard = new ImageIcon("UnoCards/Back.png");
        Character[] suits = {'❤','♦','♠','♣'};

        public GameFrame(){

            this.setSize(1900,1000);
            this.setVisible(true);
            this.setResizable(false);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setIconImage(backCard.getImage());

            changePanel.setBounds(75,600,430,100);
            changePanel.setLayout(new GridLayout(1,4,10,10));
            changePanel.setOpaque(false);
            changePanel.setVisible(false);

            for (int i = 0; i < 4; i++){
                changeButtons[i] = new JButton();
                changeButtons[i].setContentAreaFilled(false);
                changeButtons[i].setBorder(BorderFactory.createLineBorder(Color.white, 5));
                changeButtons[i].setFocusable(false);
                changeButtons[i].setText(String.valueOf(suits[i]));
                changeButtons[i].setForeground(Color.white);
                changeButtons[i].setFont(new Font("Serif",Font.BOLD,30));

                changePanel.add(changeButtons[i]);

            }

            this.add(changePanel);

            winLabel.setFont(new Font("Serif",Font.BOLD,80));
            winLabel.setForeground(Color.white);
            winPanel.add(winLabel);

            winPanel.setBounds(1000,100,534,120);
            winPanel.setBorder(BorderFactory.createLineBorder(Color.white, 5));
            winPanel.setOpaque(false);
            winPanel.setVisible(false);
            this.add(winPanel);

            int x = 100;

            for (int i = 0; i < 3; i++){

                JLabel label = new JLabel("Player " + (i+1) );
                JPanel panel = new JPanel();
                JComboBox<Card> hand = new JComboBox<>();

                label.setFont(new Font("Serif",Font.BOLD,25));
                label.setForeground(Color.gray);

                panel.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
                panel.setOpaque(false);
                panel.setVisible(true);

                hand.setFont(new Font("Serif",Font.BOLD,40));
                hand.setFocusable(false);
                hand.setBackground(Color.white);

                panel.setBounds(x,125,100,50);
                hand.setBounds(x,200,100,100);
                x += 250;

                panel.add(label);
                playerLabels.add(label);
                this.add(panel);
                playerPanels.add(panel);
                this.add(hand);
                hands.add(hand);

            }

            playerLabels.get(0).setForeground(Color.white);
            playerPanels.get(0).setBorder(BorderFactory.createLineBorder(Color.white, 3));

            playButton.setBounds(1000,700,234,111);
            playButton.setContentAreaFilled(false);
            playButton.setBorder(BorderFactory.createLineBorder(Color.white, 5));
            playButton.setFocusable(false);
            playButton.setForeground(Color.white);
            playButton.setFont(new Font("Serif",Font.BOLD,30));
            this.add(playButton);

            lastCardLabel.setBounds(1000,300,234,333);
            this.add(lastCardLabel);

            deck.setBounds(1300,300,234,333);
            deck.setIcon(backCard);
            deck.setOpaque(false);
            deck.setBorderPainted(false);
            deck.setFocusable(false);
            deck.setContentAreaFilled(false);
            this. add(deck);

            backgroundLabel.setBounds(0,0,1900,1000);
            backgroundLabel.setIcon(background);
            this.add(backgroundLabel);

        }
    }

