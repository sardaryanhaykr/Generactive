package entity;

/**
 * Created by Hayk on 21.07.2021.
 */
public class GenerativeItem extends Item {
    private int complexity;
    private GenerativeType generativeType;

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity() {
        complexity = generativeType.multipl;
    }

    public GenerativeType getGenerativeType() {
        return generativeType;
    }

    public void setGenerativeType(GenerativeType generativeType) {
        this.generativeType = generativeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GenerativeItem that = (GenerativeItem) o;

        if (complexity != that.complexity) return false;
        return generativeType == that.generativeType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + complexity;
        result = 31 * result + (generativeType != null ? generativeType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GenerativeItem{" +
                "complexity=" + complexity +
                ", generativeType=" + generativeType +
                '}';
    }
}
