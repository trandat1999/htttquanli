INSERT INTO `htttquanli`.`role` (`created_by`, `last_modified_by`, `code`, `name`)
SELECT * FROM (SELECT 'admin' as created_by , 'admin' as last_modified_by, 'ADMIN' as code, 'admin' as name) AS tmp
WHERE NOT EXISTS (
        SELECT name FROM `htttquanli`.`role` WHERE code = 'ADMIN'
) LIMIT 1;
INSERT INTO `htttquanli`.`role` (`created_by`, `last_modified_by`, `code`, `name`)
SELECT * FROM (SELECT 'admin' as created_by, 'admin' as last_modified_by,'SALER' as code, 'saler' as name) AS tmp
WHERE NOT EXISTS (
        SELECT name FROM `htttquanli`.`role` WHERE code = 'SALER'
) LIMIT 1;
INSERT INTO `htttquanli`.`role` (`created_by`, `last_modified_by`, `code`, `name`)
SELECT * FROM (SELECT 'admin' as created_by, 'admin' as last_modified_by, 'STAFFWARE' as code, 'staff2' as name) AS tmp
WHERE NOT EXISTS (
        SELECT name FROM `htttquanli`.`role` WHERE code= 'STAFFWARE'
) LIMIT 1;
INSERT INTO `htttquanli`.`tbl_account` (`created_by`, `last_modified_by`, `password`, `username`, `role`)
SELECT * FROM (SELECT 'admin' as created_by, 'admin' as last_modified_by, 'admin' as password, 'admin' as username, 1 as role) AS tmp
WHERE NOT EXISTS (
        SELECT username FROM `htttquanli`.`tbl_account` WHERE username = 'admin'
) LIMIT 1;







