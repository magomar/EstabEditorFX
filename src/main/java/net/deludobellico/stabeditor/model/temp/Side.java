//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Side complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Side">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="large-insignia" type="{}Insignia"/>
 *         &lt;element name="small-insignia" type="{}Insignia"/>
 *         &lt;element name="basics-consumption-rate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="default-enemy-aper-fp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="default-enemy-aarm-fp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nation" type="{}Nation" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "Side", propOrder = {
    "name",
    "description",
    "largeInsignia",
    "smallInsignia",
    "basicsConsumptionRate",
    "defaultEnemyAperFp",
    "defaultEnemyAarmFp",
    "nation"
})
public class Side {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "large-insignia", required = true)
    protected Insignia largeInsignia;
    @XmlElement(name = "small-insignia", required = true)
    protected Insignia smallInsignia;
    @XmlElement(name = "basics-consumption-rate")
    protected float basicsConsumptionRate;
    @XmlElement(name = "default-enemy-aper-fp")
    protected int defaultEnemyAperFp;
    @XmlElement(name = "default-enemy-aarm-fp")
    protected int defaultEnemyAarmFp;
    protected List<Nation> nation;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Insignia> largeInsigniaProxy = new SimpleObjectProperty<Insignia>();
    private final transient ObjectProperty<Insignia> smallInsigniaProxy = new SimpleObjectProperty<Insignia>();
    private final transient FloatProperty basicsConsumptionRateProxy = new SimpleFloatProperty();
    private final transient IntegerProperty defaultEnemyAperFpProxy = new SimpleIntegerProperty();
    private final transient IntegerProperty defaultEnemyAarmFpProxy = new SimpleIntegerProperty();
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
     * Define el valor de la propiedad largeInsignia.
     * 
     * @param value
     *     allowed object is
     *     {@link Insignia }
     *     
     */
    public void setLargeInsignia(Insignia value) {
        this.largeInsignia = value;
        this.largeInsigniaProxy.set(value);
    }

    /**
     * Define el valor de la propiedad smallInsignia.
     * 
     * @param value
     *     allowed object is
     *     {@link Insignia }
     *     
     */
    public void setSmallInsignia(Insignia value) {
        this.smallInsignia = value;
        this.smallInsigniaProxy.set(value);
    }

    /**
     * Define el valor de la propiedad basicsConsumptionRate.
     * 
     */
    public void setBasicsConsumptionRate(float value) {
        this.basicsConsumptionRate = value;
        this.basicsConsumptionRateProxy.set(value);
    }

    /**
     * Define el valor de la propiedad defaultEnemyAperFp.
     * 
     */
    public void setDefaultEnemyAperFp(int value) {
        this.defaultEnemyAperFp = value;
        this.defaultEnemyAperFpProxy.set(value);
    }

    /**
     * Define el valor de la propiedad defaultEnemyAarmFp.
     * 
     */
    public void setDefaultEnemyAarmFp(int value) {
        this.defaultEnemyAarmFp = value;
        this.defaultEnemyAarmFpProxy.set(value);
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
     * Obtiene el valor de la propiedad largeInsignia.
     * 
     */
    public Insignia getLargeInsignia() {
        if (this.largeInsigniaProxy.get() == null) {
            this.largeInsigniaProxy.set(largeInsignia);
        }
        return this.largeInsigniaProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Insignia> largeInsigniaProperty() {
        return this.largeInsigniaProxy;
    }

    /**
     * Obtiene el valor de la propiedad smallInsignia.
     * 
     */
    public Insignia getSmallInsignia() {
        if (this.smallInsigniaProxy.get() == null) {
            this.smallInsigniaProxy.set(smallInsignia);
        }
        return this.smallInsigniaProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Insignia> smallInsigniaProperty() {
        return this.smallInsigniaProxy;
    }

    /**
     * Obtiene el valor de la propiedad basicsConsumptionRate.
     * 
     */
    public float getBasicsConsumptionRate() {
        return this.basicsConsumptionRateProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty basicsConsumptionRateProperty() {
        return this.basicsConsumptionRateProxy;
    }

    /**
     * Obtiene el valor de la propiedad defaultEnemyAperFp.
     * 
     */
    public int getDefaultEnemyAperFp() {
        return this.defaultEnemyAperFpProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty defaultEnemyAperFpProperty() {
        return this.defaultEnemyAperFpProxy;
    }

    /**
     * Obtiene el valor de la propiedad defaultEnemyAarmFp.
     * 
     */
    public int getDefaultEnemyAarmFp() {
        return this.defaultEnemyAarmFpProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty defaultEnemyAarmFpProperty() {
        return this.defaultEnemyAarmFpProxy;
    }

    /**
     * Gets the value of the nation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nation }
     * 
     * 
     */
    public List<Nation> getNation() {
        if (nation == null) {
            List backingList = new ArrayList<Nation>();
            nation = new SimpleListProperty<Nation>(FXCollections.observableArrayList(backingList));
        }
        SimpleListProperty<Nation> nationWrapper = ((SimpleListProperty<Nation> ) this.nation);
        return nationWrapper.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ListProperty<Nation> nationProperty() {
        return ((ListProperty<Nation> ) this.nation);
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
