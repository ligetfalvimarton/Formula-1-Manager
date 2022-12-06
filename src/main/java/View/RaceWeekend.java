/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.GameModel;
import Model.TimeSimulation;
import ViewModel.RaceWeekendVM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import static rxjava_mvvm.RxSwingView2ViewModelBinder.bindSwingView;
/**
 *
 * @author Marton
 */
public class RaceWeekend extends javax.swing.JPanel {
    private final MainWindow window;
    private int devPoints;
    private int workPoints;
    private int labelCounter;
    private ArrayList<Integer> barValues;
    private GameModel gameModel;
    private Timer timer;
    private String winner;
    private boolean upgradeChance;
    private int increasedChance;
    /**
     * Creates new form ResourceAndDevelopment
     */
    public RaceWeekend(final MainWindow window) {
        this.window = window;
        initComponents();
        labelCounter = 1;
        simulationLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Simulation/0.png"));
        backToGF.setVisible(false);        
        RaceWeekendVM viewModel = new RaceWeekendVM(window.getGameModel());
        bind(viewModel);
    }
    public void bind(final RaceWeekendVM viewModel) {
        bindSwingView(simulationStartButton).toViewModel(viewModel.v2vm_simulationButtonEvents);
    }
    public void setGameModel(GameModel gameModel){
        this.gameModel = gameModel;
        devPoints = gameModel.getDevelopmentPoints();
        workPoints = gameModel.getWorkerPoints();
        barValues = gameModel.startingStats(window.getConstructor());
        setProgressBarValue(barValues);
        availablePointsText();
        trackSelection();
        hideButtons();
        increasedChance = jProgressBar5.getValue() + jProgressBar6.getValue();
        upgradeChance = gameModel.isUpgradeChance();
        MinigameButton.setVisible(gameModel.isUpgradeChanceVisibility());
    }
    
