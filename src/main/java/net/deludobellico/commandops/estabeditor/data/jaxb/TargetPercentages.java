package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TargetPercentages complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="TargetPercentages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="front" type="{}Proportion"/>
 *         &lt;element name="left" type="{}Proportion"/>
 *         &lt;element name="right" type="{}Proportion"/>
 *         &lt;element name="rear" type="{}Proportion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetPercentages", propOrder = {
        "front",
        "left",
        "right",
        "rear"
})
public class TargetPercentages {

    protected double front;
    protected double left;
    protected double right;
    protected double rear;

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
     * Obtiene el valor de la propiedad left.
     */
    public double getLeft() {
        return left;
    }

    /**
     * Define el valor de la propiedad left.
     */
    public void setLeft(double value) {
        this.left = value;
    }

    /**
     * Obtiene el valor de la propiedad right.
     */
    public double getRight() {
        return right;
    }

    /**
     * Define el valor de la propiedad right.
     */
    public void setRight(double value) {
        this.right = value;
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

}
