package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.data.jaxb.*;
import net.deludobellico.commandops.estabeditor.model.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mario on 29/04/2015.
 */
public class ModelProviderFactory {
    public static ImageProvider getImageProvider(Image image) {
        return new ImageProvider(image);
    }

    public static ModelProvider<SideModel> getImageProvider(Side image) {
        return new SideProvider(image);
    }
    public static ModelProvider<VehicleModel> getImageProvider(Vehicle vehicle) {
        return new VehicleProvider(vehicle);
    }

    public static ModelProvider<WeaponModel> getImageProvider(Weapon weapon) {
        return new WeaponProvider(weapon);
    }

    public static ModelProvider<AmmoModel> getImageProvider(Ammo ammo) {
        return new AmmoProvider(ammo);
    }

    public static ModelProvider<FormationEffectsModel> getImageProvider(FormationEffects formationEffects) {
        return new FormationEffectsProvider(formationEffects);
    }

    public static <E> List<? extends ModelProvider> getProviders(List<E> elements, Class<E> elementClass) {
        switch (elementClass.getSimpleName()) {
            case "Image":
                return elements.stream().map(e -> getImageProvider((Image) e)).collect(Collectors.toList());
            case "Side":
                return elements.stream().map(e -> getImageProvider((Side) e)).collect(Collectors.toList());
            case "Vehicle":
                return elements.stream().map(e -> getImageProvider((Vehicle) e)).collect(Collectors.toList());
            case "Weapon":
                return elements.stream().map(e -> getImageProvider((Weapon) e)).collect(Collectors.toList());
            case "Ammo":
                return elements.stream().map(e -> getImageProvider((Ammo) e)).collect(Collectors.toList());
            case "FormationEffects":
                return elements.stream().map(e -> getImageProvider((FormationEffects) e)).collect(Collectors.toList());
            default:
                return null;
        }

    }
}
