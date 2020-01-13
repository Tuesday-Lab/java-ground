package com.circlee.utils;


import com.circlee.todo.utils.NumUtil;
import com.circlee.todo.utils.StringUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class UtilTest {

    @DisplayName("1.숫자들의 합")
    @Test
    public void test1() {
        int[] nums = new int[]{111, 222, 333, 444};
        Assertions.assertThat(NumUtil.sum(nums))
                .isEqualTo(1110);
    }

    @DisplayName("2.이니셜로 그룹핑 하기")
    @Test
    public void test2() {
        String[] names = new String[]{
            "john"
            , "jake"
            , "jessy"
            , "Lobe"
            , "Max"
            , "Lobby"
            , "Cron"
        };

        Map<Character, List<String>> result = StringUtil.groupByFirstChar(names);

        Assertions.assertThat(result)
                .containsOnlyKeys('J', 'L', 'M', 'C');

        Assertions.assertThat(result.get('J'))
                .hasSize(3);

        Assertions.assertThat(result.get('L'))
                .hasSize(2);

        Assertions.assertThat(result.get('M'))
                .hasSize(1);

        Assertions.assertThat(result.get('C'))
                .hasSize(1);
    }





}
