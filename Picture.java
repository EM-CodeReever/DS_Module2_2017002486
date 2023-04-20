//Name: Elliot Morrison
//ID: 2017002486
public class Picture {
    private Integer pictureId;
    private String pictureName;
    private String albumName;
    private float pictureSize;

    public Picture(){
        pictureId = 0;
        pictureName = "n/a";
        pictureSize = 0.0f;
        albumName = "n/a";
    }

    public Picture(Integer pictureId, String pictureName, String albumName, float pictureSize) {
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.albumName = albumName;
        this.pictureSize = pictureSize;
    }

    public Picture(Picture p){
        pictureId = p.pictureId;
        pictureName = p.pictureName;
        pictureSize = p.pictureSize;
        albumName = p.albumName;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public float getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(float pictureSize) {
        this.pictureSize = pictureSize;
    }

    @Override
    public String toString() {
        return "Picture[" +
                "pictureId=" + pictureId +
                ", pictureName='" + pictureName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", pictureSize=" + pictureSize +
                ']';
    }
}
