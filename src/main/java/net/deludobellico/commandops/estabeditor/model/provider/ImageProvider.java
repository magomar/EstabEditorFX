package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.data.jaxb.Image;
import net.deludobellico.commandops.estabeditor.model.ImageModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class ImageProvider extends AbstractModelProvider<ImageModel> {

    public ImageProvider(Image image) {
        super(new ImageModel(image));
    }

}
