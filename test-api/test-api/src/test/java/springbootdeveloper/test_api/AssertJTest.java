package springbootdeveloper.test_api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {
    @Test
    void testSum() {
        int sum = 3;
        int a = 1;
        int b = 2;

        assertThat(a + b).isEqualTo(sum);

    }
}
