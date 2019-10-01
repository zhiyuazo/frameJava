package aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("perfA2")
public class PerfAspect2 {
	@Around(value="execution(* service.ProductService2.* (..))")
	public Object time(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
        System.out.println("monitor start :" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("monitor end :" + joinPoint.getSignature().getName());
		long end = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature().getName() + " consume : " + (end-start) );
        return object;
    }
}
