
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Nation complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
    protected short id;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the nationality property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNationality(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the largeInsignia property.
     *
     * @return possible object is
     * {@link Insignia }
     */
    public Insignia getLargeInsignia() {
        return largeInsignia;
    }

    /**
     * Sets the value of the largeInsignia property.
     *
     * @param value allowed object is
     *              {@link Insignia }
     */
    public void setLargeInsignia(Insignia value) {
        this.largeInsignia = value;
    }

    /**
     * Gets the value of the smallInsignia property.
     *
     * @return possible object is
     * {@link Insignia }
     */
    public Insignia getSmallInsignia() {
        return smallInsignia;
    }

    /**
     * Sets the value of the smallInsignia property.
     *
     * @param value allowed object is
     *              {@link Insignia }
     */
    public void setSmallInsignia(Insignia value) {
        this.smallInsignia = value;
    }

    /**
     * Gets the value of the service property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Service }
     */
    public List<Service> getService() {
        if (service == null) {
            service = new ArrayList<Service>();
        }
        return this.service;
    }

    /**
     * Gets the value of the id property.
     */
    public short getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(short value) {
        this.id = value;
    }

}
