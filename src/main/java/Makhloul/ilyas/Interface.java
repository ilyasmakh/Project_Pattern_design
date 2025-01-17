package Makhloul.ilyas;

import Makhloul.ilyas.Adaptateur.File;
import Makhloul.ilyas.Adaptateur.MaListe;
import Makhloul.ilyas.Adaptateur.Pile;
import Makhloul.ilyas.Decorator.DecMaListeSansDoublons;
import Makhloul.ilyas.Decorator.DecMaListeTriee;
import Makhloul.ilyas.Observer.Observateur;
import Makhloul.ilyas.Observer.Observe;
import Makhloul.ilyas.Observer.ProduitListeObs;
import Makhloul.ilyas.Observer.SommeListeObs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    MaListe maliste;
    Pile pile ;
    File file ;
    JFrame frame;
    JPanel panel1  ;
    JPanel panel4 ;
    JPanel panel5 ;
    Color beigeColor = new Color(245, 245, 220);
    Boolean contient = false  ;


    Observe o1 ;
    Observe o2 ;
    Observe o3  ;

    public Interface() {



        frame = new JFrame("Test des patterns designs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 800);

        // Définir un layout en grille (2 lignes, 2 colonnes)
        frame.setLayout(new GridLayout(2, 2));

        // Définir la couleur de fond beige pour tous les panneaux


        // Panneau 1 : "Les éléments de base (Liste & ElementListe)"
       panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 3)); // 1 ligne, 3 colonnes
        panel1.setBackground(Color.YELLOW);

        // Créer les colonnes avec les informations
        JPanel column1 = createColumn();
        JPanel column2 = createColumn2();
        JPanel column3 = createColumn3();

        // Ajouter les colonnes dans le panneau principal
        panel1.add(column1 , Color.yellow);
        panel1.add(column2 , Color.yellow);
        panel1.add(column3 , Color.yellow);

        JPanel AdapterPanel = new JPanel(new BorderLayout());

// Ajouter le panneau original (panel5) au centre


// Ajouter un titre en dessous (dans la zone SOUTH)
        JLabel titleLabel0 = new JLabel("Adapter", SwingConstants.CENTER);
        titleLabel0.setFont(new Font("Arial", Font.BOLD, 16));

        AdapterPanel.add(titleLabel0, BorderLayout.NORTH);
        AdapterPanel.add(panel1, BorderLayout.CENTER);
        AdapterPanel.setBackground(Color.YELLOW);


        // Ajouter le panneau au JFrame
        frame.add(AdapterPanel);

        // Panneau 4 : Observateur
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 3));
        panel4.setBackground(new Color(156, 160, 248));
        panel4.add(new JLabel());
        panel4.add(createObsCol1(), 0);
        panel4.add(createObsCol2(), 1);
        panel4.add(createObsCol3(), 2);
       // frame.add(panel4);

        // Panneau 5 : Décorateur
      /*  JPanel panel5 = new JPanel();
        panel5.setBackground(Color.ORANGE);
        panel5.add(new JLabel("Décorateur"));
        frame.add(panel5);*/




        // Panneau 1 : "Les éléments de base (Liste & ElementListe)"
        panel5 = new JPanel();

        panel5.setLayout(new GridLayout(1, 3)); // 1 ligne, 3 colonnes
        panel5.setBackground(new Color(100, 252,44));

        // Créer les colonnes avec les informations
        JPanel c1 = createDecCol1( );
        JPanel c2 = createDecCol2( );
        JPanel c3= createDecCol3( );

        // Ajouter les colonnes dans le panneau principal
        panel5.add(c1);
        panel5.add(c2);
        panel5.add(c3);

        // Créer un panneau parent pour le Décorator
        JPanel decoratorPanel = new JPanel(new BorderLayout());

// Ajouter le panneau original (panel5) au centre


// Ajouter un titre en dessous (dans la zone SOUTH)
        JLabel titleLabel = new JLabel("Décorateur", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        decoratorPanel.add(titleLabel, BorderLayout.NORTH);
        decoratorPanel.add(panel5, BorderLayout.CENTER);
        decoratorPanel.setBackground( new Color(100, 252,44));

        JPanel ObsPanel = new JPanel(new BorderLayout());

// Ajouter le panneau original (panel5) au centre


// Ajouter un titre en dessous (dans la zone SOUTH)
        JLabel titleLabel1 = new JLabel("Observateur", SwingConstants.CENTER);
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 16));

        ObsPanel.add(titleLabel1, BorderLayout.NORTH);
        ObsPanel.add(panel4, BorderLayout.CENTER);
        ObsPanel.setBackground(new Color(156, 160, 248));

