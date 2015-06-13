package net.deludobellico.estabeditorfx.util;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Heine on 10/28/2014.
 */
@XmlRootElement(name = "settings")
public class Settings {

    private static final Integer MAX_RECENT_FILES = 4;
    private static final List<String> sourceRecentFiles = new LimitedList<>(MAX_RECENT_FILES);
    private static final List<String> targetRecentFiles = new LimitedList<>(MAX_RECENT_FILES);
    private static final Settings settings = new Settings();
    private static String lastOpenedFolder;
    private static BooleanProperty visibleToolbar = new SimpleBooleanProperty(true);
    private static BooleanProperty visibleSourcePanel = new SimpleBooleanProperty(true);
    private static BooleanProperty visibleTargetPanel = new SimpleBooleanProperty(true);
    private static BooleanProperty newFileCreated = new SimpleBooleanProperty(false);
    private static BooleanProperty newFileSaved = new SimpleBooleanProperty(false);

    private Settings() {
    }

    public static Settings getInstance() {
        return settings;
    }

    public static void save() {
        FileIO.saveSettings();
    }

    public static void load() {
        FileIO.loadSettings();
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

    public static BooleanProperty visibleToolbarProperty() {
        return visibleToolbar;
    }

    public void setVisibleToolbar(Boolean visibleToolbar) {
        Settings.visibleToolbar.set(visibleToolbar);
    }

    @XmlElement(name = "visible-source-panel")
    public Boolean getVisibleSourcePanel() {
        return visibleSourcePanel.get();
    }

    public static BooleanProperty visibleSourcePanelProperty() {
        return visibleSourcePanel;
    }

    public void setVisibleSourcePanel(Boolean visibleSourcePanel) {
        Settings.visibleSourcePanel.set(visibleSourcePanel);
    }

    @XmlElement(name = "visible-target-panel")
    public Boolean getVisibleTargetPanel() {
        return visibleTargetPanel.get();
    }

    public static BooleanProperty visibleTargetPanelProperty() {
        return visibleTargetPanel;
    }

    public void setVisibleTargetPanel(Boolean visibleTargetPanel) {
        Settings.visibleTargetPanel.set(visibleTargetPanel);
    }

    @XmlElement(name = "last-opened-folder")
    public String getLastOpenedFolder() {
        return lastOpenedFolder;
    }

    public void setLastOpenedFolder(String lastOpenedFolder) {
        Settings.lastOpenedFolder = lastOpenedFolder;
    }

    public static boolean getNewFileCreated() {
        return newFileCreated.get();
    }

    public static BooleanProperty newFileCreatedProperty() {
        return newFileCreated;
    }

    public static void setNewFileCreated(boolean newFileCreated) {
        Settings.newFileCreated.set(newFileCreated);
    }

    public static boolean getNewFileSaved() {
        return newFileSaved.get();
    }

    public static BooleanProperty newFileSavedProperty() {
        return newFileSaved;
    }

    public static void setNewFileSaved(boolean newFileSaved) {
        Settings.newFileSaved.set(newFileSaved);
    }
}
