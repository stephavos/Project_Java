package model;

import java.sql.SQLException;

import contract.model.IModel;
import entity.GameObject;
import model.dao.*;

public class Model implements IModel {


    private GameObject[] map;
    private int ID = 1;
    private DAOHelloWorld dao = new DAOHelloWorld(DBConnection.getInstance().getConnection());

    public Model() throws SQLException {
        this.map = dao.getMap(this.ID);
    }

    public GameObject[] getMap() {
        return this.map;
    }

    public void Move(String dir){

        int index = 0;
        for(int i = 0; i < 256; i++){
            if(this.map[i].getName().equals("H")) {
                index = i;
            }
        }

        switch (dir){
            case "UP":
                if(this.map[index-1].getName().equals("d") || this.map[index-1].getName().equals("g") || this.map[index-1].getName().equals("o")) {
                    this.map[index-1].setName("H");
                    this.map[index].setName("o");
                }
                break;
            case "DOWN":
                if(this.map[index+1].getName().equals("d") || this.map[index+1].getName().equals("g") || this.map[index+1].getName().equals("o")) {
                    this.map[index+1].setName("H");
                    this.map[index].setName("o");
                }
                break;
            case "RIGHT":
                if(this.map[index+16].getName().equals("d") || this.map[index+16].getName().equals("g") || this.map[index+16].getName().equals("o")) {
                    this.map[index+16].setName("H");
                    this.map[index].setName("o");
                }
                break;
            case "LEFT":
                if(this.map[index-16].getName().equals("d") || this.map[index-16].getName().equals("g") || this.map[index-16].getName().equals("o")) {
                    this.map[index-16].setName("H");
                    this.map[index].setName("o");
                }
                break;
            case "NUL":
                break;

        }
    }

    public void setMap(GameObject[] map) {
        this.map = map;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
