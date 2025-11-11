package com.ssafy.live.basic.bean;

import java.util.stream.IntStream;
import com.ssafy.live.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PointcutTestBean {

    public void save(Member member) {
        log.debug("member(bean): {}", member);
    }

    public Member select(String email) {
        Member member = Member.builder().email(email).password("1234").name("hong").build();
        log.debug("member(bean): {}", member);
        return member;
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new RuntimeException("factorial은 0 이상의 정수 필요");
        } else if (n == 0) {
            return 0;
        }
        return IntStream.rangeClosed(1, n).reduce(1, (ov, nv) -> ov * nv);
    }

    public int add(int a, int b) {
        return a + b;
    }
}
