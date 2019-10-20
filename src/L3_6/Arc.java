package L3_6;


public class Arc {
    int dep;
    int arr;
    int val;


    public Arc(int dep, int val, int arr) {
        this.dep = dep;
        this.arr = arr;
        this.val = val;
    }

    @Override
    public String toString() {
        return dep+" "+val+" "+arr;
    }
}
