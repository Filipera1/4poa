package view;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import control.CavaloThread;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblPista;
    private ImageIcon imgCavalo1;
    private ImageIcon imgCavalo2;
    private ImageIcon imgCavalo3;
    private ImageIcon pista;

    public Janela() {
        super();
        // ADICIONANDO ELEMENTOS AO FORMUL�RIO
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);

        this.setTitle("Corrida de Threads");
        pista = new ImageIcon("./src/imagens/pista.png");

        this.lblPista = new JLabel(pista);
        // POSICIONANDO OS ELEMENTOS DO FORM
        this.lblPista.setBounds(0, 0, 1280, 650);

        this.add(lblPista);

        this.lblPista.setBackground(Color.BLACK);

        this.btnCorrida = new JButton("Começar corrida");
        this.btnCancel = new JButton("Finalizar Corrida");
        // POSIONADO OS BOT�ES
        this.btnCorrida.setBounds(500, 550, 120, 50);
        this.btnCancel.setBounds(640, 550, 120, 50);
        // INSERINDO AS IMAGENS DOS CAVALOS
        imgCavalo1 = new ImageIcon("./src/imagens/cavalo1.png");
        imgCavalo2 = new ImageIcon("./src/imagens/cavalo2.png");
        imgCavalo3 = new ImageIcon("./src/imagens/cavalo3.png");

        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setBorder(BorderFactory.createTitledBorder("[Grupo de Trabalho]"));
        jPanel.setVisible(true);

        this.repaint();

    }
    // INSERINDO AS JLABELS DOS CAVALOS
    public JLabel JLabelCavalos(String nome, ImageIcon img, int posX, int posY) {
        CavaloThread cavalo = new CavaloThread(nome, img, posX, posY);
        cavalo.setSize(256, 141);
        cavalo.setVisible(true);
        this.add(cavalo);
        return cavalo;
    }
    // PROGRAMANDO A A��O DOS BOT�ES
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            this.lblPista.add(JLabelCavalos("Cavalo1", imgCavalo1, 0, 50));
            this.lblPista.add(JLabelCavalos("Cavalo2", imgCavalo2, 0, 200));
            this.lblPista.add(JLabelCavalos("Cavalo3", imgCavalo3, 0, 350));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}