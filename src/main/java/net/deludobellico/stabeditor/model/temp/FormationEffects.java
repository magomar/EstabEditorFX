//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
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
 *         &lt;element name="moving-cohesion-level" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="frontage-per-man" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="depth-per-man" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="firing-percentages" type="{}FiringPercentages"/>
 *         &lt;element name="target-percentages" type="{}TargetPercentages"/>
 *         &lt;element name="security" type="{}FormationSecurity"/>
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
    "security"
})
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
    protected int id;
    @XmlAttribute(name = "type", required = true)
    protected FormationType type;
    private final transient FloatProperty movingCohesionLevelProxy = new SimpleFloatProperty();
    private final transient FloatProperty frontagePerManProxy = new SimpleFloatProperty();
    private final transient FloatProperty depthPerManProxy = new SimpleFloatProperty();
    private final transient ObjectProperty<FiringPercentages> firingPercentagesProxy = new SimpleObjectProperty<FiringPercentages>();
    private final transient ObjectProperty<TargetPercentages> targetPercentagesProxy = new SimpleObjectProperty<TargetPercentages>();
    private final transient ObjectProperty<FormationSecurity> securityProxy = new SimpleObjectProperty<FormationSecurity>();
    private final transient IntegerProperty idProxy = new SimpleIntegerProperty();
    private final transient ObjectProperty<FormationType> typeProxy = new SimpleObjectProperty<FormationType>();

    /**
     * Define el valor de la propiedad movingCohesionLevel.
     * 
     */
    public void setMovingCohesionLevel(float value) {
        this.movingCohesionLevel = value;
        this.movingCohesionLevelProxy.set(value);
    }

    /**
     * Define el valor de la propiedad frontagePerMan.
     * 
     */
    public void setFrontagePerMan(float value) {
        this.frontagePerMan = value;
        this.frontagePerManProxy.set(value);
    }

    /**
     * Define el valor de la propiedad depthPerMan.
     * 
     */
    public void setDepthPerMan(float value) {
        this.depthPerMan = value;
        this.depthPerManProxy.set(value);
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
        this.firingPercentagesProxy.set(value);
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
        this.targetPercentagesProxy.set(value);
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
        this.securityProxy.set(value);
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
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link FormationType }
     *     
     */
    public void setType(FormationType value) {
        this.type = value;
        this.typeProxy.set(value);
    }

    /**
     * Obtiene el valor de la propiedad movingCohesionLevel.
     * 
     */
    public float getMovingCohesionLevel() {
        return this.movingCohesionLevelProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty movingCohesionLevelProperty() {
        return this.movingCohesionLevelProxy;
    }

    /**
     * Obtiene el valor de la propiedad frontagePerMan.
     * 
     */
    public float getFrontagePerMan() {
        return this.frontagePerManProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty frontagePerManProperty() {
        return this.frontagePerManProxy;
    }

    /**
     * Obtiene el valor de la propiedad depthPerMan.
     * 
     */
    public float getDepthPerMan() {
        return this.depthPerManProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty depthPerManProperty() {
        return this.depthPerManProxy;
    }

    /**
     * Obtiene el valor de la propiedad firingPercentages.
     * 
     */
    public FiringPercentages getFiringPercentages() {
        if (this.firingPercentagesProxy.get() == null) {
            this.firingPercentagesProxy.set(firingPercentages);
        }
        return this.firingPercentagesProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<FiringPercentages> firingPercentagesProperty() {
        return this.firingPercentagesProxy;
    }

    /**
     * Obtiene el valor de la propiedad targetPercentages.
     * 
     */
    public TargetPercentages getTargetPercentages() {
        if (this.targetPercentagesProxy.get() == null) {
            this.targetPercentagesProxy.set(targetPercentages);
        }
        return this.targetPercentagesProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<TargetPercentages> targetPercentagesProperty() {
        return this.targetPercentagesProxy;
    }

    /**
     * Obtiene el valor de la propiedad security.
     * 
     */
    public FormationSecurity getSecurity() {
        if (this.securityProxy.get() == null) {
            this.securityProxy.set(security);
        }
        return this.securityProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<FormationSecurity> securityProperty() {
        return this.securityProxy;
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

    /**
     * Obtiene el valor de la propiedad type.
     * 
     */
    public FormationType getType() {
        if (this.typeProxy.get() == null) {
            this.typeProxy.set(type);
        }
        return this.typeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<FormationType> typeProperty() {
        return this.typeProxy;
    }

}
