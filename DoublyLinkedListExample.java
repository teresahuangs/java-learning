/**
* The program implements doubly linked list and demonstrate how it works
*
* @author  Teresa Huang
* @version 1.0
* @since   2018-07-15 
*/

class Node {
  public int iData;
  public Node next;
  public Node previous;

  public Node(int id) {
    iData = id;
  }

  public String toString() {
    return "{" + iData + "} ";
  }
}

class DoublyLinkedList {
  private Node first;
  private Node last;

  public DoublyLinkedList() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void insertFirst(int dd) {
    Node newNode = new Node(dd);
    if (isEmpty()){
      last = newNode;
    }else{
      first.previous = newNode;
    }
    newNode.next = first;
    first = newNode;
  }

  public void insertLast(int dd) {
    Node newNode = new Node(dd);
    if (isEmpty()){
      first = newNode;
    }else {
      last.next = newNode;
      newNode.previous = last;
    }
    last = newNode;
  }

  public Node deleteFirst() {
    Node temp = first;
    if (first.next == null){
      last = null;
    }else{
      first.next.previous = null;
    }
    first = first.next;
    return temp;
  }

  public Node deleteLast() {
    Node temp = last;
    if (first.next == null){
      first = null;
    }else{
      last.previous.next = null;
    }
    last = last.previous;
    return temp;
  }

  public boolean insertAfter(int key, int dd) {
    Node current = first;
    while (current.iData != key) {
      current = current.next;
      if (current == null){
        return false;
      }
    }
    Node newNode = new Node(dd);

    if (current == last) {
      newNode.next = null;
      last = newNode;
    } else {
      newNode.next = current.next;

      current.next.previous = newNode;
    }
    newNode.previous = current;
    current.next = newNode;
    return true;
  }

  public Node deleteKey(int key) {
    Node current = first;
    while (current.iData != key) {
      current = current.next;
      if (current == null)
        return null;
    }
    if (current == first){
      first = current.next;
    }else{
      current.previous.next = current.next;
    }
    
    if (current == last){
      last = current.previous;
    }else{
      current.next.previous = current.previous;
    }
    return current;
  }

  public String toString() {
    String str = "List (first-->last): List (last-->first): ";
    Node current = first;
    while (current != null) {
      str += current.toString();
      current = current.next;
    }

    current = last;
    while (current != null) {
      str += current.toString();
      current = current.previous;
    }
    return str;
  }
}

public class DoublyLinkedListExample {
  public static void main(String[] args) {
    DoublyLinkedList theList = new DoublyLinkedList();

    theList.insertFirst(22);
    theList.insertFirst(44);
    theList.insertFirst(66);

    theList.insertLast(11);
    theList.insertLast(33);
    theList.insertLast(55);

    System.out.println(theList);

    theList.deleteFirst();
    theList.deleteLast();
    theList.deleteKey(11);

    System.out.println(theList);

    theList.insertAfter(22, 77);
    theList.insertAfter(33, 88);

    System.out.println(theList);
  }
}