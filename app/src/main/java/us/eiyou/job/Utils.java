package us.eiyou.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Au on 2016/2/24.
 */
public class Utils {
    public static String getContext(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.getElementsByClass("list-task").text().split("\\.\\.\\.")[0].replace("【", "\n\n【").replace("一、","\n").replace("二、","\n")
                .replace("三、","\n").replace(",","\n").replace("，","\n")+"...";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getContext("http://task.zbj.com/t-ydyykf/m3w2s5o7.html"));
    }
}
