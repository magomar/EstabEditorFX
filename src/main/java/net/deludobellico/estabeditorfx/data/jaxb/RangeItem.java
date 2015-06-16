
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RangeItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RangeItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="range" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="accuracy" use="required" type="{}Proportion" />
 *       &lt;attribute name="armour-penetration" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
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
    protected int range;
    @XmlAttribute(name = "accuracy", required = true)
    protected double accuracy;
    @XmlAttribute(name = "armour-penetration", required = true)
    protected double armourPenetration;

    /**
     * Obtiene el valor de la propiedad range.
     * 
     */
    public int getRange() {
        return range;
    }

    /**
     * Define el valor de la propiedad range.
     * 
     */
    public void setRange(int value) {
        this.range = value;
    }

    /**
     * Obtiene el valor de la propiedad accuracy.
     * 
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * Define el valor de la propiedad accuracy.
     * 
     */
    public void setAccuracy(double value) {
        this.accuracy = value;
    }

    /**
     * Obtiene el valor de la propiedad armourPenetration.
     * 
     */
    public double getArmourPenetration() {
        return armourPenetration;
    }

    /**
     * Define el valor de la propiedad armourPenetration.
     * 
     */
    public void setArmourPenetration(double value) {
        this.armourPenetration = value;
    }

}
