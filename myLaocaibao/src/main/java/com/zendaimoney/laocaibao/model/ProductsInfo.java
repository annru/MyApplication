package com.zendaimoney.laocaibao.model;

import java.util.List;

/**
 * 产品列表实体对象集合类
 *
 * @author 00224524 2015-06-24
 */
public class ProductsInfo {
    private String status;
    private String respDesc;
    private Infos infos;

    public class Infos {
        private int pageNo;
        private int pageSize;
        private int totalRecord;
        private int totalPage;
        private List<ProductInfoItem> results;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(int totalRecord) {
            this.totalRecord = totalRecord;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public List<ProductInfoItem> getResults() {
            return results;
        }

        public void setResults(List<ProductInfoItem> results) {
            this.results = results;
        }

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public Infos getInfos() {
        return infos;
    }

    public void setInfos(Infos infos) {
        this.infos = infos;
    }


}
