package L3_6;


import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class main1 {

    public static void main (String[] argv) {
        int menu=1;
        lecture_fichier.creation_tab();

        while (menu!=0){
            System.out.println("\nBonjour que souhaitez vous faire ?\n1. Afficher la liste des arcs\n2. Afficher la matrice d'adjacence\n3. Afficher la matrice de valeurs\n4. Effectuer l'algorithme de Bellman\n5. Effectuer l'algorithme de Dijsktra\n6. Modifier le graphe\n7. Ajouter un arc\n8. Quitter sans sauvegarder\nAppuyer sur 0 pour sauvegarder les arcs et quitter");
            Scanner sc = new Scanner(System.in);
            menu = sc.nextInt();
            if(menu==1){
                for (int i=0;i<lecture_fichier.graphe.size();i++)
                    System.out.println(lecture_fichier.graphe.get(i));
            }
            if(menu==2){
                Tab_Adj tab1 = new Tab_Adj(lecture_fichier.getDimension());
                tab1.Remplir_tab();
                tab1.Afficher_tab();
            }
            if(menu==3){
                Tab_Val tab2 = new Tab_Val(lecture_fichier.getDimension());
                tab2.Remplir_tab();
                tab2.Afficher_tab();
            }
            if(menu==4){
                Bellman.Point_Depart();
                Bellman b1=new Bellman();
                System.out.println(b1.resultat);
            }
            if(menu==5){
                if(Dijkstra2.Test_Negatif()==0){
                    Dijkstra2.Point_Depart();
                    Dijkstra2 d1 = new Dijkstra2();
                    d1.Initialisation();
                    d1.Recherche_Sommet();
                }
               else {
                   System.out.println("Un indice est négatif ! On ne peut pas faire l'algo de Dijkstra\n Il faut faire l'algo de Bellman\nLANCEMENT DE BELLMAN");
                    Bellman.Point_Depart();
                    Bellman b1=new Bellman();
                    System.out.println(b1.resultat);
               }
            }
            if(menu==6){
                System.out.println("Que voulez vous modifier ?\n1. La dimension\n2. Un arc");
                sc=new Scanner(System.in);
                int choix=sc.nextInt();
                if(choix==1){
                    System.out.println("Entrez la nouvelle dimension");
                    sc=new Scanner(System.in);
                    int dim=sc.nextInt();
                    lecture_fichier.setDimension(dim);
                    System.out.println("La dimension a bien été modifié");
                    System.out.println("Nouvelle dimension = "+lecture_fichier.getDimension());
                }
                if (choix==2){
                    for (int i=0;i<lecture_fichier.graphe.size();i++)
                        System.out.println("Arc "+i+" : "+lecture_fichier.graphe.get(i));
                    System.out.println("Quel arc voulez vous modifier ?\n(ATTENTION si vous modifier le nombre de sommet, merci de modifier la dimension ensuite)");
                    sc=new Scanner(System.in);
                    int arc=sc.nextInt();
                    System.out.println("Que voulez vous modifier ?\n1. Point de départ\n2. Point d'arrivé\n3. Valeur de l'arc");
                    sc=new Scanner(System.in);
                    int choix2=sc.nextInt();
                    System.out.println("Quel est sa nouvelle valeur");
                    sc=new Scanner(System.in);
                    int valeur=sc.nextInt();
                    if (choix2==1){
                        lecture_fichier.graphe.get(arc).dep=valeur;
                    }
                    if (choix2==2){
                        lecture_fichier.graphe.get(arc).arr=valeur;
                    }
                    if (choix2==3){
                        lecture_fichier.graphe.get(arc).val=valeur;
                    }
                    System.out.println("L'arc "+arc+" a bien été modifié");
                    for (int i=0;i<lecture_fichier.graphe.size();i++)
                        System.out.println("Arc "+i+" : "+lecture_fichier.graphe.get(i));
                }
                }
            if(menu==7){
                System.out.println("(ATTENTION si vous modifier le nombre de sommet, merci de modifier la dimension ensuite)");
                System.out.println("Quel est le point de départ");
                sc=new Scanner(System.in);
                int depart=sc.nextInt();
                System.out.println("Quel est le point d'arrivé");
                sc=new Scanner(System.in);
                int arrive=sc.nextInt();
                System.out.println("Quel est la valeur de l'arc");
                sc=new Scanner(System.in);
                int valeur=sc.nextInt();
                Arc arc = new Arc(depart,valeur,arrive);
            }

            if(menu==0){
                Ecriture_Fichier e=new Ecriture_Fichier();
            }
            if (menu==8){
                menu=0;
            }

            }
        }
    }

