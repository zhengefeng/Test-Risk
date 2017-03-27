    package com.common.utils.entity;

    import com.common.utils.table.ColumnDesc;
    import com.common.utils.table.IncrementAuto;
    import com.common.utils.table.TimeStampAuto;

    import java.math.BigDecimal;
    import java.util.Date;

    /**
     * Created by zhenge.feng.
     */
    public class ProductCallDetail {

        @IncrementAuto
        private Integer id;

        @ColumnDesc("产品ID")
        private Integer productId;

        @ColumnDesc("公司ID")
        private Integer companyId;

        @ColumnDesc("客户ID")
        private Integer consumerId;

        @ColumnDesc("产品名称")
        private String productName;

        @ColumnDesc("产品价格")
        private BigDecimal price;

        @ColumnDesc("返回码")
        private String returncode;

        @ColumnDesc("返回数据")
        private String returnData;

        @ColumnDesc("调用状态:1成功 2失败")
        private Short status;

        @ColumnDesc("创建时间")
        private Date createTime;

        @TimeStampAuto
        @ColumnDesc("更新时间")
        private Date updateTime;

        public ProductCallDetail() {
        }

        public ProductCallDetail(Integer id, Integer productId, Integer companyId, Integer consumerId, String productName, BigDecimal price, String returncode, String returnData, Short status) {
            this.id = id;
            this.productId = productId;
            this.companyId = companyId;
            this.consumerId = consumerId;
            this.productName = productName;
            this.price = price;
            this.returncode = returncode;
            this.returnData = returnData;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public Integer getConsumerId() {
            return consumerId;
        }

        public void setConsumerId(Integer consumerId) {
            this.consumerId = consumerId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getReturncode() {
            return returncode;
        }

        public void setReturncode(String returncode) {
            this.returncode = returncode;
        }

        public String getReturnData() {
            return returnData;
        }

        public void setReturnData(String returnData) {
            this.returnData = returnData;
        }

        public Short getStatus() {
            return status;
        }

        public void setStatus(Short status) {
            this.status = status;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
    }
