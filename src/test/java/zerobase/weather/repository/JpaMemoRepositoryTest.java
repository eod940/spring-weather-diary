package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() throws Exception {
        //given
        Memo newMemo = new Memo(10, "hihi memo");

        //when
        jpaMemoRepository.save(newMemo);

        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() throws Exception {
        //given
        Memo newMemo = new Memo(11, "jpa");

        //when: id는 mysql에서 auto_increment 되어서 의미가 없음
        Memo save = jpaMemoRepository.save(newMemo);
        System.out.println(save.getId());

        //then
        Optional<Memo> result = jpaMemoRepository.findById(save.getId());
        assertEquals(result.get().getText(), "jpa");
    }
}