
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Radio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Radio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture-filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{}RadioSize"/>
 *         &lt;element name="crew" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reliability" type="{}Proportion"/>
 *         &lt;element name="armaments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="net-type" type="{}NetType"/>
 *         &lt;element name="freq-type" type="{}FreqType"/>
 *         &lt;element name="max-range" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gain" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
@XmlType(name = "Radio", propOrder = {
    "name",
    "description",
    "picture",
    "pictureFilename",
    "size",
    "crew",
    "reliability",
    "armaments",
    "netType",
    "freqType",
    "maxRange",
    "gain"
})
public class Radio {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String picture;
    @XmlElement(name = "picture-filename", required = true)
    protected String pictureFilename;
    @XmlElement(required = true)
    protected RadioSize size;
    @XmlElement(required = true)
    protected String crew;
    protected float reliability;
    @XmlElement(required = true)
    protected String armaments;
    @XmlElement(name = "net-type", required = true)
    @XmlSchemaType(name = "string")
    protected NetType netType;
    @XmlElement(name = "freq-type", required = true)
    @XmlSchemaType(name = "string")
    protected FreqType freqType;
    @XmlElement(name = "max-range")
    protected int maxRange;
    protected float gain;
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
     * Obtiene el valor de la propiedad picture.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Define el valor de la propiedad picture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPicture(String value) {
        this.picture = value;
    }

    /**
     * Obtiene el valor de la propiedad pictureFilename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureFilename() {
        return pictureFilename;
    }

    /**
     * Define el valor de la propiedad pictureFilename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureFilename(String value) {
        this.pictureFilename = value;
    }

    /**
     * Obtiene el valor de la propiedad size.
     * 
     * @return
     *     possible object is
     *     {@link RadioSize }
     *     
     */
    public RadioSize getSize() {
        return size;
    }

    /**
     * Define el valor de la propiedad size.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioSize }
     *     
     */
    public void setSize(RadioSize value) {
        this.size = value;
    }

    /**
     * Obtiene el valor de la propiedad crew.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrew() {
        return crew;
    }

    /**
     * Define el valor de la propiedad crew.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrew(String value) {
        this.crew = value;
    }

    /**
     * Obtiene el valor de la propiedad reliability.
     * 
     */
    public float getReliability() {
        return reliability;
    }

    /**
     * Define el valor de la propiedad reliability.
     * 
     */
    public void setReliability(float value) {
        this.reliability = value;
    }

    /**
     * Obtiene el valor de la propiedad armaments.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArmaments() {
        return armaments;
    }

    /**
     * Define el valor de la propiedad armaments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArmaments(String value) {
        this.armaments = value;
    }

    /**
     * Obtiene el valor de la propiedad netType.
     * 
     * @return
     *     possible object is
     *     {@link NetType }
     *     
     */
    public NetType getNetType() {
        return netType;
    }

    /**
     * Define el valor de la propiedad netType.
     * 
     * @param value
     *     allowed object is
     *     {@link NetType }
     *     
     */
    public void setNetType(NetType value) {
        this.netType = value;
    }

    /**
     * Obtiene el valor de la propiedad freqType.
     * 
     * @return
     *     possible object is
     *     {@link FreqType }
     *     
     */
    public FreqType getFreqType() {
        return freqType;
    }

    /**
     * Define el valor de la propiedad freqType.
     * 
     * @param value
     *     allowed object is
     *     {@link FreqType }
     *     
     */
    public void setFreqType(FreqType value) {
        this.freqType = value;
    }

    /**
     * Obtiene el valor de la propiedad maxRange.
     * 
     */
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * Define el valor de la propiedad maxRange.
     * 
     */
    public void setMaxRange(int value) {
        this.maxRange = value;
    }

    /**
     * Obtiene el valor de la propiedad gain.
     * 
     */
    public float getGain() {
        return gain;
    }

    /**
     * Define el valor de la propiedad gain.
     * 
     */
    public void setGain(float value) {
        this.gain = value;
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
