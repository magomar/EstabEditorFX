
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="moving-cohesion-level" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="frontage-per-man" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="depth-per-man" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="firing-percentages" type="{}FiringPercentages"/>
 *         &lt;element name="target-percentages" type="{}TargetPercentages"/>
 *         &lt;element name="security" type="{}FormationSecurity"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="type" use="required" type="{}FormationType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "movingCohesionLevel",
        "frontagePerMan",
        "depthPerMan",
        "firingPercentages",
        "targetPercentages",
        "security"
})
@XmlRootElement(name = "formation-effects")
public class FormationEffects {

    @XmlElement(name = "moving-cohesion-level")
    protected float movingCohesionLevel;
    @XmlElement(name = "frontage-per-man")
    protected float frontagePerMan;
    @XmlElement(name = "depth-per-man")
    protected float depthPerMan;
    @XmlElement(name = "firing-percentages", required = true)
    protected FiringPercentages firingPercentages;
    @XmlElement(name = "target-percentages", required = true)
    protected TargetPercentages targetPercentages;
    @XmlElement(required = true)
    protected FormationSecurity security;
    @XmlAttribute(name = "id", required = true)
    protected short id;
    @XmlAttribute(name = "type", required = true)
    protected FormationType type;

    /**
     * Gets the value of the movingCohesionLevel property.
     */
    public float getMovingCohesionLevel() {
        return movingCohesionLevel;
    }

    /**
     * Sets the value of the movingCohesionLevel property.
     */
    public void setMovingCohesionLevel(float value) {
        this.movingCohesionLevel = value;
    }

    /**
     * Gets the value of the frontagePerMan property.
     */
    public float getFrontagePerMan() {
        return frontagePerMan;
    }

    /**
     * Sets the value of the frontagePerMan property.
     */
    public void setFrontagePerMan(float value) {
        this.frontagePerMan = value;
    }

    /**
     * Gets the value of the depthPerMan property.
     */
    public float getDepthPerMan() {
        return depthPerMan;
    }

    /**
     * Sets the value of the depthPerMan property.
     */
    public void setDepthPerMan(float value) {
        this.depthPerMan = value;
    }

    /**
     * Gets the value of the firingPercentages property.
     *
     * @return possible object is
     * {@link FiringPercentages }
     */
    public FiringPercentages getFiringPercentages() {
        return firingPercentages;
    }

    /**
     * Sets the value of the firingPercentages property.
     *
     * @param value allowed object is
     *              {@link FiringPercentages }
     */
    public void setFiringPercentages(FiringPercentages value) {
        this.firingPercentages = value;
    }

    /**
     * Gets the value of the targetPercentages property.
     *
     * @return possible object is
     * {@link TargetPercentages }
     */
    public TargetPercentages getTargetPercentages() {
        return targetPercentages;
    }

    /**
     * Sets the value of the targetPercentages property.
     *
     * @param value allowed object is
     *              {@link TargetPercentages }
     */
    public void setTargetPercentages(TargetPercentages value) {
        this.targetPercentages = value;
    }

    /**
     * Gets the value of the security property.
     *
     * @return possible object is
     * {@link FormationSecurity }
     */
    public FormationSecurity getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     *
     * @param value allowed object is
     *              {@link FormationSecurity }
     */
    public void setSecurity(FormationSecurity value) {
        this.security = value;
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

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link FormationType }
     */
    public FormationType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link FormationType }
     */
    public void setType(FormationType value) {
        this.type = value;
    }

}
