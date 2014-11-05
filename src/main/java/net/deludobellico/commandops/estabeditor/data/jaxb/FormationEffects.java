
package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FormationEffects complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FormationEffects">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moving-cohesion-level" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="frontage-per-man" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="depth-per-man" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="firing-percentages" type="{}FiringPercentages"/>
 *         &lt;element name="target-percentages" type="{}TargetPercentages"/>
 *         &lt;element name="security" type="{}FormationSecurity"/>
 *         &lt;element name="flags" type="{}FlagList"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="type" use="required" type="{}FormationType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormationEffects", propOrder = {
    "movingCohesionLevel",
    "frontagePerMan",
    "depthPerMan",
    "firingPercentages",
    "targetPercentages",
    "security",
    "flags"
})
public class FormationEffects {

    @XmlElement(name = "moving-cohesion-level")
    protected double movingCohesionLevel;
    @XmlElement(name = "frontage-per-man")
    protected double frontagePerMan;
    @XmlElement(name = "depth-per-man")
    protected double depthPerMan;
    @XmlElement(name = "firing-percentages", required = true)
    protected FiringPercentages firingPercentages;
    @XmlElement(name = "target-percentages", required = true)
    protected TargetPercentages targetPercentages;
    @XmlElement(required = true)
    protected FormationSecurity security;
    @XmlElement(required = true)
    protected FlagList flags;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "type", required = true)
    protected FormationType type;

    /**
     * Obtiene el valor de la propiedad movingCohesionLevel.
     * 
     */
    public double getMovingCohesionLevel() {
        return movingCohesionLevel;
    }

    /**
     * Define el valor de la propiedad movingCohesionLevel.
     * 
     */
    public void setMovingCohesionLevel(double value) {
        this.movingCohesionLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad frontagePerMan.
     * 
     */
    public double getFrontagePerMan() {
        return frontagePerMan;
    }

    /**
     * Define el valor de la propiedad frontagePerMan.
     * 
     */
    public void setFrontagePerMan(double value) {
        this.frontagePerMan = value;
    }

    /**
     * Obtiene el valor de la propiedad depthPerMan.
     * 
     */
    public double getDepthPerMan() {
        return depthPerMan;
    }

    /**
     * Define el valor de la propiedad depthPerMan.
     * 
     */
    public void setDepthPerMan(double value) {
        this.depthPerMan = value;
    }

    /**
     * Obtiene el valor de la propiedad firingPercentages.
     * 
     * @return
     *     possible object is
     *     {@link FiringPercentages }
     *     
     */
    public FiringPercentages getFiringPercentages() {
        return firingPercentages;
    }

    /**
     * Define el valor de la propiedad firingPercentages.
     * 
     * @param value
     *     allowed object is
     *     {@link FiringPercentages }
     *     
     */
    public void setFiringPercentages(FiringPercentages value) {
        this.firingPercentages = value;
    }

    /**
     * Obtiene el valor de la propiedad targetPercentages.
     * 
     * @return
     *     possible object is
     *     {@link TargetPercentages }
     *     
     */
    public TargetPercentages getTargetPercentages() {
        return targetPercentages;
    }

    /**
     * Define el valor de la propiedad targetPercentages.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetPercentages }
     *     
     */
    public void setTargetPercentages(TargetPercentages value) {
        this.targetPercentages = value;
    }

    /**
     * Obtiene el valor de la propiedad security.
     * 
     * @return
     *     possible object is
     *     {@link FormationSecurity }
     *     
     */
    public FormationSecurity getSecurity() {
        return security;
    }

    /**
     * Define el valor de la propiedad security.
     * 
     * @param value
     *     allowed object is
     *     {@link FormationSecurity }
     *     
     */
    public void setSecurity(FormationSecurity value) {
        this.security = value;
    }

    /**
     * Obtiene el valor de la propiedad flags.
     * 
     * @return
     *     possible object is
     *     {@link FlagList }
     *     
     */
    public FlagList getFlags() {
        return flags;
    }

    /**
     * Define el valor de la propiedad flags.
     * 
     * @param value
     *     allowed object is
     *     {@link FlagList }
     *     
     */
    public void setFlags(FlagList value) {
        this.flags = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link FormationType }
     *     
     */
    public FormationType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link FormationType }
     *     
     */
    public void setType(FormationType value) {
        this.type = value;
    }

}
