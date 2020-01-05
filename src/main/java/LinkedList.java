public class LinkedList<T> {
    private T element;
    private LinkedList<T> next;

    public LinkedList(T element, LinkedList<T> next){
        this.element = element;
        this.next = next;
    }

    public T getElement(){
        return element;
    }

    public LinkedList<T> getNext(){
        return next;
    }

    public static <T> LinkedList<T> reverse(LinkedList<T> original){
        if(original == null){
            throw new NullPointerException("Cannot reverse a null list");
        }

        if(original.getNext() == null)
            return original;

        LinkedList<T> next = original.getNext();
        original.next = null;

        LinkedList<T> otherReversed = reverse(next);

        next.next = original;


        return otherReversed;
    }

    public static void main(String[] args) {
        LinkedList<String> three = new LinkedList("3",null);
        LinkedList<String> two = new LinkedList("2",three);
        LinkedList<String> one = new LinkedList("1",two);

        LinkedList<String> reversed = LinkedList.reverse(one);

        System.out.println(reversed.getElement());
        System.out.println(reversed.getNext().getElement());
        System.out.println(reversed.getNext().getNext().getElement());
    }

}
