package kr.or.ddit.spring.bean;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * LifeCycleBean.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 21. "K.S.J" 최초 생성
 *
 * </pre>
 */
public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, InitializingBean{
	//slf4j : logback
	Logger logger = LoggerFactory.getLogger(LifeCycleBean.class);
	
	public LifeCycleBean() {
		logger.debug("{}, {}", "LifeCycleBean", "생성자");
	}
	
	
	@Override
	public void setBeanName(String name) {
		logger.debug("{}, name : {}", "setBeanName", name);
		
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.debug("{}, beanFactory : {}", "setBeanFactory", beanFactory);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		logger.debug("{}, resourceLoader : {}", "setResourceLoader", resourceLoader);
	}
	
	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		logger.debug("{}, applicationEventPublisher : {}", "setApplicationEventPublisher", applicationEventPublisher);
	}
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		logger.debug("{}, messageSource : {}", "setMessageSource", messageSource);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		logger.debug("{},  applicationContext : {}", "setApplicationContext", applicationContext);
	}

	@PostConstruct
	public void postConstruct() {
		logger.debug("{}", "postConstruct");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("{}", "afterPropertiesSet");
	}
	
	public void initMethod() {
		logger.debug("{}", "initMethod");
	}

}