// Ajouter le panneau parent au JFrame
        frame.add(decoratorPanel);

        frame.add(ObsPanel);
        // Ajouter le panneau au JFrame
      //  frame.add(panel5);
        // Panneau 6 : Entrées
        JPanel panel6 = new JPanel();
        panel6.setBackground(new Color(173, 216, 230)); // Bleu ciel
        panel6.setLayout(new BorderLayout());

        JLabel titleLabelEntrees = new JLabel("Entrées", SwingConstants.CENTER);
        titleLabelEntrees.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabelEntrees.setOpaque(true);
        titleLabelEntrees.setBackground(new Color(173, 216, 230));
        titleLabelEntrees.setForeground(Color.BLACK);
        titleLabelEntrees.setPreferredSize(new Dimension(panel6.getWidth(), 40));
        panel6.add(titleLabelEntrees, BorderLayout.NORTH);

        JPanel entriesPanel = new JPanel();
        entriesPanel.setLayout(new GridLayout(3, 1)); // Liste, Pile, File
        entriesPanel.setBackground(new Color(173, 216, 230));
        panel6.add(entriesPanel, BorderLayout.CENTER);

        // Ajouter les sections Liste, Pile et File
        entriesPanel.add(createInputSection("Liste", new Color(173, 216, 230)));
        entriesPanel.add(createInputSection("Pile", new Color(173, 216, 230)));
        entriesPanel.add(createInputSection("File", new Color(173, 216, 230)));

        frame.add(panel6);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }

    private JPanel createColumn() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(5, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(Color.YELLOW);

        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("Liste",maliste==null || this.maliste.estVide() ? "vide" :this.maliste.toString(), Color.YELLOW));
        column.add(createLabeledString("Premier", maliste==null || this.maliste.estVide() ? "vide" :""+this.maliste.getListe().getPremier().getValeur(), Color.YELLOW));
        column.add(createLabeledString("Dernier", maliste==null ||this.maliste.estVide() ? "vide" : ""+this.maliste.getDernier(),Color.YELLOW));
        column.add(createLabeledString("Longueur",maliste==null || this.maliste.estVide() ? "vide" : ""+this.maliste.getLongeur(), Color.YELLOW));
        column.add(createLabeledString("Contient",contient ? "Oui" : "Non", Color.YELLOW));

        return column;
    }

    private JPanel createColumn2() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(5, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(Color.YELLOW);

        // Liste, Premier, Dernier, Longueur, Contient
        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("Pile",pile==null || this.pile.estVide() ? "vide" :this.pile.toString(),Color.YELLOW));
        column.add(createLabeledString("Premier",pile==null || this.pile.estVide() ? "vide" :""+this.pile.getListe().getPremier().getValeur(), Color.YELLOW));
        column.add(createLabeledString("Dernier", pile==null ||this.pile.estVide() ? "vide" : ""+this.pile.getDernier(), Color.YELLOW));
        column.add(createLabeledString("Longueur" , pile==null || this.pile.estVide() ? "vide" : ""+this.pile.getLongeur(), Color.YELLOW));
        column.add(createLabeledString("Vide",pile==null || this.pile.estVide() ?  "Oui" : "Non", Color.YELLOW));

        return column;
    }
    private JPanel createColumn3() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(5, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(Color.YELLOW);

        column.add(createLabeledString("File",file==null || this.file.estVide() ? "vide" :this.file.toString(), Color.YELLOW));
        column.add(createLabeledString("Premier",file==null || this.file.estVide() ? "vide" :""+this.file.getListe().getPremier().getValeur(), Color.YELLOW));
        column.add(createLabeledString("Dernier", file==null ||this.file.estVide() ? "vide" : ""+this.file.getDernier(), Color.YELLOW));
        column.add(createLabeledString("Longueur" , file==null || this.file.estVide() ? "vide" : ""+this.file.getLongeur(),Color.YELLOW));
        column.add(createLabeledString("Vide",file==null || this.file.estVide() ?  "Oui" : "Non", Color.YELLOW));


        return column;
    }

    private JPanel createDecCol1() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(5, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(new Color(100, 252,44));

        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("Liste ", maliste==null || maliste.estVide() ? "vide" :this.maliste.toString(), new Color(100, 252,44)));

        column.add(createLabeledString("Liste sans doublons",  maliste==null || maliste.estVide() ? "vide" :new DecMaListeSansDoublons(this.maliste).toString(),new Color(100, 252,44)));

        column.add(createLabeledString("Liste trier", maliste==null || maliste.estVide() ? "vide" :  new DecMaListeTriee(this.maliste).toString(),new Color(100, 252,44)));


        return column;
    }
    private JPanel createDecCol2() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(5, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(new Color(100, 252,44));

        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("Pile ",  pile==null || pile.estVide() ? "vide" :this.pile.toString(), new Color(100, 252,44)));
        column.add(createLabeledString("Pile sans doublons",  pile==null || pile.estVide() ? "vide" :new DecMaListeSansDoublons(this.pile).toString(), new Color(100, 252,44)));
        column.add(createLabeledString("Pile trier", pile==null || pile.estVide() ? "vide" :  new DecMaListeTriee(this.pile).toString(), new Color(100, 252,44)));




        return column;
    }
    private JPanel createDecCol3() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(5, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(new Color(100, 252,44));

        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("File ",  file==null || file.estVide() ? "vide" :this.file.toString(), new Color(100, 252,44)));
        column.add(createLabeledString("File sans doublons",  file==null || file.estVide() ? "vide" :new DecMaListeSansDoublons(this.file).toString(), new Color(100, 252,44)));
        column.add(createLabeledString("File trier",  file==null || file.estVide() ? "vide" :  new DecMaListeTriee(this.file).toString(), new Color(100, 252,44)));




        return column;
    }

    private JPanel createObsCol1() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(3, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(new Color(156, 160, 248));

        column.add(createLabeledString("Liste ", maliste==null || maliste.estVide() ? "vide" :this.maliste.toString(), new Color(156, 160, 248)));

        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("Produit", o1==null ? "0" :""+o1.getObservateurs().get(0).getEtat(), new Color(156, 160, 248)));

        column.add(createLabeledString("Somme ",  o1==null ? "0" :""+o1.getObservateurs().get(1).getEtat(),new Color(156, 160, 248)));

        return column;
    }

    private JPanel createObsCol2() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(3, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(new Color(156, 160, 248));

        column.add(createLabeledString("Pile ", pile==null || pile.estVide() ? "vide" :this.pile.toString(), new Color(156, 160, 248)));

        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("Produit", o2==null ? "0" :""+o2.getObservateurs().get(0).getEtat(), new Color(156, 160, 248)));

        column.add(createLabeledString("Somme ",  o2==null ? "0" :""+o2.getObservateurs().get(1).getEtat(), new Color(156, 160, 248)));

        return column;
    }


    private JPanel createObsCol3() {
        JPanel column = new JPanel();
        column.setLayout(new GridLayout(3, 1)); // 5 lignes : Liste, Premier, Dernier, Longueur, Contient
        column.setBackground(new Color(156, 160, 248));

        column.add(createLabeledString("File ", file==null || file.estVide() ? "vide" :this.file.toString(), new Color(156, 160, 248)));

        // Liste, Premier, Dernier, Longueur, Contient
        column.add(createLabeledString("Produit", o3==null ? "0" :""+o3.getObservateurs().get(0).getEtat(), new Color(156, 160, 248)));

        column.add(createLabeledString("Somme ",  o3==null ? "0" :""+o3.getObservateurs().get(1).getEtat(),new Color(156, 160, 248)));

        return column;
    }




    private JPanel createLabeledString(String label, String value, Color backgroundColor) {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);

        JLabel labelElement = new JLabel("<html><b><u>" + label + "</u></b> : " + value + "</html>");
        panel.add(labelElement);
        return panel;
    }

    private void styleButton(JButton button, Color backgroundColor, Color textColor) {
        button.setBackground(backgroundColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private JPanel createInputSection(String title, Color backgroundColor) {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        sectionPanel.setBackground(backgroundColor);

        if (title.equals("Liste")) {
            JLabel titleLabel = new JLabel("<html><b><u>" + title + "</u></b> :</html>");
            sectionPanel.add(titleLabel);

            JTextField inputField = new JTextField(10);
            sectionPanel.add(inputField);
//-------------------------------
            JButton ajouterDebutButton = new JButton("Push debut");
            styleButton(ajouterDebutButton, new Color(34, 139, 34), Color.WHITE); // Vert
            sectionPanel.add(ajouterDebutButton);

            ajouterDebutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = inputField.getText();
                    if (!isInteger(input)) {
                        JOptionPane.showMessageDialog(frame, "C'est pas un entier ! : " + input);
                    }
                    else {
                        if (maliste == null) {

                            maliste = new MaListe(new Liste(new ElementListe(Integer.parseInt(input))));
                            o1 = (Observe) maliste ;
                            o1.ajouterObs(new ProduitListeObs(0));
                            o1.ajouterObs(new SommeListeObs(0)) ;
                            o1.notifyAllObs();

                        } else {
                            maliste.push(Integer.parseInt(input));
                        }
                        // Créer les colonnes avec les informations

                        panel1.remove(0); // Supprimer la colonne à l'indice 0
                        panel1.add(createColumn(), 0); // Ajouter une nouvelle colonne au même indice
                        panel1.revalidate(); // Recalculer la disposition
                        panel1.repaint();

                       panel5.remove(0); // Supprimer la colonne à l'indice 0
                        panel5.add(createDecCol1(), 0);
                        panel5.revalidate(); // Recalculer la disposition
                        panel5.repaint();

                        panel4.remove(0); // Supprimer la colonne à l'indice 0
                        panel4.add(createObsCol1( ), 0);
                        panel4.revalidate(); // Recalculer la disposition
                        panel4.repaint();





                    }
                    }


            });




            //--------------------------------------







            JButton supprimerFinButton = new JButton("Pop Fin");
            styleButton(supprimerFinButton, new Color(178, 34, 34), Color.WHITE); // Rouge
            sectionPanel.add(supprimerFinButton);

            supprimerFinButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(maliste!=null && maliste.getListe().getPremier()!=null) {
                        maliste.pop();
                    }
                    // Créer les colonnes avec les informations

                    panel1.remove(0); // Supprimer la colonne à l'indice 0
                    panel1.add(createColumn(), 0); // Ajouter une nouvelle colonne au même indice
                    panel1.revalidate(); // Recalculer la disposition
                    panel1.repaint();

                    panel5.remove(0); // Supprimer la colonne à l'indice 0
                    panel5.add(createDecCol1( ), 0);
                    panel5.revalidate(); // Recalculer la disposition
                    panel5.repaint();

                    panel4.remove(0); // Supprimer la colonne à l'indice 0
                    panel4.add(createObsCol1( ), 0);
                    panel4.revalidate(); // Recalculer la disposition
                    panel4.repaint();


                }


            });




            //----------------------------------------

            JButton contientButton = new JButton("Contient");
            styleButton(contientButton, new Color(100, 149, 237), Color.WHITE); // Bleu
            sectionPanel.add(contientButton);


            contientButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = inputField.getText();
                    if (!isInteger(input)) {
                        JOptionPane.showMessageDialog(frame, "C'est pas un entier ! : " + input);
                    }
                    else {
                        if (maliste != null && maliste.getListe().getPremier()!=null) {

                          if(maliste.contient(Integer.parseInt(input))) contient = true ;
                          else contient = false  ;

                        }
                        // Créer les colonnes avec les informations

                        panel1.remove(0); // Supprimer la colonne à l'indice 0
                        panel1.add(createColumn(), 0); // Ajouter une nouvelle colonne au même indice
                        panel1.revalidate(); // Recalculer la disposition
                        panel1.repaint();


                    }
                }


            });



            //----------------------------
        } else if (title.equals("Pile")) {
            JLabel titleLabel = new JLabel("<html><b><u>" + title + "</u></b> :</html>");
            sectionPanel.add(titleLabel);

            JTextField inputField = new JTextField(10);
            sectionPanel.add(inputField);

            JButton pushButton = new JButton("Push (enpiler)");
            styleButton(pushButton, new Color(34, 139, 34), Color.WHITE);
            sectionPanel.add(pushButton);


            pushButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = inputField.getText();
                    if (!isInteger(input)) {
                        JOptionPane.showMessageDialog(frame, "C'est pas un entier ! : " + input);
                    }
                    else {
                        if (pile == null) {

                            pile = new Pile(new Liste(new ElementListe(Integer.parseInt(input))));
                            o2 = (Observe) pile ;
                            o2.ajouterObs(new ProduitListeObs(0));
                            o2.ajouterObs(new SommeListeObs(0)) ;
                            o2.notifyAllObs();

                        } else {
                            pile.push(Integer.parseInt(input));
                        }
                        // Créer les colonnes avec les informations

                        panel1.remove(1); // Supprimer la colonne à l'indice 0
                        panel1.add(createColumn2(), 1); // Ajouter une nouvelle colonne au même indice
                        panel1.revalidate(); // Recalculer la disposition
                        panel1.repaint();

                        panel5.remove(1); // Supprimer la colonne à l'indice 0
                        panel5.add(createDecCol2(), 1);
                        panel5.revalidate(); // Recalculer la disposition
                        panel5.repaint();

                        panel4.remove(1); // Supprimer la colonne à l'indice 0
                        panel4.add(createObsCol2( ), 1);
                        panel4.revalidate(); // Recalculer la disposition
                        panel4.repaint();
                    }
                }


            });




            //-----------------------------------

            JButton popButton = new JButton("Pop (depiler)");
            styleButton(popButton, new Color(178, 34, 34), Color.WHITE);
            sectionPanel.add(popButton);

            popButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(pile!=null && pile.getListe().getPremier()!=null) {
                       pile.pop();
                    }
                    // Créer les colonnes avec les informations

                    panel1.remove(1); // Supprimer la colonne à l'indice 0
                    panel1.add(createColumn2(), 1); // Ajouter une nouvelle colonne au même indice
                    panel1.revalidate(); // Recalculer la disposition
                    panel1.repaint();

                    panel5.remove(1); // Supprimer la colonne à l'indice 0
                    panel5.add(createDecCol2( ), 1);
                    panel5.revalidate(); // Recalculer la disposition
                    panel5.repaint();

                    panel4.remove(1); // Supprimer la colonne à l'indice 0
                    panel4.add(createObsCol2(), 1);
                    panel4.revalidate(); // Recalculer la disposition
                    panel4.repaint();

                }


            });





            ///--------------------------------
        } else if (title.equals("File")) {
            JLabel titleLabel = new JLabel("<html><b><u>" + title + "</u></b> :</html>");
            sectionPanel.add(titleLabel);

            JTextField inputField1 = new JTextField(10);
            sectionPanel.add(inputField1);

            JButton pushButton1 = new JButton("Push (enfiler)");
            styleButton(pushButton1, new Color(34, 139, 34), Color.WHITE);
            sectionPanel.add(pushButton1);

            pushButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = inputField1.getText();
                    if (!isInteger(input)) {
                        JOptionPane.showMessageDialog(frame, "C'est pas un entier ! : " + input);
                    }
                    else {
                        if (file == null) {

                            file = new File(new Liste(new ElementListe(Integer.parseInt(input))));
                            o3 = (Observe) file ;
                            o3.ajouterObs(new ProduitListeObs(0));
                            o3.ajouterObs(new SommeListeObs(0)) ;
                            o3.notifyAllObs();

                        } else {
                            file.push(Integer.parseInt(input));
                        }
                        // Créer les colonnes avec les informations

                        panel1.remove(2); // Supprimer la colonne à l'indice 0
                        panel1.add(createColumn3(), 2); // Ajouter une nouvelle colonne au même indice
                        panel1.revalidate(); // Recalculer la disposition
                        panel1.repaint();

                        panel5.remove(2); // Supprimer la colonne à l'indice 0
                        panel5.add(createDecCol3( ), 2);
                        panel5.revalidate(); // Recalculer la disposition
                        panel5.repaint();

                        panel4.remove(2); // Supprimer la colonne à l'indice 0
                        panel4.add(createObsCol3(), 2);
                        panel4.revalidate(); // Recalculer la disposition
                        panel4.repaint();
                    }
                }


            });








            //--------------------------------------

            JButton popButton1 = new JButton("Pop (defiler)");
            styleButton(popButton1, new Color(178, 34, 34), Color.WHITE);
            sectionPanel.add(popButton1);


            popButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(file!=null && file.getListe().getPremier()!=null) {
                        file.pop();
                    }
                    // Créer les colonnes avec les informations

                    panel1.remove(2); // Supprimer la colonne à l'indice 0
                    panel1.add(createColumn3(), 2); // Ajouter une nouvelle colonne au même indice
                    panel1.revalidate(); // Recalculer la disposition
                    panel1.repaint();

                    panel5.remove(2); // Supprimer la colonne à l'indice 0
                    panel5.add(createDecCol3(), 2);
                    panel5.revalidate(); // Recalculer la disposition
                    panel5.repaint();

                    panel4.remove(2); // Supprimer la colonne à l'indice 0
                    panel4.add(createObsCol3(), 2);
                    panel4.revalidate(); // Recalculer la disposition
                    panel4.repaint();

                }


            });



        }

        return sectionPanel;
    }
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input); // Tente de convertir la chaîne en entier
            return true; // Si ça fonctionne, c'est un entier
        } catch (NumberFormatException e) {
            return false; // Si une exception est levée, ce n'est pas un entier
        }
    }

    public static void main(String[] args) {
        new Interface();
    }
}
