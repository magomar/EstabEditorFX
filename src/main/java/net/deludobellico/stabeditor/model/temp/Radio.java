//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Radio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Radio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture-filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{}RadioSize"/>
 *         &lt;element name="crew" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reliability" type="{}Proportion"/>
 *         &lt;element name="armaments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="net-type" type="{}NetType"/>
 *         &lt;element name="freq-type" type="{}FreqType"/>
 *         &lt;element name="max-range" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gain" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Radio", propOrder = {
    "name",
    "description",
    "picture",
    "pictureFilename",
    "size",
    "crew",
    "reliability",
    "armaments",
    "netType",
    "freqType",
    "maxRange",
    "gain"
})
public class Radio {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String picture;
    @XmlElement(name = "picture-filename", required = true)
    protected String pictureFilename;
    @XmlElement(required = true)
    protected RadioSize size;
    @XmlElement(required = true)
    protected String crew;
    protected float reliability;
    @XmlElement(required = true)
    protected String armaments;
    @XmlElement(name = "net-type", required = true)
    protected NetType netType;
    @XmlElement(name = "freq-type", required = true)
    protected FreqType freqType;
    @XmlElement(name = "max-range")
    protected int maxRange;
    protected float gain;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient StringProperty pictureProxy = new SimpleStringProperty();
    private final transient StringProperty pictureFilenameProxy = new SimpleStringProperty();
    private final transient ObjectProperty<RadioSize> sizeProxy = new SimpleObjectProperty<RadioSize>();
    private final transient StringProperty crewProxy = new SimpleStringProperty();
    private final transient FloatProperty reliabilityProxy = new SimpleFloatProperty();
    private final transient StringProperty armamentsProxy = new SimpleStringProperty();
    private final transient ObjectProperty<NetType> netTypeProxy = new SimpleObjectProperty<NetType>();
    private final transient ObjectProperty<FreqType> freqTypeProxy = new SimpleObjectProperty<FreqType>();
    private final transient IntegerProperty maxRangeProxy = new SimpleIntegerProperty();
    private final transient FloatProperty gainProxy = new SimpleFloatProperty();
    private final transient IntegerProperty idProxy = new SimpleIntegerProperty();

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
        this.nameProxy.set(value);
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
        this.descriptionProxy.set(value);
    }

    /**
     * Define el valor de la propiedad picture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPicture(String value) {
        this.picture = value;
        this.pictureProxy.set(value);
    }

    /**
     * Define el valor de la propiedad pictureFilename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureFilename(String value) {
        this.pictureFilename = value;
        this.pictureFilenameProxy.set(value);
    }

    /**
     * Define el valor de la propiedad size.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioSize }
     *     
     */
    public void setSize(RadioSize value) {
        this.size = value;
        this.sizeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad crew.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrew(String value) {
        this.crew = value;
        this.crewProxy.set(value);
    }

    /**
     * Define el valor de la propiedad reliability.
     * 
     */
    public void setReliability(float value) {
        this.reliability = value;
        this.reliabilityProxy.set(value);
    }

    /**
     * Define el valor de la propiedad armaments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArmaments(String value) {
        this.armaments = value;
        this.armamentsProxy.set(value);
    }

    /**
     * Define el valor de la propiedad netType.
     * 
     * @param value
     *     allowed object is
     *     {@link NetType }
     *     
     */
    public void setNetType(NetType value) {
        this.netType = value;
        this.netTypeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad freqType.
     * 
     * @param value
     *     allowed object is
     *     {@link FreqType }
     *     
     */
    public void setFreqType(FreqType value) {
        this.freqType = value;
        this.freqTypeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad maxRange.
     * 
     */
    public void setMaxRange(int value) {
        this.maxRange = value;
        this.maxRangeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad gain.
     * 
     */
    public void setGain(float value) {
        this.gain = value;
        this.gainProxy.set(value);
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
        this.idProxy.set(value);
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     */
    public String getName() {
        if (this.nameProxy.get() == null) {
            this.nameProxy.set(name);
        }
        return this.nameProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty nameProperty() {
        return this.nameProxy;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     */
    public String getDescription() {
        if (this.descriptionProxy.get() == null) {
            this.descriptionProxy.set(description);
        }
        return this.descriptionProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty descriptionProperty() {
        return this.descriptionProxy;
    }

    /**
     * Obtiene el valor de la propiedad picture.
     * 
     */
    public String getPicture() {
        if (this.pictureProxy.get() == null) {
            this.pictureProxy.set(picture);
        }
        return this.pictureProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty pictureProperty() {
        return this.pictureProxy;
    }

    /**
     * Obtiene el valor de la propiedad pictureFilename.
     * 
     */
    public String getPictureFilename() {
        if (this.pictureFilenameProxy.get() == null) {
            this.pictureFilenameProxy.set(pictureFilename);
        }
        return this.pictureFilenameProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty pictureFilenameProperty() {
        return this.pictureFilenameProxy;
    }

    /**
     * Obtiene el valor de la propiedad size.
     * 
     */
    public RadioSize getSize() {
        if (this.sizeProxy.get() == null) {
            this.sizeProxy.set(size);
        }
        return this.sizeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RadioSize> sizeProperty() {
        return this.sizeProxy;
    }

    /**
     * Obtiene el valor de la propiedad crew.
     * 
     */
    public String getCrew() {
        if (this.crewProxy.get() == null) {
            this.crewProxy.set(crew);
        }
        return this.crewProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty crewProperty() {
        return this.crewProxy;
    }

    /**
     * Obtiene el valor de la propiedad reliability.
     * 
     */
    public float getReliability() {
        return this.reliabilityProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty reliabilityProperty() {
        return this.reliabilityProxy;
    }

    /**
     * Obtiene el valor de la propiedad armaments.
     * 
     */
    public String getArmaments() {
        if (this.armamentsProxy.get() == null) {
            this.armamentsProxy.set(armaments);
        }
        return this.armamentsProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty armamentsProperty() {
        return this.armamentsProxy;
    }

    /**
     * Obtiene el valor de la propiedad netType.
     * 
     */
    public NetType getNetType() {
        if (this.netTypeProxy.get() == null) {
            this.netTypeProxy.set(netType);
        }
        return this.netTypeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<NetType> netTypeProperty() {
        return this.netTypeProxy;
    }

    /**
     * Obtiene el valor de la propiedad freqType.
     * 
     */
    public FreqType getFreqType() {
        if (this.freqTypeProxy.get() == null) {
            this.freqTypeProxy.set(freqType);
        }
        return this.freqTypeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<FreqType> freqTypeProperty() {
        return this.freqTypeProxy;
    }

    /**
     * Obtiene el valor de la propiedad maxRange.
     * 
     */
    public int getMaxRange() {
        return this.maxRangeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty maxRangeProperty() {
        return this.maxRangeProxy;
    }

    /**
     * Obtiene el valor de la propiedad gain.
     * 
     */
    public float getGain() {
        return this.gainProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty gainProperty() {
        return this.gainProxy;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return this.idProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty idProperty() {
        return this.idProxy;
    }

}
