package mainthread;

import controller.VideoController;

import java.io.IOException;

public class mainthread {
    public static void main(String[] args) throws IOException {
        VideoController controller = new VideoController();
        controller.readFile();
        controller.calculateView();
    }
}
