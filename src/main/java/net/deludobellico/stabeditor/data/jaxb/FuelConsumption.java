
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FuelConsumption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FuelConsumption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="normal" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FuelConsumption")
public class FuelConsumption {

    @XmlAttribute(name = "max")
    protected Double max;
    @XmlAttribute(name = "normal")
    protected Double normal;

    /**
     * Gets the value of the max property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMax(Double value) {
        this.max = value;
    }

    /**
     * Gets the value of the normal property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNormal() {
        return normal;
    }

    /**
     * Sets the value of the normal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNormal(Double value) {
        this.normal = value;
    }

}
