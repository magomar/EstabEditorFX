package net.deludobellico.commandops.estabeditor.model;

import javax.xml.bind.JAXBElement;

/**
 * Created by mario on 30-Jul-14.
 */
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
    public int hashCode() {
        // TODO hasCode based on the wrapped element
        return super.hashCode();
    }
}
