package day03;

public class PlaystoreData {
    //Declaration
    private String category;
    private String highestRatedGame;
    private String lowestRatedGame;
    private Float highestRating = -1F;
    private Float lowestRating = 999F;
    private Float totalRating = 0F;
    private int count = 0;
    //Constructor
    public PlaystoreData(String category){
        this.category = category;
    }
    //Getters
    public String getCategory(){
        return this.category;
    }
    public Float getAverageRating(){
        return this.totalRating/this.count;
    }
    public String getHighestRatedGame(){
        return this.highestRatedGame;
    }
    public String getLowestRatedGame(){
        return this.lowestRatedGame;
    }
    public Float getHighestRating(){
        return this.highestRating;
    }
    public Float getLowestRating(){
        return this.lowestRating;
    }
    //Methods
    public void add(Float rating){
        this.count ++;
        this.totalRating += rating;
    }
    public void evaluate(String name, Float rating){
        if (rating>this.highestRating){
            this.highestRating = rating;
            this.highestRatedGame = name; 
        } else if (rating<this.lowestRating){
            this.lowestRating = rating;
            this.lowestRatedGame = name; 
        }
    }
}
