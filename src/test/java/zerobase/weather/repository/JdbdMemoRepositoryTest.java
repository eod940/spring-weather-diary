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
class JdbdMemoRepositoryTest {

    @Autowired
    JdbdMemoRepository jdbdMemoRepository;

    @Test
    void insertMemoTest() throws Exception {
        //given
        Memo newMemo = new Memo(1, "this is new memo~ test");

        //when
        jdbdMemoRepository.save(newMemo);

        //then
        Optional<Memo> result = jdbdMemoRepository.findById(1);
        assertEquals(result.get().getText(), "this is new memo~ test");
    }

    @Test
    void findAllMemoTest() throws Exception {
        //given
        Memo newMemo = new Memo(1, "this is new memo~ test");
        jdbdMemoRepository.save(newMemo);
        List<Memo> memoList = jdbdMemoRepository.findAll();

        //when
        System.out.println(memoList);

        //then
        assertNotNull(memoList);
    }
}