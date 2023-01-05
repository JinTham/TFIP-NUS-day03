package day03;

public class Zelda {
    public static void main(String[] args){
        Monster monster = new Monster();
        RockMonster rockMonster = new RockMonster();
        Tree tree = new Tree();
        Link link = new Link();

        Link.attack(monster);
        Link.attack(rockMonster);
        Link.attack(tree);

        if (monster.isDead()){
            System.out.println("You win");
        }
    }
}
