
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Armor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Armor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="front" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="side" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="rear" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="top" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Armor")
public class Armor {

    @XmlAttribute(name = "front")
    protected Float front;
    @XmlAttribute(name = "side")
    protected Float side;
    @XmlAttribute(name = "rear")
    protected Float rear;
    @XmlAttribute(name = "top")
    protected Float top;

    /**
     * Obtiene el valor de la propiedad front.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFront() {
        return front;
    }

    /**
     * Define el valor de la propiedad front.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFront(Float value) {
        this.front = value;
    }

    /**
     * Obtiene el valor de la propiedad side.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSide() {
        return side;
    }

    /**
     * Define el valor de la propiedad side.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSide(Float value) {
        this.side = value;
    }

    /**
     * Obtiene el valor de la propiedad rear.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRear() {
        return rear;
    }

    /**
     * Define el valor de la propiedad rear.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRear(Float value) {
        this.rear = value;
    }

    /**
     * Obtiene el valor de la propiedad top.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTop() {
        return top;
    }

    /**
     * Define el valor de la propiedad top.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTop(Float value) {
        this.top = value;
    }

}
