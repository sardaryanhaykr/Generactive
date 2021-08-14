package main.entity;

/**
 * Created by Hayk on 21.07.2021.
 */
public class GenerativeItem extends Item {
    private double complexity;

    public GenerativeItem(String name, String imageURL, int price, Group parentGroup, double complexity) {
        super(name, imageURL, price, parentGroup);
        this.complexity = complexity;
    }

    public GenerativeItem(String name, String imageURL, int price, Group parentGroup) {
        super(name, imageURL, price, parentGroup);
    }

    public GenerativeItem() {
        super();
    }

    public void setComplexity(double complexity) {
        this.complexity = complexity;
    }

    @Override
    public double calculatePrice(Configuration configuration) {
        return getPrice() * configuration.getResolution().coefficient * complexity;
    }

    public double getComplexity() {
        generateCompexity();
        return complexity;
    }

    private void generateCompexity() {

        complexity = 1 + Math.random();
    }

}
