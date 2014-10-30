
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ROF complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ROF">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="slow" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="normal" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="rapid" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROF")
public class ROF {

    @XmlAttribute(name = "slow")
    protected Float slow;
    @XmlAttribute(name = "normal")
    protected Float normal;
    @XmlAttribute(name = "rapid")
    protected Float rapid;

    /**
     * Gets the value of the slow property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSlow() {
        return slow;
    }

    /**
     * Sets the value of the slow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSlow(Float value) {
        this.slow = value;
    }

    /**
     * Gets the value of the normal property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNormal() {
        return normal;
    }

    /**
     * Sets the value of the normal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNormal(Float value) {
        this.normal = value;
    }

    /**
     * Gets the value of the rapid property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRapid() {
        return rapid;
    }

    /**
     * Sets the value of the rapid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRapid(Float value) {
        this.rapid = value;
    }

}
