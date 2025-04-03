package control;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CavaloThread extends JLabel implements Runnable {
    private Thread cavaloThread = null;
    private int posX;
    private int posY;
    private ImageIcon imagem;
    private static int pos=0;
    private String nome;
    // CONSTRUTOR DEFAULT
    public CavaloThread() {

    }
    // CONSTRUTOR SOBRECARREGADO
    public CavaloThread(String nome, ImageIcon img, int posX, int posY){
        super(img);
        this.imagem = img;
        this.posX = posX;
        this.posY = posY;
        this.nome = nome;

        cavaloThread = new Thread(this, nome);
        cavaloThread.start();

    }
    // M�TODO RUN() DA INTERFACE RUNNABLE
    @Override
    public void run() {
        posX += new Random().nextInt(3) * 100;
        this.setLocation(posX, posY);

        if (posX >= 1280) {
            pos++;
            JOptionPane.showMessageDialog(null, pos + ")" + nome);
            return;

        }

        try {
            Thread.sleep(new Random().nextInt(5) * 100);
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}