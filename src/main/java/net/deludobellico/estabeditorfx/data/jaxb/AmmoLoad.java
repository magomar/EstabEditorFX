
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AmmoLoad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AmmoLoad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="object-id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="load" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmmoLoad")
public class AmmoLoad {

    @XmlAttribute(name = "object-id", required = true)
    protected int objectId;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "load", required = true)
    protected int load;

    /**
     * Obtiene el valor de la propiedad objectId.
     * 
     */
    public int getObjectId() {
        return objectId;
    }

    /**
     * Define el valor de la propiedad objectId.
     * 
     */
    public void setObjectId(int value) {
        this.objectId = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

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
    }

    /**
     * Obtiene el valor de la propiedad load.
     * 
     */
    public int getLoad() {
        return load;
    }

    /**
     * Define el valor de la propiedad load.
     * 
     */
    public void setLoad(int value) {
        this.load = value;
    }

}
