package day03;

public class Tree implements Damageable {
    private int health = 10;
    
    public Tree() {}
    public Tree(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    //@Override
    public void hit(int damage){
        this.health -= damage;
    }
    public boolean isDead(){
        return health <= 0;
    }
}
