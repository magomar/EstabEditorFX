
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DeploymentDuration complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DeploymentDuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deployed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dug-in" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="entrenched" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fortified" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
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
    protected String deployed;
    @XmlElement(name = "dug-in", required = true)
    protected String dugIn;
    @XmlElement(required = true)
    protected String entrenched;
    @XmlElement(required = true)
    protected String fortified;

    /**
     * Obtiene el valor de la propiedad deployed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeployed() {
        return deployed;
    }

    /**
     * Define el valor de la propiedad deployed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeployed(String value) {
        this.deployed = value;
    }

    /**
     * Obtiene el valor de la propiedad dugIn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDugIn() {
        return dugIn;
    }

    /**
     * Define el valor de la propiedad dugIn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDugIn(String value) {
        this.dugIn = value;
    }

    /**
     * Obtiene el valor de la propiedad entrenched.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntrenched() {
        return entrenched;
    }

    /**
     * Define el valor de la propiedad entrenched.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntrenched(String value) {
        this.entrenched = value;
    }

    /**
     * Obtiene el valor de la propiedad fortified.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFortified() {
        return fortified;
    }

    /**
     * Define el valor de la propiedad fortified.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFortified(String value) {
        this.fortified = value;
    }

}
