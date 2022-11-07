package qna.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DeleteHistoryTest {

    @Autowired
    DeleteHistoryRepository deleteHistoryRepository;

    @Test
    public void save() {
        DeleteHistory deleteHistory = new DeleteHistory(ContentType.ANSWER, 1L, 1L, LocalDateTime.now());
        DeleteHistory savedDeleteHistory = deleteHistoryRepository.save(deleteHistory);
        assertThat(savedDeleteHistory).isNotNull();
    }
}