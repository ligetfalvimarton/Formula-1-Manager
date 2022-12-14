/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.GameModel;
import ViewModel.RaceWeekendVM;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static ViewModel.rxjava_mvvm.RxSwingView2ViewModelBinder.bindSwingView;
/**
 *
 * @author Marton
 */
public class RaceWeekend extends javax.swing.JPanel {
    private final MainWindow window;
    public static int devPoints;
    public static int workPoints;
    public static ArrayList<Integer> barValues;
    public static GameModel gameModel;
    public static boolean upgradeChance;
    public static int increasedChance;
    /**
     * Creates new form ResourceAndDevelopment
     * @param window
     */
    public RaceWeekend(final MainWindow window) {
        this.window = window;
        initComponents();
        simulationLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Simulation/0.png"));
        backToGF.setVisible(false);        
        RaceWeekendVM viewModel = new RaceWeekendVM(window.getGameModel());
        bind(viewModel);
    }
    public void bind(final RaceWeekendVM viewModel) {
        bindSwingView(simulationStartButton).toViewModel(viewModel.v2vm_simulationButtonEvents);
        bindSwingView(powerUnitPlusButton).toViewModel(viewModel.v2vm_upgradePowerUnitButtonEvents); 
        bindSwingView(aeroPlusButton).toViewModel(viewModel.v2vm_upgradeAeroButtonEvents); 
        bindSwingView(chasingPlusButton).toViewModel(viewModel.v2vm_upgradeChasingButtonEvents); 
        bindSwingView(durabilityPlusButton).toViewModel(viewModel.v2vm_upgradeDurabilityButtonEvents); 
        bindSwingView(mechanicsPlusButton).toViewModel(viewModel.v2vm_upgradeMechanicsButtonEvents); 
        bindSwingView(workersPlusButton).toViewModel(viewModel.v2vm_upgradeWorkersEvents); 
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
        increasedChance = mechanicsBar.getValue() + workersBar.getValue();
        upgradeChance = gameModel.isUpgradeChance();
        MinigameButton.setVisible(gameModel.isUpgradeChanceVisibility());
    }
    
