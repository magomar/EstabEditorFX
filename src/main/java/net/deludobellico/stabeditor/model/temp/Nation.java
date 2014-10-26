//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
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
 * <p>Clase Java para Nation complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Nation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="large-insignia" type="{}Insignia"/>
 *         &lt;element name="small-insignia" type="{}Insignia"/>
 *         &lt;element name="service" type="{}Service" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "Nation", propOrder = {
    "name",
    "description",
    "nationality",
    "largeInsignia",
    "smallInsignia",
    "service"
})
public class Nation {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String nationality;
    @XmlElement(name = "large-insignia", required = true)
    protected Insignia largeInsignia;
    @XmlElement(name = "small-insignia", required = true)
    protected Insignia smallInsignia;
    protected List<Service> service;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient StringProperty nationalityProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Insignia> largeInsigniaProxy = new SimpleObjectProperty<Insignia>();
    private final transient ObjectProperty<Insignia> smallInsigniaProxy = new SimpleObjectProperty<Insignia>();
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
     * Define el valor de la propiedad nationality.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
        this.nationalityProxy.set(value);
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
     * Obtiene el valor de la propiedad nationality.
     * 
     */
    public String getNationality() {
        if (this.nationalityProxy.get() == null) {
            this.nationalityProxy.set(nationality);
        }
        return this.nationalityProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty nationalityProperty() {
        return this.nationalityProxy;
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
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Service }
     * 
     * 
     */
    public List<Service> getService() {
        if (service == null) {
            List backingList = new ArrayList<Service>();
            service = new SimpleListProperty<Service>(FXCollections.observableArrayList(backingList));
        }
        SimpleListProperty<Service> serviceWrapper = ((SimpleListProperty<Service> ) this.service);
        return serviceWrapper.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ListProperty<Service> serviceProperty() {
        return ((ListProperty<Service> ) this.service);
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
