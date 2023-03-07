--ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.

Create Table workers(
worker_id INT,
worker_name Varchar(50),
salary real
)


-- All countries

CREATE TABLE countries(
    id int NOT NULL,
    phone_code int NOT NULL,
    country_code char(2) NOT NULL,
    country_name varchar(80) NOT NULL
);


INSERT INTO countries VALUES(1, 93, 'AF', 'Afghanistan');
INSERT INTO countries VALUES(2, 355, 'AL', 'Albania');
INSERT INTO countries VALUES(3, 213, 'DZ', 'Algeria');
INSERT INTO countries VALUES(4, 54, 'AR', 'Argentina');
INSERT INTO countries VALUES(5, 61, 'AU', 'Australia');
INSERT INTO countries VALUES(6, 43, 'AT', 'Austria');
INSERT INTO countries VALUES(7, 994, 'AZ', 'Azerbaijan');
INSERT INTO countries VALUES(8, 1242, 'BS', 'Bahamas');
INSERT INTO countries VALUES(9, 32, 'BE', 'Belgium');
INSERT INTO countries VALUES(10, 387, 'BA', 'Bosnia and Herzegovina');
INSERT INTO countries VALUES(11, 55, 'BR', 'Brazil');
INSERT INTO countries VALUES(12, 359, 'BG', 'Bulgaria');
INSERT INTO countries VALUES(13, 226, 'BF', 'Burkina Faso');
INSERT INTO countries VALUES(14, 237, 'CM', 'Cameroon');
INSERT INTO countries VALUES(15, 1, 'CA', 'Canada');
INSERT INTO countries VALUES(16, 236, 'CF', 'Central African Republic');
INSERT INTO countries VALUES(17, 86, 'CN', 'China');
INSERT INTO countries VALUES(18, 57, 'CO', 'Colombia');
INSERT INTO countries VALUES(19, 53, 'CU', 'Cuba');
INSERT INTO countries VALUES(20, 45, 'DK', 'Denmark');
INSERT INTO countries VALUES(21, 1809, 'DO', 'Dominican Republic');
INSERT INTO countries VALUES(22, 20, 'EG', 'Egypt');
INSERT INTO countries VALUES(23, 503, 'SV', 'El Salvador');
INSERT INTO countries VALUES(24, 240, 'GQ', 'Equatorial Guinea');
INSERT INTO countries VALUES(25, 251, 'ET', 'Ethiopia');
INSERT INTO countries VALUES(26, 358, 'FI', 'Finland');
INSERT INTO countries VALUES(27, 33, 'FR', 'France');
INSERT INTO countries VALUES(28, 220, 'GM', 'Gambia');
INSERT INTO countries VALUES(29, 49, 'DE', 'Germany');
INSERT INTO countries VALUES(30, 233, 'GH', 'Ghana');
INSERT INTO countries VALUES(31, 502, 'GT', 'Guatemala');
INSERT INTO countries VALUES(32, 852, 'HK', 'Hong Kong');
INSERT INTO countries VALUES(33, 91, 'IN', 'India');
INSERT INTO countries VALUES(34, 62, 'ID', 'Indonesia');
INSERT INTO countries VALUES(35, 964, 'IQ', 'Iraq');
INSERT INTO countries VALUES(36, 39, 'IT', 'Italy');
INSERT INTO countries VALUES(37, 81, 'JP', 'Japan');
INSERT INTO countries VALUES(38, 7, 'KZ', 'Kazakhstan');
INSERT INTO countries VALUES(39, 82, 'KR', 'Korea, Republic of');
INSERT INTO countries VALUES(40, 261, 'MG', 'Madagascar');
INSERT INTO countries VALUES(41, 960, 'MV', 'Maldives');
INSERT INTO countries VALUES(42, 31, 'NL', 'Netherlands');
INSERT INTO countries VALUES(43, 507, 'PA', 'Panama');
INSERT INTO countries VALUES(44, 63, 'PH', 'Philippines');
INSERT INTO countries VALUES(45, 65, 'SG', 'Singapore');
INSERT INTO countries VALUES(46, 90, 'TR', 'Turkey');
INSERT INTO countries VALUES(47, 44, 'GB', 'United Kingdom');
INSERT INTO countries VALUES(48, 1, 'US', 'United States');
INSERT INTO countries VALUES(49, 58, 'VE', 'Venezuela');
INSERT INTO countries VALUES(50, 263, 'ZW', 'Zimbabwe');

