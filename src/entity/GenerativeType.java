package entity;

/**
 * Created by Hayk on 21.07.2021.
 */
public enum GenerativeType {
    HD(1),
    FHD(2),
    _4K(4);
    final int multipl;
    GenerativeType(int multipl){
        this.multipl = multipl;
    }

}
