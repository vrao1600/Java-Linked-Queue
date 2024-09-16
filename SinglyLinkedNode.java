package DataStructures;

public class SinglyLinkedNode<T> {
  private T data;
  private SinglyLinkedNode<T> next;

  /**
   * @param data
   */
  public SinglyLinkedNode(T data) {
    this.data = data;
  }

  /**
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * @return the next
   */
  public SinglyLinkedNode<T> getNext() {
    return next;
  }

  /**
   * @param next the next to set
   */
  public void setNext(SinglyLinkedNode<T> next) {
    this.next = next;
  }
}
