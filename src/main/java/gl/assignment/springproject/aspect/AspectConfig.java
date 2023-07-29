package gl.assignment.springproject.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class AspectConfig {

	@Around("execution(public * gl.assignment.*.*(..))")
	public void logBeforeAndAfterMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info(proceedingJoinPoint.getSignature().getName() + "Started");
		proceedingJoinPoint.proceed();
		log.info(proceedingJoinPoint.getSignature().getName() + "Ended");
	}
}
