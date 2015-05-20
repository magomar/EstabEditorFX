package net.deludobellico.commandops.estabeditor.controller;

import javafx.util.StringConverter;
import javafx.util.converter.LocalTimeStringConverter;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.util.DateTimeUtils;

import java.util.Locale;

/**
 * Interface for the base element editor controllers.
 * <p>Element editor controllers manage the view and model of the different {@link ElementModel} classes</p>
 *
 * @author Mario
 * @author Heine
 * @see EstabEditorController
 */
interface ElementEditorController<T extends ElementModel> {
    StringConverter<Number> NUMBER_STRING_CONVERTER = new NumberStringConverter(Locale.ENGLISH);
    LocalTimeStringConverter TIME_STRING_CONVERTER = new LocalTimeStringConverter(DateTimeUtils.TIME_FORMATTER, DateTimeUtils.TIME_FORMATTER);

    /**
     * Returns the active {@code ElementModel} set in the Controller
     *
     * @return active {@link ElementModel} set in the Controller
     */
    T getActiveElement();

    /**
     * Sets the active {@code ElementModel} in the Controller.
     * <p>
     * The controller will call {@link #bindProperties()} to bind properties
     * and set other attributes (such as images).
     * <p>
     * If the active element isn't null before binding, then it'll unbind it before proceeding with the new element.
     *
     * @param element The {@link ElementModel} to be set as active
     */
    void setActiveElement(T element);

    /**
     * The controller sets the interface components as not editable when the editor is on read only mode.
     * {@code isEditable} is equivalent to "Source Estab" if true and "Target Estab" if false
     *
     * @param isEditable if true the controller sets the interface as editable, if false it sets the interface not editable
     * @see EstabEditorController#isEditable
     */
    void setEditable(boolean isEditable);

    /**
     * Sets the parent controller: either source or target {@code EstabEditorController}
     *
     * @param estabEditorController source or target {@link EstabEditorController} to be set
     */
    void setEstabEditorController(EstabEditorController estabEditorController);

    /**
     * Gets the parent controller for this element controller
     * @return
     */
    EstabEditorController getEstabEditorController();

    /**
     * Binds the {@code activeElement} properties to the view properties
     *
     */
    void bindProperties();

    /**
     * Unbinds the {@code activeElement} properties from the view properties
     *
     */
    void unbindProperties();

    /**
     * The controller calls {@code unbindProperties()} and empties the view components
     *
     * @see {@link #getActiveElement()}
     * @see {@link #unbindProperties()}
     */
    void clear();
}
