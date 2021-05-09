INSERT INTO role(created_by, last_modified_by, code, name)
SELECT 'admin' , 'admin' , 'ADMIN' , 'admin'
WHERE NOT EXISTS (
        SELECT 1 FROM role WHERE code = 'ADMIN'
) ;
INSERT INTO role (created_by, last_modified_by, code, name)
SELECT 'admin', 'admin','SALER' , 'saler'
WHERE NOT EXISTS (
        SELECT 1 FROM role WHERE code = 'SALER'
) ;
INSERT INTO role (created_by, last_modified_by, code, name)
SELECT 'admin' , 'admin' , 'STAFFWARE', 'staff2'
WHERE NOT EXISTS (
        SELECT 1 FROM role WHERE code= 'STAFFWARE'
);
INSERT INTO tbl_account (created_by, last_modified_by, password, username, role)
SELECT 'admin' , 'admin' , 'admin' , 'admin' , 1
WHERE NOT EXISTS (
        SELECT 1 FROM tbl_account WHERE username = 'admin'
);

INSERT INTO tbl_account (created_by, last_modified_by, password, username, role)
SELECT 'admin' , 'admin' , 'sale' , 'sale' , 2
    WHERE NOT EXISTS (
        SELECT 1 FROM tbl_account WHERE username = 'sale'
);

INSERT INTO tbl_account (created_by, last_modified_by, password, username, role)
SELECT 'admin' , 'admin' , 'staff' , 'staff' , 3
    WHERE NOT EXISTS (
        SELECT 1 FROM tbl_account WHERE username = 'staff'
);







