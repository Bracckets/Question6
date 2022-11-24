import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>>
{
   protected Comparable array[];
   int count;
	  
   public BinaryHeap(int i)
   {
      array = new Comparable[i + 1];
   }
    
   public BinaryHeap(Comparable[] comparable) 
   {
      this(comparable.length);
   	for(int i = 0; i < comparable.length; i++)
         array[i + 1] = comparable[i];
    	   
      count = comparable.length;
   	
      buildHeapTopDown();
      //buildHeapBottomUp();
   }
	
   private void buildHeapBottomUp()
   {
      for(int i = count / 2; i >= 1; i--)
         percolateDown(i);
   }
	
   private void buildHeapTopDown()
   {

      for(int i= 1; i <= count; i++){
         percolateUp(i);
      }
   }
	
	private void percolateDown(int index) {
      int minChild;
      Comparable temp = array[index];

      while(index * 2 <= count){
         minChild = index * 2;
         if(minChild + 1 <= count && array[minChild + 1].compareTo(array[minChild])<0)
            minChild++;

         if(array[minChild].compareTo(temp)<0){
            array[index] = array[minChild];

            index = minChild;
         }
         else
            break;
      }
      array[index] = temp;
   }
	
   private void percolateUp(int index)
   {
      Comparable x = array[index];
      while (index > 1 && x.compareTo(array[index / 2]) < 0) {

         array[index] = array[index / 2];
         index /= 2;
      }
      array[index] = x;
   }
	
   public void purge()
   {
      while(count > 0) 
         array[count--] = null;
   }

   public void enqueue(Comparable comparable)
   {

      int index = ++count;
      //percolate up via a gap
     while(index > 1 && array[index / 2].compareTo(comparable) > 0)
      {
         System.out.println(1);
         array[index] = array[index / 2];
         index = index / 2;

      }
     array[index] = comparable;
   }

   public Comparable findMin()
   {
      return array[1];
   }

   public Comparable dequeueMin()
   {
      Comparable minItem = array[1];
      array[1] = array[count];
      count--;
      percolateDown(1);
      return minItem;
   }
    
   public Comparable[] heapSort() 
   {
      Comparable[] x = new Comparable[count];
      int total = count;
      for(int i = 0; i < total; i++) {
         x[i] = dequeueMin();    		
      }
   return x;
   }
    
    
   public boolean isFull()
   {
      return count == array.length - 1;
   }
    
   public boolean isEmpty() 
   {
      return count == 0;
   }
    
   public String toString()
   {
      Comparable[] tempArray = new Comparable[array.length - 1];
    	System.arraycopy(array, 1, tempArray, 0, array.length - 1);
    	return Arrays.toString(tempArray);
   }

   public static Boolean isMinHeap(Comparable[] heap){
      int h = heap.length - 1;

      for (int i = (h/ 2 - 1); i >= 0; i--){

         //Checking Right child
         if (heap[i].compareTo(heap[2 * i + 1]) == 1)
            return false;
         //Checking Left Child
         if (2 * i + 2 < h) {
            if (heap[i].compareTo(heap[2 * i + 2]) == 1)
               return false;
         }


      }
      return true;
   }

}
