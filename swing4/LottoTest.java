package swing4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTest {

    public static void main(String[] args) {

        Lotto lotto = new Lotto();
        String numbers = lotto.createNumber();

        System.out.println(numbers);

        }
    }



