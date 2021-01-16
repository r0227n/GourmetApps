package ViewModel;

import api.RestaurantInfo;
import java.util.Random;

public class RandomlyChooseViewModel {
    public String[] Introduction(){
        String[] id = RestaurantInfo.id.split(",", 0);
        String[] name = RestaurantInfo.name.split(",", 0);
        String[] latitude = RestaurantInfo.latitude.split(",", 0);
        String[] longitude = RestaurantInfo.longitude.split(",", 0);
        String[] url = RestaurantInfo.url.split(",", 0);
        String[] addres = RestaurantInfo.addres.split(",", 0);
        String[] tel = RestaurantInfo.tel.split(",", 0);
        String[] opentime = RestaurantInfo.opentime.split(",", 0);

        String[] values = new String[8];
        int num = new Random().nextInt(id.length);

        values[0] = id[num];
        values[1] = name[num];
        values[2] = latitude[num];
        values[3] = longitude[num];
        values[4] = url[num];
        values[5] = addres[num];
        values[6] = tel[num];
        values[7] = opentime[num];
        return values;
    }
}
