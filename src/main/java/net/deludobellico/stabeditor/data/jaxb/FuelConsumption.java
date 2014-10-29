
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FuelComsumption complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FuelComsumption">
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
@XmlType(name = "FuelConsumption")
public class FuelConsumption {

    @XmlAttribute(name = "max")
    protected Float max;
    @XmlAttribute(name = "normal")
    protected Float normal;

    /**
     * Obtiene el valor de la propiedad max.
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
     * Define el valor de la propiedad max.
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

}
