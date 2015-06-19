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

    public ArmamentModel() {
        super(WeaponModel.class);
    }

    public ArmamentModel(Armament armament) {
        super(WeaponModel.class);
        initialize(armament);
    }

    @Override
    public Armament getPojo() {
        Armament armament = new Armament();
        armament.setEquipmentObjectId(getId());
        armament.setEquipmentName(getName());
        armament.setQty(getQty());
        return armament;
    }

    @Override
    public void initialize(Armament pojo) {
        setId(pojo.getEquipmentObjectId());
        setName(pojo.getEquipmentName());
        setQty(pojo.getQty());
    }

    @Override
    public WeaponModel getReferenceById(EstabModel estab) {
        return estab.getWeapons().get(getId());
    }



}
