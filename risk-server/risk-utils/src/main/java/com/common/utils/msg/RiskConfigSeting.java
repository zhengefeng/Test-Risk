package com.common.utils.msg;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 系统资源文件配置地址
 * 
 * @author zhuxinyu.carter
 * @version $Id: P2PConfigSeting.java, v 0.1 2016年1月27日 下午1:47:28 zhuxinyu.carter Exp $
 */
public class RiskConfigSeting implements Serializable {

	private static final long serialVersionUID = 3481146102952979923L;
	/**
	 * 产品图片URL
	 */
	@Value("#{config.static_weburl}")
	private String staticWeburl;

	/**
	 * 静态服务器主机
	 */
	@Value("#{config.static_host}")
	private String staticHost;

	/**
	 * 静态服务器端口
	 */
	@Value("#{config.static_port}")
	private Integer staticPort;

	/**
	 * 静态服务器用户名
	 */
	@Value("#{config.static_userName}")
	private String staticUserName;

	/**
	 * 静态服务器密码
	 */
	@Value("#{config.static_password}")
	private String staticPassword;

	/**
	 * 静态服务器地址
	 */
	@Value("#{config.static_uploadpath}")
	private String staticUploadpath;

	/**
	 * 全民财富API平台
	 */
	@Value("#{config.qmcaifu_api}")
	private String qmcaifuApi;

	/**
	 * 是否将编辑器的内容上传到sftp中YES/NO
	 */
	@Value("#{config.upload_editor_sftp}")
	private String uploadEditorSftp = "NO";

	/**
	 * redis服务器地址
	 */
	@Value("#{config.redis_server}")
	private String redisServer;

	/**
	 * Redis服务器端口
	 */
	@Value("#{config.redis_server_port}")
	private Integer redisPort;

	/**
	 * 当前系统业务占据的是redis的第几个数据库
	 */
	@Value("#{config.redis_server_hold}")
	private String redisServerHold;

	/**
	 * ActiveMQ的服务器连接地址
	 */
	@Value("#{config.activemq_broker_url}")
	private String activeMqBrokerUrl;

	/**
	 * 运营系统的地址
	 */
	@Value("#{config.operation_server}")
	private String operationServer;

	@Value("#{config.online_server}")
	private String isOnlineServer = "Y";

	public String getStaticWeburl() {
		return staticWeburl;
	}

	public void setStaticWeburl(String staticWeburl) {
		this.staticWeburl = staticWeburl;
	}

	public String getStaticHost() {
		return staticHost;
	}

	public void setStaticHost(String staticHost) {
		this.staticHost = staticHost;
	}

	public Integer getStaticPort() {
		return staticPort;
	}

	public void setStaticPort(Integer staticPort) {
		this.staticPort = staticPort;
	}

	public String getStaticUserName() {
		return staticUserName;
	}

	public void setStaticUserName(String staticUserName) {
		this.staticUserName = staticUserName;
	}

	public String getStaticPassword() {
		return staticPassword;
	}

	public void setStaticPassword(String staticPassword) {
		this.staticPassword = staticPassword;
	}

	public String getStaticUploadpath() {
		return staticUploadpath;
	}

	public void setStaticUploadpath(String staticUploadpath) {
		this.staticUploadpath = staticUploadpath;
	}

	public String getQmcaifuApi() {
		return qmcaifuApi;
	}

	public void setQmcaifuApi(String qmcaifuApi) {
		this.qmcaifuApi = qmcaifuApi;
	}

	public String getUploadEditorSftp() {
		return uploadEditorSftp;
	}

	public void setUploadEditorSftp(String uploadEditorSftp) {
		this.uploadEditorSftp = uploadEditorSftp;
	}

	public String getRedisServer() {
		return redisServer;
	}

	public void setRedisServer(String redisServer) {
		this.redisServer = redisServer;
	}

	public Integer getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(Integer redisPort) {
		this.redisPort = redisPort;
	}

	public String getRedisServerHold() {
		return redisServerHold;
	}

	public void setRedisServerHold(String redisServerHold) {
		this.redisServerHold = redisServerHold;
	}

	public String getActiveMqBrokerUrl() {
		return activeMqBrokerUrl;
	}

	public void setActiveMqBrokerUrl(String activeMqBrokerUrl) {
		this.activeMqBrokerUrl = activeMqBrokerUrl;
	}

	public String getOperationServer() {
		return operationServer;
	}

	public void setOperationServer(String operationServer) {
		this.operationServer = operationServer;
	}

	public String getIsOnlineServer() {
		return isOnlineServer;
	}

	public void setIsOnlineServer(String isOnlineServer) {
		this.isOnlineServer = isOnlineServer;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
}
