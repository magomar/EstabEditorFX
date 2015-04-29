package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.data.jaxb.Vehicle;
import net.deludobellico.commandops.estabeditor.model.VehicleModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class VehicleProvider extends AbstractModelProvider<VehicleModel> {

    public VehicleProvider(Vehicle vehicle) {
        super(new VehicleModel(vehicle));

    }
}
