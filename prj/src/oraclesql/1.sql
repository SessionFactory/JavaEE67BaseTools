INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     1,
                                                     'Intellij IDEA');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     2,
                                                     'Microsoft Office2016');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     3,
                                                     '暴风影音');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     4,
                                                     'Windows Media Player');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     5,
                                                     'pls/sql Developer');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     6,
                                                     'visual studio code');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     7,
                                                     '记事本');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     8,
                                                     'notepad++');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     9,
                                                     'IE explorer');
INSERT INTO QIN_SOFT_OPENWAYS6 (
                               SOFT_OPEN_ID,
                               SOFT_OPENWAYS) VALUES (
                                                     10,
                                                     'Google chrome');

SELECT *
FROM QIN_SOFTWARE6;

SELECT
    qs.SOFT_ID,
    qs.SOFT_NAME,
    qs.SOFT_DESCRIPTION,
    qs.SOFT_ISHIDDEN,
    qs.SOFT_CREATETIME,
    qs.SOFT_LOCATION,
    qs.SOFT_SIZE,
    qs.SOFT_TYPE,
    qso.SOFT_OPENWAYS,
    qst.SOFT_TYPE_NAME
FROM
    QIN_SOFTWARE6 qs,
    QIN_SOFT_OPENWAYS6 qso,
    QIN_SOFT_TYPE6 qst
WHERE
    qs.SOFT_ID = qso.SOFT_OPEN_ID --
    AND
    qs.SOFT_ID = qst.SOFT_TYPE_ID;

SELECT
    soft_id,
    soft_name,
    soft_description,
    soft_ishidden,
    soft_createtime,
    soft_location,
    soft_size,
    soft_type,
    soft_openways
FROM qin_software6
WHERE
    1 = 1 AND
    soft_name LIKE '%%' AND
    soft_description LIKE '%%' AND
    soft_ishidden = 0 AND
    soft_createtime BETWEEN to_date (
                                    '2012-8-8',
                                    'yyyy-mm-dd')
                    AND to_date (
                                '2016-9-8',
                                'yyyy-mm-dd') AND
    soft_location LIKE '%%' AND
            --匹配MB前面的字符
    soft_size LIKE '%MB' AND
    soft_type = (SELECT SOFT_TYPE_ID
                 FROM QIN_SOFT_TYPE6
                 WHERE SOFT_TYPE_NAME = '图片') AND
    soft_openways = (SELECT SOFT_OPEN_ID
                     FROM QIN_SOFT_OPENWAYS6
                     WHERE QIN_SOFT_OPENWAYS6.SOFT_OPENWAYS = '暴风影音');


SELECT
    soft_id,
    soft_name,
    soft_description,
    soft_ishidden,
    soft_createtime,
    soft_location,
    soft_size,
    soft_type,
    soft_openways
FROM qin_software6
WHERE
    1 = 1 AND
    soft_name LIKE '%1%' AND
    soft_description LIKE '%2%' AND
    soft_ishidden = 0 AND
    soft_createtime BETWEEN to_date (
                                    '2016-09-07',
                                    'yyyy-mm-dd')
                    AND to_date (
                                '2016-09-23',
                                'yyyy-mm-dd') AND
    soft_location LIKE '%sdf%' AND
            --匹配MB前面的字符
    soft_size LIKE 'afsd%MB' AND
    soft_type = (SELECT SOFT_TYPE_ID
                 FROM QIN_SOFT_TYPE6
                 WHERE SOFT_TYPE_NAME = '图片') AND
    soft_openways = (SELECT SOFT_OPEN_ID
                     FROM QIN_SOFT_OPENWAYS6
                     WHERE QIN_SOFT_OPENWAYS6.SOFT_OPENWAYS = '记事本');

