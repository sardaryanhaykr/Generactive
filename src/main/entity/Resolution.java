package main.entity;

/**
 * Created by Hayk on 21.07.2021.
 */
public enum Resolution {
    HD(1),
    FHD(2),
    _4K(4);
    final int coefficient;

    Resolution(int coefficient) {
        this.coefficient = coefficient;
    }

}
