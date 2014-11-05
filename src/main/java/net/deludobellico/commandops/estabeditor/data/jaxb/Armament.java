
package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Armament complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Armament">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="equipment-object-id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="equipment-name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qty" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Armament")
public class Armament {

    @XmlAttribute(name = "equipment-object-id", required = true)
    protected int equipmentObjectId;
    @XmlAttribute(name = "equipment-name", required = true)
    protected String equipmentName;
    @XmlAttribute(name = "qty", required = true)
    protected int qty;

    /**
     * Obtiene el valor de la propiedad equipmentObjectId.
     * 
     */
    public int getEquipmentObjectId() {
        return equipmentObjectId;
    }

    /**
     * Define el valor de la propiedad equipmentObjectId.
     * 
     */
    public void setEquipmentObjectId(int value) {
        this.equipmentObjectId = value;
    }

    /**
     * Obtiene el valor de la propiedad equipmentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * Define el valor de la propiedad equipmentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipmentName(String value) {
        this.equipmentName = value;
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
