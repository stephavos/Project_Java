package model;

import java.sql.SQLException;

import contract.model.IModel;
import entity.GameObject;
import model.dao.*;

import static java.lang.Thread.sleep;

public class Model implements IModel {

    private boolean isAlive = true;

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private int DiamondCount = 0;
    private GameObject[] map;
    private int ID = 1;
    private DAOHelloWorld dao = new DAOHelloWorld(DBConnection.getInstance().getConnection());

    public Model() throws SQLException {
        this.map = dao.getMap(this.ID);
    }

    public GameObject[] getMap() {
        return this.map;
    }

    public void monsterMove(){
        int randomMove = 0;
        for(int k = 0; k < 256; k++ ){
            if(this.map[k].getName().equals("X")){
                randomMove = (int) (Math.random() * 4);
                switch (randomMove){
                    case 1:
                        if(this.map[k-1].getName().equals("o")) {
                            this.map[k-1].setName("X");
                            this.map[k].setName("o");
                            if(this.map[k-1].getName().equals("H")){
                                setAlive(false);

                            }
                        }
                        break;
                    case 2:
                        if(this.map[k+1].getName().equals("o")) {
                            this.map[k+1].setName("X");
                            this.map[k].setName("o");
                            if(this.map[k+1].getName().equals("H")){
                                setAlive(false);
                            }
                        }
                        break;

                    case 3:
                        if(this.map[k+16].getName().equals("o")) {
                            this.map[k+16].setName("X");
                            this.map[k].setName("o");
                            if(this.map[k+16].getName().equals("H")){
                                setAlive(false);
                            }
                        }
                        break;
                    case 4:
                        if(this.map[k-16].getName().equals("o")) {
                            this.map[k-16].setName("X");
                            this.map[k].setName("o");
                            if(this.map[k-16].getName().equals("H")){
                                setAlive(false);
                            }
                        }
                        break;
                    case 5 :
                        break;

                }
                try {
                    sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }




        }
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
                    if(this.map[index-1].getName().equals("g")){
                        this.DiamondCount++;
                    }
                    if(this.map[index-1].getName().equals("X")){
                        setAlive(false);
                    }
                    this.map[index-1].setName("H");
                    this.map[index].setName("o");
                }
                break;
            case "DOWN":
                if(this.map[index+1].getName().equals("d") || this.map[index+1].getName().equals("g") || this.map[index+1].getName().equals("o")) {
                    if(this.map[index+1].getName().equals("g")){
                        this.DiamondCount++;
                    }
                    if(this.map[index+1].getName().equals("X")){
                        setAlive(false);
                    }
                    this.map[index+1].setName("H");
                    this.map[index].setName("o");
                }
                break;
            case "RIGHT":
                if(this.map[index+16].getName().equals("d") || this.map[index+16].getName().equals("g") || this.map[index+16].getName().equals("o")) {
                    if(this.map[index+16].getName().equals("g")){
                        this.DiamondCount++;
                    }
                    if(this.map[index+16].getName().equals("X")){
                        setAlive(false);
                    }
                    this.map[index+16].setName("H");
                    this.map[index].setName("o");
                }
                else if(this.map[index+16].getName().equals("@")){
                    if (this.map[index+32].getName().equals("o")){
                        this.map[index].setName("o");
                        this.map[index+16].setName("H");
                        this.map[index+32].setName("@");
                    }
                }
                break;
            case "LEFT":
                if(this.map[index-16].getName().equals("d") || this.map[index-16].getName().equals("g") || this.map[index-16].getName().equals("o")) {
                    if(this.map[index-16].getName().equals("g")){
                        this.DiamondCount++;
                    }
                    if(this.map[index-16].getName().equals("X")){
                        setAlive(false);
                    }
                    this.map[index-16].setName("H");
                    this.map[index].setName("o");
                }
                else if(this.map[index-16].getName().equals("@")){
                    if (this.map[index-32].getName().equals("o")){
                        this.map[index].setName("o");
                        this.map[index-16].setName("H");
                        this.map[index-32].setName("@");
                    }
                }
                break;
            case "NUL":
                break;

        }
    }

    public void fallingRockDia() {
        for (int z = 255; z >= 0; z--) {
            if (this.map[z].getName().equals("@")) {
                if (this.map[z + 1].getName().equals("o")) {
                    this.map[z + 1].setName("@");
                    this.map[z].setName("o");
                }
            }
            if (this.map[z].getName().equals("g")) {
                if (this.map[z + 1].getName().equals("o")) {
                    this.map[z + 1].setName("g");
                    this.map[z].setName("o");
                }
            }
        }
    }


    public int getDiamondCount(){
        return this.DiamondCount;
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
