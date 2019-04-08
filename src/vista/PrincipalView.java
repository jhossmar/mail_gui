package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrincipalView extends JFrame {

    // CONFIGURACION DE BARRA DE MENU
    private JMenu m_file,m_edit,m_message,m_folder,m_help;
    private JMenuBar mb_barra;
    private JMenuItem mi_new,mi_exit;

    // PANELES
    private JPanel container;
    private JPanel left_panel;
    private JPanel medium_panel;
    private JPanel medium_up_panel;
    private JPanel medium_down_panel;
    private JPanel lowerPanel;

    // LABELS
    private JLabel lbl_from;
    private JLabel lbl_date;
    private JLabel lbl_subjet;

    // IMPUTS
    protected JTextField txt_from;
    protected JTextField txt_date;
    protected JTextField txt_subjet;
    protected JTextArea txt_message;

    // BUTTONS
    protected JButton btn_friends;
    protected JButton btn_drafts;
    protected JButton btn_trash;
    protected JButton btn_sent;
    protected JButton btn_inbox;

    // OBJETOS PARA LA TABLA
    private JScrollPane scroll;
    protected Object [][] datos;
    protected String [] cabecera;
    protected DefaultTableModel dtm;
    protected JTable tabla;



    public PrincipalView(){
        super();
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Recordar capturar esta accion
        this.setTitle("Client Mail APP");
        barra_of_menu();

        btn_inbox = new JButton("INBOX");
        btn_drafts = new JButton("DRAFTS");
        btn_friends = new JButton("FRIENDS");
        btn_sent = new JButton("SENTS");
        btn_trash = new JButton("TRASH");

        this.left_panel = new JPanel();
        left_panel.setLayout(new BoxLayout(left_panel,BoxLayout.Y_AXIS));
        left_panel.add(btn_inbox);
        left_panel.add(btn_drafts);
        left_panel.add(btn_sent);
        left_panel.add(btn_friends);
        left_panel.add(btn_trash);

        medium_up_panel = new JPanel();
        medium_down_panel = new JPanel();

        this.medium_panel = new JPanel();
        medium_panel.setLayout(new BorderLayout());
        medium_panel.add(medium_up_panel,BorderLayout.NORTH);
        medium_panel.add(medium_down_panel, BorderLayout.CENTER);

        SpringLayout sp = new SpringLayout();
        medium_down_panel.setLayout(sp);

        container = new JPanel();
        this.getContentPane().add(container);
        BorderLayout borderLayout = new BorderLayout();
        container.setLayout(borderLayout);
        container.add(left_panel,BorderLayout.WEST);
        container.add(medium_panel,BorderLayout.CENTER);

        scroll = new JScrollPane();
        cabecera = new String[]{"DATE","FROM","SUBJECT"};
        dtm = new DefaultTableModel(datos,cabecera);
        tabla = new JTable(dtm);
        scroll.setViewportView(tabla);
        medium_up_panel.add(scroll);



        lbl_from = new JLabel("FROM");
        medium_down_panel.add(lbl_from);
        sp.putConstraint(SpringLayout.NORTH, lbl_from, 10,
                SpringLayout.NORTH, medium_down_panel);
        sp.putConstraint(SpringLayout.WEST,lbl_from,10,SpringLayout.WEST,medium_down_panel);

        lbl_date = new JLabel("Date");
        medium_down_panel.add(lbl_date);
        sp.putConstraint(SpringLayout.NORTH,lbl_date,50,SpringLayout.NORTH,medium_down_panel);
        sp.putConstraint(SpringLayout.WEST,lbl_date,10,SpringLayout.WEST,medium_down_panel);

        lbl_subjet = new JLabel("Subject");
        medium_down_panel.add(lbl_subjet);
        sp.putConstraint(SpringLayout.NORTH,lbl_subjet,90,SpringLayout.NORTH,medium_down_panel);
        sp.putConstraint(SpringLayout.WEST,lbl_subjet,10,SpringLayout.WEST,medium_down_panel);



        //CUADRO DE TEXTO PARA EL FROM
        txt_from = new JTextField();
        medium_down_panel.add(txt_from);
        sp.putConstraint(SpringLayout.NORTH, txt_from, 10,
                SpringLayout.NORTH, medium_down_panel);
        sp.putConstraint(SpringLayout.WEST, txt_from, 100,
                SpringLayout.WEST, medium_down_panel);
        sp.putConstraint(SpringLayout.EAST, txt_from, 300,
                SpringLayout.WEST, medium_down_panel);
        //CUADRO DE TEXTO PARA EL DATE
        txt_date = new JTextField();
        medium_down_panel.add(txt_date);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txt_date, 50,
                SpringLayout.NORTH, medium_down_panel);
        sp.putConstraint(SpringLayout.WEST, txt_date, 100,
                SpringLayout.WEST, medium_down_panel);
        sp.putConstraint(SpringLayout.EAST, txt_date, 300,
                SpringLayout.WEST, medium_down_panel);
        //CUADRO DE TEXTO PARA LOS APELLIDOS
        txt_subjet = new JTextField();
        medium_down_panel.add(txt_subjet);
        sp.putConstraint(SpringLayout.NORTH, txt_subjet, 90, SpringLayout.NORTH, medium_down_panel);
        sp.putConstraint(SpringLayout.WEST, txt_subjet, 100, SpringLayout.WEST, medium_down_panel);
        sp.putConstraint(SpringLayout.EAST, txt_subjet, 300, SpringLayout.WEST, medium_down_panel);



        txt_message = new JTextArea();
        txt_message.setBounds(100,100,100,100);
        medium_down_panel.add(txt_message);
        sp.putConstraint(SpringLayout.NORTH, txt_message,150,SpringLayout.NORTH,medium_down_panel);
        sp.putConstraint(SpringLayout.WEST, txt_message,10,SpringLayout.WEST,medium_down_panel);
        sp.putConstraint(SpringLayout.EAST, txt_message,50,SpringLayout.EAST,medium_down_panel);



    }

    private void barra_of_menu(){
        this.mi_new = new JMenuItem("New");
        this.mi_exit = new JMenuItem("Exit");

        this.m_file = new JMenu("File");
        this.m_file.add(mi_new);
        this.m_file.add(mi_exit);


        this.m_edit = new JMenu("Edit");
        this.m_folder = new JMenu("Folder");
        this.m_help = new JMenu("Help");
        this.m_message = new JMenu("Messaje");

        mb_barra = new JMenuBar();
        mb_barra.add(m_file);
        mb_barra.add(m_edit);
        mb_barra.add(m_message);
        mb_barra.add(m_folder);
        mb_barra.add(m_help);
        this.setJMenuBar(mb_barra);
    }


}

