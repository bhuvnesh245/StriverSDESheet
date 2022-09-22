package Arrays.d8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MinmumNoOfPlatformRequired {

    public static void main(String[] args) {
        int[] arrival = {1030,1020};
        int[] departure = {1055,1145};

        Set<Integer> notVisited = new HashSet<>();

        for (int i=1; i< arrival.length;i++){
            notVisited.add(i);
        }

        int platform = 0;
        int prevDeparture = departure[0];
        boolean flag = true;
        while (!notVisited.isEmpty()){
            int prevDepartureIndex = -1;
            platform++;
            for (Integer visit : notVisited.stream().collect(Collectors.toList())){
                if(prevDeparture < arrival[visit]) {
                    prevDeparture = departure[visit];
                    notVisited.remove(visit);
                }else if(flag){
                    flag = false;
                    prevDepartureIndex = visit;
                }
            }

            if(notVisited.size() == 1){
                platform++;
                break;
            }

            if(prevDepartureIndex > 0){
                prevDeparture = departure[prevDepartureIndex];
                notVisited.remove(prevDepartureIndex);
            }
            flag = true;
        }

        System.out.println(platform);


    }
}
