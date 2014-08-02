
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SpeedData complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad max.
     * 
     */
    public float getMax() {
        return max;
    }

    /**
     * Define el valor de la propiedad max.
     * 
     */
    public void setMax(float value) {
        this.max = value;
    }

    /**
     * Obtiene el valor de la propiedad normal.
     * 
     */
    public float getNormal() {
        return normal;
    }

    /**
     * Define el valor de la propiedad normal.
     * 
     */
    public void setNormal(float value) {
        this.normal = value;
    }

}
