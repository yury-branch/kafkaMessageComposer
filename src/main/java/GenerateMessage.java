import io.branch.data.eventontology.EventDatasource;
import io.branch.data.eventontology.NoCurrentFeatureAttributedTouchData;
import io.branch.data.eventontology.Open;

import java.io.IOException;
import java.util.Date;


public class GenerateMessage {

    public static void main(String[] args) throws IOException {
        Open o = Open.builder()
                .withDatasource(EventDatasource.OPEN)
                .withName("click")
                .withAppName("MMPDataExport")
                .withLastAttributedTouchData(NoCurrentFeatureAttributedTouchData.builder()
                        //.put("datasource", "OPEN")
                        //.put("name", "open")
                        //.put("app_id", "464543593810383762")
                        //.put("app_name", "MMPDataExport")
                        .put("$3p", "a_facebook")
                        .put("~campaign", "MMP Export test")
                        //.put("live_or_test", "LIVE")
                        //.put("testing_app", "true")
                        //.put("timestamp", new Date().getTime())
                        .build())
                // ...
                .withAppId(Long.valueOf("464543593810383762"))
                .build();
        Producer p = new Producer();
        p.produce("eo_click", o.encode());



    }
}
