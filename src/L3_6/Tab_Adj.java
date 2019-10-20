package L3_6;
@SuppressWarnings("Duplicates")

public class Tab_Adj {
    int dimension;
    private int tab[][];

    public Tab_Adj(int dimension) {
        this.dimension = dimension;
        tab=new int[dimension+1][dimension+1];
    }

    public void Remplir_index() {

        for (int j = 0; j < dimension+1; j++) {
            tab[0][j] = j-1;
        }
        for (int i = 0; i < dimension+1; i++) {
            tab[i][0] = i-1;
        }
        tab[0][0]=0;
    }
    public void Afficher_tab(){
        System.out.println(" ");
        for(int i=0;i<dimension+1;i++){
            for(int j=0;j<dimension+1;j++){
                System.out.print(tab[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    public void Remplir_tab(){
        Remplir_index();
    for(int i=0;i<lecture_fichier.graphe.size();i++){
        tab[(lecture_fichier.graphe.get(i).dep)+1][(lecture_fichier.graphe.get(i).arr)+1]=1;
    }
    }
}
