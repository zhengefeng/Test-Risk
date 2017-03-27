package com.common.utils.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.common.utils.msg.RiskConfigSeting;
import com.common.utils.spring.SpringContextHolder;

/**
 * SFTP 处理
 * 
 * @author zhuxinyu.carter
 * @version $Id: SftpClientUtil.java, v 0.1 2016年1月23日 下午2:44:31 zhuxinyu.carter Exp $
 */
public class SftpClientUtil {

	private final Logger logger = LoggerFactory.getLogger(SftpClientUtil.class);

	private ChannelSftp sftp = null;

	/** 主机 */
	private String host = "";

	/** 端口 */
	private int port = 0;

	/** 用户名 */
	private String username = "";

	/** 密码 */
	private String password = "";

	public static SftpClientUtil getInstance() {
		RiskConfigSeting setting = SpringContextHolder.getBean(RiskConfigSeting.class);
		SftpClientUtil sftpclient = new SftpClientUtil();
		
		sftpclient.host = setting.getStaticHost();
		sftpclient.port = setting.getStaticPort();
		sftpclient.username = setting.getStaticUserName();
		sftpclient.password = setting.getStaticPassword();
		return sftpclient;
	}

	/**
	 * 连接sftp服务器
	 */
	public void connect() throws Exception {
		JSch jsch = new JSch();
		Session sshSession = jsch.getSession(this.username, this.host, this.port);

		sshSession.setPassword(password);
		Properties sshConfig = new Properties();
		sshConfig.put("userauth.gssapi-with-mic", "no");
		sshConfig.put("StrictHostKeyChecking", "no");
		sshSession.setConfig(sshConfig);
		sshSession.connect(20000);

		Channel channel = sshSession.openChannel("sftp");
		channel.connect();
		this.sftp = (ChannelSftp) channel;
	}

	public void disconnect() throws Exception {
		if (this.sftp != null) {
			if (this.sftp.isConnected()) {
				this.sftp.disconnect();
			} else if (this.sftp.isClosed()) {
				logger.debug(SftpClientUtil.class + " sftp is closed already");
			}
		}
	}

	/**
	 * 上传单个文件
	 * 
	 * @param directory
	 *            上传的目录
	 * @param uploadFile
	 *            要上传的文件
	 */
	public void upload(String directory, String uploadFile) throws Exception {
		try {
			this.sftp.cd(directory);
		} catch (Exception e) {
			String paths[] = StringUtils.split(directory, "/");
			this.sftp.cd("/");
			for (String path : paths) {
				try {
					this.sftp.cd(path);
				} catch (Exception ef) {
					this.sftp.mkdir(path);
					this.sftp.cd(path);
				}
			}
		}
		File file = new File(uploadFile);
		this.sftp.put(new FileInputStream(file), file.getName());
	}

	/**
	 * 上传目录下全部文件
	 * 
	 * @param directory
	 *            上传的目录
	 */
	public void uploadByDirectory(String directory) throws Exception {

		String uploadFile = "";
		List<String> uploadFileList = this.listFiles(directory);
		Iterator<String> it = uploadFileList.iterator();

		while (it.hasNext()) {
			uploadFile = it.next().toString();
			this.upload(directory, uploadFile);
		}
	}

	/**
	 * 下载单个文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param downloadFile
	 *            下载的文件
	 * @param saveDirectory
	 *            存在本地的路径
	 */
	public void download(String directory, String downloadFile, String saveDirectory) throws Exception {
		String saveFile = saveDirectory + "//" + downloadFile;

		this.sftp.cd(directory);
		File file = new File(saveFile);
		this.sftp.get(downloadFile, new FileOutputStream(file));
	}

	/**
	 * 下载目录下全部文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param saveDirectory
	 *            存在本地的路径
	 */
	public void downloadByDirectory(String directory, String saveDirectory) throws Exception {
		String downloadFile = "";
		List<String> downloadFileList = this.listFiles(directory);
		Iterator<String> it = downloadFileList.iterator();

		while (it.hasNext()) {
			downloadFile = it.next().toString();
			if (downloadFile.toString().indexOf(".") < 0) {
				continue;
			}
			this.download(directory, downloadFile, saveDirectory);
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param directory
	 *            要删除文件所在目录
	 * @param deleteFile
	 *            要删除的文件
	 */
	public void delete(String directory, String deleteFile) throws Exception {
		this.sftp.cd(directory);
		this.sftp.rm(deleteFile);
	}

	/**
	 * 列出目录下的文件
	 * 
	 * @param directory
	 *            要列出的目录
	 * @return list 文件名列表
	 */
	public List<String> listFiles(String directory) throws Exception {

		Vector<?> fileList;
		List<String> fileNameList = new ArrayList<String>();

		fileList = this.sftp.ls(directory);
		Iterator<?> it = fileList.iterator();

		while (it.hasNext()) {
			String fileName = ((LsEntry) it.next()).getFilename();
			if (".".equals(fileName) || "..".equals(fileName)) {
				continue;
			}
			fileNameList.add(fileName);

		}

		return fileNameList;
	}

	/**
	 * 更改文件名
	 * 
	 * @param directory
	 *            文件所在目录
	 * @param oldFileNm
	 *            原文件名
	 * @param newFileNm
	 *            新文件名
	 */
	public void rename(String directory, String oldFileNm, String newFileNm) throws Exception {
		this.sftp.cd(directory);
		this.sftp.rename(oldFileNm, newFileNm);
	}

	public void cd(String directory) throws Exception {
		this.sftp.cd(directory);
	}

	public InputStream get(String directory) throws Exception {
		InputStream streatm = this.sftp.get(directory);
		return streatm;
	}

}
