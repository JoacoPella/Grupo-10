package TPCaballo;

import java.util.Arrays;
import java.util.Stack;

public class Horse {
    int current_positionx;
    int current_positiony;
    Stack<String>[] movepiles;
    String current_cordXY;
    int movements;

    Horse(String position, int movements){
        this.current_positiony = CordXY.toy(position);
        this.current_positionx = CordXY.tox(position);
        this.current_cordXY = position;
        this.movepiles = (Stack<String>[]) new Stack[movements];
        this.movements = movements;
        for (int i = 0; i < movepiles.length; i++) {
            this.movepiles[i] = new Stack<String>();
        }
        for (int i = 0; i<possible_moves(this.current_cordXY).length ; i++) {
            this.movepiles[0].push(possible_moves(this.current_cordXY)[i]);
        }
        fillpiles();
    }

    public String[] possible_moves(String position){
        String[] possible_moves=new String[8];
        int[] X_moves={2,2,-2,-2,1,1,-1,-1};
        int[] y_moves={1,-1,1,-1,2,-2,2,-2};
        int positionx = CordXY.tox(position);
        int positiony = CordXY.toy(position);

        for (int i = 0; i < 8; i++) {
            int x_position=positionx+ X_moves[i];
            int y_position=positiony+ y_moves[i];

            if (x_position>=1 && x_position<=8 && y_position>=1 && y_position<=8){
                possible_moves[i] = CordXY.toCordXY(x_position,y_position);}
        }
        int number_of_possible_moves=0;
        int i=0;
        while (i<8){
            if (possible_moves[i]!=null)
                number_of_possible_moves++;
            i++;
        }
        String[] actual_possible_moves = new String[number_of_possible_moves];
        int positioni = 0;
        for (int j = 0; j < 8 ; j++) {
            if(possible_moves[j]!=null){
                actual_possible_moves[positioni]=possible_moves[j];
                positioni++;}
        }
        return actual_possible_moves;}

    public void fillpiles(){ //rellena cualquier pila que encunetre vacia, con los momvimientos possibles del tope de la anterior.
        for (int i = 1; i < this.movepiles.length; i++) {
            if (this.movepiles[i].empty()){
                String cordXY =this.movepiles[i-1].peek();
                for (int j = 0; j < possible_moves(cordXY).length; j++) {
                    this.movepiles[i].push(possible_moves(cordXY)[j]);
                }
            }
        }
    }

    public boolean looper(){
        for (int j = 0; j < 10; j--) {

            for (int i = 0; i < this.movepiles[this.movements - 1].size(); i++) {
                printer();
                this.movepiles[this.movements - 1].pop();
            }
            int n = this.movements - 1;
            for (int i = 0; i < n; i++) {
                if (this.movepiles[n].size() != 0) {
                    this.movepiles[n].pop();
                    if(this.movepiles[n].size() == 0) {
                        boolean checker = false;
                        n--;
                        while (checker == false){
                            if (this.movepiles[n].size() == 1){
                                this.movepiles[n].pop();
                                n--;
                            }
                            if(n == -1){
                                return true;
                            }
                            if (this.movepiles[n].size() != 1){
                                this.movepiles[n].pop();
                                checker = true;
                            }
                            if (this.movepiles[0].size() == 0) {
                                return true;
                            }
                        }
                    }
                    fillpiles();
                } else {
                    n--;
                }
            }
        }
        return false;
    }


    public void showPiles(){
        for (int i = 0; i < movepiles.length; i++) {
            System.out.println(this.movepiles[i].toString());
        }
    }

    public void printer(){
        String[] arreglo= new String[this.movements];
        for (int i = 0; i < this.movements; i++) {
            arreglo[i]=this.movepiles[i].peek();
        }
        System.out.println(this.current_cordXY + " " + Arrays.deepToString(arreglo).replaceAll("\\[|\\]|,", ""));
    }

}

