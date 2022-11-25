import java.util.Scanner;

public class MinHeapTest {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int numOfNodes = s.nextInt();
        Comparable[] c = new Comparable[numOfNodes + 1];



        for (int i = 1; i <= numOfNodes; i++){
            System.out.printf("Enter node number %d: ", i);
            c[i] = s.nextInt();
        }

        for (int i = 1; i <= numOfNodes; i++){
            System.out.print(c[i] + " ");

        }

        if(BinaryHeap.isMinHeap(c))
            System.out.println("The array is a min-heap");
        else
            System.out.println("The array is not a min-heap");

    }
}
