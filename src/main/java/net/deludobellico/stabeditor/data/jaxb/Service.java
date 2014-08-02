
package net.deludobellico.stabeditor.data.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Service complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Service">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="large-insignia" type="{}Insignia"/>
 *         &lt;element name="small-insignia" type="{}Insignia"/>
 *         &lt;element name="rank-list" type="{}RankList"/>
 *         &lt;element name="default-icon-colors" type="{}DefaultIconColors"/>
 *         &lt;element name="force" type="{}Force" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Service", propOrder = {
    "name",
    "description",
    "largeInsignia",
    "smallInsignia",
    "rankList",
    "defaultIconColors",
    "force"
})
public class Service {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "large-insignia", required = true)
    protected Insignia largeInsignia;
    @XmlElement(name = "small-insignia", required = true)
    protected Insignia smallInsignia;
    @XmlElement(name = "rank-list", required = true)
    protected RankList rankList;
    @XmlElement(name = "default-icon-colors", required = true)
    protected DefaultIconColors defaultIconColors;
    protected List<Force> force;
    @XmlAttribute(name = "id", required = true)
    protected short id;

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
     * Obtiene el valor de la propiedad rankList.
     * 
     * @return
     *     possible object is
     *     {@link RankList }
     *     
     */
    public RankList getRankList() {
        return rankList;
    }

    /**
     * Define el valor de la propiedad rankList.
     * 
     * @param value
     *     allowed object is
     *     {@link RankList }
     *     
     */
    public void setRankList(RankList value) {
        this.rankList = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultIconColors.
     * 
     * @return
     *     possible object is
     *     {@link DefaultIconColors }
     *     
     */
    public DefaultIconColors getDefaultIconColors() {
        return defaultIconColors;
    }

    /**
     * Define el valor de la propiedad defaultIconColors.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultIconColors }
     *     
     */
    public void setDefaultIconColors(DefaultIconColors value) {
        this.defaultIconColors = value;
    }

    /**
     * Gets the value of the force property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the force property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForce().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Force }
     * 
     * 
     */
    public List<Force> getForce() {
        if (force == null) {
            force = new ArrayList<Force>();
        }
        return this.force;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

}
