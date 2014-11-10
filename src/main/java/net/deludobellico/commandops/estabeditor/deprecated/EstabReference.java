package net.deludobellico.commandops.estabeditor.deprecated;

import javax.xml.bind.JAXBElement;

/**
 * Created by mario on 30-Jul-14.
 */
@Deprecated
public class EstabReference<T> {
    private int id;
    private String name;
    private JAXBElement<T> jaxbElement;
    private Class<T> elementClass;

    public EstabReference(int id, String name, JAXBElement<T> jaxbElement, Class<T> elementClass) {
        this.id = id;
        this.name = name;
        this.jaxbElement = jaxbElement;
        this.elementClass = elementClass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public JAXBElement<T> getJaxbElement() {
        return jaxbElement;
    }

    public T getElement() {
        return jaxbElement.getValue();
    }

    public Class<T> getElementClass() {
        return elementClass;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstabReference that = (EstabReference) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
