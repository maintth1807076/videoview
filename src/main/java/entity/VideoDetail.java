package entity;

public class VideoDetail {
    private String id;
    private String title;
    private double view;

    public VideoDetail() {
    }

    public VideoDetail(String id, String title, double view) {
        this.id = id;
        this.title = title;
        this.view = view;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getView() {
        return view;
    }

    public void setView(double view) {
        this.view = view;
    }
}
