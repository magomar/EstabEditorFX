package net.deludobellico.estabeditorfx.util;

import java.util.*;

/**
 * List with limited size, without duplicate elements, kind of imitating a queue.
 * <p>
 * <p>New items are added to the first position. Existing items will be moved to the front.
 * If the maximum size is reached, any new insertion will remove the oldest item.</p>
 * <p>
 * <p>This list uses a @{code HashMap}, so be sure to implement equals & hashCode if you're going to modify
 * the items inside the list.</p>
 * <p>
 * Created by Heine on 10/29/2014.
 */

public class LimitedList<H> extends AbstractSequentialList<H> implements List<H> {
    private int maxSize;
    private HashMap<H, Node<H>> nodeMap;
    private Node<H> first;
    private Node<H> last;

    public LimitedList(int maxSize) {
        this.maxSize = maxSize;
        this.nodeMap = new HashMap<>(maxSize);
    }

    @Override
    public boolean add(H h) {
        Node<H> n = nodeMap.get(h);
        if (n == null) {
            if (size() >= maxSize) unlink(last);
            linkFirst(new Node<>(h));
        } else {
            if (n != first) {
                unlink(n);
                linkFirst(n);
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends H> c) {
        if (c == null) return false;
        addAll(c);
        return true;
    }

    @Override
    public ListIterator<H> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        for (Object o : c) {
            if (!remove(o)) return false;
        }
        return true;
    }

    @Override
    public void clear() {
        nodeMap.clear();
        last = first = null;
    }

    @Override
    public H set(int index, H element) {
        Node<H> n = nodeMap.get(element);
        add(element);
        return n == null ? null : n.value;
    }

    @Override
    public void add(int index, H element) {
        add(element);
    }

    @Override
    public H remove(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);
        return unlink(node(index));
    }

    @Override
    public int lastIndexOf(Object o) {
        return indexOf(o);
    }

    private void linkFirst(Node<H> n) {
        if (first == null) {
            last = first = n;
        } else {
            first.prev = n;
            n.next = first;
            n.prev = null;
            first = n;
        }
        nodeMap.put(n.value, n);
    }

    private H unlink(Node<H> n) {
        if (n == first) {
            first = first.next;
            if (first != null) first.prev = null;
        } else if (n == last) {
            last = last.prev;
            if (last != null) last.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        nodeMap.remove(n.value);
        return n.value;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<H> n = first; n != null; n = n.next) {
                if (n.value == null) {
                    unlink(n);
                    return true;
                }
            }
        } else {
            for (Node<H> n = first; n != null; n = n.next) {
                if (o.equals(n.value)) {
                    unlink(n);
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return nodeMap.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return nodeMap.containsKey(o);
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size()];
        Node<H> n = first;
        for (int i = 0; i < a.length; i++, n = n.next) {
            a[i] = n.value;
        }
        return a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        String delimiter = ", ";
        Node<H> n = first;
        while (n != null) {
            sb.append(n.value);
            sb.append(delimiter);
            n = n.next;
        }
        int lastDelimiter = sb.lastIndexOf(delimiter);
        if (lastDelimiter != -1) sb.replace(lastDelimiter, lastDelimiter + 1, "");
        sb.append("]");
        return sb.toString();
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size();
    }

    //// From the LinkedList class

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<H> node(int index) {
        // assert isElementIndex(index);

        if (index < (size() >> 1)) {
            Node<H> n = first;
            for (int i = 0; i < index; i++)
                n = n.next;
            return n;
        } else {
            Node<H> n = last;
            for (int i = size() - 1; i > index; i--)
                n = n.prev;
            return n;
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<H> n = first; n != null; n = n.next) {
                if (n.value == null)
                    return index;
                index++;
            }
        } else {
            for (Node<H> n = first; n != null; n = n.next) {
                if (o.equals(n.value))
                    return index;
                index++;
            }
        }
        return -1;
    }

    private class Node<K> {
        public K value;
        public Node<K> next;
        public Node<K> prev;

        public Node(K k) {
            this.value = k;
        }
    }

    private class ListItr implements ListIterator<H> {
        private Node<H> lastReturned;
        private Node<H> next;
        private int nextIndex;

        ListItr(int index) {
            next = (index == size()) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size();
        }

        @Override
        public H next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.value;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public H previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.value;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<H> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
        }

        @Override
        public void set(H h) {
            lastReturned.value = h;
        }

        @Override
        public void add(H h) {
            lastReturned = null;
            LimitedList.this.add(h);
            nextIndex++;
        }
    }

}