
package net.deludobellico.stabeditor.data.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Side complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Side">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="large-insignia" type="{}Insignia"/>
 *         &lt;element name="small-insignia" type="{}Insignia"/>
 *         &lt;element name="basics-consumption-rate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="default-enemy-aper-fp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="default-enemy-aarm-fp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nation" type="{}Nation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Side", propOrder = {
    "name",
    "description",
    "largeInsignia",
    "smallInsignia",
    "basicsConsumptionRate",
    "defaultEnemyAperFp",
    "defaultEnemyAarmFp",
    "nation"
})
public class Side {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "large-insignia", required = true)
    protected Insignia largeInsignia;
    @XmlElement(name = "small-insignia", required = true)
    protected Insignia smallInsignia;
    @XmlElement(name = "basics-consumption-rate")
    protected float basicsConsumptionRate;
    @XmlElement(name = "default-enemy-aper-fp")
    protected int defaultEnemyAperFp;
    @XmlElement(name = "default-enemy-aarm-fp")
    protected int defaultEnemyAarmFp;
    protected List<Nation> nation;
    @XmlAttribute(name = "id", required = true)
    protected int id;

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
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad largeInsignia.
     * 
     * @return
     *     possible object is
     *     {@link Insignia }
     *     
     */
    public Insignia getLargeInsignia() {
        return largeInsignia;
    }

    /**
     * Define el valor de la propiedad largeInsignia.
     * 
     * @param value
     *     allowed object is
     *     {@link Insignia }
     *     
     */
    public void setLargeInsignia(Insignia value) {
        this.largeInsignia = value;
    }

    /**
     * Obtiene el valor de la propiedad smallInsignia.
     * 
     * @return
     *     possible object is
     *     {@link Insignia }
     *     
     */
    public Insignia getSmallInsignia() {
        return smallInsignia;
    }

    /**
     * Define el valor de la propiedad smallInsignia.
     * 
     * @param value
     *     allowed object is
     *     {@link Insignia }
     *     
     */
    public void setSmallInsignia(Insignia value) {
        this.smallInsignia = value;
    }

    /**
     * Obtiene el valor de la propiedad basicsConsumptionRate.
     * 
     */
    public float getBasicsConsumptionRate() {
        return basicsConsumptionRate;
    }

    /**
     * Define el valor de la propiedad basicsConsumptionRate.
     * 
     */
    public void setBasicsConsumptionRate(float value) {
        this.basicsConsumptionRate = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultEnemyAperFp.
     * 
     */
    public int getDefaultEnemyAperFp() {
        return defaultEnemyAperFp;
    }

    /**
     * Define el valor de la propiedad defaultEnemyAperFp.
     * 
     */
    public void setDefaultEnemyAperFp(int value) {
        this.defaultEnemyAperFp = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultEnemyAarmFp.
     * 
     */
    public int getDefaultEnemyAarmFp() {
        return defaultEnemyAarmFp;
    }

    /**
     * Define el valor de la propiedad defaultEnemyAarmFp.
     * 
     */
    public void setDefaultEnemyAarmFp(int value) {
        this.defaultEnemyAarmFp = value;
    }

    /**
     * Gets the value of the nation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nation }
     * 
     * 
     */
    public List<Nation> getNation() {
        if (nation == null) {
            nation = new ArrayList<Nation>();
        }
        return this.nation;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}
