package com.nsx.cnwinchart.data;

import java.util.List;

/**
 * Created by xhu_ww on 2018/6/7.
 * description:
 */
public class BarChartBean {

    private int eFinType;
    private StFinDateBean stFinDate;

    public int getEFinType() {
        return eFinType;
    }

    public void setEFinType(int eFinType) {
        this.eFinType = eFinType;
    }

    public StFinDateBean getStFinDate() {
        return stFinDate;
    }

    public void setStFinDate(StFinDateBean stFinDate) {
        this.stFinDate = stFinDate;
    }

    public static class StFinDateBean {
        /**
         * fVal : -21.7467
         * sDtSecCode : 0001000063
         * sFinanceDesc : 净资产收益率-21.75%，行业排名100/101
         * stIndSTRank : {"iDtNum":101,"iRank":100}
         * vtDateValue : [{"fValue":-21.7467,"sYearMonth":"2018-03"},{"fValue":14.4348,"sYearMonth":"2017-12"},{"fValue":12.6504,"sYearMonth":"2017-09"},{"fValue":7.9092,"sYearMonth":"2017-06"},{"fValue":4.3995,"sYearMonth":"2017-03"}]
         * vtDateValueAvg : [{"fValue":7.50136,"sYearMonth":"2016-12"},{"fValue":0.95137,"sYearMonth":"2017-03"},{"fValue":3.50875,"sYearMonth":"2017-06"},{"fValue":4.62725,"sYearMonth":"2017-09"},{"fValue":1.38761,"sYearMonth":"2017-12"},{"fValue":0.61198,"sYearMonth":"2018-03"},{"fValue":4.45657,"sYearMonth":"2018-06"}]
         */

        private double fVal;
        private String sDtSecCode;
        private String sFinanceDesc;
        private StIndSTRankBean stIndSTRank;
        private List<VtDateValueBean> vtDateValue;
        private List<VtDateValueAvgBean> vtDateValueAvg;

        public double getFVal() {
            return fVal;
        }

        public void setFVal(double fVal) {
            this.fVal = fVal;
        }

        public String getSDtSecCode() {
            return sDtSecCode;
        }

        public void setSDtSecCode(String sDtSecCode) {
            this.sDtSecCode = sDtSecCode;
        }

        public String getSFinanceDesc() {
            return sFinanceDesc;
        }

        public void setSFinanceDesc(String sFinanceDesc) {
            this.sFinanceDesc = sFinanceDesc;
        }

        public StIndSTRankBean getStIndSTRank() {
            return stIndSTRank;
        }

        public void setStIndSTRank(StIndSTRankBean stIndSTRank) {
            this.stIndSTRank = stIndSTRank;
        }

        public List<VtDateValueBean> getVtDateValue() {
            return vtDateValue;
        }

        public void setVtDateValue(List<VtDateValueBean> vtDateValue) {
            this.vtDateValue = vtDateValue;
        }

        public List<VtDateValueAvgBean> getVtDateValueAvg() {
            return vtDateValueAvg;
        }

        public void setVtDateValueAvg(List<VtDateValueAvgBean> vtDateValueAvg) {
            this.vtDateValueAvg = vtDateValueAvg;
        }

        public static class StIndSTRankBean {
            /**
             * iDtNum : 101
             * iRank : 100
             */

            private int iDtNum;
            private int iRank;

            public int getIDtNum() {
                return iDtNum;
            }

            public void setIDtNum(int iDtNum) {
                this.iDtNum = iDtNum;
            }

            public int getIRank() {
                return iRank;
            }

            public void setIRank(int iRank) {
                this.iRank = iRank;
            }
        }

        /**
         * 公司净资产收益率
         */
        public static class VtDateValueBean {
            /**
             * fValue : -21.7467
             * sYearMonth : 2018-03
             */

            private double fValue;
            private String sYearMonth;

            public double getFValue() {
                return fValue;
            }

            public void setFValue(double fValue) {
                this.fValue = fValue;
            }

            public String getSYearMonth() {
                return sYearMonth;
            }

            public void setSYearMonth(String sYearMonth) {
                this.sYearMonth = sYearMonth;
            }
        }

        /**
         * 行业平均值
         */
        public static class VtDateValueAvgBean {
            /**
             * fValue : 7.50136
             * sYearMonth : 2016-12
             */

            private double fValue;
            private String sYearMonth;

            public double getFValue() {
                return fValue;
            }

            public void setFValue(double fValue) {
                this.fValue = fValue;
            }

            public String getSYearMonth() {
                return sYearMonth;
            }

            public void setSYearMonth(String sYearMonth) {
                this.sYearMonth = sYearMonth;
            }
        }
    }
}
