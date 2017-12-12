-- MIGRATION SCRIPT FROM 1.6 TO 1.7

/*
 * CHANGES ON
 * eurasia36/eurasia36-crm#65
 */

/*
 * add column REQUESTER_ID_NUMBER
 */
ALTER TABLE INSURANCE_REQUEST ADD COLUMN REQUESTER_ID_NUMBER VARCHAR(255) AFTER REQUESTER_EMAIL;
UPDATE INSURANCE_REQUEST SET REQUESTER_ID_NUMBER = (
	SELECT DRIVER.ID_NUMBER AS REQUESTER_ID_NUMBER
	FROM POLICY_REQUEST, POLICY_DRIVER, DRIVER
	WHERE POLICY_REQUEST.ID = INSURANCE_REQUEST.ID
	AND POLICY_DRIVER.POLICY_ID = POLICY_REQUEST.POLICY_ID
	AND DRIVER.ID = POLICY_DRIVER.ID
	LIMIT 1
);


/*
 * VERSION TABLE
 */
DROP TABLE VER_1_6;
CREATE TABLE VER_1_7 (DUMMY INTEGER NOT NULL, PRIMARY KEY (DUMMY));
