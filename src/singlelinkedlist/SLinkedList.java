
package singlelinkedlist;

public class SLinkedList {
    
    
    private Node head;
    private Node tail;
    private int size;
     
    public SLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }


    public boolean isEmpty() {
        if (head == null && tail == null ) {  // size == 0
            return true;
        } else {
            return false;
        }
    }
    
    public void addFirst(Node e){
        if (isEmpty()) {
            head = e;
            tail = e;
            size++;
        } else {
            e.next = head;
            head = e;
            size++;
        }
    }
     
     
    public Node RemoveFirst(){
        if(isEmpty()) {
            return null;
        } 
        else if (size == 1) {
         Node temp = null;
         temp = head;
         head = null;
         tail = null;
         size--;
         return temp;
        } else {
            Node temp = null;
            temp = head;
            head = head.next;
            temp.next = null;
            size--;
            return temp;
        }
    }
     
    public void addLast(Node e){
        if (isEmpty()) {
            head = e;
            tail = e;
            size++;
        }
        else{
            tail.next = e;
            tail = tail.next;
            size++;
        }
    }
     
    public Node RemoveLast(){
        if(isEmpty()) {
            return null;
        } else if (size == 1) {
         Node temp = null;
         temp = tail;
         head = null;
         tail = null;
         size--;
         return temp;
        }
        else {
            Node temp = null;
            Node i = null;
            temp = tail;
            i= head;
            while(i.next != tail){
                i= i.next;
            }
            tail=i;
            tail.next = null;
            size--;
            return temp;
        }
    }
    
    public void addAfter(int valBefore,Node e){
        if (isEmpty()){
            System.out.println("The value is NOT exist!");
        }else {
            Node i = null;
            Node t = null;
            i = head;
            while(i.data != valBefore){ //search
                i = i.next;
            }
            if (i.data == valBefore && i != tail) {
                t = i.next;
                e.next = t;
                i.next = e;
                size++;
            }
            if (i.data != valBefore && i == tail) {
                addLast(e);
            }
        }
    }
     

     

     
    public Node RemoveMiddle(int valDeleted){
        if (isEmpty()) {
            return null;
        }else{
            Node temp = null;
            Node i = null;
            Node t = null;
            temp = head;
            while(temp.data != valDeleted){
                temp = temp.next;
            }
            if (temp.data == valDeleted && temp == head) { 
                temp = RemoveFirst();
            }else if (temp.data == valDeleted && temp == tail) {
                temp = RemoveLast();
            }else if (temp.data == valDeleted) {
                i = head;
                while(i.next != temp){
                    i = i.next;
                }
                    t = temp.next;
                    i.next = t;
                    temp.next = null;
                    size--;
            } else{
                return null; 
            }
            return temp;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("No elements to Print");
        } else {
            Node temp = null;
            temp = head;
            while(temp != null) {
                System.out.println(temp); // will print its toString
                temp = temp.next;
            }
        }
    }

    public void search(int val) {
        if (isEmpty()) {
            System.out.println("No elements! the list is empty");
        } else {
            Node temp = null;
            temp = head;
            while(temp.data != val && temp.next != null) {
                temp = temp.next;
            }
            if (temp.data == val) {
                System.out.println("The value exist");
            } else {
                System.out.println("The value does not exist");
            }
        }
    }
}
