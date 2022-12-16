import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BitcoinClicker {
    // counter for the number of bitcoins
    private static double bitcoins = 0.0;

    //double for outputting the passive bitcoins/sec being mined from purchased workers
    private static double bitcoinRate = 0.0;

    //shop buttons
    private static JButton button1, button2, button3, button4, button5;

    //Timer instatiation
    private static Timer timer;

    //int variables to keep track of how many of each worker the game has
    private static int numChimps = 0;
    private static int numMinions = 0;
    private static int numKittens = 0;
    private static int numPreceptors = 0;
    private static int numKevinWaynes = 0;

    private static JLabel bitcoinLabel = new JLabel("Number of Bitcoins: 0");
    private static JLabel rateLabel = new JLabel("Bitcoins per Second: 0");
    private static JLabel messageLabel = new JLabel("Buy Workers to mine bitcoin for you!");

    //instantiating 3 fonts styles (futura)
    private static Font futura_bold, futura_big, futura_small;

    public static void getFonts() {
        //specifies each of the 3 fonts
        futura_bold = new Font("Futura", Font.BOLD, 40);
        futura_big = new Font("Futura", Font.PLAIN, 20);
        futura_small = new Font("Futura", Font.PLAIN, 15);

        //setting fonts to respective buttons and labels
        bitcoinLabel.setFont(futura_big);
        rateLabel.setFont(futura_big);
        messageLabel.setFont(futura_small);
        button1.setFont(futura_small);
        button2.setFont(futura_small);
        button3.setFont(futura_small);
        button4.setFont(futura_small);
        button5.setFont(futura_small);
    }


    public static void main(String[] args) {
        //taking in user input to determine difficulty of the game
        Scanner input = new Scanner(System.in);

        System.out.println("Select Difficulty: Easy = 0 | Normal = 1 | Hard = 2 ");

        int difficulty = input.nextInt();

        //adjusts the amount of bitcoin player starts with depending on difficulty
        if (difficulty == 0) {
            bitcoins = 1000;
        } else if (difficulty == 1) {
            bitcoins = 100;
        } else if (difficulty == 2) {
            bitcoins = 0;
        }

        // create a new frame
        JFrame frame = new JFrame("Cookie Clicker");
        frame.setSize(2560, 1440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);

        //determines the layouts for subsequent JPanels used
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 200;
        c.gridy = 220;
        c.gridwidth = 500;
        c.gridheight = 500;

        GridBagConstraints d = new GridBagConstraints();
        d.gridx = 1700;
        d.gridy = 220;
        d.gridwidth = 500;
        d.gridheight = 500;

        GridBagConstraints e = new GridBagConstraints();
        e.gridx = 3500;
        e.gridy = 220;
        e.gridwidth = 600;
        e.gridheight = 600;

        GridBagConstraints f = new GridBagConstraints();
        f.gridx = 4600;
        f.gridy = 320;
        f.gridwidth = 600;
        f.gridheight = 600;

        // set the layout manager for the JFrame
        frame.setLayout(new GridBagLayout());
        frame.setBackground(Color.WHITE);

        // create a panel for the Bitcoin clicking button
        JPanel bcPanel = new JPanel();
        bcPanel.setBounds(200, 520, 500, 500);
        bcPanel.setBackground(Color.WHITE);
        bcPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
        bcPanel.setBackground(Color.WHITE);
        frame.add(bcPanel, c);

        //creates a panel for that holds the # of bitcoin and rate of bitcoin being mined
        JPanel bcCounter = new JPanel();
        bcCounter.setBounds(250, 170, 100, 100);
        bcCounter.setBackground(Color.WHITE);
        bcCounter.setLayout(new GridLayout(2, 1));
        bcCounter.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
        frame.add(bcCounter, d);

        JPanel messagePanel = new JPanel();
        bcPanel.setBackground(Color.WHITE);
        messageLabel.setBackground(Color.WHITE);
        messageLabel.setFont(futura_big);
        messagePanel.add(messageLabel);
        messagePanel.setPreferredSize(new Dimension(300, 300));
        messagePanel.setBackground(Color.WHITE);
        //messagePanel.setBackground(Color.blue);
        frame.add(messagePanel, f);

        //creates cookie ImageIcon
        ImageIcon cookieIcon = new ImageIcon("bitcoin3.png");

        // create a label for displaying the number of bitcoins
        bcCounter.add(bitcoinLabel);

        //create a label for displaying the rate at which bitcoin is mined
        bcCounter.add(rateLabel);

        // create a button for clicking the cookie
        JButton cookieButton = new JButton("Click the bitcoin!");
        cookieButton.setIcon(cookieIcon);
        bcPanel.add(cookieButton);

        // creates the panel showing the workers
        JPanel workerPanel = new JPanel();
        workerPanel.setBackground(Color.WHITE);
        workerPanel.setLayout(new GridLayout(5, 1)); //grid layout to support 5 buttons
        workerPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
        frame.add(workerPanel, e);

        //creates the 5 worker buttons and their action commands
        button1 = new JButton("Chimps: 0");
        button1.setActionCommand("Chimps");
        button2 = new JButton("Minions: 0");
        button2.setActionCommand("Minion");
        button3 = new JButton("Kittens: 0");
        button3.setActionCommand("Kitten");
        button4 = new JButton("Preceptors: 0");
        button4.setActionCommand("Preceptor");
        button5 = new JButton("Kevin Waynes: 0");
        button5.setActionCommand("KevinWayne");

        cookieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                bitcoins++;

                // update the label with the new number of bitcoins
                bitcoinLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                BitcoinSound.playSound("pickaxe.wav");
            }
        });

        //chimp worker button is clicked
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                if (bitcoins >= 10) { //checks if player has enough money
                    numChimps++; //increases the total number of chimps working
                    bitcoins = bitcoins - 10; //subtracts bitcoin used to purchase
                    bitcoinLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0); //updates bitcoin remaining
                    bitcoinRate += 1; //increases the rate due to an added worker
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate); //updates the rate
                    BitcoinSound.playSound("chimps.wav"); //calls the BitcoinSound class to play a sound
                }

                // update the label with the new number of bitcoins
                button1.setText("Chimps: " + numChimps);
            }
        });

        //chimp worker button is hovered over
        button1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // add the message panel to the frame when the mouse enters the button
                messageLabel.setText("Price: 10 BTC | Speed: 1 BTC/sec");

                // repaint the frame to show the panel
                frame.repaint();
            }

            public void mouseExited(MouseEvent e) {
                // remove the message panel from the frame when the mouse exits the button
                messageLabel.setText("Buy Workers to mine bitcoin for you!");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        //minion worker button is clicked
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // similar implementation as button1
                if (bitcoins >= 100) {
                    numMinions++;
                    bitcoins = bitcoins - 100;
                    bitcoinLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 15;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
                    BitcoinSound.playSound("minion.wav");
                }

                // update the label with the new number of bitcoins
                button2.setText("Minions: " + numMinions);
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // add the message panel to the frame when the mouse enters the button
                messageLabel.setText("Price: 100 BTC | Speed: 15 BTC/sec");

                // repaint the frame to show the panel
                frame.repaint();
            }

            public void mouseExited(MouseEvent e) {
                // remove the message panel from the frame when the mouse exits the button
                messageLabel.setText("Buy Workers to mine bitcoin for you!");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        //kitten worker button pressed
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // similar implementation as button1
                if (bitcoins >= 200) {
                    numKittens++;
                    bitcoins = bitcoins - 200;
                    bitcoinLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 50;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
                    BitcoinSound.playSound("meow.wav");
                }

                // update the label with the new number of bitcoins
                button3.setText("Kittens: " + numKittens);
            }
        });

        button3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // add the message panel to the frame when the mouse enters the button
                messageLabel.setText("Price: 200 BTC | Speed: 50 BTC/sec");

                // repaint the frame to show the panel
                frame.repaint();
            }

            public void mouseExited(MouseEvent e) {
                // remove the message panel from the frame when the mouse exits the button
                messageLabel.setText("Buy Workers to mine bitcoin for you!");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        //preceptor button is clicked
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // similar implementation as button1
                if (bitcoins >= 500) {
                    numPreceptors++;
                    bitcoins = bitcoins - 500;
                    bitcoinLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 150;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
                    BitcoinSound.playSound("amogus.wav");
                }

                // update the label with the new number of bitcoins
                button4.setText("Preceptors: " + numPreceptors);
            }
        });

        button4.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // add the message panel to the frame when the mouse enters the button
                messageLabel.setText("Price: 500 BTC | Speed: 150 BTC/sec");

                // repaint the frame to show the panel
                frame.repaint();
            }

            public void mouseExited(MouseEvent e) {
                // remove the message panel from the frame when the mouse exits the button
                messageLabel.setText("Buy Workers to mine bitcoin for you!");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        //kevin wayne button is pressed
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // similar implementation as button1
                if (bitcoins >= 10000) {
                    numKevinWaynes++;
                    bitcoins = bitcoins - 10000;
                    bitcoinLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 5000;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
                    BitcoinSound.playSound("explosion.wav");
                }
                // update the label with the new number of bitcoins
                button5.setText("Kevin Waynes: " + numKevinWaynes);
            }
        });

        button5.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // add the message panel to the frame when the mouse enters the button
                messageLabel.setText("Price: 10,000 BTC | Speed: 5000 BTC/sec");

                // repaint the frame to show the panel
                frame.repaint();
            }

            public void mouseExited(MouseEvent e) {
                // remove the message panel from the frame when the mouse exits the button
                messageLabel.setText("Buy Workers to mine bitcoin for you!");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        //adds all the worker buttons to the panel
        workerPanel.add(button1);
        workerPanel.add(button2);
        workerPanel.add(button3);
        workerPanel.add(button4);
        workerPanel.add(button5);

        frame.setVisible(true);
        getFonts();
        startTimer();
        timer.start();
    }

    // Timer method to start a timer that increments bitcoins by the bitcoinRate based on workers purchased
    public static void startTimer() {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bitcoins += bitcoinRate / 20;
                bitcoinLabel.setText("Number of bitcoins: " + String.format("%.1f", Math.round(bitcoins * 10) / 10.0));
            }
        });
    }

}
