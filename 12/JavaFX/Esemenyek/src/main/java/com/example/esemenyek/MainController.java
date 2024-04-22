package com.example.esemenyek;

import java.io.IOException;

public class MainController {
    protected static final String CREATE_EVENT_VIEW = "createevent-view.fxml";
    protected static final String LIST_EVENT_VIEW = "eventlist-view.fxml";
    protected static final String SEARCH_EVENT_VIEW = "searchevent-view.fxml";

    public void createEvent() throws IOException {
        MainApplication main = new MainApplication();
        main.changeScene(CREATE_EVENT_VIEW);
    }

    public void listEvent() throws IOException {
        MainApplication main = new MainApplication();
        main.changeScene(LIST_EVENT_VIEW);
    }

    public void seachEvent() throws IOException {
        MainApplication main = new MainApplication();
        main.changeScene(SEARCH_EVENT_VIEW);
    }
}