package cn.easybuy.entity;

/**
 * 商品表
 */
public class Product {
    private int  id;//商品编号
    private String name;//商品名字
    private  String  description;//商品描述
    private  float   price;//商品价格
    private String stock;//商品库存
    private int  categoryLevel1Id;//分类一级ID
    private int  categoryLevel2Id;//分类二级菜单
    private int  categoryLevel3Id;//分类三级菜单
    private String    fileName;//上传的文件名
    private int isDelete;//是否删除1：删除 0：未删除

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock='" + stock + '\'' +
                ", categoryLevel1Id=" + categoryLevel1Id +
                ", categoryLevel2Id=" + categoryLevel2Id +
                ", categoryLevel3Id=" + categoryLevel3Id +
                ", fileName='" + fileName + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getCategoryLevel1Id() {
        return categoryLevel1Id;
    }

    public void setCategoryLevel1Id(int categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }

    public int getCategoryLevel2Id() {
        return categoryLevel2Id;
    }

    public void setCategoryLevel2Id(int categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }

    public int getCategoryLevel3Id() {
        return categoryLevel3Id;
    }

    public void setCategoryLevel3Id(int categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Product(int id, String name, String description, float price, String stock, int categoryLevel1Id, int categoryLevel2Id, int categoryLevel3Id, String fileName, int isDelete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryLevel1Id = categoryLevel1Id;
        this.categoryLevel2Id = categoryLevel2Id;
        this.categoryLevel3Id = categoryLevel3Id;
        this.fileName = fileName;
        this.isDelete = isDelete;
    }

    public Product() {
    }
}
