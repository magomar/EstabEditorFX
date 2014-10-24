//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 02:15:22 AM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Image complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Image">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="file-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image")
public class Image {

    @XmlAttribute(name = "id", required = true)
    protected short id;
    @XmlAttribute(name = "file-id", required = true)
    protected String fileId;
    private final transient ObjectProperty<Short> idProxy = new SimpleObjectProperty<Short>();
    private final transient StringProperty fileIdProxy = new SimpleStringProperty();

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(short value) {
        this.id = value;
        this.idProxy.set(value);
    }

    /**
     * Sets the value of the fileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileId(String value) {
        this.fileId = value;
        this.fileIdProxy.set(value);
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public short getId() {
        if (this.idProxy.get() == null) {
            this.idProxy.set(id);
        }
        return this.idProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Short> idProperty() {
        return this.idProxy;
    }

    /**
     * Gets the value of the fileId property.
     * 
     */
    public String getFileId() {
        if (this.fileIdProxy.get() == null) {
            this.fileIdProxy.set(fileId);
        }
        return this.fileIdProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty fileIdProperty() {
        return this.fileIdProxy;
    }

}
