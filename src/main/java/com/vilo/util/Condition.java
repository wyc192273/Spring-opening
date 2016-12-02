package com.vilo.util;


/**
 * author：chao.hou
 * date: 2016/06/27
 * 因子表达式
 */
public class Condition {

    public Condition(){}

    public Condition(Element fieldName, String alg, Parameter parameter, String null_value, String code){

        this.fieldName = fieldName;
        this.code = code;
        this.alg = alg;
        this.parameter = parameter;
        this.null_value = null_value;
    }

    public Condition(Element fieldName, String alg, Parameter parameter, String null_value, int isCaseSensitive,
            String code) {
        this.fieldName = fieldName;
        this.alg = alg;
        this.parameter = parameter;
        this.null_value = null_value;
        this.isCaseSensitive = isCaseSensitive;
        this.code = code;
    }

    /**
     * 因子code
     * 在一条规则中是唯一的，自增的
     * a-z A-Z 用字母标示
     */
    private String code;

    /**
     * 是否有效
     * true 有效
     * false 无效
     */
    private String valid;

    /**
     * factor的数据类型
     */
    private String dataType;
    /**
     * 字段名称
     */
    private Element fieldName;

    /**
     * 逻辑
     */
    private String alg;

    /**
     * 参数阀值
     */
    private Parameter parameter;

    private String null_value;

    private String factorId;
    private int isCaseSensitive = 1;
    private char money;

    public char getMoney() {
        return money;
    }

    public void setMoney(char money) {
        this.money = money;
    }

    public int getIsCaseSensitive() {
        return isCaseSensitive;
    }

    public void setIsCaseSensitive(int isCaseSensitive) {
        this.isCaseSensitive = isCaseSensitive;
    }

    public boolean isNull_value() {
        try {
            return Boolean.valueOf(null_value.toLowerCase());
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void setNull_value(String null_value) {
        this.null_value = null_value;
    }

    public Element getFieldName() {
        return fieldName;
    }

    public void setFieldName(Element fieldName) {
        this.fieldName = fieldName;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFactorId() {
        return factorId;
    }

    public void setFactorId(String factorId) {
        this.factorId = factorId;
    }

    /**
     * 风控因素
     */
    public static class Element {

        public Element(){

        }

        public Element(String type, String name, String subName, String property){
            this.type = type;
            this.name = name;
            this.subName = subName;
            this.property=property;
        }

        public Element(String type, String name, String subName, String property,String ifAddCurrent){
            this.type = type;
            this.name = name;
            this.subName = subName;
            this.property = property;
            this.ifAddCurrent = ifAddCurrent;
        }

        /**
         * 风控因素类型
         * 事件类型
         * 统计类型
         */
        private String type;
        /**
         * 属性名
         */
        private String name;
        /**
         * 子属性名
         */
        private String subName;
        /**
         * 属性的数据类型
         */
        private String property;

        /**
         * 如果是新统计因子,是否加上当前值
         */
        private String ifAddCurrent;

        public String getIfAddCurrent() {
            return ifAddCurrent;
        }

        public void setIfAddCurrent(String ifAddCurrent) {
            this.ifAddCurrent = ifAddCurrent;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", subName='" + subName + '\'' +
                    ", property='" + property + '\'' +
                    '}';
        }
    }

    public static class Parameter{

        public Parameter(){}

        public Parameter(String type, String value, String name, String subName, String property) {
            this.type = type;
            this.value = value;
            this.name = name;
            this.subName = subName;
            this.property = property;
        }

        public Parameter(String type, String value, String name, String subName, String property, String operator, String param) {
            this.type = type;
            this.value = value;
            this.name = name;
            this.subName = subName;
            this.property = property;
            this.operator = operator;
            this.param = param;
        }

        public Parameter(String type, String value, String name, String subName, String property, String operator, String param, String ifAddCurrent) {
            this.type = type;
            this.value = value;
            this.name = name;
            this.subName = subName;
            this.property = property;
            this.operator = operator;
            this.param = param;
            this.ifAddCurrent = ifAddCurrent;
        }

        /**
         * 参数类型
         * 原始值
         * 传入的值{关联last、关联status、跨事件关联last、事件属性、字典表等}
         */
        private String type;

        /**
         *数值或字段名
         */
        private String value;

        /**
         * 事件属性
         */
        private String name;
        /**
         * 子属性
         */
        private String subName;
        /**
         * 属性数据类型
         */
        private String property;

        /**
         * 统计属性 计算操作符
         */
        private String operator;
        /**
         * 统计属性 计算参数
         */
        private String param;

        /**
         * 如果是新统计因子,是否加上当前值
         */
        private String ifAddCurrent;

        public String getIfAddCurrent() {
            return ifAddCurrent;
        }

        public void setIfAddCurrent(String ifAddCurrent) {
            this.ifAddCurrent = ifAddCurrent;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        @Override
        public String toString() {
            return "Parameter{" +
                    "type='" + type + '\'' +
                    ", value='" + value + '\'' +
                    ", name='" + name + '\'' +
                    ", subName='" + subName + '\'' +
                    ", property='" + property + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Condition{" +
                "code='" + code + '\'' +
                ", valid='" + valid + '\'' +
                ", dataType='" + dataType + '\'' +
                ", fieldName=" + fieldName +
                ", alg='" + alg + '\'' +
                ", parameter=" + parameter +
                ", null_value=" + null_value +
                '}';
    }
}
