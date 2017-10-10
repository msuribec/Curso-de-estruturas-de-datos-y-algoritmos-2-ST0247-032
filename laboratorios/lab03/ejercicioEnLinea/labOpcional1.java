import java.util.*;
// punto opcional FunnyGame
public class lab {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nCont, origen;
        Scanner sc = new Scanner(System.in);
        System.out.println();            
        nCont = sc.nextInt();
        origen = sc.nextInt();
        --origen;
        Vector<Integer>[] List = (Vector<Integer>[]) new Vector[1000];
        for(int i =0; i < List.length; i++){
            List[i] = new Vector<Integer>();
        }
        //Vector<Integer> List = new Vector<>();
        for (int i = 1, j , k; i < nCont; i++) {
            j = sc.nextInt();
			k = sc.nextInt();
			--j;--k;
            List[j].add(k); 
            List[k].add(j);
        }
        int[] Q = new int[1000];
        int cola = 0;
        int[] parent = new int[1000];
        Arrays.fill(parent, -1);
        Q[cola] = origen;
        ++cola;
        parent[origen] = -2;
        for (int i = 0; i < nCont; ++i) {
            int cur = Q[i];
            for (int j = List[cur].size()-1; j >= 0; --j) {
                int next = List[cur].get(j);

                if (parent[next] == -1) {
                    Q[cola] = next;
                    ++cola;
                    parent[next] = cur;
                }
            }
        }
        boolean[] win = new boolean[1000];
        for (int i = nCont - 1; i >= 0; --i) {
            int cur = Q[i];
            win[cur] = false;
            for (int j = List[cur].size() - 1; j >= 0; --j) {
                int next = List[cur].get(j);
                if (parent[next] == cur && !win[next])
                    win[cur] = true;
            }
        }
        if (!win[origen]) {
            System.out.println("First player losesn");
        } else {
            int seleccionar = nCont + 1;
            for (int i = List[origen].size() - 1; i >= 0; --i) {
                int next = List[origen].get(i);
                if (parent[next] == origen && !win[next] && next < seleccionar)
                    seleccionar = next;
            }
            ++seleccionar;
            System.out.println("First player wins flying to airpot "+ seleccionar);
        }
	}	
}
