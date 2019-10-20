package L3_6;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")

public class Dijkstra {
    ArrayList<Integer> resultat = new ArrayList();
    ArrayList<Integer> chemin = new ArrayList();

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

    }

    public void Recherche_Sommet(){

        chemin.add(src);
        ArrayList<Arc> compar = new ArrayList();
        for(int i=0;i<lecture_fichier.graphe.size();i++){
    if(resultat.get(lecture_fichier.graphe.get(i).arr)>lecture_fichier.graphe.get(i).val && resultat.get(lecture_fichier.graphe.get(i).dep)!=99){
        resultat.set(lecture_fichier.graphe.get(i).arr,lecture_fichier.graphe.get(i).val+resultat.get(lecture_fichier.graphe.get(i).dep));
        compar.add(lecture_fichier.graphe.get(i));

        //System.out.println("compar= "+compar.get(0).arr);
        System.out.println("chemin= "+chemin);
        //System.out.println("i= "+i);

        if(i==lecture_fichier.graphe.size()-1){
            chemin.add(Calcule_Min_Index(compar));
            System.out.println("resultat ="+resultat);
            compar.clear();
            break;
        }
        if(lecture_fichier.graphe.get(i).dep!=lecture_fichier.graphe.get(i+1).dep){
            chemin.add(Calcule_Min_Index(compar));
            System.out.println(resultat);
            compar.clear();
        }
    }
}
        System.out.println("chemin= "+chemin);
}

public int Calcule_Min_Index(ArrayList<Arc> a){
        int b=99,index=99;
        for (int i=0;i<a.size();i++){
            if(a.get(i).val<b && !chemin.contains(a.get(i).arr)){

                b=a.get(i).val;
                index=a.get(i).arr;
                //System.out.println("indexe= "+index);
            }
        }
        return index;
}
    }

