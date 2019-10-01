package aspect;
import org.aspectj.lang.ProceedingJoinPoint;
public class PerfAspect {
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
