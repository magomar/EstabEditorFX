package net.deludobellico.commandops.estabeditor.model;

/**
 * An element model that might include a reference to a picture of itself
 *
 * @author Mario
 */
public interface GraphicalElementModel<T> extends ElementModel<T> {
//    boolean hasPicture();
    int getPictureId();
}
