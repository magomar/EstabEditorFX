
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ForceQty complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ForceQty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="force-object-id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qty" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForceQty")
public class ForceQty {

    @XmlAttribute(name = "force-object-id", required = true)
    protected int forceObjectId;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "qty", required = true)
    protected int qty;

    /**
     * Obtiene el valor de la propiedad forceObjectId.
     * 
     */
    public int getForceObjectId() {
        return forceObjectId;
    }

    /**
     * Define el valor de la propiedad forceObjectId.
     * 
     */
    public void setForceObjectId(int value) {
        this.forceObjectId = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad qty.
     * 
     */
    public int getQty() {
        return qty;
    }

    /**
     * Define el valor de la propiedad qty.
     * 
     */
    public void setQty(int value) {
        this.qty = value;
    }

}
