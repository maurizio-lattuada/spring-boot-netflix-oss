package com.fortytwotalents.spring.cloud.workshop.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RequestLoggingFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		if (log.isDebugEnabled()) {
			log.debug(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		}
		return null;
	}

}
