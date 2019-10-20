package L3_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class lecture_fichier {

    private static int dimension;
    private static String data[][];
    static ArrayList<Arc> graphe = new ArrayList<>();
    private static String nom_Fichier="./src/L3_6/L3-E06-1.txt";


    public static void creation_tab(){
        BufferedReader reader;

        int n=0;
        int i=0;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(nom_Fichier));
             line = reader.readLine();
            //System.out.println(line);
            dimension = Integer.parseInt(line);
            while((line = reader.readLine()) != null){

                String data[] = line.split(" ");
                graphe.add(new Arc(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2])));
            }
            reader.close();

        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Le graph a été importé avec succès");
    }

    public static String getNom_Fichier() {
        return nom_Fichier;
    }

    public static int getDimension() {
        return dimension;
    }

    public static void setDimension(int dimension) {
        lecture_fichier.dimension = dimension;
    }
}
