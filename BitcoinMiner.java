import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class BitcoinMiner {
    // counter for the number of bitcoins
    private static double bitcoins = 0.0;

    //double for outputting the passive bitcoins/sec being mined
    private static double bitcoinRate = 0.0;

    //shop buttons
    private static JButton button1, button2, button3, button4, button5;

    //Timer instatiation
    private static Timer timer;

    private static int numChimps = 0;
    private static int numMinions = 0;
    private static int numKittens = 0;
    private static int numPreceptors = 0;
    private static int numKevinWaynes = 0;

    private static JLabel cookieLabel = new JLabel("Number of Bitcoins: 0");
    private static JLabel rateLabel = new JLabel("Bitcoins per Second: 0");
    private static JLabel messageLabel = new JLabel("Buy Workers to mine bitcoin for you!");

    private static Font futura_bold, futura_big, futura_small;

    public static void getFonts() {
        futura_bold = new Font("Futura", Font.PLAIN, 40);
        futura_big = new Font("Futura", Font.PLAIN, 20);
        futura_small = new Font("Futura", Font.PLAIN, 15);

        cookieLabel.setFont(futura_big);
        rateLabel.setFont(futura_big);
        messageLabel.setFont(futura_small);
        button1.setFont(futura_small);
        button2.setFont(futura_small);
        button3.setFont(futura_small);
        button4.setFont(futura_small);
        button5.setFont(futura_small);
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Select Difficulty: Easy = 0 | Normal = 1 | Hard = 2 ");

        int difficulty = input.nextInt();

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

        // create a panel
        JPanel bcPanel = new JPanel();
        bcPanel.setBounds(200, 520, 500, 500);
        bcPanel.setBackground(Color.WHITE);
        bcPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
        frame.add(bcPanel, c);

        JPanel bcCounter = new JPanel();
        bcCounter.setBounds(250, 170, 100, 100);
        bcCounter.setBackground(Color.WHITE);
        bcCounter.setLayout(new GridLayout(2, 1));
        bcCounter.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
        bcPanel.setBackground(Color.WHITE);
        // bcCounter.setLayout(new GridLayout(2, 1));
        // bcCounter.setBackground(Color.BLUE);
        frame.add(bcCounter, d);

        JPanel messagePanel = new JPanel();
        bcPanel.setBackground(Color.WHITE);
        // JLabel messageLabel = new JLabel();
        messageLabel.setBackground(Color.WHITE);
        messageLabel.setFont(futura_big);
        //messageLabel.setWrapStyleWord(true); // enable word wrapping
        //messageLabel.setLineWrap(true); // enable line wrapping
        messagePanel.add(messageLabel);
        messagePanel.setPreferredSize(new Dimension(300, 300));
        messagePanel.setBackground(Color.WHITE);
        //messagePanel.setBackground(Color.blue);
        frame.add(messagePanel, f);

        //creates cookie ImageIcon
        ImageIcon cookieIcon = new ImageIcon("bitcoin3.png");

        // create a label for displaying the number of bitcoins
        bcCounter.add(cookieLabel);

        //create a label for displaying the rate at which bitcoin is mined
        bcCounter.add(rateLabel);

        // create a button for clicking the cookie
        JButton cookieButton = new JButton("Click the bitcoin!");
        cookieButton.setIcon(cookieIcon);
        bcPanel.add(cookieButton);

        JPanel workerPanel = new JPanel();
        workerPanel.setBackground(Color.WHITE);
        workerPanel.setLayout(new GridLayout(5, 1));
        workerPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
        frame.add(workerPanel, e);

        cookieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                bitcoins++;

                // update the label with the new number of bitcoins
                cookieLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
            }
        });

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

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                if (bitcoins >= 10) {
                    numChimps++;
                    bitcoins = bitcoins - 10;
                    cookieLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 1;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
                    BitcoinSound.playSound(0);
                }

                // update the label with the new number of bitcoins
                button1.setText("Chimps: " + numChimps);
            }
        });

        button1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // add the message panel to the frame when the mouse enters the button
                messageLabel.setText("Price: 10 BTC | Speed: 1 BTC/sec");

                // repaint the frame to show the panel
                frame.repaint();
            }

            public void mouseExited(MouseEvent e) {
                // remove the message panel from the frame when the mouse exits the button
                messageLabel.setText("");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                if (bitcoins >= 100) {
                    numMinions++;
                    bitcoins = bitcoins - 100;
                    cookieLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 15;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);

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
                messageLabel.setText("");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                if (bitcoins >= 200) {
                    numKittens++;
                    bitcoins = bitcoins - 200;
                    cookieLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 50;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
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
                messageLabel.setText("");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                if (bitcoins >= 500) {
                    numPreceptors++;
                    bitcoins = bitcoins - 500;
                    cookieLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 150;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
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
                messageLabel.setText("");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // increment the number of bitcoins when the button is clicked
                if (bitcoins >= 10000) {
                    numKevinWaynes++;
                    bitcoins = bitcoins - 10000;
                    cookieLabel.setText("Number of bitcoins: " + Math.round(bitcoins * 10) / 10.0);
                    bitcoinRate += 5000;
                    rateLabel.setText("Bitcoins per sec: " + bitcoinRate);
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
                messageLabel.setText("");

                // repaint the frame to hide the panel
                frame.repaint();
            }
        });

        workerPanel.add(button1);
        workerPanel.add(button2);
        workerPanel.add(button3);
        workerPanel.add(button4);
        workerPanel.add(button5);


        // show the frame
        // frame.pack();
        frame.setVisible(true);
        getFonts();
        startTimer();
        timer.start();
    }

    public static void startTimer() {
        timer = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bitcoins += bitcoinRate / 20;
                cookieLabel.setText("Number of bitcoins: " + String.format("%.1f", Math.round(bitcoins * 10) / 10.0));
            }
        });
    }

}
