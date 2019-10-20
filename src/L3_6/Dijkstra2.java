package L3_6;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Duplicates")

public class Dijkstra2 {
    ArrayList<Integer> resultat = new ArrayList();
    ArrayList<Integer> chemin = new ArrayList();
    static ArrayList<Integer>  dij_trace_cree=new ArrayList();
    static int src;


    public static void Point_Depart() {
        System.out.println("Par quelle sommet voulez vous commencer ?");
        for (int i = 0; i < lecture_fichier.graphe.size(); i++) {
            if (i == lecture_fichier.graphe.size() - 1) {
                System.out.println(lecture_fichier.graphe.get(i).dep);
            } else if (lecture_fichier.graphe.get(i).dep != lecture_fichier.graphe.get(i + 1).dep)
                System.out.println(lecture_fichier.graphe.get(i).dep);
        }
        Scanner sc = new Scanner(System.in);
        src = sc.nextInt();
    }
    public void Initialisation() {
        for (int i = 0; i < lecture_fichier.getDimension(); i++) {
            if (i == src) {
                resultat.add(0);
            } else {
                resultat.add(99);

            }
        }
        System.out.println("Initialisation= "+ resultat);

        List<String> lignes = Arrays.asList("**DIJKSTRA**");
        List<String> lignes2 = Arrays.asList("Initialisation= "+ resultat);
        Path fichier = Paths.get("./src/L3_6/L3-6-trace"+lecture_fichier.getNom_Fichier().charAt(18)+"-"+src+".txt");
        try {
            if(!Bellman.bel_trace_cree.contains(src)){
                Files.write(fichier, lignes, Charset.forName("UTF-8"));
                dij_trace_cree.add(src);
            }
            else if(Bellman.bel_trace_cree.contains(src)){
                Files.write(fichier, lignes, Charset.forName("UTF-8"),StandardOpenOption.APPEND);
                Files.write(fichier, lignes2, Charset.forName("UTF-8"),StandardOpenOption.APPEND);
                dij_trace_cree.add(src);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public void Recherche_Sommet(){

        chemin.add(src);
        int current_sommet=src;
        ArrayList<Arc> compar = new ArrayList();
        int a;
        for(a=0;a<lecture_fichier.getDimension();a++) {
            //System.out.println("current_sommet = "+current_sommet);
            for (int i = 0; i < lecture_fichier.graphe.size(); i++) {
                if (lecture_fichier.graphe.get(i).dep == current_sommet) {
                    if (resultat.get(lecture_fichier.graphe.get(i).arr) > lecture_fichier.graphe.get(i).val + resultat.get(lecture_fichier.graphe.get(i).dep) && !chemin.contains(lecture_fichier.graphe.get(i).arr)){
                        //System.out.println(lecture_fichier.graphe.get(i));
                        int nouvelle_donnee = lecture_fichier.graphe.get(i).val + resultat.get(lecture_fichier.graphe.get(i).dep);
                        resultat.set(lecture_fichier.graphe.get(i).arr, nouvelle_donnee);
                        compar.add(lecture_fichier.graphe.get(i));
                    }
                }
            }

            //System.out.println("compar="+compar);
            current_sommet=Calcule_Min_Index(compar);
            chemin.add(current_sommet);
            if(chemin.get(chemin.size()-1)==99){
                chemin.remove(chemin.size()-1);
                break;
            }
            System.out.println("current_sommet = "+current_sommet);
            compar.clear();
            System.out.println("chemin= "+chemin);
            System.out.println("resultat= "+resultat);

            List<String> lignes = Arrays.asList("chemin= "+chemin);
            List<String> lignes2 = Arrays.asList("resultat= "+resultat);

            Path fichier = Paths.get("./src/L3_6/L3-6-trace"+lecture_fichier.getNom_Fichier().charAt(18)+"-"+src+".txt");
            try {
                Files.write(fichier, lignes, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                Files.write(fichier, lignes2, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
        for (int i=0;i<chemin.size();i++){
            if(!chemin.contains(i)){
                for(int t=0;t<lecture_fichier.graphe.size();t++){
                    //System.out.println("coucou");
                    if(lecture_fichier.graphe.get(t).dep==i){
                        if (resultat.get(lecture_fichier.graphe.get(t).arr) > lecture_fichier.graphe.get(t).val + resultat.get(lecture_fichier.graphe.get(t).dep) && !chemin.contains(lecture_fichier.graphe.get(t).arr)){
                            //System.out.println(lecture_fichier.graphe.get(t));
                            int nouvelle_donnee = lecture_fichier.graphe.get(t).val + resultat.get(lecture_fichier.graphe.get(t).dep);
                            resultat.set(lecture_fichier.graphe.get(t).arr, nouvelle_donnee);
                            compar.add(lecture_fichier.graphe.get(t));
                    }
                }

                }
            }
        }
        System.out.println("chemin= "+chemin);
        System.out.println("resultat= "+resultat);
        List<String> lignes = Arrays.asList("chemin= "+chemin);
        List<String> lignes2 = Arrays.asList("resultat= "+resultat);

        Path fichier = Paths.get("./src/L3_6/L3-6-trace"+lecture_fichier.getNom_Fichier().charAt(18)+"-"+src+".txt");
        try {
            Files.write(fichier, lignes, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
            Files.write(fichier, lignes2, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public int Calcule_Min_Index(ArrayList<Arc> a){
        int b=99,index=99,valeur=0;
        for (int i=0;i<a.size();i++){
            valeur = a.get(i).val+resultat.get(a.get(i).dep);
           // System.out.println("Valeur = "+valeur);
           // System.out.println("b = "+b);
            if(valeur<=b && !chemin.contains(a.get(i).arr)){
                b=valeur;
                index=a.get(i).arr;
            }
        }
        //System.out.println("index = "+index);
        return index;
    }

    public static int Test_Negatif(){
        for(int i=0;i<lecture_fichier.graphe.size();i++){
            if(lecture_fichier.graphe.get(i).val<0){
                List<String> lignes = Arrays.asList("Indice négatif ! Dijkstra impossible ! ");
                Path fichier = Paths.get("./src/L3_6/L3-6-trace"+lecture_fichier.getNom_Fichier().charAt(18)+"-"+src+".txt");
                try {
                    if(Bellman.bel_trace_cree.contains(src)){
                        Files.write(fichier, lignes, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                    }
                    else if(!Bellman.bel_trace_cree.contains(src)){
                        Files.write(fichier, lignes, Charset.forName("UTF-8"));
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                return 1;
            }
        }
        return 0;
    }
}

