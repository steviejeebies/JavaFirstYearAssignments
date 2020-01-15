import javax.swing.JOptionPane;

public class BringUmbrella {

    public static void main(String[] args) {

        int itIsRainingAnswer = JOptionPane.showConfirmDialog(null,
                "This program will guess if you need an umbrella, "
                        + "if you're leaving now. \n\nIs it raining?");
        boolean bringUmbrella = (itIsRainingAnswer == JOptionPane.YES_OPTION);

        if(bringUmbrella)
        {
            JOptionPane.showMessageDialog(null,
                    "Bring an Umbrella, and put it up straight away.");
        }
        else
        {
            int likelytoRainAnswer = JOptionPane.showConfirmDialog(null,
                    "Does it look like it is going to rain?");
            boolean likelyToRain = (likelytoRainAnswer == JOptionPane.YES_OPTION);

            JOptionPane.showMessageDialog(null,
                    ((likelyToRain) ? "You should bring an Umbrella just in case." :
                            "It's not very likely that you'll need an umbrella."));
        }
    }

}