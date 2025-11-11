package com.ssafy.live;

import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ssafy.live.basic.bean.PointcutTestBean;
import com.ssafy.live.model.dao.MemberDao;
import com.ssafy.live.model.dto.Member;
import com.ssafy.live.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class AOPTest {
    // TODO: 01. MemberService를 주입받고 selectDetail 메서드의 동작을 테스트해보자.

    // END

    @Autowired
    PointcutTestBean ptBean;

    @Test
    // TODO: 03-2. pointcut이 변경될 때 적용되는 메서드를 확인하세요.
    public void pointCutTest() {
        Member member = Member.builder().name("hong").password("1234").email("abc@def.net").build();
        ptBean.save(member);
        ptBean.select(member.getEmail());
        ptBean.factorial(0);
        ptBean.add(0, 0);
    }
}
