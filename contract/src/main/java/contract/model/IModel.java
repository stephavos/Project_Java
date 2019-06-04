package contract.model;

import entity.GameObject;

public interface IModel {
    GameObject[] getMap();
    void setMap(GameObject[] map);
    int getID();
    void setID(int ID);
    void Move(String dir);
    void monsterMove();
    void fallingRockDia();
    int getDiamondCount();
    void setAlive(boolean alive);
    boolean isAlive();
}
