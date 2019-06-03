package entity;

public class GameObject {

    private String name;
    private int posX;
    private int posY;
    public GameObject(String string, int x, int y){
        this.setName(string);
        this.setPosX(x);
        this.setPosY(y);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public String getName() {
        return name;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
