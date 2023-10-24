import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
       Node<T> pushed = new Node<>(val, null);
       
       if(isEmpty()) {
    	   front = pushed;
    	   back = pushed;
    	   return;
       }
       
       Node<T> previous = front;
       Node<T> current = front;
       
       while(current != null){
    	   int comparison = compare.compare(pushed.val, current.val);
    	   
    	   if(comparison > 0) {

    		   if(current == front) {
    		   	pushed.next = front;
	    		front = pushed;
    		   }else {
    			   pushed.next = current;
    			   previous.next = pushed;
    		   }
    		   return;
    	   }
    	   
    	   previous = current;
    	   current = current.next;
    	   
    	   System.out.println(current);
       }
       
       back.next = pushed;
   }


}
