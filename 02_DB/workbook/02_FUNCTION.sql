-- 1. 
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, ENTRANCE_DATE 입학년도
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE;

-- 2.
SELECT PROFESSOR_NAME, PROFESSOR_SSN 
FROM TB_PROFESSOR
WHERE LENGTH(PROFESSOR_NAME) IN (2, 4);

-- 3. ??????????????????????????????????? 마이너스
SELECT PROFESSOR_NAME 교수이름, 
	   FLOOR(MONTHS_BETWEEN(TO_DATE(SUBSTR(PROFESSOR_SSN, 1, 6), 'YYMMDD'), SYSDATE)/12) 나이
FROM TB_PROFESSOR tp 
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = '1'
ORDER BY 나이;

-- 4. 
SELECT SUBSTR(PROFESSOR_NAME, -2, 2) 이름
FROM TB_PROFESSOR;

-- 5. 
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(STUDENT_SSN, 1, 6), 'RRMMDD')) NOT IN (18, 19);

-- 6. 
SELECT TO_CHAR(TO_DATE('20201225'), 'DAY')
FROM DUAL;

-- 7. 
SELECT TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD')
FROM DUAL; -- 2099-10-11 00:00:00.000, 2049-10-11 00:00:00.000

SELECT TO_DATE('99/10/11', 'RR/MM/DD'), TO_DATE('49/10/11', 'RR/MM/DD')
FROM DUAL; -- 1999-10-11 00:00:00.000, 2049-10-11 00:00:00.000

-- 8.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT 
--WHERE EXTRACT (YEAR FROM ENTRANCE_DATE) LIKE '1%';
WHERE STUDENT_NO NOT LIKE 'A%'; 

-- 9.
SELECT ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';

-- 10.
SELECT DEPARTMENT_NO "학과번호", COUNT(STUDENT_NO) "학생수(명)"
FROM TB_DEPARTMENT
JOIN TB_STUDENT USING (DEPARTMENT_NO)
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

-- 11. 
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12. 
SELECT SUBSTR(TERM_NO, 1, 4) 년도, ROUND(AVG(POINT), 1) "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY SUBSTR(TERM_NO, 1, 4);

-- 13. 휴학생 0명 ?????????????????????????????????????????????????
SELECT DEPARTMENT_NO 학과코드명, COUNT(STUDENT_NO)
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
HAVING NVL(ABSENCE_YN, 0)
ORDER BY DEPARTMENT_NO;

-- 14. 
SELECT STUDENT_NAME "동일이름", COUNT(*) "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME) >= 2
ORDER BY STUDENT_NAME;

-- 15.
SELECT SUBSTR(TERM_NO, 1, 4) 년도, SUBSTR(TERM_NO, -2, 2) 학기, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP (SUBSTR(TERM_NO, 1, 4), SUBSTR(TERM_NO, -2, 2))
ORDER BY 년도, 학기;



