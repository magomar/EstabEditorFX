
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TargetPercentages complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetPercentages", propOrder = {
    "front",
    "left",
    "right",
    "rear"
})
public class TargetPercentages {

    protected float front;
    protected float left;
    protected float right;
    protected float rear;

    /**
     * Obtiene el valor de la propiedad front.
     * 
     */
    public float getFront() {
        return front;
    }

    /**
     * Define el valor de la propiedad front.
     * 
     */
    public void setFront(float value) {
        this.front = value;
    }

    /**
     * Obtiene el valor de la propiedad left.
     * 
     */
    public float getLeft() {
        return left;
    }

    /**
     * Define el valor de la propiedad left.
     * 
     */
    public void setLeft(float value) {
        this.left = value;
    }

    /**
     * Obtiene el valor de la propiedad right.
     * 
     */
    public float getRight() {
        return right;
    }

    /**
     * Define el valor de la propiedad right.
     * 
     */
    public void setRight(float value) {
        this.right = value;
    }

    /**
     * Obtiene el valor de la propiedad rear.
     * 
     */
    public float getRear() {
        return rear;
    }

    /**
     * Define el valor de la propiedad rear.
     * 
     */
    public void setRear(float value) {
        this.rear = value;
    }

}
