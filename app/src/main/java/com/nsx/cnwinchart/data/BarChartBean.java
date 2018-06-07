package com.nsx.cnwinchart.data;

import java.util.List;

/**
 * Created by xhu_ww on 2018/6/7.
 * description:
 */
public class BarChartBean {

    private List<VtFinDateRstBean> vtFinDateRst;

    public List<VtFinDateRstBean> getVtFinDateRst() {
        return vtFinDateRst;
    }

    public void setVtFinDateRst(List<VtFinDateRstBean> vtFinDateRst) {
        this.vtFinDateRst = vtFinDateRst;
    }

    public static class VtFinDateRstBean {
        /**
         * eFinType : 3
         * stFinDate : {"fVal":5.2585,"sDtSecCode":"0001000063","sFinanceDesc":"净资产收益率5.26%，行业排名4/97","stIndSTRank":{"iDtNum":97,"iRank":4},"vtDateValue":[{"fValue":5.2585,"sYearMonth":"2018-03"},{"fValue":14.4348,"sYearMonth":"2017-12"},{"fValue":12.6504,"sYearMonth":"2017-09"},{"fValue":7.9092,"sYearMonth":"2017-06"},{"fValue":4.3995,"sYearMonth":"2017-03"}],"vtDateValueAvg":[{"fValue":9.70251,"sYearMonth":"2016-12"},{"fValue":0.97779,"sYearMonth":"2017-03"},{"fValue":3.42839,"sYearMonth":"2017-06"},{"fValue":4.48451,"sYearMonth":"2017-09"},{"fValue":0.758816,"sYearMonth":"2017-12"},{"fValue":0.765194,"sYearMonth":"2018-03"}]}
         */

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
             * fVal : 5.2585
             * sDtSecCode : 0001000063
             * sFinanceDesc : 净资产收益率5.26%，行业排名4/97
             * stIndSTRank : {"iDtNum":97,"iRank":4}
             * vtDateValue : [{"fValue":5.2585,"sYearMonth":"2018-03"},{"fValue":14.4348,"sYearMonth":"2017-12"},{"fValue":12.6504,"sYearMonth":"2017-09"},{"fValue":7.9092,"sYearMonth":"2017-06"},{"fValue":4.3995,"sYearMonth":"2017-03"}]
             * vtDateValueAvg : [{"fValue":9.70251,"sYearMonth":"2016-12"},{"fValue":0.97779,"sYearMonth":"2017-03"},{"fValue":3.42839,"sYearMonth":"2017-06"},{"fValue":4.48451,"sYearMonth":"2017-09"},{"fValue":0.758816,"sYearMonth":"2017-12"},{"fValue":0.765194,"sYearMonth":"2018-03"}]
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
                 * iDtNum : 97
                 * iRank : 4
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
             * 净资产收益率
             */
            public static class VtDateValueBean {

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
             * 行业平均水平值
             */
            public static class VtDateValueAvgBean {

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
}
