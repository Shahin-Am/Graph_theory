package L3_6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ecriture_Fichier {

     Ecriture_Fichier(){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(lecture_fichier.getNom_Fichier());
            bw = new BufferedWriter(fw);
            bw.write(lecture_fichier.getDimension()+"\n");
            for(int i=0;i<lecture_fichier.graphe.size();i++){
                String content = lecture_fichier.graphe.get(i).dep + " "+lecture_fichier.graphe.get(i).val+" "+lecture_fichier.graphe.get(i).arr+"\n";
                bw.write(content);
            }
            System.out.println("Les graphes ont été mis à jour mise à jour ");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
        System.out.println("L'arc a bien été sauvegardé");
    }
}
