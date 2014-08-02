
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FormationSecurity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FormationSecurity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="front" type="{}Security"/>
 *         &lt;element name="left" type="{}Security"/>
 *         &lt;element name="right" type="{}Security"/>
 *         &lt;element name="rear" type="{}Security"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormationSecurity", propOrder = {
    "front",
    "left",
    "right",
    "rear"
})
public class FormationSecurity {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Security front;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Security left;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Security right;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Security rear;

    /**
     * Obtiene el valor de la propiedad front.
     * 
     * @return
     *     possible object is
     *     {@link Security }
     *     
     */
    public Security getFront() {
        return front;
    }

    /**
     * Define el valor de la propiedad front.
     * 
     * @param value
     *     allowed object is
     *     {@link Security }
     *     
     */
    public void setFront(Security value) {
        this.front = value;
    }

    /**
     * Obtiene el valor de la propiedad left.
     * 
     * @return
     *     possible object is
     *     {@link Security }
     *     
     */
    public Security getLeft() {
        return left;
    }

    /**
     * Define el valor de la propiedad left.
     * 
     * @param value
     *     allowed object is
     *     {@link Security }
     *     
     */
    public void setLeft(Security value) {
        this.left = value;
    }

    /**
     * Obtiene el valor de la propiedad right.
     * 
     * @return
     *     possible object is
     *     {@link Security }
     *     
     */
    public Security getRight() {
        return right;
    }

    /**
     * Define el valor de la propiedad right.
     * 
     * @param value
     *     allowed object is
     *     {@link Security }
     *     
     */
    public void setRight(Security value) {
        this.right = value;
    }

    /**
     * Obtiene el valor de la propiedad rear.
     * 
     * @return
     *     possible object is
     *     {@link Security }
     *     
     */
    public Security getRear() {
        return rear;
    }

    /**
     * Define el valor de la propiedad rear.
     * 
     * @param value
     *     allowed object is
     *     {@link Security }
     *     
     */
    public void setRear(Security value) {
        this.rear = value;
    }

}
