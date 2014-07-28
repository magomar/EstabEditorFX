
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="image" type="{}Image" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="side" type="{}Side" maxOccurs="unbounded" minOccurs="2"/>
 *         &lt;element name="vehicle" type="{}Vehicle" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="weapon" type="{}Weapon" maxOccurs="unbounded"/>
 *         &lt;element name="radio" type="{}Radio" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ammo" type="{}Ammo" maxOccurs="unbounded"/>
 *         &lt;element name="formation-effects" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "image",
        "side",
        "vehicle",
        "weapon",
        "radio",
        "ammo",
        "formationEffects"
})
@XmlRootElement(name = "estab-data")
public class EstabData {

    protected List<Image> image;
    @XmlElement(required = true)
    protected List<Side> side;
    protected List<Vehicle> vehicle;
    @XmlElement(required = true)
    protected List<Weapon> weapon;
    protected List<Radio> radio;
    @XmlElement(required = true)
    protected List<Ammo> ammo;
    @XmlElement(name = "formation-effects", required = true)
    protected List<Object> formationEffects;
    @XmlAttribute(name = "version")
    protected Byte version;

    /**
     * Gets the value of the image property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the image property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImage().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Image }
     */
    public List<Image> getImage() {
        if (image == null) {
            image = new ArrayList<Image>();
        }
        return this.image;
    }

    /**
     * Gets the value of the side property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the side property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSide().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Side }
     */
    public List<Side> getSide() {
        if (side == null) {
            side = new ArrayList<Side>();
        }
        return this.side;
    }

    /**
     * Gets the value of the vehicle property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicle property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicle().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Vehicle }
     */
    public List<Vehicle> getVehicle() {
        if (vehicle == null) {
            vehicle = new ArrayList<Vehicle>();
        }
        return this.vehicle;
    }

    /**
     * Gets the value of the weapon property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weapon property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeapon().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Weapon }
     */
    public List<Weapon> getWeapon() {
        if (weapon == null) {
            weapon = new ArrayList<Weapon>();
        }
        return this.weapon;
    }

    /**
     * Gets the value of the radio property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the radio property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRadio().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Radio }
     */
    public List<Radio> getRadio() {
        if (radio == null) {
            radio = new ArrayList<Radio>();
        }
        return this.radio;
    }

    /**
     * Gets the value of the ammo property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ammo property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmmo().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Ammo }
     */
    public List<Ammo> getAmmo() {
        if (ammo == null) {
            ammo = new ArrayList<Ammo>();
        }
        return this.ammo;
    }

    /**
     * Gets the value of the formationEffects property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the formationEffects property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFormationEffects().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getFormationEffects() {
        if (formationEffects == null) {
            formationEffects = new ArrayList<Object>();
        }
        return this.formationEffects;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     * {@link Byte }
     */
    public Byte getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link Byte }
     */
    public void setVersion(Byte value) {
        this.version = value;
    }

}
