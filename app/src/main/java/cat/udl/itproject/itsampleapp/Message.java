package cat.udl.itproject.itsampleapp;

import java.io.Serializable;

public class Message implements Serializable {

    private String mTitle;
    private String mContent;

    public Message(String mTitle, String mContent) {
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }
}
