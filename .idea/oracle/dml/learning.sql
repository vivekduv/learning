alter session set current_schema=store;

select rownum , c.rowid, c.* from customers c where customer_id=5;

select rownum , c.rowid, c.* from customers c where rownum<5;

select 2*6 from dual;

-- add days to date result-
--to_date converts string to date
select to_date('26-JUL-2012') + 2 from dual;

select to_date('26-JUL-12') + 2 from dual;

select to_date('01-Jan-2020') - to_Date('01-Jan-19') as diffindays from dual;

select sysdate from dual;

select systimestamp from dual;

--concat
select 'A,' || 'B' from dual;

select * from STORE.customers where dob is null;
--nvl gives 2nd param when null value encounterd
select c.* , nvl(c.dob,'01-Jan-1900') as dob1  from customers c;

select distinct c.customer_id from customers c;

select * from customers where customer_id> any(2,5);

/*
LIKE
IN
BETWEEN -- range is inclusive
x and y
x or y
not x
IS NULL
IS NOT NULL
IS NAN
NOT LIKE
NOT IN
NOT BETWEEN

IN like _ (underscore) -> matches any one character
% -> matches any char
*/
select * from STORE.promotions WHERE name like '%\%%' escape '\';

select * from STORE.promotions ORDER by duration desc;
