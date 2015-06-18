//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.data.jaxb.Armament;

/**
 * Model wrapper for the {@code Armament} class
 *
 * @author Mario
 * @author Heine
 */
public class ArmamentModel extends AbstractReferenceModel<WeaponModel> implements PojoAdapter<Armament> {

    public ArmamentModel(Armament armament) {
        initialize(armament);
    }

    public ArmamentModel() {

    }

    @Override
    public Armament getPojo() {
        Armament armament = new Armament();
        armament.setEquipmentObjectId(id.get());
        armament.setEquipmentName(name.get());
        armament.setQty(qty.get());
        return armament;
    }

    @Override
    public void initialize(Armament pojo) {
        id.set(pojo.getEquipmentObjectId());
        name.set(pojo.getEquipmentName());
        qty.set(pojo.getQty());
    }

    @Override
    public WeaponModel getReferencedElement(EstabModel estab) {
        return estab.getWeapons().get(id.get());
    }

}
