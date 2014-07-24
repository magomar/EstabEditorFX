
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *       &lt;sequence>
 *         &lt;element name="max" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="normal" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedData", propOrder = {
    "max",
    "normal"
})
public class SpeedData {

    protected float max;
    protected float normal;

    /**
     * Gets the value of the max property.
     * 
     */
    public float getMax() {
        return max;
    }

    /**
     * Sets the value of the max property.
     * 
     */
    public void setMax(float value) {
        this.max = value;
    }

    /**
     * Gets the value of the normal property.
     * 
     */
    public float getNormal() {
        return normal;
    }

    /**
     * Sets the value of the normal property.
     * 
     */
    public void setNormal(float value) {
        this.normal = value;
    }

}
