package grafiikka;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Kuva extends JLabel {

    public Kuva(String img) {
        this(new ImageIcon(img));
    }

    public Kuva(ImageIcon icon) {
        setIcon(icon);
        // setMargin(new Insets(0,0,0,0));
        setIconTextGap(0);
        // setBorderPainted(false);
        setBorder(null);
        setText(null);
        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
    }
}

