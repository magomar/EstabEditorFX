package net.deludobellico.estabeditorfx.util;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * Created by Heine on 10/28/2014.
 */
@XmlRootElement(name = "settings")
public class Settings {

    private static final Integer MAX_RECENT_FILES = 4;
    private final List<String> sourceRecentFiles = new LimitedList<>(MAX_RECENT_FILES);
    private final List<String> targetRecentFiles = new LimitedList<>(MAX_RECENT_FILES);
    private static Settings SETTINGS = new Settings();
    private String lastOpenedFolder;
    private BooleanProperty visibleToolbar = new SimpleBooleanProperty(true);
    private BooleanProperty visibleSourcePanel = new SimpleBooleanProperty(true);
    private BooleanProperty visibleTargetPanel = new SimpleBooleanProperty(true);
    private BooleanProperty newFileCreated = new SimpleBooleanProperty(false);
    private BooleanProperty newFileSaved = new SimpleBooleanProperty(false);
    private static JAXBFactory JAXB_SETTINGS;

    static {
        try {
            JAXB_SETTINGS = new JAXBFactory(Settings.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private Settings() {
    }

    public static Settings getInstance() {
        return SETTINGS;
    }

    /**
     * Loads SETTINGS from file. Creates a new one if it doesn't exist.
     */
    public void load() {
        File file = new File(FileIO.getClientSettingsPath().toAbsolutePath().toString());
        if (!file.exists()) return; // Loading default SETTINGS
        SETTINGS = (Settings) JAXB_SETTINGS.unmarshallXML(file);
    }

    /**
     * Saves SETTINGS to disk. Creates a new SETTINGS file if it doesn't exist.
     */
    public void save() {
        JAXB_SETTINGS.marshallXML(this, FileIO.getFileOrCreateNew(FileIO.getClientSettingsPath().toAbsolutePath().toString()));
    }

    @XmlElement(name = "source-recent-files")
    public List<String> getSourceRecentFiles() {
        return sourceRecentFiles;
    }

    @XmlElement(name = "target-recent-files")
    public List<String> getTargetRecentFiles() {
        return targetRecentFiles;
    }

    @XmlElement(name = "visible-toolbar")
    public Boolean getVisibleToolbar() {
        return visibleToolbar.get();
    }

    public BooleanProperty visibleToolbarProperty() {
        return visibleToolbar;
    }

    public void setVisibleToolbar(Boolean visibleToolbar) {
        this.visibleToolbar.set(visibleToolbar);
    }

    @XmlElement(name = "visible-source-panel")
    public Boolean getVisibleSourcePanel() {
        return visibleSourcePanel.get();
    }

    public BooleanProperty visibleSourcePanelProperty() {
        return visibleSourcePanel;
    }

    public void setVisibleSourcePanel(Boolean visibleSourcePanel) {
        this.visibleSourcePanel.set(visibleSourcePanel);
    }

    @XmlElement(name = "visible-target-panel")
    public Boolean getVisibleTargetPanel() {
        return visibleTargetPanel.get();
    }

    public BooleanProperty visibleTargetPanelProperty() {
        return visibleTargetPanel;
    }

    public void setVisibleTargetPanel(Boolean visibleTargetPanel) {
        this.visibleTargetPanel.set(visibleTargetPanel);
    }

    @XmlElement(name = "last-opened-folder")
    public String getLastOpenedFolder() {
        return lastOpenedFolder;
    }

    public void setLastOpenedFolder(String lastOpenedFolder) {
        this.lastOpenedFolder = lastOpenedFolder;
    }

    public boolean getNewFileCreated() {
        return newFileCreated.get();
    }

    public BooleanProperty newFileCreatedProperty() {
        return newFileCreated;
    }

    public void setNewFileCreated(boolean newFileCreated) {
        this.newFileCreated.set(newFileCreated);
    }

    public boolean getNewFileSaved() {
        return newFileSaved.get();
    }

    public BooleanProperty newFileSavedProperty() {
        return newFileSaved;
    }

    public void setNewFileSaved(boolean newFileSaved) {
        this.newFileSaved.set(newFileSaved);
    }
}
