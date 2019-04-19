package controller;

import entity.Video;
import entity.VideoDetail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class VideoController {
    private ArrayList<Video> list = new ArrayList<>();
    public void readFile() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/tomandjerry.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        int count = 0;
        while ((line = br.readLine()) != null){
            if (count == 0){
                count++;
                continue;
            }
            String[] splitted = line.split("\\s{2,}");
            if(splitted.length == 4){
                String day = splitted[0];
                String id = splitted[1];
                String title = splitted[2];
                double view = Double.parseDouble(splitted[3]);
                Video video = new Video(day,id,title,view);
                list.add(video);
            }
        }
    }
    public void calculateView(){
        HashMap<String, VideoDetail> statistic = new HashMap<>();
        for (Video video:
                list) {
            double view = 0;
            if(statistic.containsKey(video.getId())){
                VideoDetail videoDetail = statistic.get(video.getId());
                view = videoDetail.getView();
            }
            view += video.getView();
            VideoDetail videoDetail = new VideoDetail(video.getId(),video.getTitle(),view);
            statistic.put(video.getId(),videoDetail);
        }
        System.out.printf("%-10s%-15s%-10s\n","Mã video", "Tiêu đề", "View");
        for (String id:
                statistic.keySet()) {
            VideoDetail videoDetail = statistic.get(id);
            System.out.printf("%-10s%-15s%.1f\n",id,videoDetail.getTitle(),videoDetail.getView());

        }
    }
}
