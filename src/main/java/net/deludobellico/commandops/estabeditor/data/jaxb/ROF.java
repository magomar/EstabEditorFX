package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ROF complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="ROF">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="slow" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="normal" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="rapid" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROF")
public class ROF {

    @XmlAttribute(name = "slow", required = true)
    protected double slow;
    @XmlAttribute(name = "normal", required = true)
    protected double normal;
    @XmlAttribute(name = "rapid", required = true)
    protected double rapid;

    /**
     * Obtiene el valor de la propiedad slow.
     */
    public double getSlow() {
        return slow;
    }

    /**
     * Define el valor de la propiedad slow.
     */
    public void setSlow(double value) {
        this.slow = value;
    }

    /**
     * Obtiene el valor de la propiedad normal.
     */
    public double getNormal() {
        return normal;
    }

    /**
     * Define el valor de la propiedad normal.
     */
    public void setNormal(double value) {
        this.normal = value;
    }

    /**
     * Obtiene el valor de la propiedad rapid.
     */
    public double getRapid() {
        return rapid;
    }

    /**
     * Define el valor de la propiedad rapid.
     */
    public void setRapid(double value) {
        this.rapid = value;
    }

}
