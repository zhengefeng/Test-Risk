package com.risk.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.risk.biz.credit.ReportBiz;

/**
 * 
 * @author chenwenhai
 * @version $Id: BatchQueryController.java, v 0.1 2016年9月1日 上午10:58:06 chenwenhai Exp $
 */
@Controller
@RequestMapping("batch")
public class BatchQueryController {

	private static final Logger logger = LoggerFactory.getLogger(BatchQueryController.class);

	@RequestMapping("batchQuery")
	public String batchQuery() {
		return "batch/batchQuery";
	}

	@ResponseBody
	@RequestMapping("submitBatchQuery")
	public Object submitBatchQuery(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {

		Map<String, Object> map = new HashMap<String, Object>();
		if (file != null) {
			Map<String, Object> readMap = readExcelFile(file); // 解析excel文件
			if ("00".equals(readMap.get("code"))) {
				// 解析文件成功，
				final List<Map<String, Object>> paramMapList = (List<Map<String, Object>>) readMap.get("data");
				System.out.println(paramMapList);
				if (paramMapList != null && paramMapList.size() > 0) {
					// 循环发送进行查询 .....
					for (int i = 0; i < paramMapList.size(); i++) {
						// TODO 
					}
				}

			} else {
				return readMap;
			}
		} else {
			map.put("code", "01");
			map.put("msg", "选择的文件不存在！");
		}

		return map;
	}

	/**
	 * 解析excel 文件
	 * 
	 * @param file
	 * @return
	 */
	private Map<String, Object> readExcelFile(MultipartFile file) {
		Map<String, Object> map = new HashMap<String, Object>();
		String fileName = file.getOriginalFilename();
		Workbook workbook = null;
		InputStream is = null;
		try {
			is = file.getInputStream();
			if (fileName.endsWith(".xls")) {
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(is);
			}
			Sheet sheet = workbook.getSheetAt(0);
			int rowNum = sheet.getLastRowNum();
			if (rowNum > 0) {
				List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
				for (int i = 1; i < rowNum; i++) {
					Row row = sheet.getRow(i);
					if (row != null) {
						int columnNum = row.getLastCellNum();
						if (columnNum > 0) {
							Map<String, Object> paramMap = new HashMap<String, Object>();
							for (int j = 1; j < columnNum; j++) {
								Cell cell = row.getCell(j);
								if (cell != null) {
									cell.setCellType(HSSFCell.CELL_TYPE_STRING);
									Object cellValue = getCellFormatValue(cell);
									switch (j) {
									case 1:
										paramMap.put("cardNum", cellValue); // 银行卡号
										break;
									case 2:
										paramMap.put("carNo", cellValue); // 车牌号
										break;
									case 3:
										paramMap.put("carType", cellValue); // 号牌种类(二选一)
										break;
									case 4:
										paramMap.put("caseId", cellValue); // 涉诉ID号
										break;
									case 5:
										String caseType = "";
										if (cellValue.equals("裁判文书")) {
											caseType = "cpws";
										} else if (cellValue.equals("执行公告")) {
											caseType = "zxgg";
										} else if (cellValue.equals("失信公告")) {
											caseType = "sxgg";
										} else if (cellValue.equals("开庭公告")) {
											caseType = "ktgg";
										} else if (cellValue.equals("法院公告")) {
											caseType = "fygg";
										} else if (cellValue.equals("网贷黑名单")) {
											caseType = "wdhmd";
										} else if (cellValue.equals("案件流程信息")) {
											caseType = "ajlc";
										}
										paramMap.put("caseType", caseType); // 涉诉详情-涉诉类型*
										break;
									case 6:
										paramMap.put("certno", cellValue); // 证件号码
										break;
									case 7:
										paramMap.put("certtype", cellValue); // 证件类型
										break;
									case 8:
										paramMap.put("drivingNo", cellValue); // 驾驶证号
										break;
									case 9:
										paramMap.put("engineNo", cellValue); // 发动机号(二选一)
										break;
									case 10:
										paramMap.put("idCard", cellValue); // 身份证号码
										break;
									case 11:
										paramMap.put("imei", cellValue); // 手机设备号
										break;
									case 12:
										paramMap.put("imsi", cellValue); // Sim卡序列号
										break;
									case 13:
										String keyType = "";
										if (cellValue.equals("个人担任高管信息")) {
											keyType = "gl";
										} else if (cellValue.equals("个人担任法定代表人信息")) {
											keyType = "fr";
										} else if (cellValue.equals("个人股权投资信息")) {
											keyType = "gd";
										}
										paramMap.put("keyType", keyType); // 个人工商法信息-查询类型 *
										break;
									case 14:
										paramMap.put("mobileNum", cellValue); // 手机号
										break;
									case 15:
										paramMap.put("name", cellValue); // 姓名
										break;
									case 16:
										paramMap.put("sreason", cellValue); // 查询原因
										break;
									case 17:
										paramMap.put("telephone", cellValue); // 固定电话
										break;
									}
								}
							}
							mapList.add(paramMap);
						}

					}
				}

				// 发送mapList 进行批量查询
				// System.out.println(mapList);
				map.put("data", mapList);
				map.put("code", "00");
				map.put("msg", "解析文件成功成功！");
			}

		} catch (Exception e) {
			logger.error("解析文件出现异常！", e);
			map.put("code", "02");
			map.put("msg", "解析Excel文件失败！");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	/**
	 * 根据Cell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	private Object getCellFormatValue(Cell cell) {
		Object cellvalue = null;
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
			case Cell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (DateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// data格式是带时分秒的：2013-7-10 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// data格式是不带带时分秒的：2013-7-10
					Date date = cell.getDateCellValue();
					cellvalue = date;
				} else {// 如果是纯数字

					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:// 默认的Cell值
				cellvalue = null;
			}
		} else {
			cellvalue = null;
		}
		return cellvalue;
	}
}
