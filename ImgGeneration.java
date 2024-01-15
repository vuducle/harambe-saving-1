import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Beschreiben Sie hier die Klasse ImgGeneration.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ImgGeneration

{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse ImgGeneration
     */
    public ImgGeneration()
    {
        String bildDateiPfad = "./harambe.png";

        try {
            BufferedImage bild = ImageIO.read(new File(bildDateiPfad));

            JFrame frame = new JFrame();
            frame.setSize(400, 400);
            JLabel label = new JLabel(new ImageIcon(bild));
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
}
