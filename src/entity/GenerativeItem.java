package entity;

/**
 * Created by Hayk on 21.07.2021.
 */
public class GenerativeItem extends Item {
    private double complexity;

    @Override
    public double calculatePrice(int price) {
        return price * getConfiguration().getResolution().coefficient * complexity;
    }

    public double getComplexity() {
        generateCompexity();
        return complexity;
    }

    private void generateCompexity() {

        complexity = 1 + Math.random();
    }

}