select * from countries

Select country_name from countries where id between 5 and 10

Select phone_code,country_name from countries where phone_code>600

CREATE TABLE developers(
id SERIAL PRIMARY KEY,
name varchar(50),
salary real,
prog_lang varchar(20)	
);

INSERT INTO developers(name,salary,prog_lang) VALUES('Akın',4000,'Java');
INSERT INTO developers(name,salary,prog_lang) VALUES('Ebubekir',5000,'JavaScript');
INSERT INTO developers(name,salary,prog_lang) VALUES('Bilal',5000,'Java');
INSERT INTO developers(name,salary,prog_lang) VALUES('Gülsüm',4000,'JavaScript');
INSERT INTO developers(name,salary,prog_lang) VALUES('Fatih',6000,'Java');
INSERT INTO developers(name,salary,prog_lang) VALUES('Cemil',6000,'Html');
INSERT INTO developers(name,salary,prog_lang) VALUES('Adam',5500,'Css');
INSERT INTO developers(name,salary,prog_lang) VALUES('Ufuk',5000,'Java');
INSERT INTO developers(name,salary,prog_lang) VALUES('Mürsel',4500,'Html');
INSERT INTO developers(name,salary,prog_lang) VALUES('Ahmet',4500,'Css');
INSERT INTO developers(name,salary,prog_lang) VALUES('İrfan',7000,'C++');
INSERT INTO developers(name,salary,prog_lang) VALUES('Victor',4000,'C#');
INSERT INTO developers(name,salary,prog_lang) VALUES('Zişan',4000,'C#');

SELECT * from developers where salary= (select min(salary) from developers)



CREATE TABLE ogrenciler 
(  
  id int, 
  isim varchar(50), 
  sehir varchar(50), 
  puan int,
  bolum varchar(20)
);

INSERT INTO ogrenciler VALUES(100, 'Ahmet Ümit', 'İstanbul', 546, 'Bilgisayar Müh.');
INSERT INTO ogrenciler VALUES(101, 'R.Nuri Güntekin', 'Antalya', 486, 'İşletme');
INSERT INTO ogrenciler VALUES(102, 'S.Faik Abasıyanık', 'Bursa', 554, 'Bilgisayar Müh.');
INSERT INTO ogrenciler VALUES(103, 'Yaşar Kemal', 'İstanbul', 501, 'Matematik');
INSERT INTO ogrenciler VALUES(104, 'Halide E. Adıvar', 'İzmir', 473, 'Psikoloji');
INSERT INTO ogrenciler VALUES(105, 'Nazan Bekiroğlu', 'İzmir', 432, 'Edebiyat');
INSERT INTO ogrenciler VALUES(106, 'Peyami Safa', 'Antalya', 535, 'Bilgisayar Müh.');
INSERT INTO ogrenciler VALUES(107, 'Sabahattin Ali', 'İstanbul', 492, 'Matematik');

CREATE TABLE bolumler 
(  
  bolum_id int, 
  bolum varchar(20),
  taban_puanı int,
  kampus varchar(20)
);

INSERT INTO bolumler VALUES(5001, 'Bilgisayar Müh.', 521,'Kuzey');
INSERT INTO bolumler VALUES(5002, 'Matematik', 455,'Güney');
INSERT INTO bolumler VALUES(5003, 'Psikoloji', 440,'Hisar');
INSERT INTO bolumler VALUES(5004, 'İşletme', 465,'Hisar');
INSERT INTO bolumler VALUES(5005, 'Edebiyat', 420,'Kuzey');


select isim,puan from ogrenciler where puan>( select avg(taban_puanı)from bolumler)