/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektas.gui;

import Competitors.YoungerCompetitor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.text.ParseException;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.RadioButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.xml.ws.handler.Handler;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author manant1
 */
public class ResultsForm extends javax.swing.JFrame implements ActionListener{

    private DataAddForm dataAddForm;
    private JFileChooser chooser;
    private final  int maxGroups = 10;
    //"Vyrai", "Moterys", "Jauniai", "Jaunės", "Jaunučiai", "Jaunutės", "Berniukai", "Mergaitės" "Vaikai berniukai", "Vaikai mergaitės"
    private  Group[] ageGroups = new Group[maxGroups];
    private  ArrayList<YoungerCompetitor> Competitors = new ArrayList<YoungerCompetitor>();
    
    private Date now = new Date();
    
    private  final String[] groupNames = {"Vyrai", "Moterys", "Jauniai", "Jaunės", "Jaunučiai", "Jaunutės", "Berniukai", "Mergaitės", "Vaikai berniukai", "Vaikai mergaitės"};
    private final String[] eventNamesMen = {"Bėgimas 60m", "Bėgimas 1500m", "Spaudimas", "Traukimas", "Presas", "Prisitraukimai"};
    private final String[] eventNamesWomen = {"Bėgimas 60m", "Bėgimas 800m", "Spaudimas", "Traukimas", "Presas", "Prisitraukimai"};
    private final String[] eventNamesMenJunior = {"Bėgimas 60m", "Bėgimas 1500m", "Spaudimas", "Traukimas", "Presas", "Prisitraukimai"};
    private final String[] eventNamesWomenJunior = {"Bėgimas 60m", "Bėgimas 800m", "Spaudimas", "Traukimas", "Presas", "Atsispaudimai"};
    private final String[] eventNamesMenYoung = {"Bėgimas 60m", "Bėgimas 800m", "Spaudimas", "Traukimas", "Presas", "Prisitraukimai"};
    private final String[] eventNamesWomenYoung = {"Bėgimas 60m", "Bėgimas 400m", "Spaudimas", "Traukimas", "Presas", "Atsispaudimai"};
    private final String[] eventNamesMenChildren = {"Bėgimas 30m", "Bėgimas 400m", "Spaudimas", "Traukimas", "Presas", "Atsispaudimai"};
    private final String[] eventNamesWomenChildren = {"Bėgimas 30m", "Bėgimas 400m", "Kabėjimas laikui", "Flamingo testas", "Presas", "Atsispaudimai nuo kelių"};
    private final String[] eventNamesMenKids = {"Bėgimas 30m", "Bėgimas 200m", "Kabėjimas laikui", "Flamingo testas", "Presas", "Šokdynė"};
    private final String[] eventNamesWomenKids = {"Bėgimas 30m", "Bėgimas 200m", "Kabėjimas laikui", "Flamingo testas", "Presas", "Šokdynė"};
    
    
    private final String[] menHeading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "1500m", "T.", "Sp. 40kg-2'", "T.", "Tr. 40kg-2'", "T.", "P-1", "T.", "Pris.", "T.", "Suma"}; 
    private final String[] womenHeading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "800m", "T.", "Sp. 30kg-2'", "T.", "Tr. 30kg-2'", "T.", "P-1'", "T.", "Pris.", "T.", "Suma"};
    private final String[] juniorMenHeading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "1500m", "T.", "Sp. 30kg-2'", "T.", "Tr. 30kg-2'", "T.", "P-1'", "T.", "Pris.", "T.", "Suma"};
    private final String[] juniorWomenHeading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "800m", "T.", "Sp. 25kg-1'", "T.", "Tr. 25kg-1'", "T.", "P-1'", "T.", "Atsisp.", "T.", "Suma"};
    private final String[] youngMenHeading = {"ID", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "Bėgimas 60m", "T.", "Bėgimas 800m", "T.", "Spaudimas", "T.", "Traukimas", "T.", "Presas", "T.", "Prisitraukimai", "T.", "Suma"};
    private final String[] youngWomenHeading = {"ID", "Vt.", "Vardas, Pavardė", "Metai" ,"Miestas", "T." ,"Treneris", "T.", "Bėgimas 60m", "T.", "Bėgimas 400m", "T.", "Spaudimas", "T.", "Traukimas", "T.", "Presas", "T.", "Atsispaudimai", "T.", "Suma"};
    private final String[] childrenMenHeading = {"ID", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "Bėgimas 30m", "T.", "Bėgimas 400m", "T.", "Spaudimas", "T.", "Traukimas", "T.", "Presas", "T.", "Atsispaudimai", "T.", "Suma"};
    private final String[] childrenWomenHeading = {"ID", "Vt.", "Vardas, Pavardė", "Miestas", "Metai", "Treneris", "Bėgimas 30m", "T.", "Bėgimas 400m", "T.", "Presas", "T.", "Atsisp. nuo k.", "T.", "Flamingo t.", "T.", "Kabėjimas", "T.", "Suma"};
    private final String[] kidsMenHeading = {"ID", "Vardas, Pavardė", "Miestas", "Treneris", "Bėgimas 30m", "Bėgimas 200m", "Presas", "Šokdynė", "Flamingo t.", "Kabėjimas", "Taškai", "Vieta"};
    private final String[] kidsWomenHeading = {"ID", "Vt.", "Vardas, Pavardė", "Miestas", "Metai", "Treneris", "Bėgimas 30m", "T.", "Bėgimas 400m", "T.", "Presas", "T.", "Šokdynė", "T.", "Flamingo t.", "T.", "Kabėjimas", "T.", "Suma"};

    
    private  final File fileMen = new File("Duomenys/Vyrai.txt");
    private  final File fileWomen = new File("Duomenys/Moterys.txt");
    private  final File fileMenJunior = new File("Duomenys/Jauniai.txt");
    private  final File fileWomenJunior = new File("Duomenys/Jaunės.txt");
    private  final File fileMenYoung = new File("Duomenys/Jaunučiai.txt");
    private  final File fileWomenYoung = new File("Duomenys/Juanutės.txt");
    private  final File fileMenKids = new File("Duomenys/VaikaiBerniukai.txt");
    private  final File fileWomenKids = new File("Duomenys/VaikaiMergaitės.txt");
    private  final File fileMenChildren = new File("Duomenys/Berniukai.txt");
    private  final File fileWomenChildren = new File("Duomenys/Mergaitės.txt");
    private YoungerCompetitor competitorToAdd;
    private JTextField coachField;
    private JTextField cityField;
    private JTextField yearsField;
    private JTextField surnameField;
    private JTextField idField;
    private JTextField nameField;
    private JRadioButton menRadBtn;
    private JRadioButton womenRadBtn;
    private YoungerCompetitor competitorToChange;
    private JFrame frameEdit;
    private JButton buttonEdit;
    private JFrame frameTableDisplay;
    private JPanel jPanel;
    
    /**
     * Creates new form ResultsForm
     */
    public ResultsForm() {
        initComponents();
        setResult.setEnabled(false);
        resultTextField.setEnabled(false);
        IDtextField.setEnabled(false);
        testiBtn.setEnabled(false);
        jButton6.setEnabled(false);
        grupesList.setModel(new javax.swing.DefaultComboBoxModel<>(groupNames));
        groupResultsList.setModel(new javax.swing.DefaultComboBoxModel<>(groupNames));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        grupesList = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        rungtisList = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        groupResultsList = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        competitorInfoText1 = new javax.swing.JTextArea();
        setGroopBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        resultsBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        IDtextField = new javax.swing.JTextField();
        setResult = new javax.swing.JButton();
        competitorInfo = new javax.swing.JLabel();
        resultTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        testiBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        enteredInfoTf = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        setEventBtn = new javax.swing.JButton();
        addCompetitorBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lastEnteredTf = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BFP v1.01");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1024, 728));
        setSize(new java.awt.Dimension(1350, 800));

        grupesList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        grupesList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                grupesListItemStateChanged(evt);
            }
        });

        jLabel1.setText("Grupės");

        rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rungtisList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rungtisListItemStateChanged(evt);
            }
        });

        jLabel2.setText("Rungtys");

        groupResultsList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        competitorInfoText1.setEditable(false);
        competitorInfoText1.setColumns(20);
        competitorInfoText1.setRows(5);
        jScrollPane2.setViewportView(competitorInfoText1);

        setGroopBtn.setText("Išvesti");
        setGroopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setGroopBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Įkelti dalyvius");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Išsaugoti");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pašalinti dalyvį");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Spausdinti");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        resultsBtn.setText("Skaičiuoti rezultatus");
        resultsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsBtnActionPerformed(evt);
            }
        });

        IDtextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IDtextFieldFocusLost(evt);
            }
        });
        IDtextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtextFieldActionPerformed(evt);
            }
        });
        IDtextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                IDtextFieldPropertyChange(evt);
            }
        });
        IDtextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDtextFieldKeyTyped(evt);
            }
        });

        setResult.setText("Pateikti");
        setResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setResultActionPerformed(evt);
            }
        });
        setResult.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setResultKeyReleased(evt);
            }
        });

        competitorInfo.setText("Dalyvio informacija");

        resultTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                resultTextFieldFocusLost(evt);
            }
        });
        resultTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Rezultatas");

        jLabel5.setText("ID");

        testiBtn.setText("Tęsti");
        testiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testiBtnActionPerformed(evt);
            }
        });

        enteredInfoTf.setEditable(false);
        enteredInfoTf.setColumns(20);
        enteredInfoTf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        enteredInfoTf.setRows(5);
        jScrollPane3.setViewportView(enteredInfoTf);

        jLabel7.setText("Paskutinis įvestas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(competitorInfo)
                        .addGap(263, 263, 263)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(IDtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(setResult, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(testiBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(295, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(testiBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(competitorInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(setResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(resultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IDtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)))
        );

        setEventBtn.setText("Pasirinkti");
        setEventBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setEventBtnActionPerformed(evt);
            }
        });

        addCompetitorBtn.setText("Pridėti dalyvį");
        addCompetitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompetitorBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Išvesti vienos grupės dalyvius");

        lastEnteredTf.setEditable(false);
        lastEnteredTf.setColumns(20);
        lastEnteredTf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lastEnteredTf.setRows(5);
        jScrollPane1.setViewportView(lastEnteredTf);

        jButton5.setText("Peržiūrėti");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Peržiūrėti dabartinę grupę");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("Keisti dalyvio informaciją");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(resultsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(grupesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(setEventBtn)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rungtisList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addCompetitorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))))
                    .addComponent(jLabel6))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(groupResultsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setGroopBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grupesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rungtisList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(setEventBtn)
                    .addComponent(jButton5)
                    .addComponent(addCompetitorBtn))
                .addGap(4, 4, 4)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupResultsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setGroopBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void testiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testiBtnActionPerformed
        setResult.setEnabled(true);
        resultTextField.setEnabled(true);
        IDtextField.setEnabled(true);
    }//GEN-LAST:event_testiBtnActionPerformed

    private void IDtextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtextFieldActionPerformed
        
        
    }//GEN-LAST:event_IDtextFieldActionPerformed

    private void IDtextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDtextFieldKeyTyped
        
    }//GEN-LAST:event_IDtextFieldKeyTyped

    private void resultTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultTextFieldActionPerformed
        
    }//GEN-LAST:event_resultTextFieldActionPerformed

    private void IDtextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_IDtextFieldPropertyChange
        
    }//GEN-LAST:event_IDtextFieldPropertyChange

    private void IDtextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDtextFieldFocusLost
        char[] charArray = IDtextField.getText().toCharArray();
        if(charArray.length != 0)
        {
            for(char c: charArray)
            {
                if(!Character.isDigit(c))
                {
                    IDtextField.setText("");
                    resultTextField.setText("");
                    enteredInfoTf.setText("");
                    JOptionPane.showMessageDialog(this, "Blogai įvestas ID");
                    return;
                }
            }
            YoungerCompetitor competitor = findByID(grupesList.getSelectedItem().toString() , Integer.parseInt(IDtextField.getText()));
            Group group = getGroupFromList();
            if(competitor != null)
            {
                if(isRightGroup(group, competitor))
                {
                    enteredInfoTf.setText("Rungtis " + rungtisList.getSelectedItem().toString() + "\n" +
                            "Dalyvis nr: " + competitor.getID() + " " + competitor.getFullName());
                }
                else
                {
                    IDtextField.setText("");
                    resultTextField.setText("");
                    JOptionPane.showMessageDialog(this, "Dalyvis ne tos grupės");
                }
            }
            else
            {
                IDtextField.setText("");
                resultTextField.setText("");
                JOptionPane.showMessageDialog(this, "Nėra tokio dalyvio ID");
            }
        }
    }//GEN-LAST:event_IDtextFieldFocusLost

    private Group getGroupFromList()
    {
        String groupString = grupesList.getSelectedItem().toString();
        Group group = null;
        switch(groupString)
        {
            case "Vyrai":
                group = ageGroups[0];
                break;
            case "Moterys":
                group = ageGroups[1];
                break;
            case "Jauniai":
                group = ageGroups[2];
                break;
            case "Jaunės":
                group = ageGroups[3];
                break;
            case "Jaunučiai":
                group = ageGroups[4];
                break;
            case "Jaunutės":
                group = ageGroups[5];
                break;
            case "Berniukai":
                group = ageGroups[6];
                break;
            case "Mergaitės":
                group = ageGroups[7];
                break;
            case "Vaikai berniukai":
                group = ageGroups[8];
                break;
            case "Vaikai mergaitės":
                group = ageGroups[9];
                break;
        }
        return group;
    }
    
    private boolean isRightGroup(Group ageGroup, YoungerCompetitor c)
    {
        if(ageGroup.getGroupList().contains(c))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void resultTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_resultTextFieldFocusLost
       
    }//GEN-LAST:event_resultTextFieldFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Informacija bus prarasta. Tęsti?");
        if(dialogResult == JOptionPane.YES_OPTION)
        {
            dataAddForm = new DataAddForm();
            dataAddForm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setResultActionPerformed
        if(checkResultsField())
        {
            String result = resultTextField.getText();
            if(IDtextField.getText().length() == 0)
            {
                JOptionPane.showMessageDialog(this, "Neįvestas rezultatas arba ID");
            }
            else
            {
                switch(grupesList.getSelectedItem().toString())
                {
                    case "Vyrai":
                        setResultOlder(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Moterys":
                        setResultOlder(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Jauniai":
                        setResultOlder(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Jaunės":
                        setResultOlder(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Jaunučiai":
                        setResultOlder(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Jaunutės":
                        setResultOlder(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Berniukai":
                        setResultOlder(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Mergaitės":
                        setResultYounger(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Vaikai berniukai":
                        setResultYounger(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                    case "Vaikai mergaitės":
                        setResultYounger(rungtisList.getSelectedItem().toString(), result, Integer.parseInt(IDtextField.getText()));
                        break;
                }
                YoungerCompetitor competitor = findByID(Integer.parseInt(IDtextField.getText()));
                lastEnteredTf.setText("Rungtis " + rungtisList.getSelectedItem().toString() + "\n" +
                            "Dalyvis nr: " + competitor.getID() + " " + competitor.getFullName() + " " + resultTextField.getText());
                resultTextField.setText("");
                IDtextField.setText("");
                resultTextField.setText("");
                enteredInfoTf.setText("");
                IDtextField.requestFocusInWindow();
                makeAgeGroups(ageGroups);
                
            }
        }
    }//GEN-LAST:event_setResultActionPerformed

    private boolean checkResultsField()
    {
        boolean isCorrect = false;
        String eventName = rungtisList.getSelectedItem().toString();
        if(eventName.isEmpty())
        {
            isCorrect = true;
        }
        else if(eventName.equals("Bėgimas 1500m") || eventName.equals("Bėgimas 800m") || eventName.equals("Bėgimas 400m") ||
                eventName.equals("Bėgimas 200m") || eventName.equals("Kabėjimas laikui"))
        {
            isCorrect = checkResultsLongRun(resultTextField.getText());
        }
        else if(eventName.equals("Bėgimas 30m") || eventName.equals("Bėgimas 60m"))
        {
            isCorrect = checkResultsSprint(resultTextField.getText());
        }
        else
        {
            isCorrect = checkMoreCount(resultTextField.getText());
        }
        return isCorrect;
    }
    
    private void setGroopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setGroopBtnActionPerformed
        String group = groupResultsList.getSelectedItem().toString();
        makeAgeGroups(ageGroups);
        switch(group)
        {
            case "Vyrai":
                System.out.println("Vyr");
                printResultsToTF(ageGroups[0]);
                break;
            case "Moterys":
                System.out.println("Mot");
                printResultsToTF(ageGroups[1]);
                break;
            case "Jauniai":
                System.out.println("Jaun");
                printResultsToTF(ageGroups[2]);
                break;
            case "Jaunės":
                System.out.println("jaunes");
                printResultsToTF(ageGroups[3]);
                break;
            case "Jaunučiai":
                System.out.println("jaunuc");
                printResultsToTF(ageGroups[4]);
                break;
            case "Jaunutės":
                System.out.println("jaunuts");
                printResultsToTF(ageGroups[5]);
                break;
            case "Berniukai":
                System.out.println("bern");
                printResultsToTF(ageGroups[6]);
                break;
            case "Mergaitės":
                System.out.println("merg");
                printResultsToTF(ageGroups[7]);
                break;
            case "Vaikai berniukai":
                System.out.println("vaik v");
                printResultsToTF(ageGroups[8]);
                break;
            case "Vaikai mergaitės":
                System.out.println("vaik m");
                printResultsToTF(ageGroups[9]);
                break;
        }
    }//GEN-LAST:event_setGroopBtnActionPerformed

    private void setEventBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setEventBtnActionPerformed
        testiBtn.setEnabled(true);
        rungtisList.setEnabled(true);
        jButton6.setEnabled(true);
        makeAgeGroups(ageGroups);
        String group = grupesList.getSelectedItem().toString();
        switch(group)
        {
            case "Vyrai":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesMen));
                break;
            case "Moterys":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesWomen));
                break;
            case "Jauniai":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesMenJunior));
                break;
            case "Jaunės":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesWomenJunior));
                break;
            case "Jaunučiai":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesMenYoung));
                break;
            case "Jaunutės":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesWomenYoung));
                break;
            case "Berniukai":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesMenChildren));
                break;
            case "Mergaitės":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesWomenChildren));
                break;
            case "Vaikai berniukai":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesMenKids));
                break;
            case "Vaikai mergaitės":
                rungtisList.setModel(new javax.swing.DefaultComboBoxModel<>(eventNamesWomenKids));
                break;
        }
    }//GEN-LAST:event_setEventBtnActionPerformed

    private void setResultKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setResultKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            System.out.println("Hello");
            setResult.doClick();
            IDtextField.requestFocusInWindow();
        }
    }//GEN-LAST:event_setResultKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String test1= JOptionPane.showInputDialog("Įrašykite šalinamo dalyvio ID: ");

            int int1 = Integer.parseInt(test1);
            
            YoungerCompetitor competitor = findByID(int1);
            if(competitor != null)
            {
                Competitors.remove(competitor);
                makeAgeGroups(ageGroups);
                JOptionPane.showMessageDialog(this, "Dalyvis pašalintas");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tokio dalyvio nėra");
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        chooser = new JFileChooser(); 
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Save to");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            chooser.setAcceptAllFileFilterUsed(false);    
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
            { 
                
                saveToFile(chooser.getSelectedFile().getAbsolutePath());
            }
            else 
            {
                System.out.println("No Selection ");
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            String input = (String)JOptionPane.showInputDialog(null, "Pasirinkti spausdinimui", "Print",
            JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Vyrai", "Moterys", "Jauniai", "Jaunės", 
                "Jaunučiai", "Jaunutės", "Berniukai", "Mergaitės", 
                "Vaikai berniukai", "Vaikai mergaitės"}, "Vyrai");
          
            makeAgeGroups(ageGroups);
            
            switch(input)
            {
                case "Vyrai":
                    printTableMen();
                    break;
                case "Moterys":
                    printTableWomen();
                    break;
                case "Jauniai":
                    printTableMenJun();
                    break;
                case "Jaunės":
                    printTableWomenJun();
                    break;
                case "Jaunučiai":
                    printTableMenYoung();
                    break;
                case "Jaunutės":
                    printTableWomenYoung();
                    break;
                case "Berniukai":
                    printTableMenChild();
                    break;
                case "Mergaitės":
                    printTableWomenChild();
                    break;
                case "Vaikai berniukai":
                    printTableMenKids();
                    break;
                case "Vaikai mergaitės":
                    printTableWomenKids();
                    break;
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void resultsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsBtnActionPerformed
        makeAgeGroups(ageGroups);
        String input = (String)JOptionPane.showInputDialog(null, "Pasirinkti skaičiavimui", "Rez",
            JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Vyrai", "Moterys", "Jauniai", "Jaunės", 
                "Jaunučiai", "Jaunutės", "Berniukai", "Mergaitės", 
                "Vaikai berniukai", "Vaikai mergaitės"}, "Vyrai");
        if(input != null)
        switch(input)
        {
            case "Vyrai":
                if(ageGroups[0].getGroupList().size() > 0)
                {
                    ageGroups[0].clearScores();
                    ageGroups[0].clearPlaces();
                    ageGroups[0].calculateSprint();
                    ageGroups[0].calculateLongRun();
                    ageGroups[0].calculateMoreCount(YoungerCompetitor.sortBenchPress, 1);
                    ageGroups[0].calculateMoreCount(YoungerCompetitor.sortBenchPull, 2);
                    ageGroups[0].calculateMoreCount(YoungerCompetitor.sortCore, 3);
                    ageGroups[0].calculateMoreCount(YoungerCompetitor.sortPullUps, 4);
                    ageGroups[0].setPlaces();
                }
                break;
            case "Moterys":
                if(ageGroups[1].getGroupList().size() > 0)
                {
                    ageGroups[1].clearScores();
                    ageGroups[1].clearPlaces();
                    ageGroups[1].calculateSprint();
                    ageGroups[1].calculateLongRun();
                    ageGroups[1].calculateMoreCount(YoungerCompetitor.sortBenchPress, 1);
                    ageGroups[1].calculateMoreCount(YoungerCompetitor.sortBenchPull, 2);
                    ageGroups[1].calculateMoreCount(YoungerCompetitor.sortCore, 3);
                    ageGroups[1].calculateMoreCount(YoungerCompetitor.sortPullUps, 4);
                    ageGroups[1].setPlaces();
                }
                break;
            case "Jauniai":
                if(ageGroups[2].getGroupList().size() > 0)
                {
                    ageGroups[2].clearScores();
                    ageGroups[2].clearPlaces();
                    ageGroups[2].calculateSprint();
                    ageGroups[2].calculateLongRun();
                    ageGroups[2].calculateMoreCount(YoungerCompetitor.sortBenchPress, 1);
                    ageGroups[2].calculateMoreCount(YoungerCompetitor.sortBenchPull, 2);
                    ageGroups[2].calculateMoreCount(YoungerCompetitor.sortCore, 3);
                    ageGroups[2].calculateMoreCount(YoungerCompetitor.sortPullUps, 4);
                    ageGroups[2].setPlaces();
                }
                break;
            case "Jaunės":
                if(ageGroups[3].getGroupList().size() > 0)
                {
                    ageGroups[3].clearScores();
                    ageGroups[3].clearPlaces();
                    ageGroups[3].calculateSprint();
                    ageGroups[3].calculateLongRun();
                    ageGroups[3].calculateMoreCount(YoungerCompetitor.sortBenchPress, 1);
                    ageGroups[3].calculateMoreCount(YoungerCompetitor.sortBenchPull, 2);
                    ageGroups[3].calculateMoreCount(YoungerCompetitor.sortCore, 3);
                    ageGroups[3].calculateMoreCount(YoungerCompetitor.sortPullUps, 4);
                    ageGroups[3].setPlaces();
                }
                break;
            case "Jaunučiai":
                if(ageGroups[4].getGroupList().size() > 0)
                {
                    ageGroups[4].clearScores();
                    ageGroups[4].clearPlaces();
                    ageGroups[4].calculateSprint();
                    ageGroups[4].calculateLongRun();
                    ageGroups[4].calculateMoreCount(YoungerCompetitor.sortBenchPress, 1);
                    ageGroups[4].calculateMoreCount(YoungerCompetitor.sortBenchPull, 2);
                    ageGroups[4].calculateMoreCount(YoungerCompetitor.sortCore, 3);
                    ageGroups[4].calculateMoreCount(YoungerCompetitor.sortPullUps, 4);
                    ageGroups[4].setPlaces();
                }
                break;
            case "Jaunutės":
                if(ageGroups[5].getGroupList().size() > 0)
                {
                    ageGroups[5].clearScores();
                    ageGroups[5].clearPlaces();
                    ageGroups[5].calculateSprint();
                    ageGroups[5].calculateLongRun();
                    ageGroups[5].calculateMoreCount(YoungerCompetitor.sortBenchPress, 1);
                    ageGroups[5].calculateMoreCount(YoungerCompetitor.sortBenchPull, 2);
                    ageGroups[5].calculateMoreCount(YoungerCompetitor.sortCore, 3);
                    ageGroups[5].calculateMoreCount(YoungerCompetitor.sortPullUps, 4);
                    ageGroups[5].setPlaces();
                }
                break;
            case "Berniukai":
                if(ageGroups[6].getGroupList().size() > 0)
                {
                    ageGroups[6].clearScores();
                    ageGroups[6].clearPlaces();
                    ageGroups[6].calculateSprint();
                    ageGroups[6].calculateLongRun();
                    ageGroups[6].calculateMoreCount(YoungerCompetitor.sortBenchPress, 1);
                    ageGroups[6].calculateMoreCount(YoungerCompetitor.sortBenchPull, 2);
                    ageGroups[6].calculateMoreCount(YoungerCompetitor.sortCore, 3);
                    ageGroups[6].calculateMoreCount(YoungerCompetitor.sortPullUps, 4);
                    ageGroups[6].setPlaces();
                }
                break;
            case "Mergaitės":
                if(ageGroups[7].getGroupList().size() > 0)
                {
                    ageGroups[7].clearScores();
                    ageGroups[7].clearPlaces();
                    ageGroups[7].calculateSprintY();
                    ageGroups[7].calculateLongRunY();
                    ageGroups[7].calculateMoreCountY(YoungerCompetitor.sortCoreY, 1);
                    ageGroups[7].calculateMoreCountY(YoungerCompetitor.sortJockey, 2);
                    ageGroups[7].calculateYLessCount();
                    ageGroups[7].calculateTimeLongest();
                    ageGroups[7].setPlaces();
                }
                break;
            case "Vaikai berniukai":
                if(ageGroups[8].getGroupList().size() > 0)
                {
                    ageGroups[8].clearScores();
                    ageGroups[8].clearPlaces();
                    ageGroups[8].calculateSprintY();
                    ageGroups[8].calculateLongRunY();
                    ageGroups[8].calculateMoreCountY(YoungerCompetitor.sortCoreY, 1);
                    ageGroups[8].calculateMoreCountY(YoungerCompetitor.sortJockey, 2);
                    ageGroups[8].calculateYLessCount();
                    ageGroups[8].calculateTimeLongest();
                    ageGroups[8].setPlaces();
                }
                break;
            case "Vaikai mergaitės":
                if(ageGroups[9].getGroupList().size() > 0)
                {
                    ageGroups[9].clearScores();
                    ageGroups[9].clearPlaces();
                    ageGroups[9].calculateSprintY();
                    ageGroups[9].calculateLongRunY();
                    ageGroups[9].calculateMoreCountY(YoungerCompetitor.sortCoreY, 1);
                    ageGroups[9].calculateMoreCountY(YoungerCompetitor.sortJockey, 2);
                    ageGroups[9].calculateYLessCount();
                    ageGroups[9].calculateTimeLongest();
                    ageGroups[9].setPlaces();
                }
                break;
            
        }
    }//GEN-LAST:event_resultsBtnActionPerformed

    private void addCompetitorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompetitorBtnActionPerformed
        if(Competitors.size() == 0)
        {
            JOptionPane.showMessageDialog(this, "Pirma pridėkite dalyvius iš failo");
        }
        else
        {
            jButton8.setEnabled(false);
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            competitorToAdd = new YoungerCompetitor();

            Label gender = new Label("Lytis V: ");
            menRadBtn = new JRadioButton();
            Label genderW = new Label("M: ");
            womenRadBtn = new JRadioButton();
            panel.add(gender);
            panel.add(menRadBtn);
            panel.add(genderW);
            panel.add(womenRadBtn);
            
            Label idLabel = new Label("ID");
            idField = new JTextField(8);;
            panel.add(idLabel);
            panel.add(idField);

            Label name = new Label("Vardas");
            nameField = new JTextField(13);
            panel.add(name);
            panel.add(nameField);

            Label surname = new Label("Pavardė");
            surnameField = new JTextField(13);
            panel.add(surname);
            panel.add(surnameField);

            Label years = new Label("Gim. metai");
            yearsField = new JTextField(8);
            panel.add(years);
            panel.add(yearsField);
        
            Label city = new Label("Miestas");
            cityField = new JTextField(12);
            panel.add(city);
            panel.add(cityField);

            Label coach = new Label("Treneris");
            coachField = new JTextField(12);;
            panel.add(coach);
            panel.add(coachField);
            
            String[] results = new String[6];
            for(int i=0;i<6;i++)
            {
                results[i] = "";
            }
        
            buttonEdit = new JButton("Pridėti dalyvi");
            buttonEdit.addActionListener(this);
            panel.add(buttonEdit);

            frame.add(panel);
            frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }//GEN-LAST:event_addCompetitorBtnActionPerformed

    private void grupesListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_grupesListItemStateChanged
        testiBtn.setEnabled(false);
        jButton6.setEnabled(false);
        IDtextField.setEnabled(false);
        resultTextField.setEnabled(false);
        setResult.setEnabled(false);
        rungtisList.setEnabled(false);
    }//GEN-LAST:event_grupesListItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try
        {
            String input = (String)JOptionPane.showInputDialog(null, "Pasirinkti peržiūrai", "Peržiūra",
            JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Vyrai", "Moterys", "Jauniai", "Jaunės", 
                "Jaunučiai", "Jaunutės", "Berniukai", "Mergaitės", 
                "Vaikai berniukai", "Vaikai mergaitės"}, "Vyrai");
          
            makeAgeGroups(ageGroups);
            
            switch(input)
            {
                case "Vyrai":
                    showTable(ageGroups[0], menHeading);
                    break;
                case "Moterys":
                    showTable(ageGroups[1], womenHeading);
                    break;
                case "Jauniai":
                    showTable(ageGroups[2], juniorMenHeading);
                    break;
                case "Jaunės":
                    showTable(ageGroups[3], juniorWomenHeading);
                    break;
                case "Jaunučiai":
                    showTable(ageGroups[4], youngMenHeading);
                    break;
                case "Jaunutės":
                    showTable(ageGroups[5], youngWomenHeading);
                    break;
                case "Berniukai":
                    showTable(ageGroups[6], childrenMenHeading);
                    break;
                case "Mergaitės":
                    showTable(ageGroups[7], childrenWomenHeading);
                    break;
                case "Vaikai berniukai":
                    showTable(ageGroups[8], kidsMenHeading);
                    break;
                case "Vaikai mergaitės":
                    showTable(ageGroups[9], kidsWomenHeading);
                    break;
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try
        {
            String group = grupesList.getSelectedItem().toString();
            switch(group)
            {
                case "Vyrai":
                    showTable(ageGroups[0], menHeading);
                    break;
                case "Moterys":
                    showTable(ageGroups[1], womenHeading);
                    break;
                case "Jauniai":
                    showTable(ageGroups[2], juniorMenHeading);
                    break;
                case "Jaunės":
                    showTable(ageGroups[3], juniorWomenHeading);
                    break;
                case "Jaunučiai":
                    showTable(ageGroups[4], youngMenHeading);
                    break;
                case "Jaunutės":
                    showTable(ageGroups[5], youngWomenHeading);
                    break;
                case "Berniukai":
                    showTable(ageGroups[6], childrenMenHeading);
                    break;
                case "Mergaitės":
                    showTable(ageGroups[7], childrenWomenHeading);
                    break;
                case "Vaikai berniukai":
                    showTable(ageGroups[8], kidsMenHeading);
                    break;
                case "Vaikai mergaitės":
                    showTable(ageGroups[9], kidsWomenHeading);
                    break;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Klaida!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rungtisListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rungtisListItemStateChanged
        autoSaveToFile();
    }//GEN-LAST:event_rungtisListItemStateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(Competitors.size() > 0)
        try
        {
            addCompetitorBtn.setEnabled(false);
            int ID = Integer.parseInt(JOptionPane.showInputDialog("Įveskite dalyvio ID"));
            competitorToChange = findByID(ID);
            competitorToAdd = findByID(ID);
            frameEdit = new JFrame();
            JPanel panel = new JPanel();
            
            Label idLabel = new Label("ID");
            idField = new JTextField(Integer.toString(competitorToAdd.getID()));
            panel.add(idLabel);
            panel.add(idField);

            Label name = new Label("Vardas");
            nameField = new JTextField(competitorToAdd.getName());
            panel.add(name);
            panel.add(nameField);

            Label surname = new Label("Pavardė");
            surnameField = new JTextField(competitorToAdd.getLastName());
            panel.add(surname);
            panel.add(surnameField);

            Label years = new Label("Gim. metai");
            yearsField = new JTextField(Integer.toString(competitorToAdd.getYears()));
            panel.add(years);
            panel.add(yearsField);
        
            Label city = new Label("Miestas");
            cityField = new JTextField(competitorToAdd.getCity());
            panel.add(city);
            panel.add(cityField);

            Label coach = new Label("Treneris");
            coachField = new JTextField(competitorToAdd.getCoach());
            panel.add(coach);
            panel.add(coachField);
        
            buttonEdit = new JButton("Keisti informaciją");
            buttonEdit.addActionListener(this);
            panel.add(buttonEdit);
            panel.setSize(1100, 200);

            frameEdit.add(panel);
            frameEdit.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            frameEdit.pack();
            frameEdit.setVisible(true);
            
        }
        catch(Exception ex)
        {
            addCompetitorBtn.setEnabled(true);
            if(frameEdit != null)
            {
                frameEdit.dispose();
            }
            JOptionPane.showMessageDialog(this, "Nėra tokio ID");
        }
    }//GEN-LAST:event_jButton8ActionPerformed
    
    private void showTable(Group group, String[] heading)
    {
        try
        {
                frameTableDisplay = new JFrame();
                jPanel = new JPanel();
                String[][] data = fillTable(group.getGroupList());
                JXTable table = new JXTable(data, heading);       
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table.packAll();table.setShowGrid(true);
                table.setName("Jauniai");
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.add(table);

                jPanel.add(new JScrollPane(table));
                frameTableDisplay.add(jPanel);
                frameTableDisplay.pack();
                frameTableDisplay.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                frameTableDisplay.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Klaida!");
        }
    }
    
    private void showCalculatedResults(Group ageGroup)
    {
        JTextArea textArea = new JTextArea("");
        for(YoungerCompetitor c: ageGroup.getGroupList())
        {
            textArea.append(c.toString() + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(textArea);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
        JOptionPane.showMessageDialog(null, scrollPane, "Rezultatai grupės " + ageGroup.getGroup(),  
                                               JOptionPane.OK_OPTION);
    }
    
    private void editTable(JTable table)
    {
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(110);
        table.getColumnModel().getColumn(5).setPreferredWidth(65);
        table.getColumnModel().getColumn(6).setPreferredWidth(40);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(40);
        table.getColumnModel().getColumn(9).setPreferredWidth(55);
        table.getColumnModel().getColumn(10).setPreferredWidth(40);
        table.getColumnModel().getColumn(11).setPreferredWidth(55);
        table.getColumnModel().getColumn(6).setPreferredWidth(40);
        table.getColumnModel().getColumn(7).setPreferredWidth(55);
        table.getColumnModel().getColumn(8).setPreferredWidth(40);
        table.getColumnModel().getColumn(9).setPreferredWidth(55);
        table.getColumnModel().getColumn(10).setPreferredWidth(40);
        table.getColumnModel().getColumn(11).setPreferredWidth(30);
        table.doLayout();
    }
    
    private void printTableMen()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "1500m", "T.", "Sp. 40kg-2'", "T.", "Tr. 40kg-2'", "T.", "P-1", "T.", "Pris.", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[0].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setName("Vyrai");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Vyrai"  + "(" + ageGroups[0].getEndYear() + " ir vyresni" + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    private void printTableWomen()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "800m", "T.", "Sp. 30kg-2'", "T.", "Tr. 30kg-2'", "T.", "P-1'", "T.", "Pris.", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[1].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Moterys");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Moterys " + "(" + ageGroups[1].getEndYear() + " ir vyresnės" + ")");
            
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    private void printTableMenJun()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "1500m", "T.", "Sp. 30kg-2'", "T.", "Tr. 30kg-2'", "T.", "P-1'", "T.", "Pris.", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[2].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Jauniai");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Jauniai (" + ageGroups[2].getStartingYear() + "-" + ageGroups[2].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private void printTableWomenJun()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"Nr.", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "60m", "T.", "800m", "T.", "Sp. 25kg-1'", "T.", "Tr. 25kg-1'", "T.", "P-1'", "T.", "Atsisp.", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[3].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Jaunės");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Jaunės (" + ageGroups[3].getStartingYear() + "-" + ageGroups[3].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private void printTableMenYoung()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"ID", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "Bėgimas 60m", "T.", "Bėgimas 800m", "T.", "Spaudimas", "T.", "Traukimas", "T.", "Presas", "T.", "Prisitraukimai", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[4].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Jaunučiai");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Jaunučiai (" + ageGroups[4].getStartingYear() + "-" + ageGroups[4].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private void printTableWomenYoung()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"ID", "Vt.", "Vardas, Pavardė", "Metai" ,"Miestas", "T." ,"Treneris", "T.", "Bėgimas 60m", "T.", "Bėgimas 400m", "T.", "Spaudimas", "T.", "Traukimas", "T.", "Presas", "T.", "Atsispaudimai", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[5].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Jaunutės");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Jaunutės (" + ageGroups[5].getStartingYear() + "-" + ageGroups[5].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private void printTableMenChild()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"ID", "Vt.", "Vardas, Pavardė", "Metai", "Miestas", "Treneris", "Bėgimas 30m", "T.", "Bėgimas 400m", "T.", "Spaudimas", "T.", "Traukimas", "T.", "Presas", "T.", "Atsispaudimai", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[6].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Berniukai");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Berniukai (" + ageGroups[6].getStartingYear() + "-" + ageGroups[6].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private void printTableWomenChild()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"ID", "Vt.", "Vardas, Pavardė", "Miestas", "Metai", "Treneris", "Bėgimas 30m", "T.", "Bėgimas 400m", "T.", "Presas", "T.", "Atsisp. nuo k.", "T.", "Flamingo t.", "T.", "Kabėjimas", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[7].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Mergaitės");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Mergaitės (" + ageGroups[7].getStartingYear() + "-" + ageGroups[7].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private void printTableMenKids()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"ID", "Vardas, Pavardė", "Miestas", "Treneris", "Bėgimas 30m", "Bėgimas 200m", "Presas", "Šokdynė", "Flamingo t.", "Kabėjimas", "Taškai", "Vieta"};
        String[][] data = fillTable(ageGroups[8].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Vaikai berniukai");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Vaikai berniukai (" + ageGroups[7].getStartingYear() + "-" + ageGroups[7].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private void printTableWomenKids()
    {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
        String[] heading = {"ID", "Vt.", "Vardas, Pavardė", "Miestas", "Metai", "Treneris", "Bėgimas 30m", "T.", "Bėgimas 400m", "T.", "Presas", "T.", "Šokdynė", "T.", "Flamingo t.", "T.", "Kabėjimas", "T.", "Suma"};
        String[][] data = fillTable(ageGroups[9].getGroupList());
        JXTable table = new JXTable(data, heading);       
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.packAll();table.setShowGrid(true);
        table.setName("Vaikai mergaitės");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(table);
                    
        jPanel.add(new JScrollPane(table));
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(false);
        try 
        {
            MessageFormat headerFormat = new MessageFormat("Vaikai mergaitės (" + ageGroups[9].getStartingYear() + "-" + ageGroups[9].getEndYear() + ")");
            table.print(JXTable.PrintMode.FIT_WIDTH, headerFormat, null);
        }
        catch (PrinterException pe) 
        {
            JOptionPane.showMessageDialog(this, "Klaida spausdinant rezultatus (" + pe.getMessage() + ")");
        }
        frame.dispose();
    }
    
    private  String[][] fillTable(ArrayList<YoungerCompetitor> competitorsList)
    {
        competitorsList.sort(YoungerCompetitor.sortByScore);
        String[][] data = new String[competitorsList.size()][19];
        for(int i=0;i<competitorsList.size();i++)
        {
            String[] results = competitorsList.get(i).getResultsString();
            data[i][0] = Integer.toString(competitorsList.get(i).getID());
            data[i][1] = Integer.toString(competitorsList.get(i).getPlace());
            data[i][2] = competitorsList.get(i).getFullName();
            data[i][3] = Integer.toString(competitorsList.get(i).getYears());
            data[i][4] = competitorsList.get(i).getCity();
            data[i][5] = competitorsList.get(i).getCoach();
            
            data[i][6] = results[0];
            data[i][7] = competitorsList.get(i).getEventsScores()[0];
            data[i][8] = results[1];
            data[i][9] = competitorsList.get(i).getEventsScores()[1];
            data[i][10] = results[2];
            data[i][11] = competitorsList.get(i).getEventsScores()[2];
            data[i][12] = results[3];
            data[i][13] = competitorsList.get(i).getEventsScores()[3];
            data[i][14] = results[4];
            data[i][15] = competitorsList.get(i).getEventsScores()[4];
            data[i][16] = results[5];
            data[i][17] = competitorsList.get(i).getEventsScores()[5];
            data[i][18] = Double.toString(competitorsList.get(i).getScore());
        }
        return data;
    }
    
    public void autoSave()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        autoSaveToFile();
    }
    
    private void autoSaveToFile()
    {
        ArrayList<String> years = new ArrayList<String>();
        if(Competitors.size() > 0)
        {
            for(Group g: ageGroups)
            {
                years.add("Grupe," + g.getGroup() + "," + g.getStartingYear() + "," + g.getEndYear());
            }
            //BufferedWriter writer;
            try 
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(now);
                File dir = new File("autosaves");
                if(!(dir.exists()))
                {
                    dir.mkdir();
                }
                String fileName = "autosave" + calendar.get(Calendar.HOUR) + ".txt";
                File file = new File(dir, fileName);
                if(!(file.exists()))
                    file.createNewFile();
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
                //writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
                writer.flush();
                //writer.newLine();
                for(String s: years)
                {
                    writer.write(s);
                    //writer.newLine();
                }
                for(YoungerCompetitor c: Competitors)
                    {
                        writer.write(c.toString());
                        //writer.newLine();
                    }
                writer.close();
            }
            catch(FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, "Autosave has failed. File not found");
            }
            catch (IOException ex) 
            {
                Logger.getLogger(ResultsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean saveToFile(String path)
    {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.flush();
            writer.newLine();
            for(YoungerCompetitor c: Competitors)
                {
                    writer.write(c.toString());
                    writer.newLine();
                }
            writer.close();
            }
            catch (IOException ex) 
            {
                Logger.getLogger(ResultsForm.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
    }
    
    private YoungerCompetitor findByID(int ID)
    {
        for(YoungerCompetitor c: Competitors)
        {
            if(c.getID() == ID)
            {
                return c;
            }
        }
        return null;
    }
    
    private void printResultsToTF(Group ageGroup)
    {
        if(ageGroup != null)
        {
            competitorInfoText1.setText(ageGroup.getGroup() + " (" + ageGroup.getStartingYear() + "-" 
                    + ageGroup.getEndYear() + ")" + "\n");
            for(YoungerCompetitor c: ageGroup.getGroupList())
            {
                competitorInfoText1.append(c.toString() + "\n");
            }
        }
        else
        {
            competitorInfoText1.setText("Grupė tuščia. Įkelkite dalyvius");
        }
    }
    
    private boolean isGroupEmty(Group ageGroup)
    {
        if(ageGroup.getGroupList().size() > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private void setResultOlder(String eventName, String result, int ID)
    {
        for(YoungerCompetitor c: Competitors)
        {
            if(c.getID() == ID)
            {
                switch(eventName)
                {
                    case "Bėgimas 60m":
                        c.setSprint(result);
                        c.setEventName(eventName, 0);
                        break;
                    case "Bėgimas 30m":
                        c.setSprint(result);
                        c.setEventName(eventName, 0);
                        break;
                    case "Bėgimas 400m":
                        c.setLongRunY(result);
                        c.setEventName(eventName, 1);
                        break;
                    case "Bėgimas 800m":
                        c.setLongRun(result);
                        c.setEventName(eventName, 1);
                        break;
                    case "Bėgimas 1500m":
                        c.setLongRun(result);
                        c.setEventName(eventName, 1);
                        break;
                    case "Spaudimas":
                        c.setBenchPress(result);
                        c.setEventName(eventName, 2);
                        break;
                    case "Traukimas":
                        c.setBenchPull(result);
                        c.setEventName(eventName, 3);
                        break;
                    case "Presas":
                        c.setCore(result);
                        c.setEventName(eventName, 4);
                        break;
                    case "Prisitraukimai":
                        c.setPullUps(result);
                        c.setEventName(eventName, 5);
                        break;
                    case "Atsispaudimai":
                        c.setPullUps(result);
                        c.setEventName(eventName, 5);
                        break;
                }
            }
        }
    }
    
    private void setResultYounger(String eventName, String result, int ID)
    {
        for(YoungerCompetitor c: Competitors)
        {
            if(c.getID() == ID)
            {
                switch(eventName)
                {
                    case "Bėgimas 30m":
                        c.setSprintY(result);
                        c.setEventName(eventName, 0);
                        break;
                    case "Bėgimas 200m":
                        c.setLongRunY(result);
                        c.setEventName(eventName, 1);
                        break;
                    case "Bėgimas 400m":
                        c.setLongRunY(result);
                        c.setEventName(eventName, 1);
                        break;
                    case "Kabėjimas laikui":
                        c.setHanging(result);
                        c.setEventName(eventName, 5);
                        break;
                    case "Flamingo testas":
                        c.setFlamingo(result);
                        c.setEventName(eventName, 4);
                        break;
                    case "Presas":
                        c.setCoreY(result);
                        c.setEventName(eventName, 2);
                        break;
                    case "Atsispaudimai nuo kelių":
                        c.setJockey(result);
                        c.setEventName(eventName, 3);
                        break;
                    case "Šokdynė":
                        c.setJockey(result);
                        c.setEventName(eventName, 3);
                        break;
                }
            }
        }
    }
    
    private boolean checkResultsSprint(String result)
    {
        boolean isCorrect = false;
        if(result.isEmpty())
        {
            return true;
        }
        char[] charArray = result.toCharArray();
            if(charArray.length == 5)
            {
                if(!(Character.isDigit(charArray[0]) && Character.isDigit(charArray[1]) && Character.isDigit(charArray[3]) && Character.isDigit(charArray[4]) && charArray[2] == ' '))
                {
                    resultTextField.setText("");
                    JOptionPane.showMessageDialog(this, "Blogai įvestas laikas. Turi būti (ss ms)");
                    isCorrect = false;
                }
                else
                {
                    resultTextField.setText(Character.toString(charArray[0]) + Character.toString(charArray[1]) + "." + Character.toString(charArray[3]) + Character.toString(charArray[4]));
                    isCorrect = true;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Blogai įvestas laikas. Turi būti (ss ms)");    
            }
        return isCorrect;
    }
    
    private boolean checkMoreCount(String result)
    {
        if(result.isEmpty())
        {
            return true;
        }
        char[] charArray = result.toCharArray();
        if(charArray.length > 0)
        {
            for(int i=0;i<charArray.length;i++)
            {
                if(!Character.isDigit(charArray[i]))
                {
                    resultTextField.setText("");
                    JOptionPane.showMessageDialog(this, "Netinkamai įvestas rezultatas");
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkResultsLongRun(String result)
    {
        boolean isCorrect = false;
        if(result.isEmpty())
        {
            return true;
        }
        char[] charArray = result.toCharArray();
            if(charArray.length == 8)
            {
                if(!(Character.isDigit(charArray[0]) && Character.isDigit(charArray[1]) && Character.isDigit(charArray[3]) && Character.isDigit(charArray[4]) && charArray[2] == ' ' && Character.isDigit(charArray[7]) && Character.isDigit(charArray[6]) && charArray[5] == ' '))
                {
                    resultTextField.setText("");
                    JOptionPane.showMessageDialog(this, "Blogai įvestas laikas. Turi būti (mm ss ms)");
                    isCorrect = false;
                }
                else
                {
                    resultTextField.setText(Character.toString(charArray[0]) + Character.toString(charArray[1]) + ":" + Character.toString(charArray[3]) + Character.toString(charArray[4]) + "." +
                            Character.toString(charArray[6]) + Character.toString(charArray[7]));
                    isCorrect = true;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Blogai įvestas laikas. Turi būti (mm ss ms)");
            }
        return isCorrect;
    }
    
    
    
    private YoungerCompetitor findByID(String group, int ID)
    {
        for(YoungerCompetitor c: Competitors)
        {
            if(ID == c.getID())
            {
                return c;
            }
        }
        return null;
    }
    
    public void setCompetitors(ArrayList<YoungerCompetitor> competitors)
    {
        Competitors.addAll(competitors);
    }
    
    public void setAgeGroups(Group[] ageGroups)
    {
        this.ageGroups = ageGroups;
        makeAgeGroups(ageGroups);
    }
    
    private void setSavedResultsO(Group group)
    {
        for(YoungerCompetitor c:group.getGroupList())
        {
            c.setSavedResultsOlder();
        }
    }
    
    private void setSavedResultsY(Group group)
    {
        for(YoungerCompetitor c:group.getGroupList())
        {
            if(group.getGroup().equals("Mergaitės"))
            {
                c.setSavedResultsYoungerM();
            }
            else
            {
                c.setSavedResultsYounger();
            }
        }
    }
    
    public void makeAgeGroups(Group[] ageGroups)
    {
        for(Group g: ageGroups)
        {
            if(g != null)
            switch(g.getGroup())
            {
                case "Vyrai":
                    setAgeGroupsList(g, "V");
                    setSavedResultsO(g);
                    break;
                case "Moterys":
                    setAgeGroupsList(g, "M");
                    setSavedResultsO(g);
                    break;
                case "Jauniai":
                    setAgeGroupsList(g, "V");
                    setSavedResultsO(g);
                    break;
                case "Jaunės":
                    setAgeGroupsList(g, "M");
                    setSavedResultsO(g);
                    break;
                case "Jaunučiai":
                    setAgeGroupsList(g, "V");
                    setSavedResultsO(g);
                    break;
                case "Jaunutės":
                    setAgeGroupsList(g, "M");
                    setSavedResultsO(g);
                    break;
                case "Berniukai":
                    setAgeGroupsList(g, "V");
                    setSavedResultsO(g);
                    break;
                case "Mergaitės":
                    setAgeGroupsList(g, "M");
                    setSavedResultsY(g);
                    break;
                case "Vaikai berniukai":
                    setAgeGroupsList(g, "V");
                    setSavedResultsY(g);
                    break;
                case "Vaikai mergaitės":
                    setAgeGroupsList(g, "M");
                    setSavedResultsY(g);
                    break;
            }
        }
    }
    
    private void setAgeGroupsList(Group ageGroup, String Gender)
    {
        ageGroup.getGroupList().clear();
        for(YoungerCompetitor c: Competitors)
        {
            if(c.getYears() <= ageGroup.getEndYear() && c.getYears() >= ageGroup.getStartingYear() && c.getGender().equals(Gender))
            {
                ageGroup.add(c);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ResultsForm form = new ResultsForm();
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDtextField;
    private javax.swing.JButton addCompetitorBtn;
    private javax.swing.JLabel competitorInfo;
    private javax.swing.JTextArea competitorInfoText1;
    private javax.swing.JTextArea enteredInfoTf;
    private javax.swing.JComboBox<String> groupResultsList;
    private javax.swing.JComboBox<String> grupesList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lastEnteredTf;
    private javax.swing.JTextField resultTextField;
    private javax.swing.JButton resultsBtn;
    private javax.swing.JComboBox<String> rungtisList;
    private javax.swing.JButton setEventBtn;
    private javax.swing.JButton setGroopBtn;
    private javax.swing.JButton setResult;
    private javax.swing.JButton testiBtn;
    // End of variables declaration//GEN-END:variables

    private void onCreate()
    {
        
        makeAgeGroups(ageGroups);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Pridėti dalyvi"))
        {
            if(Competitors.size() > 0 && chechTextFieldForEditing() == false)
            {
                buttonEdit.grabFocus();
                competitorToAdd.setID(Integer.parseInt(idField.getText()));
                competitorToAdd.setName(nameField.getText());
                competitorToAdd.setAge(Integer.parseInt(yearsField.getText()));
                competitorToAdd.setSurname(surnameField.getText());
                competitorToAdd.setCity(cityField.getText());
                competitorToAdd.setCoach(coachField.getText());
                if(menRadBtn.isSelected() && !womenRadBtn.isSelected())
                {
                    competitorToAdd.setGender("V");
                    Competitors.add(competitorToAdd);
                    jButton8.setEnabled(true);
                    frameEdit.dispose();
                    makeAgeGroups(ageGroups);
                }
                else if(!menRadBtn.isSelected() && womenRadBtn.isSelected())
                {
                    competitorToAdd.setGender("M");
                    Competitors.add(competitorToAdd);
                    jButton8.setEnabled(true);
                    frameEdit.dispose();
                    makeAgeGroups(ageGroups);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Blogai įvesti duomenys pridedant dalyvį");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Įvestas ID jau naudojamas arba nepateikti duomenys");
            }
        }
        if(e.getActionCommand().equals("Keisti informaciją"))
        {
            try
            {
                if(Competitors.size() > 0 && chechTextFieldForEditing() == false)
                {
                    competitorToAdd.setID(Integer.parseInt(idField.getText()));
                    competitorToAdd.setName(nameField.getText());
                    competitorToAdd.setAge(Integer.parseInt(yearsField.getText()));
                    competitorToAdd.setSurname(surnameField.getText());
                    competitorToAdd.setCity(cityField.getText());
                    competitorToAdd.setCoach(coachField.getText());
                    changeCompetitors(competitorToChange, competitorToAdd);
                    makeAgeGroups(ageGroups);
                    frameEdit.dispose();
                    addCompetitorBtn.setEnabled(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Įvestas ID jau naudojamas arba neįvestas");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Klaida įvedant. Įsitikinkite, kad užpildėte laukelius");
            }
        }
    }
    
    private boolean chechTextFieldForEditing()
    {
        boolean isEmty = false;
        if(idField.getText().isEmpty())
        {
            isEmty = true;
        }
        else if(nameField.getText().isEmpty())
        {
            isEmty = true;
        }
        else if(yearsField.getText().isEmpty())
        {
            isEmty = true;
        }
        else if(surnameField.getText().isEmpty())
        {
            isEmty = true;
        }
        else if(cityField.getText().isEmpty())
        {
            isEmty = true;
        }
        else if(coachField.getText().isEmpty())
        {
            isEmty = true;
        }
        return isEmty;
    }
    
    private boolean isIDUnique(int ID)
    {
        for(YoungerCompetitor c: Competitors)
        {
            if(c.getID() == ID)
            {
                return false;
            }
        }
        return true;
    }

    private void changeCompetitors(YoungerCompetitor competitorToChange, YoungerCompetitor competitorToAdd) 
    {
        for(YoungerCompetitor c: Competitors)
        {
            if(competitorToChange.equals(c))
            {
                Competitors.remove(competitorToChange);
                Competitors.add(competitorToAdd);
            }
        }
    }
}

