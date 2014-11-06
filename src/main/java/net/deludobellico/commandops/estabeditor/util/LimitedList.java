package net.deludobellico.commandops.estabeditor.util;

import java.util.*;

/**
 * List with limited size, without duplicate elements, kind of imitating a queue.
 *
 * <p>New items are added to the first position. Existing items will be moved to the front.
 * If the maximum size is reached, any new insertion will remove the oldest item.</p>
 *
 * <p>This list uses a hashmap, so be sure to implement equals & hashCode if you're going to modify
 * the items inside the list.</p>
 *
 * Created by Heine on 10/29/2014.
 */

public class LimitedList<H> extends AbstractSequentialList<H> implements List<H> {
    int maxSize;
    int size;
    private Node first;
    private Node last;
    HashMap<H, Node> nodeMap;

    private class Node<H> {
        public H value;
        public Node<H> next;
        public Node<H> prev;

        public Node(H h) {
            this.value = h;
        }
    }

    private class ListItr implements ListIterator<H> {
        private Node<H> lastReturned;
        private Node<H> next;
        private int nextIndex;

        ListItr(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
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
            add(h);
            nextIndex++;
        }
    }

    public LimitedList(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        this.nodeMap = new HashMap<H, Node>(maxSize);
    }


    @Override
    public boolean add(H h) {
        Node n = nodeMap.get(h);
        if (n == null) {
            if (size() >= maxSize) unlink(last);
            linkFirst(new Node<H>(h));
        } else {
            if (n != first) {
                unlink(n);
                linkFirst(n);
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (nodeMap.get(o) == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends H> c) {
        for (H h : c) {
            add(h);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends H> c) {
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
        for (Object o : c) {
            if (!remove(o)) return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        HashMap m = new HashMap(nodeMap);
        clear();
        for (Object o : c) {
            if (m.get(o) != null) {
                add((H) o);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        nodeMap.clear();
        size = nodeMap.size();
        last = first = null;
    }

    @Override
    public H get(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);
        Node<H> n = first;
        for (int i = 0; i < index; ++i, n = n.next) {
        }
        return n.value;
    }

    @Override
    public H set(int index, H element) {
        Node n = nodeMap.get(element);
        add(element);
        return n == null ? null : (H) n.value;
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

    //TODO
    @Override
    public List<H> subList(int fromIndex, int toIndex) {
        return new LimitedList<>(maxSize);
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
        size++;
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
        size--;
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return nodeMap.get(o) == null;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size()];
        Node n = first;
        for (int i = 0; i < a.length; i++, n = n.next) {
            a[i] = n.value;
        }
        return a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        String delimiter = ", ";
        Node n = first;
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

    //// From the LinkedList class

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }


    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
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

        if (index < (size >> 1)) {
            Node<H> n = first;
            for (int i = 0; i < index; i++)
                n = n.next;
            return n;
        } else {
            Node<H> n = last;
            for (int i = size - 1; i > index; i--)
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

}