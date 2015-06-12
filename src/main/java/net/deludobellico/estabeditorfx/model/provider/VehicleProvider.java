package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.data.jaxb.Vehicle;
import net.deludobellico.estabeditorfx.model.VehicleModel;
import net.deludobellico.estabeditorfx.model.VehicleModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class VehicleProvider extends AbstractModelProvider<VehicleModel> {

    public VehicleProvider(Vehicle vehicle) {
        super(new VehicleModel(vehicle));

    }
}
