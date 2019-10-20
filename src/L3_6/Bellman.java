package L3_6;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

@SuppressWarnings("Duplicates")

public class Bellman {
    static int src;
    ArrayList<Integer> resultat = new ArrayList();
    static ArrayList<Integer> bel_trace_cree = new ArrayList<>();

    public Bellman() {
        this.Initialisation();
        this.Recherche_Chemins();
    }

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
            } else resultat.add(99);
        }
        System.out.println(resultat);
        List<String> lignes = Arrays.asList("**BELLMAN**");
        List<String> lignes2 = Arrays.asList("Initialisation= "+ resultat);
        Path fichier = Paths.get("./src/L3_6/L3-6-trace"+lecture_fichier.getNom_Fichier().charAt(18)+"-"+src+".txt");
            try {
                if(!Dijkstra2.dij_trace_cree.contains(src)){
                    Files.write(fichier, lignes, Charset.forName("UTF-8"));
                    bel_trace_cree.add(src);
                }

                else if(Dijkstra2.dij_trace_cree.contains(src)){
                    Files.write(fichier, lignes, Charset.forName("UTF-8"),StandardOpenOption.APPEND);
                    Files.write(fichier, lignes2, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                    bel_trace_cree.add(src);
                }

            }
            catch(IOException e){
                e.printStackTrace();
            }
    }

    public void Recherche_Chemins() {
        int depart=lecture_fichier.graphe.get(0).dep;
        for (int i = 0; i <=lecture_fichier.getDimension()-1 ; i++) { ////////
            for (int a = 0; a < lecture_fichier.graphe.size() ; a++) {
                if (lecture_fichier.graphe.get(a).dep!=depart){
                    System.out.println(resultat);
                    List<String> lignes2 = Arrays.asList(" "+resultat);

                    Path fichier = Paths.get("./src/L3_6/L3-6-trace"+lecture_fichier.getNom_Fichier().charAt(18)+"-"+src+".txt");
                    try {
                        Files.write(fichier, lignes2, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    depart=lecture_fichier.graphe.get(a).dep;
                    if(i==1)break;
                }
                if (resultat.get(lecture_fichier.graphe.get(a).arr) > resultat.get(lecture_fichier.graphe.get(a).dep) + lecture_fichier.graphe.get(a).val) {
                    resultat.set((lecture_fichier.graphe.get(a).arr), resultat.get(lecture_fichier.graphe.get(a).dep) + lecture_fichier.graphe.get(a).val);
                }
            }
            depart=lecture_fichier.graphe.get(0).dep;
        }

                for (int a = 0; a < lecture_fichier.graphe.size() - 1; a++) {
                    if (resultat.get(lecture_fichier.graphe.get(a).arr) > resultat.get(lecture_fichier.graphe.get(a).dep) + lecture_fichier.graphe.get(a).val) {
                        System.out.println("Existance d'une boucle négative\n\nCIRCUIT ABSORBANT !");
                        List<String> lignes2 = Arrays.asList("CIRCUIT ABSORBANT !");
                        Path fichier = Paths.get("./src/L3_6/L3-6-trace"+lecture_fichier.getNom_Fichier().charAt(18)+"-"+src+".txt");
                        try {
                            Files.write(fichier, lignes2, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                        break;
                    }
                }


    }
}
