package com.ssafy.live;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ssafy.live.basic.bean.PointcutTestBean;
import com.ssafy.live.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class AdviceTypeTest {
    @Autowired
    PointcutTestBean ptBean;

    @Test
    // TODO: 04-02.advice가 적용된 결과 비밀번호가 변경된 것을 확인하세요.
    public void beforetest() {
        Member member = Member.builder().email("abc@def.net").password("1234").name("hong").build();
        ptBean.save(member);
        Assertions.assertEquals("4321", member.getPassword());
    }

    @Test
    // TODO: 05-02.advice가 적용된 결과 비빌번호가 변경된 것을 확인하세요.
    public void afterReturningTest() {
        Member member = ptBean.select("abc@def.net");
        Assertions.assertEquals("*", member.getPassword());
    }

    @Test
    // TODO: 06-02.advice가 적용된 결과 예외 발생 시 email 전송을 확인하세요.
    public void afterThrowingTest() {
        Assertions.assertThrows(RuntimeException.class, () -> ptBean.factorial(-1));
    }

    @Test
    // TODO: 07-02.advice가 적용된 결과를 확인하세요.
    public void aroundTest1() {
        long result = ptBean.add(5, 6);
        Assertions.assertEquals(56, result);

        result = ptBean.add(5, 7);
        Assertions.assertEquals(28, result);
    }

    // TODO: 07-04. factorial을 호출하고 cache가 적절히 동작하는지 확인하세요.
    @Test
    public void aroundTest2() {
        long result = ptBean.factorial(5);
        result = ptBean.factorial(5);
        Assertions.assertEquals(120, result);
    }

}
