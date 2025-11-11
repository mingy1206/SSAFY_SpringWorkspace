package com.ssafy.live.basic.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ssafy.live.model.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AdviceTypeTestAspect {
    // TODO: 04-01. PointcutTestBean의 save가 호출될 때 비밀번호가 암호화되도록 해보자.
    //  암호화는 단순히 문자열을 뒤집는 것으로 처리

    // END

    // TODO: 05-01. PointcutTestBean의 select가 호출된 후 반환되는 Member의 비밀번호를 마스킹해보자.

    // END

    // TODO: 06-01. P.T.Bean의 메서드가 호출될 때 예외 발생 시 관리자에게 email이 전송되는 것처럼 처리해보자.

    // END

    // TODO: 07-01. pointcut을 읽고 적용 대상을 파악한 후 advice 동작을 확인하세요.
    @Around("execution(* *..PointcutTestBean.add(int, int))")
    public Integer modifyAdd(ProceedingJoinPoint pjp) throws Throwable { // 예외 전파

        Object[] args = pjp.getArgs();
        args[0] = (Integer) args[0] * 10; // 1. 파라미터 완전 대체 가능
        Integer result = (Integer) pjp.proceed(args); // 2. 타겟의 메서드 호출
        return result % 2 == 0 ? result : result / 2; // 3. 결과 조작 가능
    }

    private final Map<Integer, Long> cache = new HashMap<>();

    // TODO: 07-03. PointcutTestBean의 factorial이 호출될 때 값을 캐싱해보자.

    // END
}
