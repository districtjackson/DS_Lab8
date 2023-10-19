public class Queue<T>
{
	private class Node<T>{
		T val;
		Node<T> next;
		
		Node(T val, Node<T> next){
			this.val = val;
			this.next = next;
		}
	}
	
	protected Node<T> front;
	protected Node<T> back;
    //be sure that your attributes are protected, so subclasses can use them


   public Queue()
   {
	   front = null;
	   back = null;
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   Node<T> temp = new Node<T>(val, null);
	   
	   if(isEmpty()) {
		   front = temp;
	   }else{
		   back.next = temp;
	   }
	   
	   back = temp;
	   
	   
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop() throws QueueUnderFlowException
   {
       if(isEmpty()) {
    	   throw new QueueUnderFlowException();
       }
       
       T val = front.val;
       front = front.next;
       return val;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       return front == null;
   }




}
