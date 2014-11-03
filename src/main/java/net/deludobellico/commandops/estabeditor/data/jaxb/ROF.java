package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ROF complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ROF">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="slow" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="normal" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="rapid" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROF")
public class ROF {

    @XmlAttribute(name = "slow")
    protected Double slow;
    @XmlAttribute(name = "normal")
    protected Double normal;
    @XmlAttribute(name = "rapid")
    protected Double rapid;

    /**
     * Gets the value of the slow property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getSlow() {
        return slow;
    }

    /**
     * Sets the value of the slow property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setSlow(Double value) {
        this.slow = value;
    }

    /**
     * Gets the value of the normal property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getNormal() {
        return normal;
    }

    /**
     * Sets the value of the normal property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setNormal(Double value) {
        this.normal = value;
    }

    /**
     * Gets the value of the rapid property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getRapid() {
        return rapid;
    }

    /**
     * Sets the value of the rapid property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setRapid(Double value) {
        this.rapid = value;
    }

}
