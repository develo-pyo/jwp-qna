package qna.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteHistoryTest {
    public static final DeleteHistory DH1 = new DeleteHistory(ContentType.QUESTION, 1L, 2L, LocalDateTime.now());
    public static final DeleteHistory DH2 = new DeleteHistory(ContentType.QUESTION, 1L, 2L, LocalDateTime.now());
    public static final DeleteHistory DH3 = new DeleteHistory(ContentType.ANSWER, 2L, 3L, LocalDateTime.now());

    @DisplayName("DeleteHistory 객체 동일객체 비교 테스트")
    @Test
    void equalDeleteHistory() {
        assertThat(DH1).isEqualTo(DH2);
    }

    @DisplayName("DeleteHistory 객체 비동일객체 비교 테스트")
    @Test
    void notEqualDeleteHistory() {
        assertThat(DH2).isNotEqualTo(DH3);
    }

}
