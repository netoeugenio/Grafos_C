import java.util.Iterator;
import java.util.NoSuchElementException;


public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first; // início da lista
    private int n;            // quantidade de elementos

    // Classe interna que representa cada nó da lista
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    // Construtor: inicia bag vazia
    public Bag() {
        first = null;
        n = 0;
    }

    // Verifica se está vazia
    public boolean isEmpty() {
        return first == null;
    }

    // Retorna quantidade de elementos
    public int size() {
        return n;
    }

 
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    // Permite usar for-each
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // Iterador da lista
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}