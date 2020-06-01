package ceui.lisa.base.repo;

import java.util.ArrayList;
import java.util.List;

public class Repo {


    public static List<String> constList(){
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            stringList.add("this is data " + (i + 1));
        }
        return stringList;
    }
}
