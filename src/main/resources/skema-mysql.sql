create database db_prediksi_cacat_produk;
use db_prediksi_cacat_produk; 

create table data(
    ID integer auto_increment,
    tanggal int(5),
    suhu DOUBLE (19,2),
    jumlah_cacat DOUBLE(19,2),
    primary key(ID)
)engine=InnoDB;