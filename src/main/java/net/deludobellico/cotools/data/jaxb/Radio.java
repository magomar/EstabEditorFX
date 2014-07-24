
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Radio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
 *         &lt;element name="max-range" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="gain" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
    protected NetType netType;
    @XmlElement(name = "freq-type", required = true)
    protected FreqType freqType;
    @XmlElement(name = "max-range")
    @XmlSchemaType(name = "unsignedByte")
    protected short maxRange;
    protected float gain;
    @XmlAttribute(name = "id", required = true)
    protected short id;

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
     * Gets the value of the description property.
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
     * Sets the value of the description property.
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
     * Gets the value of the picture property.
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
     * Sets the value of the picture property.
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
     * Gets the value of the pictureFilename property.
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
     * Sets the value of the pictureFilename property.
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
     * Gets the value of the size property.
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
     * Sets the value of the size property.
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
     * Gets the value of the crew property.
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
     * Sets the value of the crew property.
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
     * Gets the value of the reliability property.
     * 
     */
    public float getReliability() {
        return reliability;
    }

    /**
     * Sets the value of the reliability property.
     * 
     */
    public void setReliability(float value) {
        this.reliability = value;
    }

    /**
     * Gets the value of the armaments property.
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
     * Sets the value of the armaments property.
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
     * Gets the value of the netType property.
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
     * Sets the value of the netType property.
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
     * Gets the value of the freqType property.
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
     * Sets the value of the freqType property.
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
     * Gets the value of the maxRange property.
     * 
     */
    public short getMaxRange() {
        return maxRange;
    }

    /**
     * Sets the value of the maxRange property.
     * 
     */
    public void setMaxRange(short value) {
        this.maxRange = value;
    }

    /**
     * Gets the value of the gain property.
     * 
     */
    public float getGain() {
        return gain;
    }

    /**
     * Sets the value of the gain property.
     * 
     */
    public void setGain(float value) {
        this.gain = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

}
