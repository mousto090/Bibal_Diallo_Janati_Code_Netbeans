package IHM;

import Utility.BibalExceptions;
import Utility.DBConnection;
import Utility.ModelTableau;
import static Utility.Utility.closeStatementResultSet;
import static Utility.Utility.initialiseRequetePreparee;
import static Utility.Utility.showMessageSucces;
import control.EmpruntControl;
import control.ExemplaireControl;
import control.OeuvreControl;
import control.ReservationControl;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objets_metiers.Emprunt;
import objets_metiers.Exemplaire;
import objets_metiers.Livre;
import objets_metiers.Magazine;
import objets_metiers.Oeuvre;
import objets_metiers.Reservation;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 * 
 * @author Diallo & Janati
 */
public class GestionReservationsEmprunts extends javax.swing.JFrame {

    public GestionReservationsEmprunts() {
        initComponents();
        setIdentifiant();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bibliotheque_icone.png")));
        tableExemplaires.setModel(new ModelTableau(new Object[0][0],
                new String[]{"ID", "Etat"}));
        tableExemplaires.setRowHeight(30);

        tableEmpCours.setModel(new ModelTableau(new Object[0][0],
                new String[]{"ID", "Exemplaire", "Usager",
                    "Date Emprunt", "Date Retour"}));
        tableEmpCours.setRowHeight(30);

        tableResaCours.setModel(new ModelTableau(new Object[0][0],
                new String[]{"ID", "Oeuvre", "Usager",
                    "Date Réservation"}));
        tableResaCours.setRowHeight(30);

        tableExemplaires.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int row = tableExemplaires.getSelectedRow();
                int nbreCol = tableExemplaires.getColumnCount();

                dataLigneSelectedExemplaires = new Object[nbreCol];
                if (row >= 0) {
                    for (int i = 0; i < nbreCol; i++) {
                        dataLigneSelectedExemplaires[i] = tableExemplaires.getModel().getValueAt(row, i);
                    }
                    emprunterButton.setEnabled(true);
                } else {
                    emprunterButton.setEnabled(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        tableEmpCours.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int row = tableEmpCours.getSelectedRow();
                int nbreCol = tableEmpCours.getColumnCount();

                dataLigneSelectedEmprunts = new Object[nbreCol];
                if (row >= 0) {
                    for (int i = 0; i < nbreCol; i++) {
                        dataLigneSelectedEmprunts[i] = tableEmpCours.getModel().getValueAt(row, i);
                    }
                    rendreButton.setEnabled(true);
                } else {
                    rendreButton.setEnabled(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        tableResaCours.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int row = tableResaCours.getSelectedRow();
                int nbreCol = tableResaCours.getColumnCount();

                dataLigneSelectedReservations = new Object[nbreCol];
                if (row >= 0) {
                    for (int i = 0; i < nbreCol; i++) {
                        dataLigneSelectedReservations[i] = tableResaCours.getModel().getValueAt(row, i);
                    }
                    annulerResaButton.setEnabled(true);
                } else {
                    annulerResaButton.setEnabled(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        EmpruntPanel = new javax.swing.JPanel();
        panEmpCours = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpCours = new javax.swing.JTable();
        menuEmpPanel = new javax.swing.JPanel();
        rendreButton = new javax.swing.JButton();
        emprunterButton = new javax.swing.JButton();
        affEmpButton = new javax.swing.JButton();
        affExempButton = new javax.swing.JButton();
        panExemplaires = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableExemplaires = new javax.swing.JTable();
        ReservationPanel = new javax.swing.JPanel();
        panResaCours = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableResaCours = new javax.swing.JTable();
        menuResaPanel = new javax.swing.JPanel();
        annulerResaButton = new javax.swing.JButton();
        reserverButton = new javax.swing.JButton();
        affResaButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        empruntsButton = new javax.swing.JButton();
        ReservationButton = new javax.swing.JButton();
        retourButton = new javax.swing.JButton();
        titleResaEmpLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        typeOeuvreLabel1 = new javax.swing.JLabel();
        identifiantLabel1 = new javax.swing.JLabel();
        auteurLabel1 = new javax.swing.JLabel();
        titreLabel1 = new javax.swing.JLabel();
        categorieLabel1 = new javax.swing.JLabel();
        nbExemplaire1 = new javax.swing.JLabel();
        titreLabelValue = new javax.swing.JLabel();
        categorieLabelValue = new javax.swing.JLabel();
        typeOeuvreLabelValue = new javax.swing.JLabel();
        auteurLabelValue = new javax.swing.JLabel();
        nbExemplaireLabelValue = new javax.swing.JLabel();
        identifiantComboBox = new javax.swing.JComboBox<>();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Réservations et Oeuvres");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        EmpruntPanel.setBackground(new java.awt.Color(255, 255, 255));

        panEmpCours.setBackground(new java.awt.Color(255, 255, 255));
        panEmpCours.setBorder(javax.swing.BorderFactory.createTitledBorder("Emprunts en cours des exempalaires de l'oeuvre"));

        jScrollPane1.getViewport().setBackground(Color.white);
        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tableEmpCours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Exemplaire", "Usager", "Date emprunt", "Date Retour"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmpCours.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableEmpCours.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableEmpCours);

        javax.swing.GroupLayout panEmpCoursLayout = new javax.swing.GroupLayout(panEmpCours);
        panEmpCours.setLayout(panEmpCoursLayout);
        panEmpCoursLayout.setHorizontalGroup(
            panEmpCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEmpCoursLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
        );
        panEmpCoursLayout.setVerticalGroup(
            panEmpCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        menuEmpPanel.setBackground(new java.awt.Color(255, 255, 255));
        menuEmpPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        rendreButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rendreButton.setText("Rendre");
        rendreButton.setEnabled(false);
        rendreButton.setPreferredSize(new java.awt.Dimension(95, 31));
        rendreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendre(evt);
            }
        });

        emprunterButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        emprunterButton.setText("Emprunter");
        emprunterButton.setEnabled(false);
        emprunterButton.setPreferredSize(new java.awt.Dimension(95, 31));
        emprunterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprunter(evt);
            }
        });

        affEmpButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        affEmpButton.setText("Afficher emprunts");
        affEmpButton.setEnabled(false);
        affEmpButton.setPreferredSize(new java.awt.Dimension(95, 31));
        affEmpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affEmpButtonActionPerformed(evt);
            }
        });

        affExempButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        affExempButton.setText("Afficher exemplaires");
        affExempButton.setEnabled(false);
        affExempButton.setPreferredSize(new java.awt.Dimension(95, 31));
        affExempButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affExempButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuEmpPanelLayout = new javax.swing.GroupLayout(menuEmpPanel);
        menuEmpPanel.setLayout(menuEmpPanelLayout);
        menuEmpPanelLayout.setHorizontalGroup(
            menuEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEmpPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(menuEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(affEmpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emprunterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rendreButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(affExempButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );
        menuEmpPanelLayout.setVerticalGroup(
            menuEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEmpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rendreButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emprunterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(menuEmpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(affEmpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(affExempButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panExemplaires.setBackground(new java.awt.Color(255, 255, 255));
        panExemplaires.setBorder(javax.swing.BorderFactory.createTitledBorder("Exemplaires Disponibles"));

        jScrollPane2.getViewport().setBackground(Color.white);
        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tableExemplaires.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Etat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableExemplaires.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableExemplaires.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableExemplaires);

        javax.swing.GroupLayout panExemplairesLayout = new javax.swing.GroupLayout(panExemplaires);
        panExemplaires.setLayout(panExemplairesLayout);
        panExemplairesLayout.setHorizontalGroup(
            panExemplairesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panExemplairesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );
        panExemplairesLayout.setVerticalGroup(
            panExemplairesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout EmpruntPanelLayout = new javax.swing.GroupLayout(EmpruntPanel);
        EmpruntPanel.setLayout(EmpruntPanelLayout);
        EmpruntPanelLayout.setHorizontalGroup(
            EmpruntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpruntPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(EmpruntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuEmpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EmpruntPanelLayout.createSequentialGroup()
                        .addComponent(panEmpCours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panExemplaires, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );
        EmpruntPanelLayout.setVerticalGroup(
            EmpruntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpruntPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuEmpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(EmpruntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panEmpCours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panExemplaires, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(EmpruntPanel, "panel1");

        ReservationPanel.setBackground(new java.awt.Color(255, 255, 255));

        panResaCours.setBackground(new java.awt.Color(255, 255, 255));
        panResaCours.setBorder(javax.swing.BorderFactory.createTitledBorder("Réservations en cours"));

        jScrollPane5.getViewport().setBackground(Color.white);
        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tableResaCours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Oeuvre", "Usager", "Date Reservation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResaCours.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableResaCours);

        javax.swing.GroupLayout panResaCoursLayout = new javax.swing.GroupLayout(panResaCours);
        panResaCours.setLayout(panResaCoursLayout);
        panResaCoursLayout.setHorizontalGroup(
            panResaCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panResaCoursLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5))
        );
        panResaCoursLayout.setVerticalGroup(
            panResaCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        menuResaPanel.setBackground(new java.awt.Color(255, 255, 255));
        menuResaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        annulerResaButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        annulerResaButton.setText("Annuler");
        annulerResaButton.setEnabled(false);
        annulerResaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerResaButtonActionPerformed(evt);
            }
        });

        reserverButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        reserverButton.setText("Réserver");
        reserverButton.setEnabled(false);
        reserverButton.setPreferredSize(new java.awt.Dimension(95, 31));
        reserverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserverButtonActionPerformed(evt);
            }
        });

        affResaButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        affResaButton.setText("Afficher ");
        affResaButton.setEnabled(false);
        affResaButton.setPreferredSize(new java.awt.Dimension(95, 31));
        affResaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affResaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuResaPanelLayout = new javax.swing.GroupLayout(menuResaPanel);
        menuResaPanel.setLayout(menuResaPanelLayout);
        menuResaPanelLayout.setHorizontalGroup(
            menuResaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuResaPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(reserverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(affResaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(annulerResaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        menuResaPanelLayout.setVerticalGroup(
            menuResaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuResaPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(menuResaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annulerResaButton)
                    .addComponent(reserverButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(affResaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ReservationPanelLayout = new javax.swing.GroupLayout(ReservationPanel);
        ReservationPanel.setLayout(ReservationPanelLayout);
        ReservationPanelLayout.setHorizontalGroup(
            ReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
            .addGroup(ReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ReservationPanelLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addGroup(ReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(menuResaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panResaCours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        ReservationPanelLayout.setVerticalGroup(
            ReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
            .addGroup(ReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ReservationPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menuResaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addComponent(panResaCours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        mainPanel.add(ReservationPanel, "panel2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        empruntsButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        empruntsButton.setText("Emprunts");
        empruntsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empruntsButtonActionPerformed(evt);
            }
        });

        ReservationButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ReservationButton.setText("Réservations");
        ReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservationButtonActionPerformed(evt);
            }
        });

        retourButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        retourButton.setText("Retour");
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(empruntsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(retourButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(empruntsButton)
                .addGap(90, 90, 90)
                .addComponent(ReservationButton)
                .addGap(90, 90, 90)
                .addComponent(retourButton)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        titleResaEmpLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        titleResaEmpLabel.setForeground(new java.awt.Color(51, 51, 255));
        titleResaEmpLabel.setText("Gestion des Réservations et Emprunts");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        typeOeuvreLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        typeOeuvreLabel1.setForeground(new java.awt.Color(0, 0, 255));
        typeOeuvreLabel1.setText("Type de l'oeuvre");

        identifiantLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        identifiantLabel1.setForeground(new java.awt.Color(0, 0, 255));
        identifiantLabel1.setText("Identifiant ");

        auteurLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        auteurLabel1.setForeground(new java.awt.Color(0, 0, 255));
        auteurLabel1.setText("Auteur");

        titreLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titreLabel1.setForeground(new java.awt.Color(0, 0, 255));
        titreLabel1.setText("Titre");

        categorieLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        categorieLabel1.setForeground(new java.awt.Color(0, 0, 255));
        categorieLabel1.setText("Catégorie");

        nbExemplaire1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nbExemplaire1.setForeground(new java.awt.Color(0, 0, 255));
        nbExemplaire1.setText("Nombre \nd'exemplaire");

        titreLabelValue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titreLabelValue.setText(" ");

        categorieLabelValue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        categorieLabelValue.setText(" ");

        typeOeuvreLabelValue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        typeOeuvreLabelValue.setText(" ");

        auteurLabelValue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        auteurLabelValue.setText(" ");

        nbExemplaireLabelValue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nbExemplaireLabelValue.setText(" ");

        identifiantComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        identifiantComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choix ID" }));
        identifiantComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiantComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(titreLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(titreLabelValue))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(categorieLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(categorieLabelValue)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(identifiantLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(identifiantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeOeuvreLabel1)
                    .addComponent(nbExemplaire1)
                    .addComponent(auteurLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(auteurLabelValue)
                    .addComponent(nbExemplaireLabelValue)
                    .addComponent(typeOeuvreLabelValue))
                .addGap(195, 195, 195))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeOeuvreLabel1)
                    .addComponent(identifiantLabel1)
                    .addComponent(typeOeuvreLabelValue)
                    .addComponent(identifiantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titreLabel1)
                    .addComponent(titreLabelValue)
                    .addComponent(auteurLabel1)
                    .addComponent(auteurLabelValue))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorieLabelValue)
                    .addComponent(nbExemplaire1)
                    .addComponent(nbExemplaireLabelValue)
                    .addComponent(categorieLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(titleResaEmpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(126, 126, 126))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleResaEmpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservationButtonActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "panel2");
        String identitfiant = identifiantComboBox.getSelectedItem().toString();
        if (!identitfiant.equals("Choix ID")) {
            reserverButton.setEnabled(true);
        } else {
            reserverButton.setEnabled(false);
        }

    }//GEN-LAST:event_ReservationButtonActionPerformed

    private void empruntsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empruntsButtonActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "panel1");

        String identitfiant = identifiantComboBox.getSelectedItem().toString();
        if (!identitfiant.equals("Choix ID")) {
            emprunterButton.setEnabled(true);
        } else {
            emprunterButton.setEnabled(false);
            rendreButton.setEnabled(false);
            annulerResaButton.setEnabled(false);
        }
    }//GEN-LAST:event_empruntsButtonActionPerformed

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        Menu m = new Menu();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_retourButtonActionPerformed

    private void affEmpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affEmpButtonActionPerformed
        try {
            String identitfiant = identifiantComboBox.getSelectedItem().toString();
            if (!identitfiant.equals("Choix ID")) {
                Oeuvre oeuvre = getOeuvreInfos();
                ArrayList<Emprunt> listEmprunts = EmpruntControl.findEmprunts(oeuvre);
                if (null != listEmprunts) {
                    fillEmpruntsJtable(listEmprunts);
                } else {
                    showMessageSucces("Aucun emprunt en cours de cette oeuvre trouvé");
                    String titre[] = new String[]{"ID", "Exemplaire", "Usager",
                        "Date Emprunt", "Date Retour"};
                    Object data[][] = new Object[1][titre.length];
                    ModelTableau model = new ModelTableau(data, titre);
                    tableEmpCours.setModel(model);
                    tableEmpCours.setRowHeight(1);
                }
            }

        } catch (BibalExceptions ex) {
            System.out.println("IHM.GestionReservationsEmprunts.affEmpButtonActionPerformed()");
        }
    }//GEN-LAST:event_affEmpButtonActionPerformed

    private void identifiantComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifiantComboBoxActionPerformed

        String identitfiant = identifiantComboBox.getSelectedItem().toString();
        if (!identitfiant.equals("Choix ID")) {
            try {
                int id = parseInt(identitfiant);
                Oeuvre oeuvre = OeuvreControl.findById(id);
                titreLabelValue.setText(oeuvre.getTitre());
                categorieLabelValue.setText(oeuvre.getCategorie());
                typeOeuvreLabelValue.setText(oeuvre.getClass().getSimpleName());
                auteurLabelValue.setText(oeuvre.getAuteur());
                nbExemplaireLabelValue.setText(oeuvre.getExamplairesOeuvre().size() + "");
            } catch (BibalExceptions ex) {
                System.out.println("IHM.GestionReservationsEmprunts.identifiantComboBoxActionPerformed()");
            }
            affEmpButton.setEnabled(true);
            affExempButton.setEnabled(true);
            emprunterButton.setEnabled(true);
            reserverButton.setEnabled(true);
            affResaButton.setEnabled(true);
        } else {
            titreLabelValue.setText("");
            categorieLabelValue.setText("");
            typeOeuvreLabelValue.setText("");
            auteurLabelValue.setText("");
            nbExemplaireLabelValue.setText("");
            affEmpButton.setEnabled(false);
            affExempButton.setEnabled(false);
            emprunterButton.setEnabled(false);
            rendreButton.setEnabled(false);
            reserverButton.setEnabled(false);
            affResaButton.setEnabled(false);

        }
        rendreButton.setEnabled(false);
        //vider les tables
        tableExemplaires.setModel(new ModelTableau(new Object[0][0],
                new String[]{"ID", "Etat"}));
        tableExemplaires.setRowHeight(30);

        tableEmpCours.setModel(new ModelTableau(new Object[0][0],
                new String[]{"ID", "Exemplaire", "Usager",
                    "Date Emprunt", "Date Retour"}));
        tableResaCours.setRowHeight(30);

        tableResaCours.setModel(new ModelTableau(new Object[0][0],
                new String[]{"ID", "Oeuvre", "Usager",
                    "Date Réservation"}));
        tableResaCours.setRowHeight(30);

    }//GEN-LAST:event_identifiantComboBoxActionPerformed

    private void affExempButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affExempButtonActionPerformed
        try {
            String identitfiant = identifiantComboBox.getSelectedItem().toString();
            if (!identitfiant.equals("Choix ID")) {
                Oeuvre oeuvre = getOeuvreInfos();
                ArrayList<Exemplaire> listExemplaires = ExemplaireControl.findExemplaireDispo(oeuvre);
                if (null != listExemplaires) {
                    fillExemplaireJtable(listExemplaires);
                } else {
                    String titre[] = new String[]{"ID", "Etat"};
                    Object data[][] = new Object[1][titre.length];
                    ModelTableau model = new ModelTableau(data, titre);
                    tableExemplaires.setModel(model);
                    tableExemplaires.setRowHeight(1);
                    showMessageSucces("Aucun exemplaire disponible trouvé");
                }
            }
        } catch (BibalExceptions e) {
            System.out.println("IHM.GestionOeuvre.afficherButtonActionPerformed()");
        }
    }//GEN-LAST:event_affExempButtonActionPerformed

    private void rendre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendre
        try {
            int oeuvreId = getOeuvreID();
            if (oeuvreId != -1 && tableEmpCours.getSelectedRow() >= 0) {
                int idExemplaire = parseInt(dataLigneSelectedEmprunts[1].toString());
                int idOeuvre = parseInt(identifiantComboBox.getSelectedItem().toString());
                EmpruntControl.rendre(dataLigneSelectedEmprunts[2].toString(), idOeuvre, idExemplaire);
                ((ModelTableau) tableEmpCours.getModel()).removeRow(tableEmpCours.getSelectedRow());
                showMessageSucces("Exemplaire Rendu");
            }
        } catch (BibalExceptions e) {
            System.out.println("IHM.GestionReservationsEmprunts.rendreButtonActionPerformed()");
        }
    }//GEN-LAST:event_rendre

    private void emprunter(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprunter

        String titre = titreLabelValue.getText();
        GestionEmprunts emprunter = new GestionEmprunts(this, true, titre);
        emprunter.setLocationRelativeTo(null);
        emprunter.setVisible(true);
    }//GEN-LAST:event_emprunter

    private void affResaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affResaButtonActionPerformed
        try {
            String identitfiant = identifiantComboBox.getSelectedItem().toString();
            if (!identitfiant.equals("Choix ID")) {
                Oeuvre oeuvre = getOeuvreInfos();
                ArrayList<Reservation> listReservations = ReservationControl.findByReservation(oeuvre);
                if (null != listReservations) {
                    fillResaJtable(listReservations);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Aucune réservation en cours de cette oeuvre trouvée", "Informations",
                            JOptionPane.INFORMATION_MESSAGE);
                    String titre[] = new String[]{"ID", "Exemplaire", "Usager",
                        "Date Emprunt", "Date Retour"};
                    Object data[][] = new Object[1][titre.length];
                    ModelTableau model = new ModelTableau(data, titre);
                    tableResaCours.setModel(model);
                    tableResaCours.setRowHeight(1);
                }
            }

        } catch (BibalExceptions e) {
            System.out.println("IHM.GestionReservationsEmprunts.affEmpButtonActionPerformed()");
        }
    }//GEN-LAST:event_affResaButtonActionPerformed

    private void reserverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserverButtonActionPerformed
        String titre = titreLabelValue.getText();
        GestionReservations reserver = new GestionReservations(this, true, titre);
        reserver.setLocationRelativeTo(null);
        reserver.setVisible(true);
    }//GEN-LAST:event_reserverButtonActionPerformed

    private void annulerResaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerResaButtonActionPerformed
        try {
            int oeuvreId = getOeuvreID();
            if (oeuvreId != -1 && tableResaCours.getSelectedRow() >= 0) {
                int idUsager = parseInt(dataLigneSelectedReservations[2].toString());
                ReservationControl.annuler(idUsager, titreLabelValue.getText());
                ((ModelTableau) tableResaCours.getModel()).removeRow(tableResaCours.getSelectedRow());
                showMessageSucces("Réservation annulée ");
            }

        } catch (BibalExceptions e) {
            System.out.println("IHM.GestionReservationsEmprunts.annulerResaButtonActionPerformed()");
        }
    }//GEN-LAST:event_annulerResaButtonActionPerformed

    private int getOeuvreID() {
        String id = identifiantComboBox.getSelectedItem().toString();
        if (!id.equals("Choisir identifiant")) {
            return parseInt(id);
        }
        return -1;
    }

    private void fillExemplaireJtable(ArrayList<Exemplaire> listExemplaires) {
        String titre[] = new String[]{"ID", "Etat"};
        if (listExemplaires.size() > 0) {
//            pour le findByID si l'objet ajouté est null
            int nbLigne = (null == listExemplaires.get(0)) ? 0 : listExemplaires.size();
            Object data[][] = new Object[nbLigne][titre.length];
            for (int i = 0; i < nbLigne; i++) {
                Exemplaire exemplaire = listExemplaires.get(i);
                data[i][0] = exemplaire.getId();
                data[i][1] = exemplaire.getEtat();
            }
            ModelTableau model = new ModelTableau(data, titre);
            tableExemplaires.setModel(model);
            tableExemplaires.setRowHeight(30);
        } else {
            //afficher tableau vide
            Object data[][] = new Object[1][titre.length];
            ModelTableau model = new ModelTableau(data, titre);
            tableExemplaires.setModel(model);
            tableExemplaires.setRowHeight(1);
        }
    }

    private void fillEmpruntsJtable(ArrayList<Emprunt> listEmprunts) {
        String titre[] = new String[]{"ID", "Exemplaire", "Usager",
            "Date Emprunt", "Date Retour"};
        if (listEmprunts.size() > 0) {
//            pour le findByID si l'objet ajouté est null
            int nbLigne = (null == listEmprunts.get(0)) ? 0 : listEmprunts.size();
            Object data[][] = new Object[nbLigne][titre.length];
            for (int i = 0; i < nbLigne; i++) {
                Emprunt emprunt = listEmprunts.get(i);
                data[i][0] = emprunt.getId();
                data[i][1] = emprunt.getExemplairesEmprunt().getId();
                data[i][2] = emprunt.getUsagerEmprunt().getNom();
                data[i][3] = emprunt.getDateEmprunt();
                data[i][4] = emprunt.getDateRetourPrevu();

            }
            ModelTableau model = new ModelTableau(data, titre);
            tableEmpCours.setModel(model);
            tableEmpCours.setRowHeight(30);
        } else {
            //afficher tableau vide
            Object data[][] = new Object[1][titre.length];
            ModelTableau model = new ModelTableau(data, titre);
            tableEmpCours.setModel(model);
            tableEmpCours.setRowHeight(1);
        }
    }

    private void fillResaJtable(ArrayList<Reservation> listReservations) {
        String titre[] = new String[]{"ID", "Oeuvre", "Usager",
            "Date Réservation"};
        if (listReservations.size() > 0) {
            int nbLigne = (null == listReservations.get(0)) ? 0 : listReservations.size();
            Object data[][] = new Object[nbLigne][titre.length];
            for (int i = 0; i < nbLigne; i++) {
                Reservation reservation = listReservations.get(i);
                data[i][0] = reservation.getId();
                data[i][1] = reservation.getOeuvresReservation().getId();
                data[i][2] = reservation.getUsagerReservation().getId();
                data[i][3] = reservation.getDateReservation();

            }
            ModelTableau model = new ModelTableau(data, titre);
            tableResaCours.setModel(model);
            tableResaCours.setRowHeight(30);
        } else {
            //afficher tableau vide
            Object data[][] = new Object[1][titre.length];
            ModelTableau model = new ModelTableau(data, titre);
            tableResaCours.setModel(model);
            tableResaCours.setRowHeight(1);
        }
    }

    private void setIdentifiant() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            final String SQL_SELECT_ID = "SELECT id FROM oeuvre ";
            preparedStatement = initialiseRequetePreparee(DBConnection.getConnection(),
                    SQL_SELECT_ID, new Object[0]);
            resultSet = preparedStatement.executeQuery();
            int identifiant;
            while (resultSet.next()) {
                identifiant = resultSet.getInt("id");
                identifiantComboBox.addItem(Integer.toString(identifiant));
            }
        } catch (SQLException | BibalExceptions e) {
            showMessageDialog(null, "Erreurs d'accès à la base de données",
                    "Erreurs", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeStatementResultSet(preparedStatement, resultSet);
        }
    }

    private Oeuvre getOeuvreInfos() {
        int id = parseInt(identifiantComboBox.getSelectedItem().toString());
        String titre = titreLabelValue.getText();
        String auteur = auteurLabelValue.getText();
        String categorie = categorieLabelValue.getText();
        String typeOeuvre = typeOeuvreLabelValue.getText();
        Oeuvre oeuvre;
        if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
            oeuvre = new Magazine(id, titre, auteur, categorie);
        } else {
            oeuvre = new Livre(id, titre, auteur, categorie);
        }
        return oeuvre;
    }
    
    private Object dataLigneSelectedExemplaires[];
    private Object dataLigneSelectedEmprunts[];
    private Object dataLigneSelectedReservations[];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EmpruntPanel;
    private javax.swing.JButton ReservationButton;
    private javax.swing.JPanel ReservationPanel;
    private javax.swing.JButton affEmpButton;
    private javax.swing.JButton affExempButton;
    private javax.swing.JButton affResaButton;
    private javax.swing.JButton annulerResaButton;
    private javax.swing.JLabel auteurLabel1;
    private javax.swing.JLabel auteurLabelValue;
    private javax.swing.JLabel categorieLabel1;
    private javax.swing.JLabel categorieLabelValue;
    private javax.swing.JButton emprunterButton;
    private javax.swing.JButton empruntsButton;
    private javax.swing.JComboBox<String> identifiantComboBox;
    private javax.swing.JLabel identifiantLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuEmpPanel;
    private javax.swing.JPanel menuResaPanel;
    private javax.swing.JLabel nbExemplaire1;
    private javax.swing.JLabel nbExemplaireLabelValue;
    private javax.swing.JPanel panEmpCours;
    private javax.swing.JPanel panExemplaires;
    private javax.swing.JPanel panResaCours;
    private javax.swing.JButton rendreButton;
    private javax.swing.JButton reserverButton;
    private javax.swing.JButton retourButton;
    public static javax.swing.JTable tableEmpCours;
    public static javax.swing.JTable tableExemplaires;
    public static javax.swing.JTable tableResaCours;
    private javax.swing.JLabel titleResaEmpLabel;
    private javax.swing.JLabel titreLabel1;
    private javax.swing.JLabel titreLabelValue;
    private javax.swing.JLabel typeOeuvreLabel1;
    private javax.swing.JLabel typeOeuvreLabelValue;
    // End of variables declaration//GEN-END:variables
}
