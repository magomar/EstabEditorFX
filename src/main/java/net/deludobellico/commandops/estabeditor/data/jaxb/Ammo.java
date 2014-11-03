package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Ammo complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Ammo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="min-order-qty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="min-order-weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ammo", propOrder = {
        "name",
        "description",
        "minOrderQty",
        "minOrderWeight"
})
public class Ammo {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "min-order-qty")
    protected int minOrderQty;
    @XmlElement(name = "min-order-weight")
    protected double minOrderWeight;
    @XmlAttribute(name = "id", required = true)
    protected int id;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the minOrderQty property.
     */
    public int getMinOrderQty() {
        return minOrderQty;
    }

    /**
     * Sets the value of the minOrderQty property.
     */
    public void setMinOrderQty(int value) {
        this.minOrderQty = value;
    }

    /**
     * Gets the value of the minOrderWeight property.
     */
    public double getMinOrderWeight() {
        return minOrderWeight;
    }

    /**
     * Sets the value of the minOrderWeight property.
     */
    public void setMinOrderWeight(double value) {
        this.minOrderWeight = value;
    }

    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

}
