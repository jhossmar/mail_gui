package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrincipalView extends JFrame {

    // CONFIGURACION DE BARRA DE MENU
    private JMenu m_file,m_edit,m_message,m_folder,m_help;
    private JMenuBar mb_barra;
    private JMenuItem mi_new,mi_exit;

    //MAIN CONTAINER
    private JPanel container;
    private JPanel left_panel;
    private JPanel medium_panel;
    private JPanel medium_up_panel;
    private JPanel medium_down_panel;

    // LABELS
    private JLabel lbl_from;
    private JLabel lbl_date;
    private JLabel lbl_subjet;

    // IMPUTS
    protected JTextField txt_from;
    protected JTextField txt_date;
    protected JTextField txt_subjet;

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
        this.setMinimumSize(new Dimension(800, 600));
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


        this.medium_panel = new JPanel();


        container = new JPanel();
        this.getContentPane().add(container);
        BorderLayout borderLayout = new BorderLayout();
        container.setLayout(borderLayout);
        container.add(left_panel,BorderLayout.WEST);
        container.add(medium_panel,BorderLayout.CENTER);



//        // SE INDICA QUE SE UTILIZARA SPRINGLAYAOUT PARA EL CONTENEDOR PRINCIPAL
//        SpringLayout sp = new SpringLayout();
//        container.setLayout(sp);




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

