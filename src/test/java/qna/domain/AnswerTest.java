package qna.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import qna.NotFoundException;
import qna.UnAuthorizedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static qna.domain.DomainTestFactory.*;

@DataJpaTest
public class AnswerTest {
    public static final Answer A1 = new Answer(UserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents1");
    public static final Answer A2 = new Answer(UserTest.SANJIGI, QuestionTest.Q1, "Answers Contents2");

    @Test
    @DisplayName("isOwner 테스트 : 답변 작성자가 유저와 같은지 테스트")
    public void isOwnerTest() {
        User answerUser = createUser("DEVELOPYO");
        Question question = createQuestion().writeBy(createUser("TESTER"));
        Answer answer = createAnswer(answerUser, question);

        assertThat(answer.isOwner(answerUser)).isTrue();
    }

    @Test
    @DisplayName("answer 생성자 테스트 : 작성자 없을 경우 예외 처리 테스트")
    public void createAnswerTest() {
        assertThatThrownBy(() -> new Answer(null, createQuestion(), "contents")).isInstanceOf(UnAuthorizedException.class);
    }

    @Test
    @DisplayName("answer 생성자 테스트 : 질문글 없을 경우 예외 처리 테스트")
    public void createAnswerTest2() {
        assertThatThrownBy(() -> new Answer(createUser("DEVELOPYO"), null, "contents")).isInstanceOf(NotFoundException.class);
    }
}
