import com.sun.source.tree.Tree;
import java.util.TreeSet;
import java.util.HashSet;

public class BenchmarkSets {
        public static void main(String[] args){
            int n = 10000;

            HashSet<Integer> hashSet = new HashSet<>();
            long startHashAdd = System.nanoTime();
            for(int i = 0; i<n; i++){
                hashSet.add(i);
            }

            long endHashAdd = System.nanoTime();

            TreeSet<Integer> treeSet = new TreeSet<>();
            long startTreeAdd = System.nanoTime();
            for(int i = 0; i<n; i++){
                treeSet.add(i);
            }

            long endTreeAdd = System.nanoTime();

            System.out.println("HashSet:" + (endHashAdd - startHashAdd) + "наносекунд" );
            System.out.println("TreeSet:" + (endTreeAdd - startTreeAdd) + "наносекунд" );


            long startHashGet = System.nanoTime();
            for(int i = 0; i<n; i++){
                hashSet.contains(i);
            }
            long endHashGet = System.nanoTime();


            long startTreeGet = System.nanoTime();
            for(int i = 0; i<n; i++){
                hashSet.contains(i);
            }
            long endTreeGet = System.nanoTime();


            System.out.println("HashSet:" + (endHashGet - startHashGet) + "наносекунд" );
            System.out.println("TreeSet:" + (endTreeGet - startTreeGet) + "наносекунд" );
        }
}
