package com.risk.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成pdf格式个人征信报告
 * Created by zhenge.feng.
 */
@RequestMapping("/contract")
@Controller
public class PdfController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String DATA = "data";

    private static final String FILENAME = "mergePdfFileName";

    @RequestMapping("/export/pdf")
    public String exportPersonalCreaditLoanContract(Model model) {
        model.addAttribute(DATA, data());
        model.addAttribute(FILENAME, "XXX个人征信报告");
        return "contract";
    }

    private Map<String, String> data() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("borrower", "fff同学");
        return data;
    }

}
