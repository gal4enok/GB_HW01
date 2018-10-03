import java.util.List;

public class Array {
    private List<Integer> list;

    public List<Integer> getList(){return list;}
    public void setList(List<Integer> list) {this.list = list;}

    public void add(int i){
        this.list.add(i);
    }

    public int coundEvenNumbers(){
        int count = 0;

        for(int i=0; i<list.size(); i++){
            if (list.get(i)%2 ==0) count ++;
        }
        return count;
    }
}
