
package net.deludobellico.stabeditor.data.jaxb;

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
 *       &lt;attribute name="object-id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="load" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
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
    protected short objectId;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "load", required = true)
    protected short load;

    /**
     * Obtiene el valor de la propiedad objectId.
     * 
     */
    public short getObjectId() {
        return objectId;
    }

    /**
     * Define el valor de la propiedad objectId.
     * 
     */
    public void setObjectId(short value) {
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
    public short getLoad() {
        return load;
    }

    /**
     * Define el valor de la propiedad load.
     * 
     */
    public void setLoad(short value) {
        this.load = value;
    }

}
