import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
  // Un nodo para una lista simplemente enlazada
  class Node {
     public int data;
     public Node next;
     public Node(int data)
     {
        next = null;
          this.data = data;
     }  
  }
  
private Node first;
private int size;
public LinkedListMauricio()
{
    size = 0;
    first = null;   
}


    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next; 
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return temp.data;
    }

// Retorna el tamaño actual de la lista
public int size() // O(1)
{
    return this.size;
}

// Inserta un dato en la posición index
public void insert(int data, int index)
{
    Node n = new Node(data);
    if(index==0){
        n.next=first;
        first=n;
        
    }else {
        Node cont=this.getNode(index-1);
        n.next=cont.next;
        cont.next=n;
    }
    size++;
}
// Borra el dato en la posición index
public void remove(int index)
{
    if(index==0){
    first=this.getNode(index+1);
    }else{
    Node cont= this.getNode(index-1);
    cont.next= this.getNode(index).next;
    }
    size--;
}

// Verifica si está un dato en la lista
public boolean contains(int dato)
{
    Node temp=first;
    for(int i=0;i<size;i++){
    if(temp.data==dato){
    return true;
    }else{}
    temp=temp.next;
    }
    return false;
}

}
