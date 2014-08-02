
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Equipment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad equipmentObjectId.
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
     * Define el valor de la propiedad equipmentObjectId.
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
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getQty() {
        return qty;
    }

    /**
     * Define el valor de la propiedad qty.
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