    public void setProgressBarValue(ArrayList<Integer> values)
    {
        if(values != null)
        {
            powerUnitBar.setValue(values.get(0));
            powerUnitBar.setToolTipText(String.valueOf(values.get(0)));
            aeroBar.setValue(values.get(1));
            aeroBar.setToolTipText(String.valueOf(values.get(1)));
            chasingBar.setValue(values.get(2));
            chasingBar.setToolTipText(String.valueOf(values.get(2)));
            durabilityBar.setValue(values.get(3));
            durabilityBar.setToolTipText(String.valueOf(values.get(3)));
            mechanicsBar.setValue(values.get(4));
            mechanicsBar.setToolTipText(String.valueOf(values.get(4)));
            workersBar.setValue(values.get(5));
            workersBar.setToolTipText(String.valueOf(values.get(5)));
        }
    }
    public static void availablePointsText(){
        devPointsLabel.setText("Available development points: " + devPoints);
        workPointsLabel.setText("Available worker points: " + workPoints);
    }
    public static void hideButtons()
    {
        if(devPoints <= 0)
        {
            powerUnitPlusButton.setVisible(false);
            aeroPlusButton.setVisible(false);
            chasingPlusButton.setVisible(false);
            durabilityPlusButton.setVisible(false);
            
        }
        if(workPoints <=0)
        {
            workersPlusButton.setVisible(false);
            mechanicsPlusButton.setVisible(false);
        }
    }
    public void trackSelection()
    {
        switch(gameModel.getGpCounter())
        {
            case 0:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Bahrein.jpg"));
                trackNameLabel.setText("Grand Prix: Bahrein");
                break;
            case 1:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Monaco.jpg"));
                trackNameLabel.setText("Grand Prix: Monaco");
                break;
            case 2:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Austria.jpg"));
                trackNameLabel.setText("Grand Prix: Austria");
                break; 
            case 3:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/French.jpg"));
                trackNameLabel.setText("Grand Prix: French");
                break; 
            case 4:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Silverstone.jpg"));
                trackNameLabel.setText("Grand Prix: Silverstone");
                break; 
            case 5:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Spain.jpg"));
                trackNameLabel.setText("Grand Prix: Spain");
                break; 
            case 6:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Italy.jpg"));
                trackNameLabel.setText("Grand Prix: Italy");
                break; 
            case 7:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Hungary.jpg"));
                trackNameLabel.setText("Grand Prix: Hungary");
                break; 
            case 8:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Spa.jpg"));
                trackNameLabel.setText("Grand Prix: Belgium");
                break; 
            case 9:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Abudabi.jpg"));
                trackNameLabel.setText("Grand Prix: Abudabi");
                break;               
            default:
                trackPictureLabel.setIcon(new ImageIcon(Paths.get("").toAbsolutePath().toString() + "/src/main/java/Images/Tracks/Bahrein.jpg"));
                trackNameLabel.setText("Grand Prix: Bahrein");
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
        dashboardTitle = new javax.swing.JLabel();
        powerUnitBar = new javax.swing.JProgressBar();
        powerUnitLabel = new javax.swing.JLabel();
        aeroBar = new javax.swing.JProgressBar();
        aeroLabel = new javax.swing.JLabel();
        chasingLabel = new javax.swing.JLabel();
        durabilityLabel = new javax.swing.JLabel();
        chasingBar = new javax.swing.JProgressBar();
        durabilityBar = new javax.swing.JProgressBar();
        simulationPanel = new javax.swing.JPanel();
        racingTittle = new javax.swing.JLabel();
        simulationStartButton = new javax.swing.JButton();
        simulationLabel = new javax.swing.JLabel();
        winnerLabel = new javax.swing.JLabel();
        mechanicsLabel = new javax.swing.JLabel();
        mechanicsBar = new javax.swing.JProgressBar();
        workersLabel = new javax.swing.JLabel();
        workersBar = new javax.swing.JProgressBar();
        powerUnitPlusButton = new javax.swing.JButton();
        workersPlusButton = new javax.swing.JButton();
        mechanicsPlusButton = new javax.swing.JButton();
        aeroPlusButton = new javax.swing.JButton();
        chasingPlusButton = new javax.swing.JButton();
        durabilityPlusButton = new javax.swing.JButton();
        devPointsLabel = new javax.swing.JLabel();
        workPointsLabel = new javax.swing.JLabel();
        trackPictureLabel = new javax.swing.JLabel();
        trackNameLabel = new javax.swing.JLabel();
        MinigameButton = new javax.swing.JButton();
        upgradeStatLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        backToGF.setText("Back");
        backToGF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToGFActionPerformed(evt);
            }
        });

        dashboardTitle.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        dashboardTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardTitle.setText("Dashboard");

        powerUnitBar.setForeground(new java.awt.Color(0, 204, 51));
        powerUnitBar.setMaximum(50);
        powerUnitBar.setToolTipText("10");
        powerUnitBar.setValue(10);

        powerUnitLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        powerUnitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        powerUnitLabel.setText("Power Unit");

        aeroBar.setForeground(new java.awt.Color(0, 204, 51));
        aeroBar.setMaximum(50);
        aeroBar.setToolTipText("10");
        aeroBar.setValue(10);

        aeroLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        aeroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aeroLabel.setText("Aero Development");

        chasingLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chasingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chasingLabel.setText("Chasing System");

        durabilityLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        durabilityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        durabilityLabel.setText("Durability");

        chasingBar.setForeground(new java.awt.Color(0, 204, 51));
        chasingBar.setMaximum(50);
        chasingBar.setToolTipText("10");
        chasingBar.setValue(10);

        durabilityBar.setForeground(new java.awt.Color(0, 204, 51));
        durabilityBar.setMaximum(50);
        durabilityBar.setToolTipText("10");
        durabilityBar.setValue(10);

        simulationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        racingTittle.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        racingTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        racingTittle.setText("Racing");

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

        javax.swing.GroupLayout simulationPanelLayout = new javax.swing.GroupLayout(simulationPanel);
        simulationPanel.setLayout(simulationPanelLayout);
        simulationPanelLayout.setHorizontalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(racingTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simulationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(winnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(simulationStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(simulationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        simulationPanelLayout.setVerticalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulationPanelLayout.createSequentialGroup()
                .addComponent(racingTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simulationStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(winnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        mechanicsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        mechanicsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mechanicsLabel.setText("Mechanics");
        mechanicsLabel.setToolTipText("With more mechanics, your upgrade performance increased.");

        mechanicsBar.setForeground(new java.awt.Color(0, 204, 51));
        mechanicsBar.setMaximum(50);
        mechanicsBar.setToolTipText("10");
        mechanicsBar.setValue(10);

        workersLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        workersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workersLabel.setText("Workers");
        workersLabel.setToolTipText("With more workers, your upgrade performance increased.");

        workersBar.setForeground(new java.awt.Color(0, 204, 51));
        workersBar.setMaximum(50);
        workersBar.setToolTipText("10");
        workersBar.setValue(10);

        powerUnitPlusButton.setText("+");
        powerUnitPlusButton.setMaximumSize(new java.awt.Dimension(48, 25));
        powerUnitPlusButton.setPreferredSize(new java.awt.Dimension(43, 40));
        powerUnitPlusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                powerUnitPlusButtonMouseClicked(evt);
            }
        });
        powerUnitPlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powerUnitPlusButtonActionPerformed(evt);
            }
        });

        workersPlusButton.setText("+");
        workersPlusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workersPlusButtonMouseClicked(evt);
            }
        });

        mechanicsPlusButton.setText("+");
        mechanicsPlusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mechanicsPlusButtonMouseClicked(evt);
            }
        });

        aeroPlusButton.setText("+");
        aeroPlusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aeroPlusButtonMouseClicked(evt);
            }
        });

        chasingPlusButton.setText("+");
        chasingPlusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chasingPlusButtonMouseClicked(evt);
            }
        });

        durabilityPlusButton.setText("+");
        durabilityPlusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                durabilityPlusButtonMouseClicked(evt);
            }
        });

        devPointsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        devPointsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        devPointsLabel.setText("Available development points: 3");

        workPointsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        workPointsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workPointsLabel.setText("Available worker points: 2");

        MinigameButton.setText("Increase Upgrade");
        MinigameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinigameButtonActionPerformed(evt);
            }
        });

        upgradeStatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        upgradeStatLabel.setText("Upgrade Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(aeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(powerUnitLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chasingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(durabilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mechanicsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(workersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(workersBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(workersPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(mechanicsBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(mechanicsPlusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(powerUnitBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(aeroBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(40, 40, 40)
                                                        .addComponent(powerUnitPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(aeroPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(durabilityBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(chasingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(chasingPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(durabilityPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(trackNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(trackPictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(devPointsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(workPointsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MinigameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(upgradeStatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simulationPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToGF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simulationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backToGF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dashboardTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(devPointsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinigameButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(workPointsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(upgradeStatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(powerUnitPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addComponent(powerUnitBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aeroPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aeroBar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chasingPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(chasingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(durabilityPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(durabilityBar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mechanicsBar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mechanicsPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(workersPlusButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(workersBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(powerUnitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(aeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(chasingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(durabilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mechanicsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(workersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(trackNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trackPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backToGFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToGFActionPerformed
        gameModel.setValues(barValues);
        gameModel.setDevelopmentPoints(devPoints);
        gameModel.setWorkerPoints(workPoints);
        gameModel.setUpgradeChance(false);
        gameModel.setUpgradeChanceVisibility(true);
        gameModel.setGpCounter(gameModel.getGpCounter()+1);
        gameModel.setMoney(gameModel.getMoney() + 20000);
        gameModel.getTimeSimulation().setDateTime(LocalTime.of(0, 0, 0));
        gameModel.getTimeSimulation().setDaysPassed((gameModel.getGpCounter()*3)+1);
        gameModel.getTimeSimulation().NormalTime();
        window.switchToGameField(this);
    }//GEN-LAST:event_backToGFActionPerformed

    private void powerUnitPlusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_powerUnitPlusButtonMouseClicked

    }//GEN-LAST:event_powerUnitPlusButtonMouseClicked

    private void aeroPlusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aeroPlusButtonMouseClicked
        
    }//GEN-LAST:event_aeroPlusButtonMouseClicked

    private void chasingPlusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chasingPlusButtonMouseClicked

    }//GEN-LAST:event_chasingPlusButtonMouseClicked

    private void durabilityPlusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_durabilityPlusButtonMouseClicked

    }//GEN-LAST:event_durabilityPlusButtonMouseClicked

    private void mechanicsPlusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mechanicsPlusButtonMouseClicked

    }//GEN-LAST:event_mechanicsPlusButtonMouseClicked

    private void workersPlusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workersPlusButtonMouseClicked

    }//GEN-LAST:event_workersPlusButtonMouseClicked

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

    private void powerUnitPlusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powerUnitPlusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_powerUnitPlusButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton MinigameButton;
    public static javax.swing.JProgressBar aeroBar;
    private javax.swing.JLabel aeroLabel;
    public static javax.swing.JButton aeroPlusButton;
    public static javax.swing.JButton backToGF;
    public static javax.swing.JProgressBar chasingBar;
    private javax.swing.JLabel chasingLabel;
    public static javax.swing.JButton chasingPlusButton;
    private javax.swing.JLabel dashboardTitle;
    public static javax.swing.JLabel devPointsLabel;
    public static javax.swing.JProgressBar durabilityBar;
    private javax.swing.JLabel durabilityLabel;
    public static javax.swing.JButton durabilityPlusButton;
    public static javax.swing.JProgressBar mechanicsBar;
    private javax.swing.JLabel mechanicsLabel;
    public static javax.swing.JButton mechanicsPlusButton;
    public static javax.swing.JProgressBar powerUnitBar;
    private javax.swing.JLabel powerUnitLabel;
    public static javax.swing.JButton powerUnitPlusButton;
    private javax.swing.JLabel racingTittle;
    public static javax.swing.JLabel simulationLabel;
    private javax.swing.JPanel simulationPanel;
    public static javax.swing.JButton simulationStartButton;
    private javax.swing.JLabel trackNameLabel;
    private javax.swing.JLabel trackPictureLabel;
    public static javax.swing.JLabel upgradeStatLabel;
    public static javax.swing.JLabel winnerLabel;
    public static javax.swing.JLabel workPointsLabel;
    public static javax.swing.JProgressBar workersBar;
    private javax.swing.JLabel workersLabel;
    public static javax.swing.JButton workersPlusButton;
    // End of variables declaration//GEN-END:variables
}
