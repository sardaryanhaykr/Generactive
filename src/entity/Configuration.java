package entity;

/**
 * Created by Hayk on 21.07.2021.
 */

class Configuration {
    private Resolution resolution;


    public Configuration(Resolution resolution) {
        this.resolution = resolution;

    }

    public Configuration() {
    }

    Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }
}
