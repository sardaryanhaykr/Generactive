package Entity;

/**
 * Created by Hayk on 15.07.2021.
 */
public class Item {
    private long id;
    private String name;
    private String imageURL;
    private Group  parentGroup;

    public Item(long id, String name, String imageURL, Group  parentGroup) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.parentGroup = parentGroup;
    }

    public Item(String name,String imageURL,Group  parentGroup){
        this(0,name,imageURL,parentGroup);
    }

    public Item(){}

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

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (imageURL != null ? !imageURL.equals(item.imageURL) : item.imageURL != null) return false;
        return parentGroup != null ? parentGroup.equals(item.parentGroup) : item.parentGroup == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageURL != null ? imageURL.hashCode() : 0);
        result = 31 * result + (parentGroup != null ? parentGroup.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", parentGroup=" + parentGroup +
                '}';
    }
}
