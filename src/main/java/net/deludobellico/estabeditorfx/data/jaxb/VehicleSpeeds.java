
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para VehicleSpeeds complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VehicleSpeeds">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="road" type="{}SpeedData"/>
 *         &lt;element name="cross-country" type="{}SpeedData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleSpeeds", propOrder = {
    "road",
    "crossCountry"
})
public class VehicleSpeeds {

    @XmlElement(required = true)
    protected SpeedData road;
    @XmlElement(name = "cross-country", required = true)
    protected SpeedData crossCountry;

    /**
     * Obtiene el valor de la propiedad road.
     * 
     * @return
     *     possible object is
     *     {@link SpeedData }
     *     
     */
    public SpeedData getRoad() {
        return road;
    }

    /**
     * Define el valor de la propiedad road.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedData }
     *     
     */
    public void setRoad(SpeedData value) {
        this.road = value;
    }

    /**
     * Obtiene el valor de la propiedad crossCountry.
     * 
     * @return
     *     possible object is
     *     {@link SpeedData }
     *     
     */
    public SpeedData getCrossCountry() {
        return crossCountry;
    }

    /**
     * Define el valor de la propiedad crossCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedData }
     *     
     */
    public void setCrossCountry(SpeedData value) {
        this.crossCountry = value;
    }

}
