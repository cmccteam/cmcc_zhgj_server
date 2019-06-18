package com.cmcc.config.aop;

/**
 * type,host,path
 * ClassName: WebLogBean 
 * @Description 日志处理bean
 * @author zengzhibin
 * @date 2019年4月25日
 */
public class WebLogBean {
	
	private String esindex;
	private String url;
	private String method;
	private String ip;
	
	
	public String getEsindex() {
		return esindex;
	}
	public void setEsindex(String esindex) {
		this.esindex = esindex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
