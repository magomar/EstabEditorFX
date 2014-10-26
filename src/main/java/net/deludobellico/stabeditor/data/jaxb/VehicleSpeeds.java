//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.26 at 08:01:14 PM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.xml.bind.annotation.XmlElement;


/**
 * <p>Java class for VehicleSpeeds complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
public class VehicleSpeeds {

    protected SpeedData road;
    protected SpeedData crossCountry;
    private final transient ObjectProperty<SpeedData> roadProxy = new SimpleObjectProperty<SpeedData>();
    private final transient ObjectProperty<SpeedData> crossCountryProxy = new SimpleObjectProperty<SpeedData>();

    /**
     * Sets the value of the road property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedData }
     *
     */
    @XmlElement(required = true)
    public void setRoad(SpeedData value) {
        this.road = value;
        this.roadProxy.set(value);
    }

    /**
     * Sets the value of the crossCountry property.
     *
     * @param value
     *     allowed object is
     *     {@link SpeedData }
     *     
     */
    @XmlElement(required = true, name = "cross-country")
    public void setCrossCountry(SpeedData value) {
        this.crossCountry = value;
        this.crossCountryProxy.set(value);
    }

    /**
     * Gets the value of the road property.
     * 
     */
    public SpeedData getRoad() {
        return this.roadProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<SpeedData> roadProperty() {
        return this.roadProxy;
    }

    /**
     * Gets the value of the crossCountry property.
     * 
     */
    public SpeedData getCrossCountry() {
        return this.crossCountryProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<SpeedData> crossCountryProperty() {
        return this.crossCountryProxy;
    }

}