    public void setProgressBarValue(ArrayList<Integer> values)
    {
        if(values != null)
        {
            jProgressBar1.setValue(values.get(0));
            jProgressBar1.setToolTipText(String.valueOf(values.get(0)));
            jProgressBar2.setValue(values.get(1));
            jProgressBar2.setToolTipText(String.valueOf(values.get(1)));
            jProgressBar3.setValue(values.get(2));
            jProgressBar3.setToolTipText(String.valueOf(values.get(2)));
            jProgressBar4.setValue(values.get(3));
            jProgressBar4.setToolTipText(String.valueOf(values.get(3)));
            jProgressBar5.setValue(values.get(4));
            jProgressBar5.setToolTipText(String.valueOf(values.get(4)));
            jProgressBar6.setValue(values.get(5));
            jProgressBar6.setToolTipText(String.valueOf(values.get(5)));
        }
    }
    public void availablePointsText(){
        jLabel10.setText("Available development points: " + devPoints);
        jLabel11.setText("Available worker points: " + workPoints);
    }
    public void hideButtons()
    {
        if(devPoints <= 0)
        {
            jButton2.setVisible(false);
            jButton6.setVisible(false);
            jButton7.setVisible(false);
            jButton8.setVisible(false);
            
        }
        if(workPoints <=0)
        {
            jButton4.setVisible(false);
            jButton5.setVisible(false);
        }
    }
    public void trackSelection()
    {
        switch(gameModel.getGpCounter())
        {
            case 0:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Bahrein.jpg"));
                jLabel13.setText("Grand Prix: Bahrein");
                break;
            case 1:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Monaco.jpg"));
                jLabel13.setText("Grand Prix: Monaco");
                break;
            case 2:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Austria.jpg"));
                jLabel13.setText("Grand Prix: Austria");
                break; 
            case 3:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/French.jpg"));
                jLabel13.setText("Grand Prix: French");
                break; 
            case 4:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Silverstone.jpg"));
                jLabel13.setText("Grand Prix: Silverstone");
                break; 
            case 5:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Spain.jpg"));
                jLabel13.setText("Grand Prix: Spain");
                break; 
            case 6:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Italy.jpg"));
                jLabel13.setText("Grand Prix: Italy");
                break; 
            case 7:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Hungary.jpg"));
                jLabel13.setText("Grand Prix: Hungary");
                break; 
            case 8:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Spa.jpg"));
                jLabel13.setText("Grand Prix: Belgium");
                break; 
            case 9:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Abudabi.jpg"));
                jLabel13.setText("Grand Prix: Abudabi");
                break;               
            default:
                jLabel12.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Bahrein.jpg"));
                jLabel13.setText("Grand Prix: Bahrein");
                break; 
        }
        if(gameModel.getGpCounter() == 9)
        {
            gameModel.setGpCounter(1);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backToGF = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        simulationStartButton = new javax.swing.JButton();
        simulationLabel = new javax.swing.JLabel();
        winnerLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar6 = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        MinigameButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        backToGF.setText("Back");
        backToGF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToGFActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dashboard");

        jProgressBar1.setForeground(new java.awt.Color(0, 204, 51));
        jProgressBar1.setMaximum(50);
        jProgressBar1.setToolTipText("10");
        jProgressBar1.setValue(10);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Power Unit");

        jProgressBar2.setForeground(new java.awt.Color(0, 204, 51));
        jProgressBar2.setMaximum(50);
        jProgressBar2.setToolTipText("10");
        jProgressBar2.setValue(10);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Aero Development");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chasing System");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Durability");

        jProgressBar3.setForeground(new java.awt.Color(0, 204, 51));
        jProgressBar3.setMaximum(50);
        jProgressBar3.setToolTipText("10");
        jProgressBar3.setValue(10);

        jProgressBar4.setForeground(new java.awt.Color(0, 204, 51));
        jProgressBar4.setMaximum(50);
        jProgressBar4.setToolTipText("10");
        jProgressBar4.setValue(10);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Racing");

        simulationStartButton.setText("Simulate");
        simulationStartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                simulationStartButtonMousePressed(evt);
            }
        });
        simulationStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulationStartButtonActionPerformed(evt);
            }
        });

        simulationLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        simulationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        winnerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        winnerLabel.setText("Winner:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(winnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(simulationStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(simulationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simulationStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(winnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Mechanics");
        jLabel8.setToolTipText("With more mechanics, your upgrade performance increased.");

        jProgressBar5.setForeground(new java.awt.Color(0, 204, 51));
        jProgressBar5.setMaximum(50);
        jProgressBar5.setToolTipText("10");
        jProgressBar5.setValue(10);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Workers");
        jLabel9.setToolTipText("With more workers, your upgrade performance increased.");

        jProgressBar6.setForeground(new java.awt.Color(0, 204, 51));
        jProgressBar6.setMaximum(50);
        jProgressBar6.setToolTipText("10");
        jProgressBar6.setValue(10);

        jButton2.setText("+");
        jButton2.setMaximumSize(new java.awt.Dimension(48, 25));
        jButton2.setPreferredSize(new java.awt.Dimension(43, 40));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("+");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("+");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("+");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton7.setText("+");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton8.setText("+");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Available development points: 3");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Available worker points: 2");

        MinigameButton.setText("Increase Upgrade");
        MinigameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinigameButtonActionPerformed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Upgrade Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jProgressBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(40, 40, 40)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MinigameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToGF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backToGF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinigameButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backToGFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToGFActionPerformed
        gameModel.setValues(barValues);
        gameModel.setUpgradeChance(false);
        gameModel.setUpgradeChanceVisibility(true);
        gameModel.setGpCounter(gameModel.getGpCounter()+1);
        gameModel.getTimeSimulation().setDateTime(LocalTime.of(0, 0, 0));
        gameModel.getTimeSimulation().setDaysPassed((gameModel.getGpCounter()*3)+1);
        gameModel.getTimeSimulation().NormalTime();
        window.switchToGameField(this);
    }//GEN-LAST:event_backToGFActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Random rand = new Random();
        int numberOne = rand.nextInt(increasedChance);
        if(upgradeChance)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar1.getValue() +1;
            jProgressBar1.setValue(addon);
            jProgressBar1.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else if(numberOne%3 ==0)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar1.getValue() +1;
            jProgressBar1.setValue(addon);
            jProgressBar1.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else
        {
            jLabel15.setText("Failed");
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        Random rand = new Random();
        int numberOne = rand.nextInt(increasedChance);
        if(upgradeChance)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar2.getValue() +1;
            jProgressBar2.setValue(addon);
            jProgressBar2.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else if(numberOne%3 ==0)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar2.getValue() +1;
            jProgressBar2.setValue(addon);
            jProgressBar2.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else
        {
            jLabel15.setText("Failed");
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        Random rand = new Random();
        int numberOne = rand.nextInt(increasedChance);
        if(upgradeChance)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar3.getValue() +1;
            jProgressBar3.setValue(addon);
            jProgressBar3.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else if(numberOne%3 ==0)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar3.getValue() +1;
            jProgressBar3.setValue(addon);
            jProgressBar3.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else
        {
            jLabel15.setText("Failed");
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        Random rand = new Random();
        int numberOne = rand.nextInt(increasedChance);
        if(upgradeChance)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar4.getValue() +1;
            jProgressBar4.setValue(addon);
            jProgressBar4.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else if(numberOne%3 ==0)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar4.getValue() +1;
            jProgressBar4.setValue(addon);
            jProgressBar4.setToolTipText(String.valueOf(addon));
            barValues.set(0, addon);
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
        else
        {
            jLabel15.setText("Failed");
            devPoints--;
            gameModel.setDevelopmentPoints(devPoints);
            availablePointsText();
            hideButtons();
        }
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        Random rand = new Random();
        int numberOne = rand.nextInt(increasedChance);
        if(upgradeChance)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar5.getValue() +1;
            jProgressBar5.setValue(addon);
            jProgressBar5.setToolTipText(String.valueOf(addon));
            barValues.set(4, addon);
            workPoints--;
            gameModel.setWorkerPoints(workPoints);
            availablePointsText();
            hideButtons();
        }
        else if(numberOne%3 ==0)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar5.getValue() +1;
            jProgressBar5.setValue(addon);
            jProgressBar5.setToolTipText(String.valueOf(addon));
            barValues.set(4, addon);
            workPoints--;
            gameModel.setWorkerPoints(workPoints);
            availablePointsText();
            hideButtons();
        }
        else
        {
            jLabel15.setText("Failed");
            workPoints--;
            gameModel.setWorkerPoints(workPoints);
            availablePointsText();
            hideButtons();
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        Random rand = new Random();
        int numberOne = rand.nextInt(increasedChance);
        if(upgradeChance)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar6.getValue() +1;
            jProgressBar6.setValue(addon);
            jProgressBar6.setToolTipText(String.valueOf(addon));
            barValues.set(4, addon);
            workPoints--;
            gameModel.setWorkerPoints(workPoints);
            availablePointsText();
            hideButtons();
        }
        else if(numberOne%3 ==0)
        {
            jLabel15.setText("Sucessful");
            int addon = jProgressBar6.getValue() +1;
            jProgressBar6.setValue(addon);
            jProgressBar6.setToolTipText(String.valueOf(addon));
            barValues.set(4, addon);
            workPoints--;
            gameModel.setWorkerPoints(workPoints);
            availablePointsText();
            hideButtons();
        }
        else
        {
            jLabel15.setText("Failed");
            workPoints--;
            gameModel.setWorkerPoints(workPoints);
            availablePointsText();
            hideButtons();
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void simulationStartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulationStartButtonMousePressed

    }//GEN-LAST:event_simulationStartButtonMousePressed

    private void simulationStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulationStartButtonActionPerformed

    }//GEN-LAST:event_simulationStartButtonActionPerformed

    private void MinigameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinigameButtonActionPerformed
        try {
            window.switchToMiniGame(this);
        } catch (IOException ex) {
            Logger.getLogger(Minigame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MinigameButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton MinigameButton;
    public static javax.swing.JButton backToGF;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JProgressBar jProgressBar6;
    public static javax.swing.JLabel simulationLabel;
    public static javax.swing.JButton simulationStartButton;
    public static javax.swing.JLabel winnerLabel;
    // End of variables declaration//GEN-END:variables
}
