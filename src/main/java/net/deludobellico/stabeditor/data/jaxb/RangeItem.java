
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RangeItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RangeItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="range" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="accuracy" use="required" type="{}Proportion" />
 *       &lt;attribute name="armour-penetration" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeItem")
public class RangeItem {

    @XmlAttribute(name = "range", required = true)
    protected short range;
    @XmlAttribute(name = "accuracy", required = true)
    protected float accuracy;
    @XmlAttribute(name = "armour-penetration", required = true)
    protected float armourPenetration;

    /**
     * Gets the value of the range property.
     * 
     */
    public short getRange() {
        return range;
    }

    /**
     * Sets the value of the range property.
     * 
     */
    public void setRange(short value) {
        this.range = value;
    }

    /**
     * Gets the value of the accuracy property.
     * 
     */
    public float getAccuracy() {
        return accuracy;
    }

    /**
     * Sets the value of the accuracy property.
     * 
     */
    public void setAccuracy(float value) {
        this.accuracy = value;
    }

    /**
     * Gets the value of the armourPenetration property.
     * 
     */
    public float getArmourPenetration() {
        return armourPenetration;
    }

    /**
     * Sets the value of the armourPenetration property.
     * 
     */
    public void setArmourPenetration(float value) {
        this.armourPenetration = value;
    }

}
