
package net.deludobellico.stabeditor.data.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RangeTable complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RangeTable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="range-item" type="{}RangeItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeTable", propOrder = {
    "rangeItem"
})
public class RangeTable {

    @XmlElement(name = "range-item", required = true)
    protected List<RangeItem> rangeItem;

    /**
     * Gets the value of the rangeItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rangeItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRangeItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RangeItem }
     * 
     * 
     */
    public List<RangeItem> getRangeItem() {
        if (rangeItem == null) {
            rangeItem = new ArrayList<RangeItem>();
        }
        return this.rangeItem;
    }

}