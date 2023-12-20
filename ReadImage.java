import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Read and open image from file
 * refactor the code, it was before in the main game file
 * @version 0.1
 */
public class ReadImage {
    public static void read(String BildDateiPfad) {
        try {
            BufferedImage Bild = ImageIO.read(new File(BildDateiPfad));

            JFrame frame = new JFrame();
            frame.setSize(400, 400);
            JLabel label = new JLabel(new ImageIcon(Bild));
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
