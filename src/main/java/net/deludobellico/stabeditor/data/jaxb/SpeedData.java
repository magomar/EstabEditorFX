
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpeedData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpeedData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="normal" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedData")
public class SpeedData {

    @XmlAttribute(name = "max")
    protected Float max;
    @XmlAttribute(name = "normal")
    protected Float normal;

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMax(Float value) {
        this.max = value;
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

}
