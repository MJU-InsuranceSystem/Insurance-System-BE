package fourservings_fiveservings.insurance_system_be.user.customer;

public enum ContractStatus {
    PENDING,       // 계약 요청 중
    ACTIVE,        // 계약 유효
    SUSPENDED,     // 계약 일시 중지
    CANCELLED,     // 계약 취소
    EXPIRED,       // 계약 만료
    TERMINATED     // 계약 종료
}
