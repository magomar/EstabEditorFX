package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.data.jaxb.Image;
import net.deludobellico.estabeditorfx.model.ImageModel;
import net.deludobellico.estabeditorfx.data.jaxb.Image;

/**
 * Created by Mario on 29/04/2015.
 */
public class ImageProvider extends AbstractModelProvider<ImageModel> {

    public ImageProvider(Image image) {
        super(new ImageModel(image));
    }

}
