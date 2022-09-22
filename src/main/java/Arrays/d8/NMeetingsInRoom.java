package Arrays.d8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInRoom {

    public static void main(String[] args) {
        int[] start = {1,1,3,4,5,7};
        int[] end =   {2,3,4,5,6,8};
        List<Meeting> meetings = new ArrayList<>();

        for (int i =0; i < start.length; i++){
            Meeting meeting = new Meeting(start[i], end[i]);
            meetings.add(meeting);
        }

        Collections.sort(meetings, new MeetingComparator());

        int answer = 1;
        int limit = meetings.get(0).getEnd();

        for (int i = 1; i<meetings.size(); i++){

            if(meetings.get(i).getStart() > limit){
                answer++;
                limit = meetings.get(i).getEnd();
            }
        }

        System.out.println(answer);
    }
}

class MeetingComparator implements Comparator<Meeting>{

    @Override
    public int compare(Meeting m1, Meeting m2) {
        if(m1.getEnd() < m2.getEnd()){
            return -1;
        }
        return 1;
    }
}
class Meeting{
    private int start;
    private int end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}