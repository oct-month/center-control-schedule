package cn.ablocker.ccs.aspect;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import cn.ablocker.ccs.dao.DeviceDao;
import cn.ablocker.ccs.model.Device;

@Order(2)
@Component
@Aspect
public class BasicAuthAspect {
	@Autowired
	private DeviceDao deviceDao;
	
	@Pointcut("@annotation(cn.ablocker.ccs.aspect.BasicAuth)")
	public void basicAuth() {}
	
	@Before("basicAuth()")
	public void basicAuthBefore(JoinPoint jp) {
		RequestAttributes ras = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sras = (ServletRequestAttributes) ras;
		HttpServletRequest req = sras.getRequest();
		String auth = req.getHeader("Authorization");
		if (auth != null && auth.startsWith("deviceId ")) {
			String deviceId = auth.substring(9);
			Optional<Device> opd = deviceDao.findById(deviceId);
			if (!opd.isPresent()) {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
			}
		}
		else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}
}
