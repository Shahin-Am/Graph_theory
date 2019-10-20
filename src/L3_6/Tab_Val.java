package L3_6;
@SuppressWarnings("Duplicates")

public class Tab_Val {
    int dimension;
    static String tab[][];

    public Tab_Val(int dimension) {
        this.dimension = dimension;
        tab=new String[dimension+1][dimension+1];
    }

    public void Remplir_index() {

        for (int j = 0; j < dimension+1; j++) {
            tab[0][j] = Integer.toString(j-1);
        }
        for (int i = 0; i < dimension+1; i++) {
            tab[i][0] = Integer.toString(i-1);
        }
        tab[0][0]=Integer.toString(0);
    }

    public void Initialisation(){
        for(int i=1;i<lecture_fichier.getDimension()+1;i++){
            for(int j=1;j<lecture_fichier.getDimension()+1;j++){
                tab[i][j]="-";
            }
        }
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
        Initialisation();
        for(int i=0;i<lecture_fichier.graphe.size();i++){
            tab[(lecture_fichier.graphe.get(i).dep)+1][(lecture_fichier.graphe.get(i).arr)+1]=Integer.toString(lecture_fichier.graphe.get(i).val);
        }
    }
}
