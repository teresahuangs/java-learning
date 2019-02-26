class Link {
  public int iData;
  public Link next;

  public Link(int id) {
    iData = id;
  }

  public String toString() {
    return "{" + iData + "} ";
  }
}

class SortedList {
  private Link first;

  public SortedList() {
    first = null;
  }

  public boolean isEmpty() {
    return (first == null);
  }

  public void insert(int key) {
    Link newLink = new Link(key);
    Link previous = null;
    Link current = first;

    while (current != null && key > current.iData) {
      previous = current;
      current = current.next;
    }
    if (previous == null)
      first = newLink;
    else
      previous.next = newLink;
    newLink.next = current;
  }

  public Link remove() {
    Link temp = first;
    first = first.next;
    return temp;
  }

  public String toString() {
    String str = "";
    Link current = first;
    while (current != null) {
      str += current.toString();
      current = current.next;
    }
    return str;
  }
}

public class SortedListExample {
  public static void main(String[] args) {
    SortedList theSortedList = new SortedList();
    theSortedList.insert(20);
    theSortedList.insert(40);

    System.out.println(theSortedList);

    theSortedList.insert(10);
    theSortedList.insert(30);
    theSortedList.insert(50);

    System.out.println(theSortedList);

    theSortedList.remove();

    System.out.println(theSortedList);
  }
}