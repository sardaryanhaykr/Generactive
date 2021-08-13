package main.entity;

/**
 * Created by Hayk on 15.07.2021.
 */
public abstract class Item {
    private long id;
    private int price;
    private String name;
    private String imageURL;

    private Group parentGroup;
    private static long idSequance = 1000;

    public Item(String name, String imageURL, int price, Group parentGroup) {
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.parentGroup = parentGroup;
    }

    Item() {
        this(null, null, 0, null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public abstract double calculatePrice(Configuration configuration);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (price != item.price) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (imageURL != null ? !imageURL.equals(item.imageURL) : item.imageURL != null) return false;
        return parentGroup != null ? parentGroup.equals(item.parentGroup) : item.parentGroup == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageURL != null ? imageURL.hashCode() : 0);
        result = 31 * result + (parentGroup != null ? parentGroup.hashCode() : 0);
        return result;
    }
}
