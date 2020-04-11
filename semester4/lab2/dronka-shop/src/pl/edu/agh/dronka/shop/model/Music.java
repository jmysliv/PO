package pl.edu.agh.dronka.shop.model;

public class Music extends Item {

    private MusicGenre genre;
    private boolean video;

    public Music(String name, Category category, int price, int quantity, MusicGenre genre, boolean video){
        super(name, category, price, quantity);
        this.genre = genre;
        this.video = video;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }
}
