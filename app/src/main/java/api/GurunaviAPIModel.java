package api;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GurunaviAPIModel extends Thread {

    public void run() {
        System.out.println("sleepを始めます");

        try {
            //  レストランAPIを叩く
            String gnavi = "https://api.gnavi.co.jp/RestSearchAPI/v3/";
            //　APIアクセスキー
            String keyid = "?keyid=" + "c8386ce589f0b9400473d96556fe9f4d";
            // 緯度
            String latitude = "&latitude=" + "35.681382";
            // 軽度
            String longitude = "&longitude=" + "139.76608399999998";
            // 	緯度/経度からの検索範囲(半径)  1:300m、2:500m、3:1000m、4:2000m、5:3000m
            String range = "&range=" + 1;
            String test = "";
            String request = gnavi + keyid + latitude + longitude + range;
            URL url = new URL(request);
            //connectionのインスタンス
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //リクエストのメソッドを指定
            connection.setRequestMethod("GET");
            //通信開始
            connection.connect();

            //　レスポンスコードを戻る
            int responseCode = connection.getResponseCode();
            // レスポンスコードを判断する、OKであれば、進める
            if(responseCode == HttpURLConnection.HTTP_OK){
                // 通信に成功した
                // テキストを取得する
                InputStream in= connection.getInputStream();
                String encoding = connection.getContentEncoding();
                if(null == encoding){
                    encoding = "UTF-8";
                }
                StringBuffer result = new StringBuffer();
                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);


                RestaurantInfo.init();  // グローバル変数を初期化

                String line = null;
                // 1行ずつテキストを読み込む
                while((line = bufReader.readLine()) != null) {
                    result.append(line);
                    if(line.contains("\"id\":")){
                        RestaurantInfo.id += (line.substring(19, line.length() - 2) + ",");
                    }
                    if(line.contains("\"name\":")){
                        RestaurantInfo.name += (line.substring(21, line.length() - 2) + ",");
                    }
                    if(line.contains("\"latitude\":")){  //longitude
                        RestaurantInfo.latitude += (line.substring(25, line.length() - 2) + ",");
                    }
                    if(line.contains("\"longitude\":")){
                        RestaurantInfo.longitude += (line.substring(26, line.length() - 2) + ",");
                    }
                    if(line.contains("\"url\":")){
                        RestaurantInfo.url += (line.substring(20, line.length() - 2) + ",");
                    }
                    if(line.contains("\"address\":")){
                        RestaurantInfo.addres += (line.substring(23, line.length() - 2) + ",");
                    }
                    if(line.contains("\"tel\":")){
                        RestaurantInfo.tel += (line.substring(20, line.length() - 2) + ",");
                    }
                    if(line.contains("\"opentime\":")){
                        RestaurantInfo.opentime += (line.substring(25, line.length() - 2) + ",");
                    }
                }
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        System.out.println("sleepを終わります" );
    }


}