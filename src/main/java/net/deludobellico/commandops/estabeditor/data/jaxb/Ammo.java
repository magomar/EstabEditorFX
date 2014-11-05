package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para Ammo complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad name.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad minOrderQty.
     */
    public int getMinOrderQty() {
        return minOrderQty;
    }

    /**
     * Define el valor de la propiedad minOrderQty.
     */
    public void setMinOrderQty(int value) {
        this.minOrderQty = value;
    }

    /**
     * Obtiene el valor de la propiedad minOrderWeight.
     */
    public double getMinOrderWeight() {
        return minOrderWeight;
    }

    /**
     * Define el valor de la propiedad minOrderWeight.
     */
    public void setMinOrderWeight(double value) {
        this.minOrderWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     */
    public void setId(int value) {
        this.id = value;
    }

}
