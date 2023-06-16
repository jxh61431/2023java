package swing4;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    // 로또 번호를 생성하는 함수
    public List<Integer> create() {

        List<Integer> number = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            number.add(i);
        }

        Collections.shuffle(number);

        return number.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());

    }

    public String createNumber() {
        StringBuilder sb = new StringBuilder();
        for (Integer x : create()) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(x);
        }
        return sb.toString();
    }
}



