package chapter2.wordcount;

/**
 * Created by wjs on 2017/3/14.
 */
public class Page {
    private String title;
    private String text;
    public Page(String title, String text){
        this.title = title;
        this.text = text;
    };
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return "Page{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
