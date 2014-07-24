
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Equipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Equipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="equipment-object-id" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qty" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Equipment")
public class Equipment {

    @XmlAttribute(name = "equipment-object-id")
    protected Short equipmentObjectId;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "qty")
    protected Short qty;

    /**
     * Gets the value of the equipmentObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getEquipmentObjectId() {
        return equipmentObjectId;
    }

    /**
     * Sets the value of the equipmentObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setEquipmentObjectId(Short value) {
        this.equipmentObjectId = value;
    }

    /**
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setQty(Short value) {
        this.qty = value;
    }

}
