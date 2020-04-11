package pl.edu.agh.dronka.shop.model;

public enum MusicGenre {
    HIP_HOP("Hip-hop"), POP("POP"), JAZZ("Jazz");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    private MusicGenre(String displayName) {
        this.displayName = displayName;
    }
}
