CREATE TABLE item
(
    id                NUMBER PRIMARY KEY,
    name              NVARCHAR2(50)  NOT NULL,
    date_created      DATE DEFAULT CURRENT_DATE,
    last_updated_date DATE DEFAULT CURRENT_DATE,
    description       NVARCHAR2(300) NOT NULL
);
