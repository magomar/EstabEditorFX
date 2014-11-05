package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Armor complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="Armor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="front" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="side" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="rear" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="top" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Armor")
public class Armor {

    @XmlAttribute(name = "front", required = true)
    protected double front;
    @XmlAttribute(name = "side", required = true)
    protected double side;
    @XmlAttribute(name = "rear", required = true)
    protected double rear;
    @XmlAttribute(name = "top", required = true)
    protected double top;

    /**
     * Obtiene el valor de la propiedad front.
     */
    public double getFront() {
        return front;
    }

    /**
     * Define el valor de la propiedad front.
     */
    public void setFront(double value) {
        this.front = value;
    }

    /**
     * Obtiene el valor de la propiedad side.
     */
    public double getSide() {
        return side;
    }

    /**
     * Define el valor de la propiedad side.
     */
    public void setSide(double value) {
        this.side = value;
    }

    /**
     * Obtiene el valor de la propiedad rear.
     */
    public double getRear() {
        return rear;
    }

    /**
     * Define el valor de la propiedad rear.
     */
    public void setRear(double value) {
        this.rear = value;
    }

    /**
     * Obtiene el valor de la propiedad top.
     */
    public double getTop() {
        return top;
    }

    /**
     * Define el valor de la propiedad top.
     */
    public void setTop(double value) {
        this.top = value;
    }

}
