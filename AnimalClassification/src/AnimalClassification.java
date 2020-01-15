// bird or mammal, based on answers provided by the user
// Program for classifying an animal as a fish, reptile, amphibian,

import javax.swing.JOptionPane;

public class AnimalClassification {

    public static void main(String[] args) {

        boolean hasFeathers = false;
        boolean hasScales = false;

        int hasFinsAnswer = JOptionPane.showConfirmDialog(null, "Does your animal have fins?");
        boolean hasFins = (hasFinsAnswer == JOptionPane.YES_OPTION);

        int hasColdBloodAnswer = JOptionPane.showConfirmDialog(null,
                "Is your animal cold blooded?");
        boolean hasColdBlood = (hasColdBloodAnswer == JOptionPane.YES_OPTION);

        if(hasColdBlood)
        {
            int hasScalesAnswer = JOptionPane.showConfirmDialog(null,
                    "Does your animal have scales?");
            hasScales = (hasScalesAnswer == JOptionPane.YES_OPTION);
        }
        else
        {
            int hasFeathersAnswer = JOptionPane.showConfirmDialog(null,
                    "Does your animal have feathers?");
            hasFeathers = (hasFeathersAnswer == JOptionPane.YES_OPTION);
        }

        String animalClassification = "cannot be classified.";

        if(hasFins && hasColdBlood && hasScales)
            animalClassification = "is a Fish.";
        else if(!hasFins && hasColdBlood && hasScales)
            animalClassification = "is a Reptile.";
        else if(!hasFins && hasColdBlood && !hasScales)
            animalClassification = "is an Amphibian.";
        else if(!hasFins && !hasColdBlood && hasFeathers)
            animalClassification = "is a Bird.";
        else if(!hasFins && !hasColdBlood && !hasFeathers)
            animalClassification = "is a Mammal.";

        JOptionPane.showMessageDialog(null, "Your animal " + animalClassification);


    }

}
