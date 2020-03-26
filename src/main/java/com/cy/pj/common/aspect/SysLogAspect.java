package com.cy.pj.common.aspect;
//
//import java.lang.reflect.Method;
//import java.util.Date;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.jboss.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Component;
//
//
//import com.cy.pj.common.utils.IPUtils;
//import com.cy.pj.sys.common.annotation.RequiredLog;
//import com.cy.pj.sys.entity.SysLog;
//import com.cy.pj.sys.service.SysLogService;
//import com.fasterxml.jackson.databind.ObjectMapper;


//@Aspect
//@Component
//public class SysLogAspect {
//	private Logger log = Logger.getLogger(SysLogAspect.class);

	/**
	 * @Pointcut注解用于定义切入点
	 * bean表达式为切入点表达式,
	 * bean表达式内部指定的bean对象中
	 *   所有方法为切入点(进行功能扩展的点)
	 */
	//@Pointcut("bean(sysUserServiceImpl)")
	//@Pointcut("bean(*ServiceImpl)")
//	@Pointcut("@annotation(com.cy.pj.sys.common.annotation.RequiredLog)")
//	public void logPointCut() {}

	/**
	 * @Around 描述的方法为环绕通知,用于功能增强
	 * 可以再目标方法执行之前和之后添加自己的拓展业务
	 * 方法返回值类型为object
	 * 方法参数类型为ProceedingJoinPoint
	 * 方法异常跑出为Throwable类型
	 * @param jp 连接点 (封装了要执行的目标方法信息)
	 * @return 目标方法的执行结果
	 * @throws Throwable
	 */

//	@Around("logPointCut()")
//	public Object arround(ProceedingJoinPoint jointPoint) throws Throwable {
//		long startTime = System.currentTimeMillis();
//		Object result = jointPoint.proceed();//调用下一个切面方法或目标方法
//		long endTime = System.currentTimeMillis();
//		long totalTime = endTime-startTime;
//		log.info("方法执行的总时长为："+totalTime);
//		saveSysLog(jointPoint,totalTime);
//		return result;
//	}
//	@Autowired
//	private SysLogService logService;
//	//获取用户行为日志信息,然后将日志写入到数据库
//		private void saveSysLog(ProceedingJoinPoint joinPoint,long time)throws Exception {
//			//1.获取日志信息
//			String username="admin";
//			//获取目标方法对象
//			Method targetMethod = getTargetMethod(joinPoint);
//			//获取目标方法名:目标类全名+方法名
//			String classMethodName=getTargetMethodName(targetMethod);
//			//获取操作名
//			String operation= getOperation(targetMethod);
//			//String params=Arrays.toString(joinPoint.getArgs());
//			//获取方法执行时的实际参数
//			String params=
//			new ObjectMapper().writeValueAsString(joinPoint.getArgs());
//			//2.封装日志信息
//			 SysLog Syslog=new SysLog();
//			 Syslog.setId(null);
//			 Syslog.setUsername(username);
//			 Syslog.setOperation(operation);
//			 Syslog.setMethod(classMethodName);
//			 Syslog.setParams(params);//method params
//			 Syslog.setIp(IPUtils.getIpAddr());//ip 地址
//			 Syslog.setTime(time);//
//			 Syslog.setCreatedTime(new Date());
//			 System.out.println(Syslog);
//			//3.持久化日志信息
//			logService.saveObject(Syslog);
//		}

//		private String getOperation(Method targetMethod) {
//			RequiredLog rLog=
//			targetMethod.getAnnotation(RequiredLog.class);
//			return rLog.value();
//		}
//
//		private String getTargetMethodName(Method targetMethod) {
//			return targetMethod.getDeclaringClass().getName()
//			+"."+targetMethod.getName();
//		}
//
//		private Method getTargetMethod(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
//			Class<?> targetClass=joinPoint.getTarget().getClass();
//			MethodSignature s=(MethodSignature)joinPoint.getSignature();//方法签名
//			Method targetMethod=
//					targetClass.getMethod(
//							s.getName(),
//					        s.getParameterTypes());
//			return targetMethod;
//		}
//	}


/*
	@Before("logPointCut()")
	public void MethodName(JoinPoint jp) {
		System.out.println(jp.getSignature().getName());
	}
 */

