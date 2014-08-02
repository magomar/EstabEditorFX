
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ROF complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad slow.
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
     * Define el valor de la propiedad slow.
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
     * Obtiene el valor de la propiedad normal.
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
     * Define el valor de la propiedad normal.
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
     * Obtiene el valor de la propiedad rapid.
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
     * Define el valor de la propiedad rapid.
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
