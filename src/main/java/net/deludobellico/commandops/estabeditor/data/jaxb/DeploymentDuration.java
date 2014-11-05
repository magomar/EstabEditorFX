package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para DeploymentDuration complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="DeploymentDuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deployed" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="dug-in" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="entrenched" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="fortified" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeploymentDuration", propOrder = {
        "deployed",
        "dugIn",
        "entrenched",
        "fortified"
})
public class DeploymentDuration {

    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar deployed;
    @XmlElement(name = "dug-in", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar dugIn;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar entrenched;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar fortified;

    /**
     * Obtiene el valor de la propiedad deployed.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDeployed() {
        return deployed;
    }

    /**
     * Define el valor de la propiedad deployed.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDeployed(XMLGregorianCalendar value) {
        this.deployed = value;
    }

    /**
     * Obtiene el valor de la propiedad dugIn.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDugIn() {
        return dugIn;
    }

    /**
     * Define el valor de la propiedad dugIn.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDugIn(XMLGregorianCalendar value) {
        this.dugIn = value;
    }

    /**
     * Obtiene el valor de la propiedad entrenched.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEntrenched() {
        return entrenched;
    }

    /**
     * Define el valor de la propiedad entrenched.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEntrenched(XMLGregorianCalendar value) {
        this.entrenched = value;
    }

    /**
     * Obtiene el valor de la propiedad fortified.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getFortified() {
        return fortified;
    }

    /**
     * Define el valor de la propiedad fortified.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setFortified(XMLGregorianCalendar value) {
        this.fortified = value;
    }

}
