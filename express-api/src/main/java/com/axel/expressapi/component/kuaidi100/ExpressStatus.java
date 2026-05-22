package com.axel.expressapi.component.kuaidi100;

import lombok.Getter;

public enum ExpressStatus {
    // ===================== 揽收 =====================
    COLLECTED(1, "揽收", 1, "揽收", "快件揽件"),
    ORDERED(1, "揽收", 101, "已下单", "已经下快件单"),
    WAIT_COLLECT(1, "揽收", 102, "待揽收", "待快递公司揽收"),
    COLLECTED_BY_EXPRESS(1, "揽收", 103, "已揽收", "快递公司已经揽收"),

    // ===================== 在途 =====================
    ON_THE_WAY(0, "在途", 0, "在途", "快件在途中"),
    ARRIVED_DELIVERY_CITY(0, "在途", 1001, "到达派件城市", "快件到达收件人城市"),
    MAIN_LINE(0, "在途", 1002, "干线", "快件处于运输过程中"),
    FORWARD_TRANSIT(0, "在途", 1003, "转递", "快件发往到新的收件地址"),

    // ===================== 派件 =====================
    DELIVERING(5, "派件", 5, "派件", "快件正在派件"),
    DELIVER_TO_CABINET(5, "派件", 501, "投柜或驿站", "快件已经投递到快递柜或者快递驿站"),

    // ===================== 签收 =====================
    SIGNED(3, "签收", 3, "签收", "快件已签收"),
    SELF_SIGNED(3, "签收", 301, "本人签收", "收件人正常签收"),
    SIGNED_AFTER_ERROR(3, "签收", 302, "派件异常后签收", "快件显示派件异常，但后续正常签收"),
    AGENT_SIGNED(3, "签收", 303, "代签", "快件已被代签"),
    CABINET_SIGNED(3, "签收", 304, "投柜或站签收", "快件已从快递柜或者驿站取出签收"),

    // ===================== 退回 / 退签 =====================
    RETURNING(6, "退回", 6, "退回", "快件正处于返回发货人的途中"),
    RETURN_SIGNED(4, "退签", 4, "退签", "此快件单已退签"),
    CANCELED(4, "退回", 401, "已销单", "此快件单已撤销"),
    REFUSED(4, "退回", 14, "拒签", "收件人拒绝签收，且寄件人签收了"),

    // ===================== 转投 =====================
    FORWARD_TO_OTHER(7, "转投", 7, "转投", "快件转给其他快递公司邮寄"),

    // ===================== 疑难 =====================
    PROBLEM(2, "疑难", 2, "疑难", "快件存在疑难"),
    TIMEOUT_UNSIGNED(2, "疑难", 201, "超时未签收", "快件长时间派件后未签收"),
    NO_UPDATE(2, "疑难", 202, "超时未更新", "快件长时间没有派件或签收"),
    REJECTED(2, "疑难", 203, "拒收", "收件人发起拒收快递,待发货方确认"),
    DELIVERY_ERROR(2, "疑难", 204, "派件异常", "快件派件时遇到异常情况"),
    CABINET_TIMEOUT(2, "疑难", 205, "柜或驿站超时未取", "快件在快递柜或者驿站长时间未取"),
    UNCONTACTABLE(2, "疑难", 206, "无法联系", "无法联系到收件人"),
    OUT_OF_AREA(2, "疑难", 207, "超区", "超出快递公司的服务区范围"),
    STAGNANT(2, "疑难", 208, "滞留", "快件滞留在网点，没有派送"),
    BROKEN(2, "疑难", 209, "破损", "快件破损"),
    CANCEL_BY_SENDER(2, "疑难", 210, "销单", "寄件人申请撤销寄件"),

    // ===================== 清关 =====================
    CUSTOMS(8, "清关", 8, "清关", "快件清关"),
    WAIT_CUSTOMS(10, "待清关", 10, "待清关", "快件等待清关"),
    IN_CUSTOMS(11, "清关中", 11, "清关中", "快件正在清关流程中"),
    CUSTOMS_PASSED(12, "已清关", 12, "已清关", "快件已完成清关流程"),
    CUSTOMS_ERROR(13, "清关异常", 13, "清关异常", "货物在清关过程中出现异常");

    @Getter
    private final Integer state;          // 物流状态值
    @Getter
    private final String stateName;       // 物流状态名称
    @Getter
    private final Integer highState;      // 高级物流状态值
    @Getter
    private final String highStateName;   // 高级物流状态名称
    @Getter
    private final String desc;            // 含义

    ExpressStatus(Integer state, String stateName, Integer highState, String highStateName, String desc) {
        this.state = state;
        this.stateName = stateName;
        this.highState = highState;
        this.highStateName = highStateName;
        this.desc = desc;
    }
}
