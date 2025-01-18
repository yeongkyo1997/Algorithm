SELECT 
    A.APNT_NO    AS APNTNO,
    P.PT_NAME    AS PTNAME,
    P.PT_NO      AS PTNO,
    A.MCDP_CD    AS MCDPCD,
    D.DR_NAME    AS DRNAME,
    A.APNT_YMD   AS APNTYMD
FROM APPOINTMENT A
JOIN PATIENT P
    ON A.PT_NO = P.PT_NO
JOIN DOCTOR D
    ON A.MDDR_ID = D.DR_ID
WHERE A.MCDP_CD = 'CS'
  AND A.APNT_CNCL_YN <> 'Y'                /* 취소되지 않은 예약 */
  AND DATE(A.APNT_YMD) = '2022-04-13'      /* 2022년 4월 13일 */
ORDER BY A.APNT_YMD ASC;                   /* 예약일시 기준 오름차순 정렬 */
